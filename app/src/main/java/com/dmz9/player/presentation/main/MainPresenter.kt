package com.dmz9.player.presentation.main

import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.presentation.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter() {
    override fun onViewAttached(iView: IView) {
        super.onViewAttached(iView)
        ui(UiCommand.Notify("test"))
    }
}