package com.dmz9.player.domain.usecase

import com.dmz9.player.domain.ILibraryPlugin
import com.dmz9.player.domain.plugin.LocalMusic

/**
 * библиотека
 * библиотека музыки подразумевает что есть некоторые плагины - провайдеры музыки
 * в зависимости от загруженых плагинов - можно видеть разный набор вкладок в библиотеке
 */
class LibraryUseCase @Inject constructor(
    private val localMusic: LocalMusic
) {
    fun getLoadedPlugins(): List<ILibraryPlugin> {
        return listOf(localMusic)
    }
}