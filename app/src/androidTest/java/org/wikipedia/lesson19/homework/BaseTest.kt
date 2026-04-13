package org.wikipedia.lesson19.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity

abstract class BaseTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport(false)
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
}