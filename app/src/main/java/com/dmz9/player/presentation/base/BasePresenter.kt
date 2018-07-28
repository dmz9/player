package com.dmz9.player.presentation.base

import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter : IPresenter {
    override var view: IView = IView.NullView()
    override var disposable = CompositeDisposable()

    fun ui(command: UiCommand) {
        view.exec(command)
    }

    fun ui(vararg commands: UiCommand) {
        commands.forEach { ui(it) }
    }
}