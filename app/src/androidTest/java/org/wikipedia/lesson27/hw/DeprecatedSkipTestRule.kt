package org.wikipedia.lesson27.hw

import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DeprecatedTestSkipRule : TestRule {
    override fun apply(
        base: Statement,
        description: Description
    ): Statement {
        return object : Statement() {
            override fun evaluate() {
                val isDeprecated = description.getAnnotation(Deprecated::class.java)!= null

                if (isDeprecated) {
                    throw AssumptionViolatedException("Тест пропущен")
                } else {
                    base.evaluate()
                }
            }
        }
    }
}