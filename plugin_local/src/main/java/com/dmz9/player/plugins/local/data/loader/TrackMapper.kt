package com.dmz9.player.plugins.local.data.loader

import android.database.Cursor
import android.provider.MediaStore.Audio.Media.*
import com.dmz9.player.domain.entity.Album
import com.dmz9.player.domain.entity.Track
import com.dmz9.player.plugins.local.data.exception.MapperException

/**
 * Created on 05.08.18.
 * класс для превращения данных одной записи курсора в трек
 * проекцию получает из самого курсора
 * при нехватке данных бросает исключение
 */
class TrackMapper(
    private val cursor: Cursor
) {
    private val columnNames: Array<String> = cursor.columnNames

    init {
        if (columnNames.intersect(requiredFields).size != requiredFields.size) {
            throw MapperException("Data projection lacks required fields! Check that these fields present: [$requiredFields]")
        }
    }

    private val idIndex = columnNames.indexOf(_ID)
    private val artistIndex = columnNames.indexOf(ARTIST)
    private val nameIndex = columnNames.indexOf(TITLE)
    private val albumNameIndex = columnNames.indexOf(ALBUM)
    private val internalContentUriIndex = columnNames.indexOf(DATA)

    fun getTrack(): Track {
        return Track(
            id = cursor.getString(idIndex),
            name = cursor.getString(artistIndex) + " - " + cursor.getString(nameIndex),
            album = Album(
                name = cursor.getString(albumNameIndex)
            ),
            uri = cursor.getString(internalContentUriIndex)
        )
    }

    companion object {
        val requiredFields = listOf(
            _ID,
            ARTIST,
            TITLE,
            ALBUM,
            DATA
        )
    }
}