package com.dmz9.player.di.components

import com.dmz9.player.ui.base.BaseApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    ]
)
interface AppComponent {
    fun inject(app: BaseApp)
}