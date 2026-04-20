package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.invokeWithText
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen.items
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.lesson21.invokeAtIndexAndId

object SettingsScreen : NamedScreen<SettingsScreen>() {
    override val screenName: String = "Экран настроек"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val recyclerSettings by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsItem)
            }
        ).name(withParent("Список настроек"))
    }

    fun settingsItem(text: String, fnc: SettingsItem.() -> Unit) {
        recyclerSettings.invokeWithText(text, fnc)
    }

    fun settingsItemIndex(index: Int, fnc: SettingsItem.() -> Unit) {
            items.invokeAtIndexAndId(
                index,
                0,
                10,
                R.id.switchWidget,
                "$index переключатель",
                fnc
            )
    }
}