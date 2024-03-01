package com.example.appcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcompose.datastore.AppDataStore
import com.example.appcompose.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
): ViewModel(){
    val autenticado = mutableStateOf(false)

    fun login(
        user:String,
        senha:String,
        onSucess:() -> Unit,
        onError: (String) -> Unit,
    ){
        if (user.isEmpty()) {
            onError("Informe o usuario")
        }

        if (senha.isEmpty()){
            onError("Informe a senha")
        }
        if (user == "Aminah" && senha == "1234"){
            viewModelScope.launch {
                //delay(2000)
                appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO,true).apply {
                    onSucess()
                }
            }

        } else{
            onError("Usuário ou senha inválida")
        }
    }

    fun logout(){
        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, false)
        }

    }
}