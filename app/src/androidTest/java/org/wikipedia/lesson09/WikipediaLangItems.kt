package org.wikipedia.lesson09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikipediaLangItems(matcher: Matcher<View>) : KRecyclerItem<WikipediaLangItems>(matcher) {

    val headerText = KTextView {
        withId(R.id.section_header_text)
    }

    val wikiLangOrder = KTextView {
        withId(R.id.wiki_language_order)
    }

    val wikiLangCode = KTextView {
        withId(R.id.wiki_language_code)
    }

    val wikiLangTitle = KTextView {
        withId(R.id.wiki_language_title)
    }

    val wikiLangDragHandle = KImageView {
        withId(R.id.wiki_language_drag_handle)
    }
}