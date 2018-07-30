package com.dmz9.player.di.modules

import com.dmz9.player.presentation.IRouter
import com.dmz9.player.ui.Router
import dagger.Binds
import dagger.Module

@Module
interface RouterModule {
    @Binds
    fun router(router: Router): IRouter
}