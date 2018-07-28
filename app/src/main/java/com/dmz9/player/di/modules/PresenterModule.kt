package com.dmz9.player.di.modules

import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
interface PresenterModule {
    @Binds
    @Named("wtf")
    fun mainPresenter(presenter: MainPresenter): IPresenter
}