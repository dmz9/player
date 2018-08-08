package com.dmz9.player.plugins.local.data.exception

/**
 * Created on 06.08.18.
 */
class MapperException : RuntimeException {
    constructor() : super()
    constructor(message: kotlin.String) : super(message)
    constructor(message: kotlin.String, cause: kotlin.Throwable) : super(message, cause)
    constructor(cause: kotlin.Throwable) : super(cause)
    constructor(message: kotlin.String, cause: kotlin.Throwable, enableSuppression: kotlin.Boolean, writableStackTrace: kotlin.Boolean) : super(message, cause, enableSuppression, writableStackTrace)
}