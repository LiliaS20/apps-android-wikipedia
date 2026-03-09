package org.wikipedia.lesson09

import androidx.compose.material3.IconButton
import androidx.compose.ui.test.hasTestTag
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView

object AddLanguageScreen : KScreen<AddLanguageScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val iconButton =  {

    }
    val spanishLang = KView {
        hasTestTag("Spanish")
    }
}