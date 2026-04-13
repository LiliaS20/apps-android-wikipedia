package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsPager(matcher: Matcher<View>) : KRecyclerItem<InTheNewsPager>(matcher),
    TextViewAssertions {
    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }
    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}

class CustomizeRecycler(matcher: Matcher<View>) : KRecyclerItem<CustomizeRecycler>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }
    val title = KTextView(matcher) {
        withId(R.id.feed_content_type_title)
    }
    val subtitle = KTextView(matcher) {
        withId(R.id.feed_content_type_subtitle)
    }
    val checkbox = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }
}