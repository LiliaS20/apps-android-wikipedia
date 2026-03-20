package lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

class UiOnboardingTest: TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSkipButton() {
        run("Проверяет, что кнопка Skip отображается") {
            OnboardingUiScreen.skipButton.isDisplayed()
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkContinueButton() {
        run("Проверяет нажатие на кнопку Continue") {
            OnboardingUiScreen {
                continueButton.click()
                title.hasText("New ways to explore")
            }
        }
    }

    @Test
    fun checkSwipeSlide() {
        run("Проверяет переключение слайдов свайпом") {
            OnboardingUiScreen {
                screenSwipe.swipeLeft()
                title.hasText("New ways to explore")
            }
        }
    }

    @Test
    fun checkTwoSwipeSlide() {
        run("Проверяет переключение слайдов разными способами") {
            OnboardingUiScreen {
                screenSwipe.swipeLeft()
                continueButton.click()
                title.hasText("Reading lists with sync")
            }
        }
    }

    @Test
    fun checkSwipeSlideEnd() {
        run("Проверяет переключение слайдов до конца") {
            OnboardingUiScreen {
                screenSwipe {
                    swipeLeft()
                    swipeLeft()
                    swipeLeft()
                }
                title.hasText("Data & Privacy")
            }
        }
    }

}