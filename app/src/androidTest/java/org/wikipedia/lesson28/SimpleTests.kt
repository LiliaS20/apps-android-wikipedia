package org.wikipedia.lesson28

import androidx.test.espresso.action.ViewActions.replaceText
import com.kaspersky.components.kautomator.component.text.UiTextView
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.SearchScreen

class SimpleTests : BaseTest() {

    @get:Rule
    val dataValidityRule = ValidityRule()

    private fun searchArticle() {
        run {

            action.click(OnboardingScreen.skipButton)
            action.click(ExploreScreen.searchWidget)

            SearchScreen {
                searchWidget {
                    isDisplayed()
                    click()
                    replaceText(dataValidityRule.testData)
                }
            }
        }
    }

    @Test
    @Description("valid")
    fun validSearchArticle() {
        run {

            searchArticle()

            val article = UiTextView {
                withIndex(1) { containsText(dataValidityRule.testData) }
            }
            article {
                isDisplayed()
            }
        }
    }

    @Test
    @Description("no result")
    fun noSearchArticle() {
        run {

            searchArticle()

            SearchScreen {
                noResultText {
                    isDisplayed()
                }
            }
        }
    }
}