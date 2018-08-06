package com.dmz9.player.presentation

import com.dmz9.player.domain.entity.Track

sealed class UiEvent {
    class Play():UiEvent()
    class Stop():UiEvent()
    class PlayRequest(val track:Track):UiEvent()
}