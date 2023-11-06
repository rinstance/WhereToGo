package com.rinstance.feature.auth.presentation.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rinstance.core.ui.text_inputs.CoreTextInput
import com.rinstance.core.ui.text_inputs.InputPlaceHolder
import com.rinstance.feature.auth.presentation.R

@Preview
@Composable
internal fun LoginScreen() {
    Button(
        onClick = {
    }) {
        Text(text = "login")
    }
}

@Composable
fun PasteMePleaseLater() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .wrapContentSize(Alignment.Center)
            .padding(
                horizontal = 24.dp,
                vertical = 32.dp
            )
    ) {
        Text(
            text = stringResource(R.string.auth_title),
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        CoreTextInput(
            placeholder = { InputPlaceHolder(text = stringResource(R.string.login_placeholder)) }
        )

        Spacer(Modifier.height(8.dp))

        CoreTextInput(
            placeholder = { InputPlaceHolder(text = stringResource(R.string.password_placeholder)) }
        )
    }
}
