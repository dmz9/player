package com.dmz9.player.di.components

import com.dmz9.player.di.modules.AndroidModule
import com.dmz9.player.di.modules.LoaderModule
import com.dmz9.player.di.modules.PresenterModule
import com.dmz9.player.di.modules.RouterModule
import com.dmz9.player.di.scope.ActivityLifecycle
import com.dmz9.player.ui.base.SingleActivity
import com.dmz9.player.ui.view.MediaLibraryView
import dagger.Component

@ActivityLifecycle
@Component(
    dependencies = [AppComponent::class],
    modules = [
        PresenterModule::class,
        LoaderModule::class,
        RouterModule::class,
        AndroidModule::class
    ]
)
interface ActivityComponent {
    fun inject(activity: SingleActivity)
    fun inject(fragment: MediaLibraryView)
}