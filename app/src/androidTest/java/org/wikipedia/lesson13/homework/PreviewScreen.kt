package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object PreviewScreen: KScreen<PreviewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val openInNewTab = KButton() {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticle = KButton() {
        withId(R.id.link_preview_primary_button)
    }
}