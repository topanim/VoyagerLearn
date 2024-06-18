package com.whatrushka.voyagerlearn.simple_project.screens.secondScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object SecondScreenTab : Tab {
    private fun readResolve(): Any = SecondScreenTab
    override val options: TabOptions
    @Composable
    get() {
        val icon = rememberVectorPainter(Icons.Default.ThumbUp)

        return remember {
            TabOptions(
                index = 1u,
                title = "Second",
                icon = icon
            )
        }
    }


    @Composable
    override fun Content() {
        Text(options.title)
    }
}