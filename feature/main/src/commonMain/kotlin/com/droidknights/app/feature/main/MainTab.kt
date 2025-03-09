package com.droidknights.app.feature.main

import androidx.compose.runtime.Composable
import com.droidknights.app.core.navigation.MainTabRoute
import com.droidknights.app.core.navigation.Route
import droidknights.feature.main.generated.resources.Res
import droidknights.feature.main.generated.resources.ic_bookmark
import droidknights.feature.main.generated.resources.ic_home
import droidknights.feature.main.generated.resources.ic_setting
import org.jetbrains.compose.resources.DrawableResource

sealed class MainTab(
    val iconResId: DrawableResource,
    internal val contentDescription: String,
    val route: MainTabRoute,
) {
    data object SETTING : MainTab(
        iconResId = Res.drawable.ic_setting,
        contentDescription = "설정",
        MainTabRoute.Setting,
    )

    data object HOME : MainTab(
        iconResId = Res.drawable.ic_home,
        contentDescription = "홈",
        MainTabRoute.Home
    )

    data object BOOKMARK : MainTab(
        iconResId = Res.drawable.ic_bookmark,
        contentDescription = "북마크",
        MainTabRoute.Bookmark,
    );

    companion object {
        val tabs = listOf(SETTING, HOME, BOOKMARK)

        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return tabs.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return tabs.map { it.route }.any { predicate(it) }
        }
    }
}
