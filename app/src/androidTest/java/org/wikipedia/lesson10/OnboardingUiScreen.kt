package lesson10.homework

import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {

    override val packageName: String = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val title = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val screenSwipe = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "scrollViewContainer")
    }

}