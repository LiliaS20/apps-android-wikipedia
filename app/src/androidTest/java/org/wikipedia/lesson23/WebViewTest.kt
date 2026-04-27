package lesson23

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.ArticleScreen
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.explore.TopReadItem
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.ext.action
import org.wikipedia.lesson19.homework.ext.verify
import org.wikipedia.lesson19.homework.utils.BaseTest

class WebViewTest: BaseTest(){

    @Test
    fun test(){
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(0, {
                    action.click(this)
                    Thread.sleep(3000)
                })
            }
            verify.isDisplayed(ArticleScreen.title)
        }
    }
}