package com.dmz9.player.domain.usecase

import com.dmz9.player.domain.IPlaybackService
import com.dmz9.player.domain.IPlaylistStorage
import com.dmz9.player.domain.entity.Playlist
import io.reactivex.Flowable

/**
 * Created on 05.08.18.
 */
class PlaybackUseCase (
	private val service: IPlaybackService,
	private val storage: IPlaylistStorage
) {
	fun setPlaylist(playlist: Playlist) {
        storage.save(playlist)
		storage.setCurrent(playlist.name)
	}

	fun play(): Flowable<Int> {
		val playlist = storage.current()
		service.stop()
		service.onNextTrack {
			playlist.next()?.let {
				storage.save(playlist.copy(currentTrack = it))
				return@onNextTrack it
			}
			null
		}

		return service.play(playlist.currentTrack)
	}
}