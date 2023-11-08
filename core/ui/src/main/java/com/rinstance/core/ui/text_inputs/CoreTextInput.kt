package com.rinstance.core.ui.text_inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
    stateValue: MutableState<String>? = null,
    defValue: String = "",
    trailingIcon: DefComposableAction? = null,
    placeholder: DefComposableAction = { CorePlaceholder() },
    onValueChange: ParamAction<String>? = null
) {
    val text = stateValue ?: rememberSaveable { mutableStateOf(defValue) }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        maxLines = 1,
        placeholder = placeholder,
        trailingIcon = trailingIcon,
        onValueChange = { value ->
            text.value = value
            onValueChange?.invoke(value)
        },
        colors = getInputColors()
    )
}

@Composable
fun getInputColors() = TextFieldDefaults.textFieldColors(
    backgroundColor = Color.White,
    textColor = Color.Black,
    unfocusedIndicatorColor = colorResource(R.color.color_placeholder),
    focusedIndicatorColor = Color.Black,
    cursorColor = Color.Black
)
