package org.wikipedia.lesson03.homework

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView
import org.wikipedia.R

val imageView = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

val primaryText = listOf(
    AppTextView::class.java,
    R.id.primaryTextView
)

val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView
)

val languagesList = listOf(
    RecyclerView::class.java,
    R.id.languagesList
)

val textView = listOf(
    AppTextView::class.java,
    R.id.option_label
)

val languagesButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

val tabView = listOf(
    TabLayout::class.java,
    R.id.view_onboarding_page_indicator
)

val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)