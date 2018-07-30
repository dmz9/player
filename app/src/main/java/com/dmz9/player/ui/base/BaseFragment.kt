package com.dmz9.player.ui.base

import android.support.v4.app.Fragment
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand

open class BaseFragment : Fragment(), IView {
    override fun exec(command: UiCommand) {
        (activity as SingleActivity?)?.exec(command)
    }
}