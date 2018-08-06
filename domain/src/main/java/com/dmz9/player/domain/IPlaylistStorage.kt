package com.dmz9.player.domain

import com.dmz9.player.domain.entity.Playlist

/**
 * Created on 06.08.18.
 */
interface IPlaylistStorage {
	fun list(): List<String>
	fun save(playlist: Playlist)
	fun remove(playlist: Playlist)
	fun get(name: String): Playlist
	fun current(): Playlist
	fun setCurrent(name: String)
}