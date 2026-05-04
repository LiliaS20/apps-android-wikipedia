package org.wikipedia.lesson24

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.utils.BaseTest

class SimpleTest : BaseTest() {

    @Test
    fun testAddLanguage() {
        run {
            action.click(OnboardingScreen.skipButton)


        }
    }
}