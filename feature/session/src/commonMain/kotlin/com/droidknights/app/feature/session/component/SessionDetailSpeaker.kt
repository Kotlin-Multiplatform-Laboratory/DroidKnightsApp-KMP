package com.droidknights.app.feature.session.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.droidknights.app.core.designsystem.component.NetworkImage
import com.droidknights.app.core.designsystem.theme.KnightsTheme
import com.droidknights.app.core.model.Speaker
import droidknights.feature.session.generated.resources.Res
import droidknights.feature.session.generated.resources.placeholder_speaker
import droidknights.feature.session.generated.resources.session_detail_speaker
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun SessionDetailSpeaker(
    speaker: Speaker,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        NetworkImage(
            imageUrl = speaker.imageUrl,
            modifier = Modifier
                .size(108.dp)
                .clip(CircleShape),
            placeholder = painterResource(resource = Res.drawable.placeholder_speaker)
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = stringResource(resource = Res.string.session_detail_speaker),
            style = KnightsTheme.typography.labelSmallM,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )
        Text(
            text = speaker.name,
            style = KnightsTheme.typography.titleMediumB,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = speaker.introduction,
            style = KnightsTheme.typography.titleSmallR140,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )
    }
}

//@Preview
//@Composable
//private fun SessionDetailSpeakerPreview() {
//    KnightsTheme {
//        SessionDetailSpeaker(
//            speaker = Speaker(
//                name = "스피커1",
//                introduction = "스피커1 에 대한 소개",
//                imageUrl = "",
//            )
//        )
//    }
//}
