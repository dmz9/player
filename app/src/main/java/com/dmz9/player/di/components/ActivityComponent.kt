package com.dmz9.player.di.components

import com.dmz9.player.di.modules.PresenterModule
import com.dmz9.player.di.scope.ActivityLifecycle
import com.dmz9.player.ui.base.BaseActivity
import com.dmz9.player.ui.main.MainFragment
import dagger.Component

@ActivityLifecycle
@Component(
    dependencies = [AppComponent::class],
    modules = [PresenterModule::class]
)
interface ActivityComponent {
    fun inject(activity: BaseActivity)
    fun inject(fragment: MainFragment)
}