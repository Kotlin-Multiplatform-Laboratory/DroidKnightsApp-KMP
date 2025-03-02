package com.droidknights.app.feature.session.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import com.droidknights.app.core.designsystem.component.KnightsTopAppBar
import com.droidknights.app.core.designsystem.component.TopAppBarNavigationType
import com.droidknights.app.core.designsystem.theme.Gray
import com.droidknights.app.core.designsystem.theme.Purple01
import droidknights.feature.session.generated.resources.*
import org.jetbrains.compose.resources.*

@Composable
internal fun SessionDetailTopAppBar(
    bookmarked: Boolean,
    onClickBookmark: (Boolean) -> Unit,
    onBackClick: () -> Unit,
) {
    KnightsTopAppBar(
        titleRes = Res.string.session_detail_title,
        navigationIconContentDescription = null,
        navigationType = TopAppBarNavigationType.Back,
        actionButtons = {
            BookmarkToggleButton(
                bookmarked = bookmarked,
                onClickBookmark = onClickBookmark
            )
        },
        onNavigationClick = onBackClick,
    )
}

@Composable
private fun BookmarkToggleButton(
    bookmarked: Boolean,
    onClickBookmark: (Boolean) -> Unit,
) {
    IconToggleButton(
        checked = bookmarked,
        onCheckedChange = onClickBookmark
    ) {
        Icon(
            painter =
            if (bookmarked) {
                painterResource(resource = Res.drawable.ic_session_bookmark_filled)
            } else {
                painterResource(resource = Res.drawable.ic_session_bookmark)
            },
            contentDescription = null,
            tint = if (bookmarked) Purple01 else Gray
        )
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//private fun SessionDetailTopAppBarPreview() {
//    KnightsTheme {
//        var state by remember { mutableStateOf(false) }
//        SessionDetailTopAppBar(
//            bookmarked = state,
//            onClickBookmark = {
//                state = it
//            }
//        ) { }
//    }
//}
