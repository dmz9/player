package com.dmz9.player.di.modules

import android.content.Context
import android.support.v4.app.FragmentManager
import com.dmz9.player.shared.SchedulersPool
import com.dmz9.player.ui.base.SingleActivity
import dagger.Module
import dagger.Provides

@Module
class AndroidModule(
	private val activity: SingleActivity
) {
	@Provides
	fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager

	@Provides
	fun provideContext(): Context = activity.applicationContext

	@Provides
	fun provideSchedulerPool(): SchedulersPool = SchedulersPool()
}