package com.dmz9.player.presentation

interface IPresenter {
    fun on(event: UiEvent)
    fun onViewAttached(iView: IView)
    fun onViewDetached()
}