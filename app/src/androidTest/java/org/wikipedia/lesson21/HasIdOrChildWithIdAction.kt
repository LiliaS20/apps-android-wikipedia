package org.wikipedia.lesson21

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.hamcrest.Matcher

class HasIdOrChildWithIdAction(private val resourceId: Int) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view contains view with specified resource id"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) throw IllegalStateException("View not submitted")
        if (view.id == resourceId) {
            result = true
        } else {
            val foundView = view.findViewById<View>(resourceId)
            result = foundView != null
        }
    }

    fun getResult() = result
}

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}