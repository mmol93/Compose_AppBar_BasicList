package com.example.composetheme

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetheme.ui.theme.AppBar.AppBarData
import com.example.composetheme.ui.theme.ComposeThemeTheme
import com.google.accompanist.coil.rememberCoilPainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemeTheme {
                Column() {
                    Appbar()
                    lazyList()
                }
            }
        }
    }
}
@Composable
fun Appbar(){
    Column() {
        // 앱바 생성
        TopAppBar(title = { Text(text = "AppBar", color = Color.Magenta) },
            backgroundColor = Color.White,
            // 네비게이션 버튼 생성(좌측에 있는 버튼)
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
            // 액션 버튼 생성(우측에 있는 버튼)
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.ic_baseline_settings_24),
                        contentDescription = null)
                }
            }
        )
    }
}

@Composable
fun lazyList(){
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100){
            ImageListItem(index = it)
        }
    }
}
@Composable
fun ImageListItem(index : Int){
    // verticalAlignment 리스트 안에서 어떻게 정렬할지
    // Alignment.CenterVertically: 리스트 안 모든 요소를 세로기준 가운데 정렬
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = rememberCoilPainter(
            request = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text("Item: #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    ComposeThemeTheme {
        Column() {
            Appbar()
            lazyList()
        }
    }
}