package com.dmz9.player.ui.base

import android.support.v4.app.Fragment
import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.presentation.UiEvent

class BaseFragment : Fragment(), IView {
    protected lateinit var presenter: IPresenter
    fun on(event: UiEvent) = presenter.on(event)
    override fun exec(command: UiCommand) {
        (activity as BaseActivity?)?.exec(command)
    }
}