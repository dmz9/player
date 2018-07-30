package com.dmz9.player.ui.base

import android.app.Application
import com.dmz9.player.di.components.AppComponent
import com.dmz9.player.di.components.DaggerActivityComponent
import com.dmz9.player.di.components.DaggerAppComponent
import com.dmz9.player.di.modules.AndroidModule
import com.dmz9.player.ui.view.MediaLibraryView


class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent
            .builder()
            .build()
            .apply {
                inject(this@BaseApp)
            }

    }

    companion object {
        @JvmStatic
        internal lateinit var graph: AppComponent

        fun inject(frag: MediaLibraryView) = (frag.activity!! as SingleActivity).graph.inject(frag)
        fun inject(activity: SingleActivity) {
            activity.graph = DaggerActivityComponent
                .builder()
                .appComponent(graph)
                .androidModule(AndroidModule(activity))
                .build()
                .apply {
                    inject(activity)
                }
        }
    }
}
