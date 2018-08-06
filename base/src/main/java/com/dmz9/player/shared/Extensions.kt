package com.dmz9.player.shared

import io.reactivex.Single

/**
 * Created on 06.08.18.
 */
fun <T> Single<T>.withPool(pool: SchedulersPool): Single<T> {
	return this.observeOn(pool.io()).subscribeOn(pool.ui())
}