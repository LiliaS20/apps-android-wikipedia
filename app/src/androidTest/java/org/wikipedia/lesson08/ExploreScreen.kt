package org.wikipedia.lesson08

import com.kaspersky.kaspresso.screens.KScreen
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

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val retryButton = KButton {
        withId(R.id.view_card_offline_button_retry)
    }

    val textNotConnect = KTextView {
        withText("Content cannot be loaded when offline.")
    }

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
    )
}