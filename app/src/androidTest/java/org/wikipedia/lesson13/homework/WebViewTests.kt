package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.web.KWebView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson08.ExploreScreen
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen.FeaturedArticleItem
import org.wikipedia.main.MainActivity

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }
}

class WebViewTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test2() {
        run() {
            OnboardingScreen.skipButton.click()
            ExploreScreen {
                items.childWith<FeaturedArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    articleTitle.click()
                }
            }
            ModalScreen.closeButton.click()
            ArticleScreen {
                webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
                webView {
                    withElement(Locator.XPATH, "(//*[@class=\"mw-reflink-text\"])[28]") {
                        scroll()
                        click()
                        Thread.sleep(300)
                    }
                }
                ReferenceScreen.referencesId.hasText("24.")
                device.uiDevice.pressBack()
                Thread.sleep(300)
                webView {
                    withElement(Locator.XPATH, "(//*[@class=\"mw-redirect\"])[2]") {
                        scroll()
                        click()
                        Thread.sleep(300)
                    }
                }
                PreviewScreen.readArticle.click()
                webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
        }
    }

    @Test
    fun test1() {
        run() {
            ArticleScreen {
                webView {
                    withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                        scroll()
                        hasText("Chris Redfield")
                    }
                    withElement(Locator.XPATH, "Chris Redfield") {
                        scroll()
                    }
                }
            }
        }
    }
}

