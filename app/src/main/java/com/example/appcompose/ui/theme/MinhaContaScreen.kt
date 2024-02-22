package com.example.appcompose.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun MinhaContaScreen(){
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbr.pinterest.com%2Fmarcusmickaelq%2Fimagens-para-perfil%2F&psig=AOvVaw2NCeGdZwMv7KvjtutI7o6g&ust=1708717745080000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNiIu-Tbv4QDFQAAAAAdAAAAABAV",
                contentDescription = "n sei",
                modifier = Modifier
                    .padding(top = 160.dp, bottom = 100.dp)
                    .size(200.dp)
            )



        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun MinhaContaScreenPreview(){
    MinhaContaScreen()
}