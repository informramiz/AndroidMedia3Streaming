package com.example.streamingapp.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaLocalDataSource @Inject constructor() {
    fun getMp4VideoUrl() = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"

    fun getMp3AudioUrl() = "https://storage.googleapis.com/exoplayer-test-media-0/Jazz_In_Paris.mp3"
}