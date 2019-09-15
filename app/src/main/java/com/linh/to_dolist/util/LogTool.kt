package com.linh.to_dolist.util

import android.util.Log
import com.linh.to_dolist.BuildConfig

class LogTool {
    companion object {
        fun logD(TAG: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, message)
            }
        }
    }
}