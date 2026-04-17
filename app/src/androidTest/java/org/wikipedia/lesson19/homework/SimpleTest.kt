package org.wikipedia.lesson19.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson19.homework.utils.BaseTest

class SimpleTest : BaseTest() {

    @Test
    fun example() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }

    @Test
    fun testImageIsDisplayed() {
        run("Проверяет отображение картинки") {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                item(2) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

    @Test
    fun testChangeSettings() {
        run("Проверяет изменение настроек") {
            action.click(OnboardingScreen.skipButton)
            action.click(MainButtonScreen.buttonMore)
            action.click(MainButtonScreen.buttonSettings)
            SettingsScreen.settingsItem("Show link previews") {
                action.setChecked(false, showLinkPreviews)
                verify.isNotChecked(showLinkPreviews)
            }
        }
    }
}