package com.rinstance.core.ui.text_inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.rinstance.core.ui.R
import com.rinstance.core.utils.actions.DefComposableAction

@Preview
@Composable
fun PasswordTextInput(
    state: MutableState<String>? = null,
    placeholder: DefComposableAction = { PasswordPlaceholder() }
) {
    val text = state ?: rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = { value ->
            text.value = value
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        trailingIcon = { LockIcon() },
        placeholder = placeholder,
        colors = getInputColors()
    )
}

@Composable
fun LockIcon() {
    Icon(painter = painterResource(R.drawable.ic_lock), contentDescription = null)
}

@Composable
fun PasswordPlaceholder() {
    CorePlaceholder(text = stringResource(R.string.password_placeholder))
}
