package org.wikipedia.lesson27.hw

import android.util.Log
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class DeprecatedTest {

    @get:Rule
    val deprecatedTestSkipRule = DeprecatedTestSkipRule()

    @Test
    fun test1() {
        Log.i("KASPRESSO", "LogTest")
        Assert.assertTrue(true)
    }

    @Deprecated("Пропуск теста")
    @Test
    fun test2() {
        Assert.assertTrue(false)
    }

    @Test
    fun test3() {
        Log.i("KASPRESSO", "LogTest")
        Assert.assertTrue(true)
    }
}