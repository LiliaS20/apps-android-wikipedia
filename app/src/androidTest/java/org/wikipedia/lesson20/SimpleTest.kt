package org.wikipedia.lesson20

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.MainButtonScreen
import org.wikipedia.lesson19.homework.SettingsScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.SearchScreen.searchInput

class SimpleTest : BaseTest() {

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }

    private val text = "ddd"
    @Test
    fun test() {
        run("") {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.searchBlock {
                verify.isDisplayed(searchInput)
                searchInput.multiAction()
            }
            SearchScreen.searchInput {
                multiAction(text)
                equalsWithTrim(text)
            }
            repeat(2) {
                device.uiDevice.pressBack()
            }
            MainButtonScreen {
                action.apply {
                    click(buttonMore)
                    click(buttonSettings)
                }
            }
            SettingsScreen.settingsItem("Download only over Wi-Fi") {
                wifi.multiAction()
                verify.isChecked(wifi)
            }
        }
    }
}