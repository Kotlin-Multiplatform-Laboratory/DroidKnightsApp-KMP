package com.droidknights.app.feature.session.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.droidknights.app.core.designsystem.component.TextChip
import com.droidknights.app.core.designsystem.theme.DarkGray
import com.droidknights.app.core.designsystem.theme.LightGray
import com.droidknights.app.core.model.Room
import com.droidknights.app.core.model.Session
import com.droidknights.app.core.model.Tag
import com.droidknights.app.core.ui.textRes
import droidknights.feature.session.generated.resources.Res
import droidknights.feature.session.generated.resources.session_time_fmt
import kotlinx.collections.immutable.toPersistentList
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun SessionChips(session: Session) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val sessionTags = session.tags.toPersistentList()

        TrackChip(room = session.room)
        TimeChip(dateTime = session.startTime)
        sessionTags.forEach { tag ->
            TagChip(tag = tag)
        }
    }
}

@Composable
internal fun TagChip(tag: Tag) {
    TextChip(
        text = tag.name,
        containerColor = DarkGray,
        labelColor = LightGray,
    )
}

@Composable
internal fun TrackChip(room: Room) {
    TextChip(
        text = stringResource(resource = room.textRes),
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
    )
}

@OptIn(FormatStringsInDatetimeFormats::class)
@Composable
internal fun TimeChip(dateTime: LocalDateTime) {
    val pattern = stringResource(resource = Res.string.session_time_fmt)
    val formatter = remember { LocalDateTime.Format {
            byUnicodePattern(pattern)
        }
    }

    TextChip(
        text = formatter.format(dateTime),
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
    )
}

//internal class RoomPreviewParameterProvider : PreviewParameterProvider<Room> {
//    override val values = sequenceOf(
//        Room.TRACK1,
//        Room.TRACK2,
//        Room.TRACK3,
//        Room.ETC
//    )
//}
//
//@Preview
//@Composable
//private fun TagChipPreview() {
//    TagChip(Tag("Android"))
//}
//
//@Preview
//@Composable
//fun TrackChipPreview(
//    @PreviewParameter(RoomPreviewParameterProvider::class) room: Room,
//) {
//    TrackChip(room)
//}
//
//@Preview
//@Composable
//fun TimeChipPreview() {
//    TimeChip(LocalDateTime(2022, 1, 1, 10, 22))
//}
