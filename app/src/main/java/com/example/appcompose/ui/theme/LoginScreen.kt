package com.example.appcompose.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appcompose.viewmodel.AuthViewModel
import com.example.appcompose.R

@Composable

fun LoginScreen(
    navController: NavController
){
    val authViewModel = hiltViewModel<AuthViewModel>()
    var usuario by remember { mutableStateOf("")}
    var senha by remember { mutableStateOf("")}
    var error by remember { mutableStateOf("")}

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ifro_campus_vertical),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .size(150.dp)
            )
            if (error.isNotBlank()){
                Text(error)
            }

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                //.padding(10.dp)
                //.width(350.dp)
            )
            Row {
                Button(
                    onClick = {
                        authViewModel.login(
                            usuario,
                            senha,
                            onSucess = {
                                navController.navigate("inicio")
                            },

                            onError = {message ->
                                error = message

                            }
                        )
                    },
                    colors = ButtonDefaults.run { buttonColors(Color.Red) },
                ) {
                    Text("Entrar")

                }
            }
        }

        if (authViewModel.loading.value){
            CarregarScreen()
        }
    }
}



