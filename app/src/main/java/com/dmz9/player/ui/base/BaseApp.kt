package com.dmz9.player.ui.base

import android.app.Application
import com.dmz9.player.di.components.AppComponent
import com.dmz9.player.di.components.DaggerActivityComponent
import com.dmz9.player.di.components.DaggerAppComponent
import com.dmz9.player.ui.main.MainFragment


class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent
            .builder()
            .build()
            .apply{
                inject(this@BaseApp)
            }

    }
     companion object {
         @JvmStatic
         internal lateinit var graph:AppComponent
         fun inject(frag:MainFragment) = (frag.activity!! as BaseActivity).graph.inject(frag)
         fun inject(activity:BaseActivity){
             activity.graph = DaggerActivityComponent
                 .builder()
                 .appComponent(graph)
                 .build()
                 .apply{
                     inject(activity)
                 }
         }
     }
}
