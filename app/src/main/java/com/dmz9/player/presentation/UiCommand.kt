package com.dmz9.player.presentation

sealed class UiCommand {
    class SetTitle(val title: String) : UiCommand()
    class Notify(val message:String):UiCommand()
}