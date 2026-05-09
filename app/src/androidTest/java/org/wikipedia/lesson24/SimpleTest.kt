package org.wikipedia.lesson24

import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.utils.BaseTest
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson24.AddLanguageScreen.items

class SimpleTest : BaseTest() {

    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule()

    private val localizedLanguageName = "Deutsch"
    private val canonicalLanguageName = "German"

    @Test
    fun addLanguageTest() {
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(YourLanguagesScreen.addLanguage)

            AddLanguageScreen {
                Thread.sleep(1000)
                items.invokeWithText<LanguageItem>(localizedLanguageName) {
                    localName.assertTrimmedTextIsEquals(localizedLanguageName)
                    canonicName.assertTrimmedTextIsEquals(canonicalLanguageName)
                    clickIfEnabled()
                }
            }
            action.click(YourLanguagesScreen.backToolbarButton)
            OnboardingScreen.page(0) {
                languagesBlockByIndex(2){
                    verify.hasText(this, "2.\t\tDeutsch")
                }
            }
        }
    }
}