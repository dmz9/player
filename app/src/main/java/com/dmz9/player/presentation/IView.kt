package com.dmz9.player.presentation

interface IView {
    fun exec(command: UiCommand)
    class NullView : IView {
        override fun exec(command: UiCommand) {}
    }
}