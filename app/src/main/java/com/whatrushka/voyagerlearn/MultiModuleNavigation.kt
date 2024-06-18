package com.whatrushka.voyagerlearn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import java.util.UUID

sealed class SharedScreen : ScreenProvider {
    data object PostList : SharedScreen()
    data class PostDetails(val id: String) : SharedScreen()
}

class HomeScreen : Screen {

    private val randomId: String
        get() = UUID.randomUUID().toString()

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val postListScreen = rememberScreen(SharedScreen.PostList)
        val postDetailsScreen = rememberScreen(SharedScreen.PostDetails(id = randomId))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Home",
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navigator.push(postListScreen) }
            ) {
                Text(
                    text = "To Post List",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navigator.push(postDetailsScreen) }
            ) {
                Text(
                    text = "To Post Details",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

class ListScreenOld : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Post List",
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

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

data class DetailsScreen(
    val id: String
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Post Details",
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "ID: $id",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

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