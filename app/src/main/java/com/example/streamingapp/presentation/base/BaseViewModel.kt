package com.example.streamingapp.presentation.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE: ViewState> : ViewModel() {
    private val _viewState = MutableLiveData<VIEW_STATE>().apply {
        value = initialViewState()
    }
    val viewState: LiveData<VIEW_STATE>
        get() = _viewState


    abstract fun initialViewState(): VIEW_STATE

    fun currentViewState(): VIEW_STATE = viewState.value!!

    protected fun updateViewState(newState: (VIEW_STATE) -> VIEW_STATE) {
        _viewState.value = newState(currentViewState())
    }

    protected fun launchWithErrorHandling(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                Log.e(BaseViewModel::class.simpleName, e.message ?: "Operation Failed due to unknown error")
                onOperationFailure()
            }
        }
    }

    protected open fun onOperationFailure() {}
}