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
//            verify.isDisplayed(ArticleScreen.title)
        }
    }

//    @Test
//    fun indexReferenceWebViewTest(){
//        run {
//            action.click(OnboardingScreen.skipButton)
//            ExploreScreen.topReadBlock {
//                cardListItem(0) {
//                    action {
//                        click(image)
//                    }
//                }
//            }
//            ArticleScreen{
//                Thread.sleep(2000)
//                action.clickOnWebView(references)
//                Thread.sleep(2000)
//                referenceItem(2){
//                    verify.hasText(
//                        index,
//                        "[2]"
//                    )
//                }
//            }
//        }
//    }
}