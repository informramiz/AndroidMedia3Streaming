package com.example.streamingapp.presentation.home

import androidx.compose.ui.res.stringResource
import com.example.streamingapp.data.MediaRepository
import com.example.streamingapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mediaRepository: MediaRepository
) : BaseViewModel<HomeViewState>(){
    override fun initialViewState() = HomeViewState(null)
}