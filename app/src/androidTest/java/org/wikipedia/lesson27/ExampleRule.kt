package org.wikipedia.lesson27

import android.util.Log
import androidx.paging.Config
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.main.MainActivity

class ExampleRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "BEFORE TEST RULE STARTED")
        Log.i("KASPRESSO", description?.displayName ?: "")
//        val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
//            ?.value
//        Log.i("KASPRESSO", annot ?: "")
//        if (!Config.testCases.contains(annot)) {
//            throw IllegalStateException("Не входит в диапазон")
//        }
//        return MyStatement(base, description)
        return object : Statement() {
            override fun evaluate() {
                val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
                    ?.value
                if (annot !in Config.testCases) {
                    throw IllegalStateException("Не входит в диапазон")
                }
                try {
                    base?.evaluate()

                } catch (e: Throwable) {
                    Log.e("KASPRESSO", e.message ?: "empty message")
                }
                Log.i("KASPRESSO", "AFTER TEST RULE STARTED")
            }
        }
    }
}

object Config {
    val testCases = listOf("1", "2", "3")
}

class SampleTest() {

    @get:Rule
    val testRule = ExampleRule()

    @Test
    @AllureId("4")
    fun test1() {
        Log.i("KASPRESSO", "LogTest")
        Assert.assertTrue("Тут упали", false)
    }
}

//class MyStatement(
//    private val base: Statement?,
//    private val description: Description?
//) : Statement() {
//
//    override fun evaluate() {
//
//        val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
//            ?.value
//        if (!Config.testCases.contains(annot)) {
//            throw IllegalStateException("Не входит в диапазон")
//        }
//
//        try {
//            base?.evaluate()
//
//        } catch (e: Throwable) {
//            Log.e("KASPRESSO", e.message ?: "empty message")
//        }
//        Log.i("KASPRESSO", "AFTER TEST RULE STARTED")
//    }
//}