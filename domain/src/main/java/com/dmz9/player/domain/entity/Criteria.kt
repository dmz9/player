package com.dmz9.player.domain.entity

data class Criteria(
	val filter: Filter? = null,
	val sort: Sort = Sort.Asc(Field.TRACK_ID),
	val limit: Int = 100,
	val offset: Int = 0,
	val page: String = ""
) {

	sealed class Filter {
		class Like(val field: Field, val query: String) : Filter()
		class Eq(val field: Field, val query: String) : Filter()
		class InStrings(val field: Field, val values: List<String>) : Filter()
		class InIntegers(val field: Field, val values: List<Int>) : Filter()
		class Composite(val field: Field, val list: List<Filter>) : Filter()
	}

	sealed class Sort {
		class Asc(val field: Field) : Sort()
		class Desc(val field: Field) : Sort()
		class Rand(val field: Field) : Sort()
	}

	enum class Field {
		TRACK_ID,
		TRACK_NAME,
		ALBUM_ID,
		ALBUM_NAME,
		PLAYLIST_ID,
		PLAYLIST_NAME
	}
}