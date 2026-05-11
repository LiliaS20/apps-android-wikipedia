package org.wikipedia.lesson26.hw

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity

class RunWatcherInterceptorTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple().apply {
        testRunWatcherInterceptors.add(CustomTestRunWatcherInterceptor(testLogger))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun runWatcherInterceptorTest() {
        before {
            OnboardingScreen.skipButton.isDisplayed()
        }.after {
            ExploreScreen.searchWidget.isDisplayed()
        }.run {
            step("Клик по кнопке Skip") {
                OnboardingScreen.skipButton.click()
            }
        }
    }
}