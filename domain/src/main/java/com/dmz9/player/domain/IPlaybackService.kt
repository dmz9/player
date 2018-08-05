package com.dmz9.player.domain

import com.dmz9.player.domain.entity.Track
import io.reactivex.Flowable

/**
 * Created on 05.08.18.
 */
interface IPlaybackService {
    fun play(track: Track):Flowable<Int>
    fun stop()
    // stops if null
    fun onNextTrack(factory: () -> Track? = { null })
}