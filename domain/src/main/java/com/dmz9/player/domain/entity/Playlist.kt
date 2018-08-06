package com.dmz9.player.domain.entity

import java.util.*

/**
 * Created on 05.08.18.
 */
data class Playlist(
	val name: String,
	val tracks: List<Track>,
	var currentTrack: Track,
	val repeatable: Boolean = false,
	val shuffled: Boolean = false
) {
	fun next(): Track? {
		return when {
			tracks.isEmpty() -> null
			shuffled -> nextShuffled()
			currentTrack == tracks.last() -> {
				if (repeatable) {
					tracks.first()
				} else {
					null
				}
			}
			else -> tracks[tracks.indexOf(currentTrack) + 1]
		}

	}

	private fun nextShuffled(): Track? {
		val size = tracks.size
		if (0 == size) {
			return null
		} else if (1 == size) {
			return if (repeatable) {
				tracks.first()
			} else {
				null
			}
		}
		// size >= 2
		val rand = Random().nextInt(size - 1)

		return if (currentTrack == tracks.first()) {
			tracks[rand + 1]
		} else if (currentTrack == tracks.last()) {
			tracks[rand]
		} else {
			if (rand == tracks.indexOf(currentTrack)) {
				tracks[rand + 1]
			} else {
				tracks[rand]
			}
		}
	}
}