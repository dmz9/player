package com.dmz9.player.di.modules

import com.dmz9.player.data.loader.LocalTrackLoader
import com.dmz9.player.domain.ITrackLoader
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
interface LoaderModule {
    @Binds
    @Named("local")
    fun localTrackLoader(loader: LocalTrackLoader): ITrackLoader
}