package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson08.ExploreScreen
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.CustomizeScreen.backButton
import org.wikipedia.lesson08.homework.ExploreScreen.CustomizeItem
import org.wikipedia.lesson08.homework.ExploreScreen.FeaturedArticleItem
import org.wikipedia.main.MainActivity

class WikipediaTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkADB() {
        run() {
            device.network.enable()
            adbServer.performAdb("shell svc wifi enabled")
            adbServer.performAdb("shell svc wifi disabled")
            adbServer.performShell(
                command = "echo",
                arguments = listOf(
                    "Hello from Kaspresso",
                    ">",
                    "/sdcard/kaspresso_test.txt"
                )
            )
        }
    }

    @Test
    fun test1() {
        run() {
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            Assert.assertEquals(3, device.uiDevice.getDisplayRotation())
        }
    }

    @Test
    fun testCheckNaturelOrientation() {
        run(
            "Поворот экрана и проверка ориентации через метод " +
                    "device.uiDevice.isNaturalOrientation"
        ) {
            device.uiDevice.setOrientationRight()
            device.uiDevice.setOrientationRight()
            device.uiDevice.setOrientationNatural()
            Thread.sleep(3000)
            Assert.assertTrue(device.uiDevice.isNaturalOrientation)
        }
    }

    @Test
    fun testSleepWakeUpDevice() {
        run("выключение экрана, включение и проверка отображения элемента (любого)") {
            device.uiDevice.sleep()
            Thread.sleep(100)
            device.uiDevice.wakeUp()
            Thread.sleep(100)
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun testGetHome() {
        run(
            "свернуть приложение кнопкой home и развернуть дважды нажав recent apps " +
                    "и проверить отображение элемента (любого)"
        ) {
            device.uiDevice.pressHome()
            Thread.sleep(3000)
            repeat(2) {
                device.uiDevice.pressRecentApps()
                Thread.sleep(3000)
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun test3() {
        before("Проверка отображения экрана ошибки при отсутствии интернета") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            OnboardingScreen.skipButton.click()
            ExploreScreen {
                items.childWith<FeaturedArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    moreLink.click()
                }
                ExploreScreen.textNotConnect.hasText("Content cannot be loaded when offline.")
                adbServer.performAdb("shell svc data enable")
                adbServer.performAdb("shell svc wifi enable")
                retryButton.click()
            }
        }
    }

    @Test
    fun checkTurnOfInternetTest() {
        before("Проверка отображения экрана ошибки при отсутствии интернета") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            step("Кликнуть на кнопку Skip") {
                OnboardingScreen.skipButton.click()
            }
            ExploreScreen {
                items.childWith<CustomizeItem> {
                    isInstanceOf(AnnouncementCardView::class.java)
                } perform {
                    step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                        customizeButton.click()
                    }
                    step("Нажимает стрелку назад в верхнем тулбаре") {
                        backButton.click()
                    }
                }
            }
        }
    }
}

