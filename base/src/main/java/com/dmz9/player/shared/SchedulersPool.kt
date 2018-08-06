package com.dmz9.player.shared

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created on 06.08.18.
 */
class SchedulersPool {
	fun io() = Schedulers.io()
	fun ui() = AndroidSchedulers.mainThread()
	fun comp() = Schedulers.computation()
}