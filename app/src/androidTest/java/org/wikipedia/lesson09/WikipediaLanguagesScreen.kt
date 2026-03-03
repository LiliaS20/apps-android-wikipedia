package org.wikipedia.lesson09

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikipediaLanguagesScreen : KScreen<WikipediaLanguagesScreen>() {
    override val layoutId: Int = R.id.wikipedia_languages_recycler
    override val viewClass: Class<*> = RecyclerView::class.java

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val items = KRecyclerView (
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::WikipediaLangItems)
        }
    )

    val imageButtonAdd = KImageView {
        isInstanceOf(AppCompatImageView::class.java)
    }

    val addLanguage = KImageView {
        withId(R.id.wiki_language_title)
    }
}