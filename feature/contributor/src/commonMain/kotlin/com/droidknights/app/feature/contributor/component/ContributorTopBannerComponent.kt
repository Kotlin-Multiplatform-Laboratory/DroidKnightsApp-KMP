package com.droidknights.app.feature.contributor.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.droidknights.app.core.designsystem.theme.Black
import com.droidknights.app.core.designsystem.theme.KnightsTheme
import com.droidknights.app.core.designsystem.theme.LocalDarkTheme
import com.droidknights.app.core.designsystem.theme.Neon01
import com.droidknights.app.core.designsystem.theme.Neon05
import droidknights.feature.contributor.generated.resources.Res
import droidknights.feature.contributor.generated.resources.bg_contributors_darkmode
import droidknights.feature.contributor.generated.resources.bg_contributors_lightmode
import droidknights.feature.contributor.generated.resources.contributor_banner_description
import droidknights.feature.contributor.generated.resources.contributor_banner_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ContributorTopBanner(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = LocalDarkTheme.current,
) {
    Box(
        modifier = modifier
            .background(if (darkTheme) Black else Neon05)
            .statusBarsPadding()
            .padding(top = 48.dp)
    ) {
        ContributorBannerImage(darkTheme = darkTheme)
        ContributorBannerContent()
    }
}

@Composable
private fun ContributorBannerImage(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
) {
    Image(
        painter = painterResource(
            if (darkTheme) {
                Res.drawable.bg_contributors_darkmode
            } else {
                Res.drawable.bg_contributors_lightmode
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
private fun ContributorBannerContent(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Text(
            text = stringResource(Res.string.contributor_banner_title),
            style = KnightsTheme.typography.headlineSmallBL,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(top = 24.dp),
        )
        Text(
            text = stringResource(Res.string.contributor_banner_description),
            style = KnightsTheme.typography.titleSmallM140,
            color = Neon01,
            modifier = Modifier.padding(top = 6.dp, start = 3.dp),
        )
    }
}

//@Preview
//@Composable
//private fun ContributorTopBannerPreview() {
//    KnightsTheme {
//        Column {
//            ContributorTopBanner(darkTheme = false)
//
//            Spacer(modifier = Modifier.padding(top = 20.dp))
//
//            ContributorTopBanner(darkTheme = true)
//        }
//    }
//}
