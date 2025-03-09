package com.droidknights.app.feature.home

import com.droidknights.app.core.model.Sponsor
import com.droidknights.app.feature.home.model.SponsorsUiState
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

internal class SponsorsUiStatePreviewParameterProvider : PreviewParameterProvider<SponsorsUiState> {

    override val values: Sequence<SponsorsUiState> = sequenceOf(
        SponsorsUiState.Loading,
        SponsorsUiState.Sponsors(
            sponsors = listOf(
                Sponsor(
                    name = "Sponsor1",
                    homepage = "https://www.instagram.com/droid_knights",
                    grade = Sponsor.Grade.GOLD,
                    imageUrl = "https://avatars.githubusercontent.com/u/25101514",
                ),
                Sponsor(
                    name = "Sponsor2",
                    homepage = "https://www.instagram.com/droid_knights",
                    grade = Sponsor.Grade.PLATINUM,
                    imageUrl = "https://avatars.githubusercontent.com/u/25101514",
                ),
                Sponsor(
                    name = "Sponsor3",
                    homepage = "https://www.instagram.com/droid_knights",
                    grade = Sponsor.Grade.SILVER,
                    imageUrl = "https://avatars.githubusercontent.com/u/25101514",
                ),
            )
        ),
    )
}
