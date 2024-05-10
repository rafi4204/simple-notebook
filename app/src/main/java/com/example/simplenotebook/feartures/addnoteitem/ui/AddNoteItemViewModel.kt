package com.example.simplenotebook.feartures.addnoteitem.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenotebook.data.model.NoteItem
import com.example.simplenotebook.feartures.addnoteitem.domain.InsertNoteItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteItemViewModel @Inject constructor(private val insertNoteItemsUseCase: InsertNoteItemsUseCase) :
    ViewModel() {

    private val _stateFlow = MutableStateFlow(AddNoteItemState())
    val stateFlow = _stateFlow.asStateFlow()

    fun insert(noteItem: NoteItem) = viewModelScope.launch {
        insertNoteItemsUseCase(noteItem).onSuccess {
            _stateFlow.value = _stateFlow.value.copy(isNoteItemInserted = true)
        }.onFailure {
            _stateFlow.value = _stateFlow.value.copy(isNoteItemInserted = false)
        }

    }

    fun onTitleChanged(title: String) {
        _stateFlow.value = _stateFlow.value.copy(title = title)
    }

    fun onContentChanged(content: String) {
        _stateFlow.value = _stateFlow.value.copy(content = content)
    }
}


