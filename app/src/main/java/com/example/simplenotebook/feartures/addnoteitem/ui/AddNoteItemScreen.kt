package com.example.simplenotebook.feartures.addnoteitem.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenotebook.data.model.NoteItem
import java.time.LocalDate
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteItemScreen(
    uiState: AddNoteItemState = AddNoteItemState(),
    actions: AddNoteItemActions = AddNoteItemActions()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null
                    )
                    Box(modifier = Modifier.width(16.dp))
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                    Box(modifier = Modifier.width(16.dp))
                    Icon(imageVector = Icons.Default.Check, modifier = Modifier.clickable {

                        actions.onAddNoteItem(
                            NoteItem(
                                id = Random.nextInt(),
                                title = uiState.title,
                                content = uiState.content,
                                date = LocalDate.now().toString()
                            )
                        )
                    }, contentDescription = null)
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TextField(
                value = uiState.title, onValueChange = { title ->
                    actions.onTitleChange(title)
                }, modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                placeholder = { Text(text = "Heading", fontSize = 20.sp, color = Color.Gray) }
            )
            TextField(
                value = uiState.content, onValueChange = { content ->
                    actions.onContentChange(content)
                }, modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                placeholder = { Text(text = "Write Here", color = Color.Gray) }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun PreviewAddNoteItemScreen() {
    AddNoteItemScreen()
}