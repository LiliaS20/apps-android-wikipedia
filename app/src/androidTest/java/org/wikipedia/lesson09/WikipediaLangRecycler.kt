package org.wikipedia.lesson09

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.settings.languages.WikipediaLanguagesItemView

class WikipediaLangRecycler(matcher: Matcher<View>) :
    KRecyclerItem<WikipediaLangRecycler>(matcher) {

    val headerText = KTextView {
        withId(R.id.section_header_text)
    }

    val items = KRecyclerView(
        parent = matcher,
        builder = {
            isInstanceOf(WikipediaLanguagesItemView::class.java)
        },
        itemTypeBuilder = {
            itemType(::WikipediaLangItem)
        }
    )

    val imageButtonAdd = KImageView(matcher) {
        isInstanceOf(AppCompatImageView::class.java)
    }

    val addLanguage = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }
}