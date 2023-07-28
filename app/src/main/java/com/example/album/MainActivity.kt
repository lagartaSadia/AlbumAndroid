package com.example.album

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.album.ui.theme.AlbumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryWithImageAndTextAndButtons()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    AlbumTheme {
        GalleryWithImageAndTextAndButtons()
    }
}

@Composable
fun GalleryWithImageAndTextAndButtons() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Image 1")
        Text(text = "Maybe a cat, by Lagarta")

    }
}

