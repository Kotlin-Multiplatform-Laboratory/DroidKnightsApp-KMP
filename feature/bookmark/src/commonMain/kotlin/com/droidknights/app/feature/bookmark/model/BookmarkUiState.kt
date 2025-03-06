package com.droidknights.app.feature.bookmark.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
sealed interface BookmarkUiState {

    @Immutable
    data object Loading : BookmarkUiState

    @Immutable
    data class Success(
        val isEditMode: Boolean = false,
        val bookmarks: List<BookmarkItemUiState> = listOf(),
        val selectedSessionIds: Set<String> = setOf(),
    ) : BookmarkUiState
}
