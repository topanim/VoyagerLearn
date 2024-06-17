package com.whatrushka.voyagerlearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScreenRegistry {
                register<SharedScreen.PostList> {
                    ListScreen()
                }
                register<SharedScreen.PostDetails> { provider ->
                    DetailsScreen(id = provider.id)
                }
            }
            
            Navigator(screen = HomeScreen())
        }
    }
}
