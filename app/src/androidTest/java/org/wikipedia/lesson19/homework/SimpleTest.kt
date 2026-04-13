package org.wikipedia.lesson19.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.ext.verify

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
}