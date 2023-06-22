package com.example.streamingapp.ui.utils

import android.os.Build

object Utils {
    fun isPictureInPictureSupported(): Boolean {
        return Build.VERSION.SDK_INT >= 24
    }
}