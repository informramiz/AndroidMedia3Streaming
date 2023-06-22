package com.example.streamingapp.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaRepository @Inject constructor(
    private val mediaDataSource: MediaLocalDataSource
) {
    fun getMp4VideoUrl() = mediaDataSource.getMp4VideoUrl()
    fun getMp3AudioUrl() = mediaDataSource.getMp3AudioUrl()
}