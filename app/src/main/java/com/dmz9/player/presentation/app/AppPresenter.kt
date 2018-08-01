package com.dmz9.player.presentation.app

import com.dmz9.player.presentation.IRouter
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.Route
import com.dmz9.player.presentation.base.BasePresenter
import javax.inject.Inject

class AppPresenter @Inject constructor(
    private val router:IRouter
) : BasePresenter() {
    override fun onViewAttached(iView: IView) {
        super.onViewAttached(iView)
        router.to(Route.LIBRARY)
    }
}