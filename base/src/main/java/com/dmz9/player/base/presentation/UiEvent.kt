package com.dmz9.player.base.presentation

import com.dmz9.player.domain.entity.Track

sealed class UiEvent {
    class Play():UiEvent()
    class Stop():UiEvent()
    class PlayRequest(track:Track):UiEvent()
}