package org.wikipedia.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity


class SimpleTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced().apply {
        viewBehaviorInterceptors.add(LogBeforeAfterInterceptor())
        // viewBehaviorInterceptors.add(BrokenInterceptor()) // только для задания 2

        viewAssertionWatcherInterceptors.add(CheckStartWatcherInterceptor())
        viewAssertionWatcherInterceptors.add(AssertFailureWatcherInterceptor())

        viewBehaviorInterceptors.add(ActionTimeInterceptor())
    }
) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run() {
            OnboardingScreen.continueButton.click()
        }
    }
}