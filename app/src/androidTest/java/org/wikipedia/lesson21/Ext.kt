package org.wikipedia.lesson21

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.homework.ext.getName
import org.wikipedia.lesson18.homework.ext.name
import kotlin.math.min


inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    limit: Int,
    startWith: Int,
    clazz: Class<out View>,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val countElements = this.getSize()
    val lastIndex = min(countElements - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recycler = this

    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(blockName))
                fnc()
                return
            }
        }
    }
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    limit: Int,
    startWith: Int,
    idRes: Int,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val countElements = this.getSize()
    val lastIndex = min(countElements - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recycler = this

    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasIdOrChildWithId(idRes)
            if (isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(blockName))
                fnc()
                return
            }
        }
    }
}