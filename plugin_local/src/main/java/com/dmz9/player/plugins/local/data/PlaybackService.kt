package com.dmz9.player.plugins.local.data

import android.util.Log
import com.dmz9.player.domain.IPlaybackService
import com.dmz9.player.domain.entity.Track
import com.dmz9.player.shared.SchedulersPool
import com.dmz9.player.shared.withPool
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created on 07.08.18.
 */
class PlaybackService @Inject constructor(
    private val pool: SchedulersPool
) : IPlaybackService {
    override fun play(track: Track): Flowable<Int> {
        return Flowable.intervalRange(0, 150, 0, 1, TimeUnit.SECONDS)
            .map {
                it.toInt()
            }.withPool(pool)
    }

    override fun stop() {

    }

    override fun onNextTrack(factory: () -> Track?) {
        val track = factory()
        val name = track?.name ?: "no-name"
        Log.d("PlaybackService", "onNextTrack (line 26): $name")
    }

}