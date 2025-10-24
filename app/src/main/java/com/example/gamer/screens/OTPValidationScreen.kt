package com.example.gamer.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamer.ui.theme.GamerTheme
import kotlinx.coroutines.launch

@Composable
fun OTPValidationScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // OTP value (4 boxes)
    var otpValue by remember { mutableStateOf(List(4) { "" }) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // 🧾 Title
                Text(
                    text = "Enter the code sent to you by\nEmail or Mobile number",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // 🔢 OTP Boxes
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    otpValue.forEachIndexed { index, value ->
                        OutlinedTextField(
                            value = value,
                            onValueChange = { newValue ->
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    val newOtp = otpValue.toMutableList()
                                    newOtp[index] = newValue
                                    otpValue = newOtp
                                }
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp
                            ),
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // ✅ Verify Button
                Button(
                    onClick = {
                        val otpEntered = otpValue.joinToString("")
                        scope.launch {
                            if (otpEntered.length == 4)
                                snackbarHostState.showSnackbar("OTP Verified: $otpEntered")
                            else
                                snackbarHostState.showSnackbar("Please enter all 4 digits")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Verify", color = MaterialTheme.colorScheme.onPrimary, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 🔁 Resend Section
                Text("Didn’t receive a verification code?", fontSize = 14.sp)
                TextButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Coming Soon :)")
                    }
                }) {
                    Text("Resend code", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OTPValidationScreenPreview() {
    GamerTheme {
        OTPValidationScreen()
    }
}
