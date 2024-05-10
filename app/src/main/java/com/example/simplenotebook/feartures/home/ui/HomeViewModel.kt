package com.example.simplenotebook.feartures.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenotebook.feartures.home.domain.GetNoteItemByIdUseCase
import com.example.simplenotebook.feartures.home.domain.GetNoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNoteListUseCase: GetNoteListUseCase,
    private val getNoteItemByIdUseCase: GetNoteItemByIdUseCase
) :
    ViewModel() {
    private val _stateFlow: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState())
    val stateFlow = _stateFlow.asStateFlow()
    fun getNoteItemById(id: Int) {
        viewModelScope.launch {
            getNoteItemByIdUseCase(id).onSuccess {
                _stateFlow.value = _stateFlow.value.copy(noteItem = it)
            }
        }
    }

    fun getAllNotes() = viewModelScope.launch {
        getNoteListUseCase().onSuccess {
            _stateFlow.value = _stateFlow.value.copy(noteItemList = it)
        }
    }

}