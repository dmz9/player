package com.dmz9.player.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dmz9.player.R
import com.dmz9.player.di.components.ActivityComponent
import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.ui.main.MainFragment
import javax.inject.Inject
import javax.inject.Named

class BaseActivity : AppCompatActivity(), IView {

    lateinit var graph: ActivityComponent

    @Inject
    @field:Named("wtf")
    lateinit var presenter: IPresenter

    override fun exec(command: UiCommand) {
        when (command) {
            is UiCommand.Notify -> notify(command.message)
        }

    }

    private fun notify(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApp.inject(this)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewAttached(this)
    }
}