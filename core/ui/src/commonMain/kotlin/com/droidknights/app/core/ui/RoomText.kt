package com.droidknights.app.core.ui

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import com.droidknights.app.core.model.Room
import droidknights.core.ui.generated.resources.*
import org.jetbrains.compose.resources.*

val Room.textRes: StringResource
    get() = when (this) {
        Room.ETC -> Res.string.session_room_keynote
        Room.TRACK1 -> Res.string.session_room_track_01
        Room.TRACK2 -> Res.string.session_room_track_02
        Room.TRACK3 -> Res.string.session_room_track_03
    }

@Composable
fun RoomText(
    room: Room,
    style: TextStyle,
    color: Color = LocalContentColor.current,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    Text(
        text = stringResource(resource = room.textRes),
        style = style,
        color = color,
        onTextLayout = onTextLayout,
    )
}
