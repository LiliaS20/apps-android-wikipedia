package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import coil3.decode.ImageSource
import com.google.android.material.materialswitch.MaterialSwitch
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KSwipeView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object Article : KScreen<Article>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSetting = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val textSize = KTextView {
        withId(R.id.text_size_percent)
    }

    val buttonDecreaseText = KTextView {
        withId(R.id.buttonDecreaseTextSize)
    }

    val textSizeSeekBar = KView {
        withId(R.id.text_size_seek_bar)
    }

    val buttonIncreaseText = KTextView {
        withId(R.id.buttonIncreaseTextSize)
    }

    val buttonSansSerif = KButton {
        containsText("sans-serif")
    }

    val buttonSerif = KButton {
        containsText("serif")
    }

    val appCompatImageView = KImageView {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val focusModeSwitch = KCheckBox {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(MaterialSwitch::class.java)
    }

    val themeChooser = KTextView {
        withText("Hides edit features and bottom toolbar on scroll")
    }

    val textTheme = KTextView {
        withText(R.string.color_theme_select)
    }

    val buttonThemeL = KButton {
        withId(R.id.button_theme_light)
    }

    val buttonThemeS = KButton {
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeD = KButton {
        withId(R.id.button_theme_dark)
    }

    val buttonThemeB = KButton {
        withId(R.id.button_theme_black)
    }

    val switchSystemTheme = KCheckBox {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val switchDarkTheme = KCheckBox {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}