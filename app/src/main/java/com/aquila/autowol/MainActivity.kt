package com.aquila.autowol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import com.aquila.autowol.ui.theme.AutoWolTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AutoWolTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          floatingActionButtonPosition = FabPosition.End,
          floatingActionButton = {
            FloatingActionButton(
              onClick = { println("HELLO") },
              shape = MaterialTheme.shapes.medium.copy(CornerSize(percent = 50))
            ) {
              Icon(Icons.Default.Add, contentDescription = "Ted")
            }
          },
          topBar = {
            TopAppBar(
                title = { Text(text = "Auto Wake on Lan") },
                navigationIcon = {
                  IconButton(
                      onClick = { /*TODO*/ },
                    ) {
                    Icon(Icons.Default.Menu, contentDescription = "Hamburger Menu")
                  }
                },
              )
          }
          ) { innerPadding ->
          Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.surface
  ) {
    Text(
      text = "Hello $name!",
      modifier = modifier
    )
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AutoWolTheme {
    Greeting("Android")
  }
}