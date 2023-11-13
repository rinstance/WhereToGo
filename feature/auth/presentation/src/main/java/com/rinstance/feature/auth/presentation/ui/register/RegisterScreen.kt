package com.rinstance.feature.auth.presentation.ui.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rinstance.core.ui.R
import com.rinstance.core.ui.buttons.CoreButton
import com.rinstance.core.ui.text_inputs.CorePlaceholder
import com.rinstance.core.ui.text_inputs.PasswordTextInput
import com.rinstance.core.ui.text_inputs.PhoneTextInput
import com.rinstance.core.utils.actions.DefAction
import com.rinstance.feature.auth.presentation.R.string
import com.rinstance.feature.auth.presentation.ui.register.RegisterEvents.BackToLogin
import com.rinstance.feature.auth.presentation.ui.register.RegisterEvents.Register

@Preview
@Composable
internal fun RegisterScreen() {
    val viewModel = hiltViewModel<RegisterViewModel>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.height(62.dp))
        CloseIcon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable { viewModel.handleEvent(BackToLogin) }
        )
        RegisterTitle()
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .navigationBarsPadding()
        ) {
            Spacer(Modifier.height(16.dp))
            PhoneTextInput(viewModel.phoneState)
            Spacer(Modifier.height(4.dp))
            PasswordTextInput(viewModel.passwordState)
            Spacer(Modifier.height(4.dp))
            PasswordTextInput(
                state = viewModel.confirmPasswordState,
                placeholder = { CorePlaceholder(stringResource(string.repeat_password_placeholder)) }
            )
            Spacer(Modifier.height(20.dp))
            RegisterButton { viewModel.handleEvent(Register) }
        }
    }
}

@Composable
fun CloseIcon(modifier: Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.ic_close),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun RegisterButton(onClick: DefAction) {
    CoreButton(
        text = stringResource(string.register_button),
        onClick = onClick
    )
}

@Composable
fun RegisterTitle() {
    Text(
        text = stringResource(string.register_title),
        fontSize = 50.sp,
        fontFamily = FontFamily.Monospace
    )
}
