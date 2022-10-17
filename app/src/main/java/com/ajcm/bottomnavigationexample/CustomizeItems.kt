package com.ajcm.bottomnavigationexample

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.drawRoundRectBehind(
    color: Color,
    cornerRadius: Dp
) = drawBehind {
    drawRoundRect(
        topLeft = Offset.Zero,
        color = color,
        size = Size(width = size.width, height = size.height),
        cornerRadius = CornerRadius(x = cornerRadius.toPx(), cornerRadius.toPx())
    )
}

fun Modifier.drawCircleBehind(
    color: Color
) = drawBehind {
    drawCircle(color = color)
}

fun Modifier.drawBottomCircleBehind(
    color: Color
) = drawBehind {
    drawRoundRect(
        topLeft = Offset(size.width * 0.48f, size.height * 0.7f),
        color = color,
        size = Size(width = 10f, height = 10f),
        cornerRadius = CornerRadius(x = 10f, 10f)
    )
}

fun Modifier.drawBottomLineBehind(
    color: Color
) = drawBehind {
    drawRoundRect(
        topLeft = Offset(size.width * 0.425f, size.height * 0.7f),
        color = color,
        size = Size(width = 40f, height = 10f),
        cornerRadius = CornerRadius(x = 20f, 20f)
    )
}
