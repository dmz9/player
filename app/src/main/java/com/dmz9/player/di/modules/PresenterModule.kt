package com.dmz9.player.di.modules

import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.app.AppPresenter
import com.dmz9.player.presentation.medialib.MediaLibraryPresenter
import dagger.Binds
import dagger.Module

@Module
interface PresenterModule {
    @Binds
    @Named("AppPresenter")
    fun appPresenter(presenter: AppPresenter): IPresenter
    @Binds
    @Named("MediaLibraryPresenter")
    fun mediaLibPresenter(presenter: MediaLibraryPresenter): IPresenter
}