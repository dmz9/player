package com.dmz9.player.plugins.local.data.loader

import android.database.Cursor
import android.provider.MediaStore
import com.dmz9.player.domain.entity.Album
import com.dmz9.player.domain.entity.Track

/**
 * Created on 05.08.18.
 */
class TrackMapper(
    private val cursor: Cursor,
    projection: Array<String>?
) {
    private val columnCount = cursor.columnCount
    private val columnNames = projection ?: cursor.columnNames
    private val artistIndex = columnNames.indexOf(MediaStore.Audio.Media.ARTIST)
    private val nameIndex = columnNames.indexOf(MediaStore.Audio.Media.TITLE)
    private val albumNameIndex = columnNames.indexOf(MediaStore.Audio.Media.ALBUM)

    fun getTrack(): Track {
        return Track(
            name = cursor.getString(artistIndex) + " - " + cursor.getString(nameIndex),
            album = Album(
                name = cursor.getString(albumNameIndex)
            )
        )
    }
}