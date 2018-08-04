package com.dmz9.player.domain

import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.entity.Track
import io.reactivex.Single

interface ILibraryPlugin {
    fun name(): String
    fun list(criteria: Criteria): Single<out List<Track>>
}