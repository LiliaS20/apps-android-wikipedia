//
//package org.wikipedia.lesson12.homework
//
//import android.util.Log
//import android.view.Surface
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import androidx.test.uiautomator.By
//import androidx.test.uiautomator.BySelector
//import androidx.test.uiautomator.UiObject2
//import androidx.test.uiautomator.Until
//import com.kaspersky.kaspresso.device.exploit.Exploit
//import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
//import org.junit.Assert
//import org.junit.Rule
//import org.junit.Test
//import org.wikipedia.lesson10.Onboarding
//import org.wikipedia.main.MainActivity
//import org.wikipedia.onboarding.InitialOnboardingActivity
//import kotlin.math.log
//
//class Main : TestCase() {
//    val p = "org.wikipedia.alpha"
//
//    @get:Rule
//    val scenario = ActivityScenarioRule(MainActivity::class.java)
//
//    //поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
//    @Test
//    fun chekOrientation() {
//        run {
//            step("Переворачивает экран вправо") {
//                device.uiDevice.setOrientationRight()
//                Thread.sleep(1000)
//            }
//            step("Проверяет значение ориентации. Ожидает ${Surface.ROTATION_270}") {
//                val actual = device.uiDevice.displayRotation
//                val ex = Surface.ROTATION_270
//                Assert.assertEquals(ex, actual)
//            }
//
//        }
//    }
//
//    //выключение экрана, включение и проверка отображения элемента (любого)
//    @Test
//    fun displayTurnOffTurnOnAndCheckContainsElement() {
//        run {
//            step("Выключает экран") {
//                device.uiDevice.sleep()
//            }
//            Thread.sleep(2000)
//            step("Включает экран") {
//                device.uiDevice.wakeUp()
//            }
//            Thread.sleep(2000)
//            step("Проверяет отображается ли элемент по тексту на экране") {
//                Assert.assertTrue(device.uiDevice.hasObject(By.textContains("Add or edit languages")))
//            }
//        }
//    }
//
//    //свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)
//    @Test
//    fun shouldRestoreAppAfterMinimizing() {
//        run {
//            step("Сворачивает приложение") {
//                device.uiDevice.pressHome()
//            }
//            Thread.sleep(1000)
//            step("Восстанавливает приложение через последние активные приложения") {
//                device.uiDevice.pressRecentApps()
//                Thread.sleep(1000)
//                device.uiDevice.pressRecentApps()
//
//            }
//            Thread.sleep(1000)
//            step("Проверяет отображение эелемента кнопки \"Add or edit languages\"") {
//                val state = device.uiDevice.hasObject(By.textContains("Add or edit languages"))
//                if (state) Log.d("Kaspresso", "Кнопка присутствует") else Log.d(
//                    "button text",
//                    "Кнопка отсутствует"
//                )
//                Assert.assertTrue(state)
//            }
//        }
//    }
//    //
//    @Test
//    fun addLanguageAndCheck() {
//        run {
//            step("Нажимает skip на экране онбординга") {
//                device.uiDevice.findObject(By.text("Skip")).click()
//            }
//            step("Нажимает на кнопку More") {
//                device.uiDevice.wait(Until.hasObject(By.text("More")), 5000)
//                device.uiDevice.findObject(By.text("More")).click()
//            }
//            step("В появившемся выезжающем окне нажимает Settings") {
//                device.uiDevice.wait(Until.hasObject(By.text("Settings")), 5000)
//                device.uiDevice.findObject(By.text("Settings")).click()
//            }
//            step("Нажимает на раздел с выбором язырка \"Wikipedia languages\"") {
//                device.uiDevice.wait(Until.hasObject(By.text("Wikipedia languages")), 5000)
//                device.uiDevice.findObject(By.text("Wikipedia languages")).click()
//            }
//            step("Нажимает на кнопку добавления языка") {
//                device.uiDevice.wait(Until.hasObject(By.text("Add language")), 5000)
//                device.uiDevice.findObject(By.text("Add language")).click()
//            }
//            step("Ищет и нажимает на русский язык") {
//                device.uiDevice.wait(Until.hasObject(By.text("Russian")), 5000)
//                device.uiDevice.findObject(By.text("Russian")).click()
//            }
//            step("Нажимает кнопку back") {
//                device.uiDevice.pressBack()
//                device.uiDevice.pressBack()
//            }
//            step("Немного свайпает вниз") {
//                val width = device.uiDevice.displayWidth
//                val height = device.uiDevice.displayHeight
//                device.uiDevice.swipe(
//                    width / 2,
//                    height / 2,
//                    width / 2,
//                    height - (height / 4) * 3,
//                    20
//                )
//            }
//            step("Провряет, что появился раздел на русском") {
//                device.uiDevice.wait(Until.hasObject(By.text("Игры Википедии")), 5000)
//                val games = device.uiDevice.hasObject(By.text("Игры Википедии"))
//                Assert.assertTrue(games)
//
//            }
//        }
//    }
//
//    @Test
//    fun checkCurrentActivity1() {
//        run {
//            step("Проверяет текущую активити") {
//                Assert.assertEquals(InitialOnboardingActivity::class.java, device.activities.getResumed()?.javaClass)
//            }
//        }
//    }
//    @Test
//    fun checkCurrentActivity2() {
//        run {
//            step("Нажимает Skip"){
//                device.uiDevice.findObject(By.text("Skip")).click()
//
//            }
//            step("Проверяет текущую активити") {
//                device.uiDevice.wait(Until.hasObject(By.text("Explore")), 5000)
//                Assert.assertEquals(MainActivity::class.java, device.activities.getResumed()?.javaClass)
//            }
//        }
//    }
//
//    @Test
//    fun chekData() {
//        run {
//            device.uiDevice.executeShellCommand("svc wifi disable")
//            device.uiDevice.executeShellCommand("svc data disable")
//            device.uiDevice.executeShellCommand("svc wifi enable")
//            device.uiDevice.executeShellCommand("svc data enable")
//        }
//    }
//
//}
