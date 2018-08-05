package com.dmz9.player.plugins.local.data.loader

import android.content.Context
import android.provider.MediaStore
import com.dmz9.player.domain.ITrackLoader
import com.dmz9.player.domain.entity.Criteria
import com.dmz9.player.domain.entity.Track
import io.reactivex.Single
import io.reactivex.Single.fromCallable
import javax.inject.Inject

class LocalTrackLoader @Inject constructor(
    private val context: Context
) : ITrackLoader {
    override fun next(criteria: Criteria): Single<out List<Track>> {
        return fromCallable {
            val parser = CriteriaParser.from(criteria)
            val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            val cursor = context.contentResolver.query(
                uri,
                parser.getProjection(),
                parser.getSelection(),
                parser.getSelectionArgs(),
                parser.getSort()
            )
            val mapper = TrackMapper(cursor, parser.getProjection())
            val items = mutableListOf<Track>()
            while (cursor.moveToNext()) {
                items.add(mapper.getTrack())
            }
            cursor.close()
            items
        }
    }
}