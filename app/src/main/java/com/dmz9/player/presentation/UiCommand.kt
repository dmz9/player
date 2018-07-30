package com.dmz9.player.presentation

import com.dmz9.player.domain.entity.Track

sealed class UiCommand {
    class SetTitle(val title: String) : UiCommand()
    class Notify(val message:String):UiCommand()
    class DisplayLibraryTabs(val tabs:List<String>):UiCommand()
    class DisplayTrackList(val list:List<Track>):UiCommand()
}