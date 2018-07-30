package com.dmz9.player.presentation.medialib

import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.usecase.LibraryUseCase
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.presentation.UiEvent
import com.dmz9.player.presentation.base.BasePresenter

class MediaLibraryPresenter @Inject constructor(
    private val lib: LibraryUseCase
) : BasePresenter() {

    override fun on(event: UiEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewAttached(iView: IView) {
        super.onViewAttached(iView)

        val tracks = lib.getLoadedPlugins()[0].list(Criteria()).subscribe({
            ui(UiCommand.DisplayTrackList(it))
        }, {
        })
        disposable.add(tracks)

        val title = UiCommand.SetTitle("Библиотека")
        val tabs = UiCommand.DisplayLibraryTabs(lib.getLoadedPlugins().map { it.name() })
        ui(title, tabs)
    }
}