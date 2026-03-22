package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object ModalScreen: KScreen<ModalScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val closeButton = KButton() {
        withId(R.id.closeButton)
    }
}