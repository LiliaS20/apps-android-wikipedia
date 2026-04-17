package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.ext.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun setChecked(is1: Boolean, element: CheckableActions) {
        if (is1) {
            steps.setChecked("Включает '${element.getName()}'", element, is1)
        } else {
            steps.setChecked("Выключает '${element.getName()}'", element, is1)
        }
    }
}