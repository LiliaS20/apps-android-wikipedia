package org.wikipedia.lesson24

object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName = "Экран Add a language"

    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        )
    }
}