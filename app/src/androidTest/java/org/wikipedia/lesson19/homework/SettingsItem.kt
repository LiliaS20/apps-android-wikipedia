package org.wikipedia.lesson19.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.ext.withParent

class SettingsItem(matcher: Matcher<View>) : KRecyclerItem<SettingsItem>(matcher) {

    val showLinkPreviews by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Чек-бокс showLinkPreviews"))
    }
}