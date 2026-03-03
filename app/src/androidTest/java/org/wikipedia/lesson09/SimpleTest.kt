package org.wikipedia.lesson09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.InTheNewsItem
import org.wikipedia.lesson08.homework.PagerInTheNewsItem
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSlide() {
        run("Прокликивает онбординг до последнего слайда и проверяет отображение кнопки Skip и кнопки переключения") {
            OnboardingScreen {
                step("Проверяет отображение кнопки Skip") {
                    skipButton.hasText("Skip")
                }
                step("Переходит на следующий слайд") {
                    pager.childAt<PagerItem>(1) { }
                }
                step("Проверяет положение таба") {
                    tab.isTabSelected(1)
                }
                step("Проверяет отображение кнопки Skip") {
                    skipButton.hasText("Skip")
                }
                step("Переходит на следующий слайд") {
                    pager.childAt<PagerItem>(2) { }
                }
                step("Проверяет положение таба") {
                    tab.isTabSelected(2)
                }
                step("Проверяет отображение кнопки Skip") {
                    skipButton.hasText("Skip")
                }
                step("Переходит на следующий слайд") {
                    pager.childAt<PagerItem>(3) { }
                }
                step("Проверяет положение таба") {
                    tab.isTabSelected(3)
                }
                step("Проверяет отображение кнопки Skip") {
                    skipButton.hasText("Skip")
                }
            }
        }
    }

    @Test
    fun checkAddLanguage() {
        run("Добавляет новый язык и проверяет отображение обоих языков") {
            OnboardingScreen.pager.childAt<PagerItem>(0) {
                step("Нажимает кнопку Add or edit languages") {
                    addLanguageButton.click()
                }
                WikipediaLanguagesScreen {
                    step("Нажимает кнопку Add or edit languages") {
                        addLanguage.click()
                    }
                    AddLanguageScreen {
                        spanishLang.click()
                    }
                    toolbar.click()
                }
                languages.childAt<LanguageItem>(0) {
                    this.hasText("1.\t\tEnglish")
                }
                languages.childAt<LanguageItem>(0) {
                    this.hasText("text\t2.\t\tEspañol")
                }
            }
        }
    }

    @Test
    fun checkOnboardingScreen() {
        run("Кнопка Skip отображается на экране онбординга") {
            OnboardingScreen {
                step("Проверяет отображение кнопки Skip") {
                    skipButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun test() {
        run("Проверяет заголовок") {
            OnboardingScreen {
                step("Нажимает кнопку Skip") {
                    skipButton.click()
                }
            }
            ExploreScreen.items.childWith<InTheNewsItem> {
                isInstanceOf(NewsCardView::class.java)
            } perform {
                title.hasText("In the news")
                pager.childAt<PagerInTheNewsItem>(2) {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun test1() {
        run("") {
            OnboardingScreen {
                pager.childAt<PagerItem>(1) { }
                tab.isTabSelected(1)
            }
        }
    }
}