package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.ext.withParent

class NavigationBar(matcher: Matcher<View>) : KRecyclerItem<NavigationBar>(matcher) {

    val button by lazy {
        KView(matcher) {
            withText("More")
        }.name(withParent("Кнопка More"))
    }
}