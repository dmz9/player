package com.dmz9.player.plugins.local.data.loader

import com.dmz9.player.domain.ITrackLoader
import com.dmz9.player.domain.entity.Album
import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.entity.Track
import io.reactivex.Single
import io.reactivex.Single.fromCallable
import javax.inject.Inject

class LocalTrackLoader @Inject constructor() : ITrackLoader {
    override fun next(criteria: Criteria): Single<out List<Track>> {
        return fromCallable {
            listOf(Track(name = "123", album = Album("Some album name")))
        }
    }
}