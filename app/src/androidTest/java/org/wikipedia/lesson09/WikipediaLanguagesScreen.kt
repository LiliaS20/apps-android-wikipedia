package org.wikipedia.lesson09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikipediaLanguagesScreen : KScreen<WikipediaLanguagesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val items = KRecyclerView (
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::WikipediaLangRecycler)
        }
    )
}