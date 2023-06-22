package com.example.streamingapp.ui.screens.home

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.streamingapp.presentation.home.HomeViewModel
import com.example.streamingapp.presentation.home.HomeViewState
import com.example.streamingapp.ui.widgets.AppScaffold

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val viewState = viewModel.viewState.observeAsState()
    AppScaffold(title = "Media3 Streaming") {
        HomeScreenContent(viewState.value!!)
    }
}

@Composable
private fun HomeScreenContent(viewState: HomeViewState) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Hello World")
        if (viewState.medialUrl != null) {
            MediaPlayer(mediaUri = viewState.medialUrl)
        }
    }
}

@Composable
private fun MediaPlayer(modifier: Modifier = Modifier, mediaUri: String) {
    val localContext = LocalContext.current
    val mediaPlayer = remember {
        getMediaPlayer(localContext, mediaUri)
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(key1 = Unit) {
        val lifecycleObserver = object : DefaultLifecycleObserver {
            override fun onStop(owner: LifecycleOwner) {
                mediaPlayer.stop()
            }
        }

        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
            mediaPlayer.release()
        }
    }

    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
            .heightIn(max = 300.dp),
        factory = { context ->
            PlayerView(context)
        },
        update = { playerView ->
            playerView.player = mediaPlayer
        })
}

private fun getMediaPlayer(context: Context, mediaUri: String): ExoPlayer {
    return ExoPlayer.Builder(context)
        .build()
        .apply {
            val mediaItem = MediaItem.fromUri(mediaUri)
            setMediaItem(mediaItem)
            prepare()
        }
}

