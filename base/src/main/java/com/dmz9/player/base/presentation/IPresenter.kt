package com.dmz9.player.base.presentation

import io.reactivex.disposables.CompositeDisposable

interface IPresenter {
    var view: IView
    var disposable: CompositeDisposable

    fun on(event: UiEvent){

    }

    fun onViewAttached(iView: IView) {
        view = iView
    }

    fun onViewDetached() {
        disposable.dispose()
        disposable = CompositeDisposable()
        view = IView.NullView()
    }
}