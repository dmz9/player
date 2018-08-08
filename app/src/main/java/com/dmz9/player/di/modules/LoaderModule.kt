package com.dmz9.player.di.modules

import com.dmz9.player.domain.IPlaybackService
import com.dmz9.player.domain.IPlaylistStorage
import com.dmz9.player.domain.ITrackLoader
import com.dmz9.player.plugins.local.data.InMemoryPlaylistStorage
import com.dmz9.player.plugins.local.data.PlaybackService
import com.dmz9.player.plugins.local.data.loader.LocalTrackLoader
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
interface LoaderModule {
    @Binds
    @Named("local")
    fun localTrackLoader(loader: LocalTrackLoader): ITrackLoader

    @Binds
    fun playbackService(playbackService: PlaybackService): IPlaybackService

    @Binds
    fun playlistStorage(inMemoryPlaylistStorage: InMemoryPlaylistStorage): IPlaylistStorage
}