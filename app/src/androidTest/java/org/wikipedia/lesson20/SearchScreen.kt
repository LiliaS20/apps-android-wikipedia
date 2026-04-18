package org.wikipedia.lesson20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

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
}