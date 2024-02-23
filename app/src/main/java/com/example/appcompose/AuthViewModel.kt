package com.example.appcompose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel(){
    val autenticado = mutableStateOf(false)

    fun login(
        user:String,
        senha:String,
        onSucess:() -> Unit,
        onError: (String) -> Unit,
    ){
        if (user == "Aminah" && senha == "1234"){
            onSucess()
        } else{
            onError("Usuário ou senha inválida")
        }
    }
}