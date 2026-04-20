package org.wikipedia.lesson21

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.MainButtonScreen
import org.wikipedia.lesson19.homework.SettingsScreen
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.multiAction
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson20.equalsWithTrim

class SimpleTest : BaseTest() {

    @Test
    fun invokeAtIndexAndClassTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.featuredArticleBlock(1) { verify.isDisplayed(this) }
        }
    }

    @Test
    fun invokeAtIndexAndIdTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            MainButtonScreen.buttonMore.multiAction()
            MainButtonScreen.buttonSettings.multiAction()
            SettingsScreen.settingsItemIndex(0) {
                switchWidget.multiAction()
                switchWidget.isChecked()
            }
            SettingsScreen.settingsItemIndex(1) {
                title.equalsWithTrim("Collapse tables")
            }
        }
    }
}