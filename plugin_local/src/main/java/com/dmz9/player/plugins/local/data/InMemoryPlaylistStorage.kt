package com.dmz9.player.plugins.local.data

import com.dmz9.player.domain.IPlaylistStorage
import com.dmz9.player.domain.entity.Playlist
import javax.inject.Inject

/**
 * Created on 07.08.18.
 */
class InMemoryPlaylistStorage @Inject constructor(): IPlaylistStorage {
    private val list: MutableMap<String, Playlist> = mutableMapOf()
    override fun list(): List<String> {
        return list.keys.toList()
    }

    override fun save(playlist: Playlist) {
        list[playlist.name] = playlist
    }

    override fun remove(playlist: Playlist) {
        if (list.contains(playlist.name)) {
            list.remove(playlist.name)
        }
    }

    override fun get(name: String): Playlist {
        return list.getOrDefault(name, Playlist.empty())
    }

    override fun current(): Playlist {
        return when {
            list.isNotEmpty() -> list[list.keys.first()]!!
            else -> Playlist.empty()
        }
    }

    override fun setCurrent(name: String) {

    }
}