package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object MainButtonScreen: NamedScreen<MainButtonScreen>() {
    override val screenName: String = "Экран настроек"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val buttonMore by lazy {
        KButton {
            withId(R.id.nav_tab_more)
        }.name(withParent("Кнопка More"))
    }

    val buttonSettings by lazy {
        KButton {
            withId(R.id.main_drawer_settings_container)
        }.name(withParent("Кнопка Settings"))
    }
}