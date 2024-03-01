package com.example.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcompose.ui.theme.AppcomposeTheme
import com.example.appcompose.ui.theme.InicioScreen
import com.example.appcompose.ui.theme.LoginScreen
import com.example.appcompose.ui.theme.MinhaContaScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppcomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(navController = navController,
                        startDestination = "login"){

                        
                        composable("inicio"){
                            InicioScreen(navController)
                        }

                        composable("login"){
                            LoginScreen(navController)
                        }

                        composable("minha-conta"){
                            MinhaContaScreen(navController)
                        }
                    }


                }
            }

        }
    }
}