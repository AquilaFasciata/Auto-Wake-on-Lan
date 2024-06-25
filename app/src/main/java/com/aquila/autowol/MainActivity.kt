package com.aquila.autowol

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
          Column (modifier = Modifier.padding(innerPadding)) {
            DeviceListing(
              compName = "Computer",
              devIcon = R.drawable.desktop_windows
            )
          }
        }
      }
    }
  }
}

@Composable
fun DeviceListing(compName: String, devIcon: Int) {
  Surface (
    color = MaterialTheme.colorScheme.surfaceVariant,
    modifier = Modifier
      .padding(all = 6.dp)
      .fillMaxWidth()
      .height(85.dp),
    shape = MaterialTheme.shapes.large,
    ) {
    Row {
      Icon(
        painter = painterResource(id = devIcon),
        contentDescription = "Device icon",
        modifier = Modifier
          .size(60.dp)
          .clip(CircleShape)
          .scale(scale = 0.8f)
          .align(Alignment.CenterVertically)
      )

      Spacer(modifier = Modifier.width(8.dp))

      Text(text = compName, modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeviceListingPreview() {
  DeviceListing(compName = "Computer 1", devIcon = R.drawable.desktop_windows)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
  AutoWolTheme {
    DeviceListingPreview()
  }
}