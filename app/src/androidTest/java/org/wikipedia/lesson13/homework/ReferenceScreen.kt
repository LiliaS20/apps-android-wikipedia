package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferenceScreen: KScreen<ReferenceScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val reference = KView() {
        withId(R.id.reference_title_text)
    }

    val referencesId = KTextView() {
        withId(R.id.reference_id)
    }
}