package com.dmz9.player.domain.plugin

import com.dmz9.player.domain.ILibraryPlugin
import com.dmz9.player.domain.ITrackLoader
import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.entity.Track
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class LocalMusic @Inject constructor(
    @Named("local")
    private val localTrackLoader: ITrackLoader
) : ILibraryPlugin {
    override fun list(criteria: Criteria): Single<out List<Track>> {
        return localTrackLoader.next(criteria)
    }

    override fun name(): String = "Локальная музыка"
}