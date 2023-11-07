package com.rinstance.feature.auth.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rinstance.core.ui.buttons.CoreButton
import com.rinstance.core.ui.text_inputs.CoreTextInput
import com.rinstance.core.ui.text_inputs.InputPlaceHolder
import com.rinstance.feature.auth.presentation.R

@Preview(device = Devices.PIXEL_2)
@Composable
internal fun LoginScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.onPrimary) // may remove?
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.height(62.dp))
        LoginTitle()
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .navigationBarsPadding()
        ) {
            Spacer(Modifier.height(16.dp))
            PhoneInput()
            Spacer(Modifier.height(4.dp))
            PasswordInput()
            Spacer(Modifier.height(20.dp))
            LoginButton()
            Spacer(Modifier.height(24.dp))
            NotRegisterText(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun NotRegisterText(modifier: Modifier) {
    Text(
        text = stringResource(R.string.no_register),
        fontSize = 12.sp,
        modifier = modifier
    )
}

@Composable
fun LoginButton() {
    CoreButton(text = stringResource(R.string.login_button)) {
    }
}

@Composable
fun PhoneInput() {
    CoreTextInput(
        placeholder = { InputPlaceHolder(text = stringResource(R.string.login_placeholder)) }
    )
}

@Composable
fun PasswordInput() {
    CoreTextInput(
        placeholder = { InputPlaceHolder(text = stringResource(R.string.password_placeholder)) }
    )
}

@Composable
fun LoginTitle() {
    Text(
        text = stringResource(R.string.auth_title),
        fontSize = 50.sp,
        fontFamily = FontFamily.Monospace
    )
}
