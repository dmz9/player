package com.dmz9.player.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.dmz9.player.R
import com.dmz9.player.presentation.IRouter
import com.dmz9.player.presentation.Route
import com.dmz9.player.ui.view.MediaLibraryView

open class Router @Inject constructor(
    private val supportFragmentManager: FragmentManager
) : IRouter {
    /**
     * флаг добавлять ли фрагмент в стэк или нет
     */
    private var addToBackStack = false

    override fun to(route: Route) {
        when (route) {
            Route.LIBRARY -> launch(MediaLibraryView::class.java)
            Route.NO_ROUTE -> launch(MediaLibraryView::class.java)
        }
    }

    /**
     * добавление фрагмента в бэкстак (запомнить)
     */
    override fun remember() {
        addToBackStack = true
    }

    @Synchronized
    protected fun launch(cl: Class<out Fragment>) {
        try {
            val fragment = cl.newInstance()
            val tag = fragment.javaClass.toString()
            if (!addToBackStack) {
                while (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .apply {
                    if (addToBackStack) {
                        this.addToBackStack(tag)
                    } else {
                        this.addToBackStack(ROOT_TAG)
                    }
                }
                .commitAllowingStateLoss()
        } catch (t: Throwable) {
            Log.wtf("router", t)
        } finally {
            addToBackStack = false
        }
    }

    companion object {
        private const val ROOT_TAG = "com.dmz9.player.ui.router.ROOT_TAG"
    }
}