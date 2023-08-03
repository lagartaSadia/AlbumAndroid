package com.example.album

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

@Composable
fun AlbumApp() {
    AlbumTheme {
        GalleryWithImageAndTextAndButtons()
    }
}

@Composable
fun GalleryWithImageAndTextAndButtons() {
    var returnButton by remember {
        mutableStateOf(false)
    }
    var fowardButton by remember {
        mutableStateOf(true)
    }
    var imageNumber by remember {
        mutableStateOf(1)
    }
    val imageResource = when(imageNumber) {
        1 -> R.drawable.teiu_1
        2 -> R.drawable.teiu_2
        3 -> R.drawable.teiu_3
        else -> R.drawable.teiu_4
    }
    val imageAuthor = when(imageNumber) {
        1 -> R.string.description_1
        2 -> R.string.description_2
        3 -> R.string.description_3
        else -> R.string.description_4
    }

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
            .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(1f),
            painter = painterResource(imageResource),
            contentDescription = "Teiú",
            contentScale = ContentScale.FillWidth)
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(imageAuthor))
            Text(text = stringResource(R.string.author_name))
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Button(enabled = returnButton, onClick = {
                imageNumber -= 1
                if (imageNumber == 1) {
                    returnButton = false
                }
                if (imageNumber != 4) {
                    fowardButton = true
                }
            }) {
                Text(text = "Voltar")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Button(enabled = fowardButton, onClick = {
                imageNumber += 1
                if (imageNumber != 1) {
                    returnButton = true
                }
                if (imageNumber == 4) {
                    fowardButton = false
                }
            }
            ) {
                Text(text = "Avançar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumAppPreview() {
    AlbumTheme {
        AlbumApp()
    }
}