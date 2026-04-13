package org.wikipedia.lesson19.homework.steps

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.ext.getName
import org.wikipedia.lesson19.homework.stepsUtils.StepDefinitions
import org.wikipedia.lesson19.homework.stepsUtils.StepsDsl

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}