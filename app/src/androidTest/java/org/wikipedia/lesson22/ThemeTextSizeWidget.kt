package org.wikipedia.lesson22

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.ext.withParent
import org.wikipedia.R

class ThemeTextSizeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeTextSizeWidget>(builder) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.textSettingsCategory)
        }.name(withParent("Заголовок Reading"))
    }

    val sizePercentText by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Процент размера текста"))
    }

    val decreaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения размера шрифта"))
    }

    val textSizeSeekBar by lazy {
        KSeekBar(matcher) {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Бар изменения размера шрифта"))
    }

    val increaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения размера шрифта"))
    }

    val sansSerifButton by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_sans_serif)
        }.name(withParent("Кнопка sans-serif"))
    }

    val serifButton by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_serif)
        }.name(withParent("Кнопка serif"))
    }
}