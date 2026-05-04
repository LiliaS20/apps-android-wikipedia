package org.wikipedia.lesson18.homework.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen.withParent
import org.wikipedia.lesson23.KWebViewList
import org.wikipedia.lesson23.ReferencesItem
import org.wikipedia.lesson23.withXpath

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }

    val title by lazy {
        webView.withXpath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXpath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//ol")
            .name(withParent("Список"))
    }

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}