package org.wikipedia.lesson24.ext

import io.github.kakaocup.kakao.common.builders.ViewBuilder

//fun BaseNode<*>.createLazyList(
//    viewBuilderAction: ViewBuilder.() -> Unit,
//    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
//) = KLazyListNode(
//    viewBuilderAction = viewBuilderAction,
//    itemTypeBuilder = itemTypeBuilder,
//    positionMatcher = {
//        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
//    },
//    lengthSemanticsPropertyKey = LazyListSizeSemantics,
//)