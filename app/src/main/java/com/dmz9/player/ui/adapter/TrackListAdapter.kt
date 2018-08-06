package com.dmz9.player.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dmz9.player.R
import com.dmz9.player.domain.entity.Track
import com.dmz9.player.presentation.UiEvent
import com.dmz9.player.ui.viewholder.TrackVH

class TrackListAdapter constructor(
	private val uiEventConsumer: (event: UiEvent) -> Unit = {}
) : RecyclerView.Adapter<TrackVH>() {
	private val list: MutableList<Track> = mutableListOf()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackVH {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_track, parent, false)
		return TrackVH(view, this::onPlayClick)
	}

	override fun getItemCount(): Int {
		return list.count()
	}

	override fun onBindViewHolder(holder: TrackVH, position: Int) {
		val track = list[position]
		holder.populate(track)
	}

	private fun onPlayClick(track: Track) {
		uiEventConsumer(UiEvent.PlayRequest(track))
	}

	fun add(list: List<Track>) {
		this.list.addAll(list)
		notifyDataSetChanged()
	}

	fun clear() {
		this.list.clear()
		notifyDataSetChanged()
	}
}