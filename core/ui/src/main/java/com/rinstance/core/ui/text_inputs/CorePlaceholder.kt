package com.rinstance.core.ui.text_inputs

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.rinstance.core.ui.R

@Composable
fun CorePlaceholder(text: String = "") {
    Text(
        text = text,
        color = colorResource(R.color.color_placeholder)
    )
}