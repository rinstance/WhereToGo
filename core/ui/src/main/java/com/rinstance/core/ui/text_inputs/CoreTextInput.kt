package com.rinstance.core.ui.text_inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rinstance.core.utils.actions.DefComposableAction
import com.rinstance.core.utils.actions.ParamAction

@Composable
fun CoreTextInput(
    defValue: String = "",
    placeholder: DefComposableAction = { InputPlaceHolder() },
    onValueChange: ParamAction<String>? = null
) {
    val text = remember { mutableStateOf(defValue) }

    OutlinedTextField(
        value = text.value,
        maxLines = 1,
        placeholder = placeholder,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { value ->
            text.value = value
            onValueChange?.invoke(value)
        }
    )
}

@Composable
fun InputPlaceHolder(text: String = "") {
    Text(text = text)
}
