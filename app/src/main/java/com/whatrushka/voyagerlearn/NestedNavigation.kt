package com.whatrushka.voyagerlearn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent


@Composable
fun Content() {
    NestedNavigation(backgroundColor = Color.Gray) {
        CurrentScreen()
        NestedNavigation(backgroundColor = Color.LightGray) {
            CurrentScreen()
            NestedNavigation(backgroundColor = Color.White) { navigator ->
                CurrentScreen()
                Button(
                    onClick = { navigator.popUntilRoot() },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(text = "Pop Until Root")
                }
            }
        }
    }
}

@Composable
fun NestedNavigation(
    backgroundColor: Color,
    content: NavigatorContent = { CurrentScreen() }
) {
    Navigator(
        screen = BasicNavigationScreen(index = 0, wrapContent = true)
    ) { navigator ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .background(backgroundColor)
        ) {
            Text(
                text = "Level #${navigator.level}",
                modifier = Modifier.padding(8.dp)
            )
            content(navigator)
        }
    }
}
