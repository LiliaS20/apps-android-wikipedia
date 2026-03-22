package org.wikipedia.lesson12.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

abstract class CustomTest(kaspressoBuilder : Kaspresso.Builder.() -> Unit) : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        flakySafetyParams = FlakySafetyParams.custom(
            timeoutMs = 30000
        )
    }.apply(kaspressoBuilder)
)  {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1() {
        run() {
            OnboardingScreen.skipButton.hasText("Continue")
        }
    }
}

class ConfigTest: CustomTest({

})
