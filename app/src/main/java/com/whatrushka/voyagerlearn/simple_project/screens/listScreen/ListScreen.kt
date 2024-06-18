package com.whatrushka.voyagerlearn.simple_project.screens.listScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { ListScreenModel() }
        val state by screenModel.state.collectAsState()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Post List",
                style = MaterialTheme.typography.titleSmall
            )


            when (state) {
                is ListScreenModel.State.Init -> {
                    Text(
                        text = "init",
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                is ListScreenModel.State.Loading -> CircularProgressIndicator(progress = .5f)
                is ListScreenModel.State.Result -> Text(
                    text = (state as ListScreenModel.State.Result).value,
                    style = MaterialTheme.typography.titleSmall
                )
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { screenModel.getPost("hi") }
            ) {
                Text(
                    text = "get",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Button(
                onClick = { navigator.pop() }
            ) {
                Text(
                    text = "Return",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}