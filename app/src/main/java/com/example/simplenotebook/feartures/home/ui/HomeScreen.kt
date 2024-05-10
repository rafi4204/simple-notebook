package com.example.simplenotebook.feartures.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenotebook.data.model.NoteItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(homeState: HomeState = HomeState(), actions: HomeActions = HomeActions()) {
    Scaffold(floatingActionButton = {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(CircleShape)
                .background(color = Color.Blue)
                .clickable {
                    actions.navigateToAddNoteItemScreen()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable {
                })
        }
    },
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    Box(modifier = Modifier.width(16.dp))
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                })

        },
        bottomBar = {
            BottomAppBar {
                Icon(
                    modifier = Modifier.fillMaxWidth(.5f),
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
                Icon(
                    modifier = Modifier.fillMaxWidth(.5f),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            }
        }) {
        LazyColumn {
            homeState.noteItemList?.size?.let { it1 ->
                items(count = it1) {
                    ListItem(homeState.noteItemList[it])
                }
            }
        }
    }
}


@Composable
fun ListItem(noteItem: NoteItem) {
    Column {
        Text(text = noteItem.date, fontSize = 14.sp)
        Text(text = noteItem.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = noteItem.content, fontSize = 16.sp)
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

