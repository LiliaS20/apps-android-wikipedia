package org.wikipedia.lesson19.homework.ext

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.lesson19.homework.steps.Actions
import org.wikipedia.lesson19.homework.steps.Verify
import org.wikipedia.lesson19.homework.stepsUtils.StepDefinitions
import org.wikipedia.lesson19.homework.stepsUtils.StepsDsl

private val steps = mutableMapOf<String, StepsDsl<*>>()

val TestContext<*>.action: Actions
    get() {
        return steps.getOrPut(getId(this, "action")) {
            Actions(StepDefinitions(this))
        } as Actions

    }

val TestContext<*>.verify: Verify
    get() {
        return steps.getOrPut(getId(this, "verify")) {
            Verify(StepDefinitions(this))
        } as Verify
    }

private fun getId(testContext: TestContext<*>, stepType: String): String {
    return "${testContext.hashCode()}-$stepType"
}