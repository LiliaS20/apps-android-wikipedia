package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PagerInTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<PagerInTheNewsItem>(matcher) {

    val image = KView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}