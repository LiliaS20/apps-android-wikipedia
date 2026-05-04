package org.wikipedia.lesson20

import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.lesson22.NoRecentlyViewedWidget
import org.wikipedia.lesson22.SearchWidget

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName: String = "Экран поиска"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchInput by lazy {
        KEditText {
            withId(R.id.search_cab_view)
        }.name(withParent("Строка поиска"))
    }

    val voiceIcon by lazy {
        KImageView {
            withId(R.id.voice_search_button)
        }.name(withParent("Кнопка Назад"))
    }

    val searchTitle by lazy {
        KTextView {
            withText("Search")
            isInstanceOf(AppCompatTextView::class.java)
        }.name(withParent("Заголовок поиска"))
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val historyTitle by lazy {
        KTextView {
            withId(R.id.history_title)
        }.name(withParent("Заголовок истории"))
    }

    val noRecentlyWidget by lazy {
        NoRecentlyViewedWidget {
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустой истории"))
    }
}