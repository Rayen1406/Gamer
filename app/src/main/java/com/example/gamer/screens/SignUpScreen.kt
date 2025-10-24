package com.example.gamer.screens

import android.icu.text.CaseMap
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamer.R
import com.example.gamer.ui.theme.GamerTheme
import kotlinx.coroutines.launch
import kotlin.compareTo



@Composable
fun SignUpScreen(){
    // Fields
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }

    // Field Errors
    var nameErr by remember { mutableStateOf("") }
    var emailErr by remember { mutableStateOf("") }
    var passErr by remember { mutableStateOf("") }
    var confirmPassErr by remember { mutableStateOf("") }

    // Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isconfirmPassVisible by remember { mutableStateOf(false) }



    fun validateFields(): Boolean {
        // Full name validation
        nameErr = when {
            fullName.isBlank() -> "Must not be empty"
            fullName.length < 6 -> "Must be at least 6 characters"
            else -> ""
        }

        // Email validation
        emailErr = when {
            email.isBlank() -> "Must not be empty"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
            else -> ""
        }

        // Password validation
        passErr = when {
            password.isBlank() -> "Must not be empty"
            password != confirmPass -> "Passwords must match"
            else -> ""
        }

        // Confirm password validation
        confirmPassErr = when {
            confirmPass.isBlank() -> "Must not be empty"
            confirmPass != password -> "Passwords must match"
            else -> ""
        }

        return nameErr.isEmpty() && emailErr.isEmpty() && passErr.isEmpty() && confirmPassErr.isEmpty()
    }
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

                Image(
                    painter = painterResource(R.drawable.logo_gamer),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )


                OutlinedTextField(
                    label = { Text("Full Name") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = ""
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxWidth(),
                    value = fullName,
                    onValueChange = { fullName = it
                                    validateFields()},
                    singleLine = true,
                    isError = nameErr.isNotEmpty(),
                    supportingText = {
                        if (nameErr.isNotEmpty()) {
                            Text(text = nameErr, color = Color.Red)
                        }
                    }
                )
                OutlinedTextField(
                    label = { Text("Email") },
                    isError = emailErr.isNotEmpty(),
                    supportingText = {
                        if (emailErr.isNotEmpty()) {
                            Text(text = emailErr, color = Color.Red)
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it
                                    validateFields()},
                    singleLine = true
                )
                OutlinedTextField(
                    label = { Text("Password") },
                    isError = passErr.isNotEmpty(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = ""
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it
                                    validateFields()},
                    supportingText = {
                        if (passErr.isNotEmpty()) {
                            Text(text = passErr, color = Color.Red)
                        }
                    },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                isPasswordVisible = !isPasswordVisible
                            })
                        {
                            Icon(
                                painter = if (isPasswordVisible) {
                                    painterResource(R.drawable.outline_visibility_24)
                                } else {
                                    painterResource(R.drawable.baseline_visibility_off_24)
                                },
                                contentDescription = "show Icon"
                            )
                        }

                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()

                )
                OutlinedTextField(
                    label = { Text("Confirm Password") },
                    isError = confirmPassErr.isNotEmpty(),
                    supportingText = {
                        if (confirmPassErr.isNotEmpty()) {
                            Text(text = confirmPassErr, color = Color.Red)
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = ""
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxWidth(),
                    value = confirmPass,
                    onValueChange = { confirmPass = it
                                    validateFields()},
                    singleLine = true,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                isconfirmPassVisible = !isconfirmPassVisible
                            })
                        {
                            Icon(
                                painter = if (isconfirmPassVisible) {
                                    painterResource(R.drawable.outline_visibility_24)
                                } else {
                                    painterResource(R.drawable.baseline_visibility_off_24)
                                },
                                contentDescription = "show Icon"
                            )
                        }

                    },
                    visualTransformation = if (isconfirmPassVisible) VisualTransformation.None else PasswordVisualTransformation()

                )
                Button(
                    onClick = {
                        if (!validateFields()) {
                            scope.launch {
                                snackbarHostState.showSnackbar("You have an Error in your inputs")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                    )
                ) {
                    Text(
                        text = "Submit",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                ) {
                    TermsAndPrivacyInline(

                        onTermsClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Coming Soon :)")
                            }
                        },
                        onPrivacyClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Coming Soon :)")
                            }
                        }
                    )
                }


            }


        }
    }
}




@Composable
fun TermsAndPrivacyInline(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
) {
    val termsTag = "terms"
    val privacyTag = "privacy"


    val annotated = buildAnnotatedString {
        append("By registering you agree to our ")

        // Terms
        pushStringAnnotation(tag = termsTag, annotation = "terms")
        withStyle(
            SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        ) { append("Terms & Conditions") }
        pop()

        append(" and ")

        // Privacy
        pushStringAnnotation(tag = privacyTag, annotation = "privacy")
        withStyle(
            SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        ) { append("Privacy Policy") }
        pop()
    }

    ClickableText(
        text = annotated,
        modifier = Modifier.fillMaxWidth(),


        style = MaterialTheme.typography.bodyMedium.copy(
            color = Color.Red,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotated.getStringAnnotations(start = offset, end = offset)
                .firstOrNull()
                ?.let {
                    when (it.tag) {
                        termsTag -> onTermsClick()
                        privacyTag -> onPrivacyClick()
                    }
                }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    GamerTheme {
        SignUpScreen()
    }
}