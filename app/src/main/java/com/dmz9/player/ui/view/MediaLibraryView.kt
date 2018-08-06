package com.dmz9.player.ui.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmz9.player.R
import com.dmz9.player.domain.entity.Track
import com.dmz9.player.presentation.IPresenter
import com.dmz9.player.presentation.UiCommand
import com.dmz9.player.ui.adapter.TrackListAdapter
import com.dmz9.player.ui.base.BaseApp
import com.dmz9.player.ui.base.BaseFragment
import javax.inject.Inject
import javax.inject.Named

class MediaLibraryView : BaseFragment() {
    @Inject
    @field:Named("MediaLibraryPresenter")
    lateinit var presenter: IPresenter
    private var rv: RecyclerView? = null
    private val adapter = TrackListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApp.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_medialibrary, container, false)
        rv = v.findViewById(R.id.recycler)
        rv?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
            it.setItemViewCacheSize(20)
            it.setHasFixedSize(true)
        }
        return v
    }

    override fun exec(command: UiCommand) {
        when (command) {
            is UiCommand.DisplayLibraryTabs -> showLibraryTabs()
            is UiCommand.DisplayTrackList -> displayTrackList(command.list)
            else -> super.exec(command)
        }
    }

    private fun showLibraryTabs() {
        exec(UiCommand.Notify("woot"))
    }

    private fun displayTrackList(list: List<Track>) {
        adapter.add(list)
    }

    override fun onResume() {
        super.onResume()
        adapter.clear()
        presenter.onViewAttached(this)
    }

    override fun onPause() {
        presenter.onViewDetached()
        super.onPause()
    }
}