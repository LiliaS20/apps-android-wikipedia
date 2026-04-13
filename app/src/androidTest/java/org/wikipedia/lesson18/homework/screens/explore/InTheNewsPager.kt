package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.ext.withParent

class InTheNewsPager(matcher: Matcher<View>) : KRecyclerItem<InTheNewsPager>(matcher),
    TextViewAssertions {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.name(withParent("Текст"))
    }
}

class CustomizeRecycler(matcher: Matcher<View>) : KRecyclerItem<CustomizeRecycler>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.feed_content_type_drag_handle)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.feed_content_type_title)
        }.name(withParent("Заголовок"))
    }

    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.feed_content_type_subtitle)
        }.name(withParent("Подзаголовок"))
    }

    val checkbox by lazy {
        KCheckBox(matcher) {
            withId(R.id.feed_content_type_checkbox)
        }.name(withParent("Чек-бокс"))
    }
}