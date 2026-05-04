package org.wikipedia.lesson22.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson19.homework.utils.BaseTest

class ThemeWithWidgetTests : BaseTest() {

    @Test
    fun searchWidgetTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(magnifyIcon)
                    hasText(text, "Search Wikipedia")
                    isDisplayed(micIcon)
                }
            }
        }
    }

//    @Test
//    fun textSizeChangeTest() {
//        openThemeBottomsheetScenario()
//        run {
//            ThemeBottomsheetScreen.themeTextSizeWidget {
//                verify.isDisplayed(this)
//                action.click(increaseSizeButton)
//                verify.hasText(sizePercentText, "110%")
//                action.click(decreaseSizeButton)
//                action.click(decreaseSizeButton)
//                verify.hasText(sizePercentText, "90%")
//            }
//        }
//    }
//
//    @Test
//    fun themeSwitchTest() {
//        openThemeBottomsheetScenario()
//        run {
//            ThemeBottomsheetScreen.themeButtonsWidget {
//                verify.isDisplayed(this)
//                action.setState(matchSystemThemeSwitch, false)
//                verify {
//                    isNotChecked(matchSystemThemeSwitch)
//                    isEnabled(darkThemeButton)
//                    isEnabled(blackThemeButton)
//                }
//                action.setState(matchSystemThemeSwitch, true)
//                verify {
//                    isChecked(matchSystemThemeSwitch)
//                    isDisabled(darkThemeButton)
//                    isDisabled(blackThemeButton)
//                }
//            }
//        }
//    }
//
//    fun openThemeBottomsheetScenario() {
//        run {
//            action.click(OnboardingScreen.skipButton)
//            try {
//                action.click(ExploreScreen.closeButton)
//            } catch (_: Exception) {
//            }
//            ExploreScreen.topReadBlock {
//                verify.isDisplayed(this)
//                item(0) {
//                    action.click(this)
//                }
//            }
//            try {
//                action.click(ExploreScreen.closeButton)
//            } catch (_: Exception) {
//            }
//            action.click(ArticleNavBar.themeTab)
//        }
//    }
}