package org.wikipedia.lesson18.homework.screens.explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson08.homework.ExploreScreen.CustomizeItem
import org.wikipedia.lesson08.homework.ExploreScreen.DayItem
import org.wikipedia.lesson08.homework.ExploreScreen.FeaturedArticleItem
import org.wikipedia.lesson08.homework.ExploreScreen.InTheNewsItem
import org.wikipedia.lesson08.homework.ExploreScreen.SearchItem
import org.wikipedia.lesson08.homework.ExploreScreen.TopReadItem
import org.wikipedia.lesson18.homework.ext.invokeByIndex
import org.wikipedia.lesson18.homework.ext.invokeWithText
import org.wikipedia.lesson18.homework.ext.name
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen.pager
import org.wikipedia.lesson18.homework.screens.onboarding.PagerItem
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val screenName = "Главный экран"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Логотип"))

    val retryButton = KButton {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Кнопка Retry"))

    val textNotConnect = KTextView {
        withText("Content cannot be loaded when offline.")
    }.name(withParent("Текст об отсутствии соединения"))

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::DayItem)
            itemType(::TopReadItem)
            itemType(::InTheNewsItem)
            itemType(::FeaturedArticleItem)
        }
    ).name(withParent("Список блоков на странице"))

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }
}