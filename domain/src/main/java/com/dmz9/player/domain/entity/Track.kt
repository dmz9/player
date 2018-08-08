package com.dmz9.player.domain.entity

data class Track(
    val id: String,
    val name: String,
    val album: Album,
    val uri: String
) {
}