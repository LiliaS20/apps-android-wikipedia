package org.wikipedia.lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

class AllureReportTest: TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testForAllureReport() {
        run() {
            step("Проверяет, что кнопка Skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет название кнопки Continue") {
                OnboardingScreen.continueButton.hasText("Continue")
            }
        }
    }

    @Test
    fun testForAllureReportFail() {
        run() {
            step("Проверяет, что кнопка Skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет название кнопки Continue") {
                OnboardingScreen.continueButton.hasText("Continue1")
            }
        }
    }
}