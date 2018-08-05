package com.dmz9.player.plugins.local.data.loader

import com.dmz9.player.domain.entity.Criteria

/**
 * Created on 05.08.18.
 */
class CriteriaParser private constructor(
    private val criteria: Criteria
) {
    fun getSelection(): String {
        return ""
    }

    fun getProjection(): Array<String>? {
        return null
    }

    fun getSelectionArgs(): Array<String> {
        return emptyArray()
    }
    fun getSort():String{
        return ""
    }

    companion object {
        fun from(criteria: Criteria): CriteriaParser {
            return CriteriaParser(criteria)
        }
    }
}