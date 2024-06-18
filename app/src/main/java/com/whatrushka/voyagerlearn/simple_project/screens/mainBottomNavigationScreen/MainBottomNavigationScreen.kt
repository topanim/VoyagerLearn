package com.whatrushka.voyagerlearn.simple_project.screens.mainBottomNavigationScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.whatrushka.voyagerlearn.simple_project.screens.firstScreen.FirstScreenTab
import com.whatrushka.voyagerlearn.simple_project.screens.secondScreen.SecondScreenTab

class MainBottomNavigationScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            FirstScreenTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(FirstScreenTab, SecondScreenTab)
                )
            }
        ) { tabNavigator ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = tabNavigator.current.options.title) }
                    )
                },
                content = {
                    Box(modifier = Modifier.padding(it)) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomAppBar {
                        TabNavigationItem(FirstScreenTab)
                        TabNavigationItem(SecondScreenTab)
                    }
                }
            )

        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        Log.d("m", tab.options.title)

        NavigationBarItem(
            selected = tabNavigator.current.key == tab.key,
            onClick = { tabNavigator.current = tab },
            label = { Text(text = tab.options.title) },
            colors = NavigationBarItemDefaults.colors(
                unselectedTextColor = Color.Black
            ),
            icon = {
                Icon(
                    painter = tab.options.icon!!,
                    contentDescription = tab.options.title
                )
            }
        )

    }
}