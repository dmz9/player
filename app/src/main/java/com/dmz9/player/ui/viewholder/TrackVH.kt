package com.dmz9.player.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.dmz9.player.R
import com.dmz9.player.domain.entity.Track

class TrackVH(
    itemView: View,
    private val onPlayClickListener: (track: Track) -> Unit = {}
) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.trackName)
    private val album = itemView.findViewById<TextView>(R.id.albumName)
    private val play = itemView.findViewById<ImageView>(R.id.play)

    fun populate(track: Track) {
        name.text = track.name
        album.text = track.album.name
        play.setOnClickListener { onPlayClickListener(track) }
    }
}