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
import androidx.core.text.isDigitsOnly
import com.rinstance.core.ui.R

@Composable
fun PhoneTextInput(stateValue: MutableState<String>? = null) {
    val text = stateValue ?: rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = { value ->
            if (value.isDigitsOnly()) text.value = value
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        maxLines = 1,
        trailingIcon = { PhoneIcon() },
        placeholder = { PhonePlaceholder() },
        colors = getInputColors()
    )
}

@Composable
fun PhoneIcon() {
    Icon(painter = painterResource(R.drawable.ic_phone), contentDescription = null)
}

@Composable
fun PhonePlaceholder() {
    CorePlaceholder(text = stringResource(R.string.phone_placeholder))
}
