package com.dmz9.player.base.presentation

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