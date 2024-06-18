package com.whatrushka.voyagerlearn.simple_project.screens.firstScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.whatrushka.voyagerlearn.SharedScreen

object FirstScreenTab : Tab {
    private fun readResolve(): Any = FirstScreenTab
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "First",
                    icon = icon
                )
            }
        }



    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow.parent!!
        val postDetailsScreen = rememberScreen(provider = SharedScreen.PostList)

        Column {
            Text(options.title)

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