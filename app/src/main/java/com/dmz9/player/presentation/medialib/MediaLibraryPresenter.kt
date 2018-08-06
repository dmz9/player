package com.dmz9.player.presentation.medialib

import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.entity.Playlist
import com.dmz9.player.domain.usecase.LibraryUseCase
import com.dmz9.player.domain.usecase.PlaybackUseCase
import com.dmz9.player.presentation.IView
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.presentation.UiEvent
import com.dmz9.player.presentation.base.BasePresenter
import javax.inject.Inject

class MediaLibraryPresenter @Inject constructor(
	private val lib: LibraryUseCase,
	private val player: PlaybackUseCase
) : BasePresenter() {

	override fun on(event: UiEvent) {
		when (event) {
			is UiEvent.PlayRequest -> {
				player.setPlaylist(Playlist("Default", tracks = listOf(event.track), currentTrack = event.track))
				player.play()
			}
		}
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