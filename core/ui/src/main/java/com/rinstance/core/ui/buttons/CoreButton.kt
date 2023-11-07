package com.rinstance.core.ui.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinstance.core.ui.R
import com.rinstance.core.utils.actions.DefAction

@Composable
fun CoreButton(
    text: String,
    onClick: DefAction
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.button_color)),
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewCoreButton() {
    CoreButton(text = "button") {}
}
