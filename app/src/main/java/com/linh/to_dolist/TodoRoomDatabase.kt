package com.linh.to_dolist

import android.content.Context
import androidx.room.*
import java.util.*

@Database(entities = [TodoEntry::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoRoomDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(context: Context): TodoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, TodoRoomDatabase::class.java, "Todo_database").build()
                instance
            }
        }
    }
}

class Converters {
    @TypeConverter
    fun toCalendar(l: Long?): Calendar? =
        if (l == null) null else Calendar.getInstance().apply { timeInMillis = l }

    @TypeConverter
    fun fromCalendar(c: Calendar?): Long? = c?.time?.time
}