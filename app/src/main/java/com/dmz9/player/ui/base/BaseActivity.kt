package com.dmz9.player.ui.base

import android.support.v4.app.ActivityCompat
import android.widget.Toast
import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.presentation.UiEvent

class BaseActivity : ActivityCompat(), IView {
    protected lateinit var presenter: IPresenter
    fun on(event: UiEvent) = presenter.on(event)
    override fun exec(command: UiCommand) {
        when (command) {
            is UiCommand.Notify -> notify(command.message)
        }
    }

    private fun notify(message: String) {
//        Toast.makeText(this.ge, message, Toast.LENGTH_LONG)
    }
}