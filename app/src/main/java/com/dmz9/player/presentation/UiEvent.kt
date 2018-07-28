package com.dmz9.player.presentation

sealed class UiEvent {
    class Play():UiEvent()
    class Stop():UiEvent()
}