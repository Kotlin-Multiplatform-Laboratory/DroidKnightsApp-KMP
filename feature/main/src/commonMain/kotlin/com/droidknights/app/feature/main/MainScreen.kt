package com.droidknights.app.feature.main

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidknights.app.core.designsystem.theme.KnightsTheme
import com.droidknights.app.feature.main.component.MainBottomBar
import com.droidknights.app.feature.main.component.MainNavHost
import droidknights.feature.main.generated.resources.Res
import droidknights.feature.main.generated.resources.error_message_unknown
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    val viewModel = koinViewModel<MainViewModel>()
    val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle(false)
    val snackBarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()
    val errorMessage = stringResource(Res.string.error_message_unknown)
    val onShowErrorSnackBar: (throwable: Throwable?) -> Unit = { throwable ->
        coroutineScope.launch {
            snackBarHostState.showSnackbar(errorMessage)
        }
    }
    KnightsTheme(darkTheme = isDarkTheme) {
        MainScreenContent(
            navigator = navigator,
            onShowErrorSnackBar = onShowErrorSnackBar,
            onChangeDarkTheme = { viewModel.updateIsDarkTheme(it) },
            snackBarHostState = snackBarHostState
        )
    }
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    onChangeDarkTheme: (Boolean) -> Unit,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
                onShowErrorSnackBar = onShowErrorSnackBar,
                onChangeDarkTheme = onChangeDarkTheme,
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(start = 8.dp, end = 8.dp, bottom = 28.dp),
                visible = navigator.shouldShowBottomBar(),
                tabs = MainTab.tabs.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    )
}
