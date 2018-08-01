package com.dmz9.player.base.presentation

interface IRouter {
    fun to(route: Route)
    fun remember()
}