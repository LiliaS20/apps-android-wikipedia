package org.wikipedia.lesson22

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.ext.withParent
import org.wikipedia.R

class ReadingFocusModeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ReadingFocusModeWidget>(builder) {

    val icon by lazy {
        KImageView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Иконка очков"))
    }

    val switch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Переключатель"))
    }

    val focusModeDescription by lazy {
        KTextView(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Описание Reading focus mode"))
    }
}