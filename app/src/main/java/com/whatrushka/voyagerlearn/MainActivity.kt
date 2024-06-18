package com.whatrushka.voyagerlearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import com.whatrushka.voyagerlearn.simple_project.screens.listScreen.ListScreen
import com.whatrushka.voyagerlearn.simple_project.screens.mainBottomNavigationScreen.MainBottomNavigationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        ScreenRegistry {
            register<SharedScreen.PostList> {
                ListScreen()
            }
        }

        setContent {
            Navigator(screen = MainBottomNavigationScreen())
        }
    }


}
