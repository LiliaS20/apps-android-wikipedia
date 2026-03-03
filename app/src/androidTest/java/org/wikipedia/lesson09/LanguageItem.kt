package org.wikipedia.lesson09

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher),
    TextViewAssertions {

    val textView = KTextView {
        withId(R.id.option_label)
    }
}