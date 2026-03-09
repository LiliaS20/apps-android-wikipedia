package org.wikipedia.lesson09

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikipediaLangItem(matcher: Matcher<View>) : KRecyclerItem<WikipediaLangItem>(matcher) {

    val wikiLangOrder = KTextView(matcher) {
        withId(R.id.wiki_language_order)
    }

    val wikiLangCode = KTextView(matcher) {
        withId(R.id.wiki_language_code)
    }

    val wikiLangTitle = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }

    val wikiLangDragHandle = KImageView(matcher) {
        withId(R.id.wiki_language_drag_handle)
    }
}