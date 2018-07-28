package com.dmz9.player.domain.usecase

import com.dmz9.player.domain.ILibraryPlugin

/**
 * библиотека
 * библиотека музыки подразумевает что есть некоторые плагины - провайдеры музыки
 * в зависимости от загруженых плагинов - можно видеть разный набор вкладок в библиотеке
 */
class LibraryUseCase {
    fun getLoadedPlugins(): List<ILibraryPlugin> {
        return emptyList()
    }
}