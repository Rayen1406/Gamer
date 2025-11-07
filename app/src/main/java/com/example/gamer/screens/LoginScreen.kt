package com.example.gamer.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gamer.R
import com.example.gamer.ui.theme.GamerTheme
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navController: NavHostController) {
    var context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmail by remember { mutableStateOf(true) }
    var isPassword by remember { mutableStateOf(true) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var rememberme by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_gamer),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth().height(100.dp)
                )


                OutlinedTextField(
                    label = { Text(text = "Email") },
                    isError = !isEmail,
                    supportingText = {
                        if (!isEmail) {
                            Text(text = "Email is not valid", color = Color.Red)
                        }
             },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email Icon"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { e ->
                        //isEmail = valedateEmail(email)
                        email = e
                    },
                    singleLine = true
                )
                OutlinedTextField(
                    label = { Text(text = "Password") },
                    isError = !isPassword,
                    supportingText = {
                        if (!isPassword) {
                            Text(text = "Password is not valid", color = Color.Red)
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password Icon"
                        )
                    },
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
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { p ->
                        //isPassword = valedatePassword(password)
                        password = p
                    },
                    singleLine = true,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = rememberme,
                            onCheckedChange = { rememberme = it }
                        )
                        Text(
                            text = "Remember me",
                            fontSize = 15.sp,
                            color = Color.Red,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Text(
                        text = "Forgot password?",
                        fontSize = 15.sp,
                        color = Color.Red,
                        textDecoration = TextDecoration.Underline // optional, makes it look like a link
                    )
                }

                Button(
                    onClick = {
                        //isEmail = valedateEmail(email)
                        //isPassword = valedatePassword(password)
                        //if (isEmail && isPassword)
                        //navigateToNews(navController ,email,password, rememberme,context )
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                    )
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "OR",
                        color = Color.Red,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Facebook Button
                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Coming soon :)")
                            }
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook Icon"
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text("Facebook")
                    }
                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Coming soon :)")
                            }
                        },
                        modifier = Modifier.weight(1f),
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray,
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Icon"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Google",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Don't have an account?", color = Color.Red,
                        fontSize = 15.sp
                    )
                    TextButton(
                        onClick = {
                            navController.navigate("signup")
                        }
                    ) {
                        Text(
                            "Register Now",
                            color = Color.Red,
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,

                        )
                    }

                }


            }


        }
    }
}

@Composable
fun ScaffoldSnackbarDemo() {
    // [START android_compose_layout_material_snackbar]
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Info, contentDescription = "") },
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Snackbar")
                    }
                }
            )
        }
    ) { contentPadding ->
        // Screen content
        // [START_EXCLUDE silent]
        Box(modifier = Modifier.padding(contentPadding)) { /* ... */ }
        // [END_EXCLUDE]
    }
    // [END android_compose_layout_material_snackbar]
}




@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    GamerTheme {
        LoginScreen(navController = rememberNavController())
    }
}