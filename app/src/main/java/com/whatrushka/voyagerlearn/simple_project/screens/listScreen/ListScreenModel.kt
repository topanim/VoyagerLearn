package com.whatrushka.voyagerlearn.simple_project.screens.listScreen

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListScreenModel :
    StateScreenModel<ListScreenModel.State>(State.Init) {

    sealed class State {
        data object Init : State()
        data object Loading : State()
        data class Result(val value: String) : State()
    }

    fun getPost(id: String) {
        screenModelScope.launch {
            mutableState.value = State.Loading
            delay(3000)
            mutableState.value = State.Result(value = "hello")
        }
    }
}