package com.rinstance.core.ui.text_inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.rinstance.core.ui.R
import com.rinstance.core.utils.actions.DefComposableAction
import com.rinstance.core.utils.actions.ParamAction

@Preview
@Composable
fun CoreTextInput(
    defValue: String = "",
    placeholder: DefComposableAction = { InputPlaceHolder() },
    onValueChange: ParamAction<String>? = null
) {
    val text = remember { mutableStateOf(defValue) }

    TextField(
        value = text.value,
        maxLines = 1,
        placeholder = placeholder,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { value ->
            text.value = value
            onValueChange?.invoke(value)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            unfocusedIndicatorColor = colorResource(R.color.color_placeholder),
            focusedIndicatorColor = Color.Black,
            cursorColor =Color.Black
        )
    )
}

@Composable
fun InputPlaceHolder(text: String = "") {
    Text(
        text = text,
        color = colorResource(R.color.color_placeholder)
    )
}
