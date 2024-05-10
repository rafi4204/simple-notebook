package com.example.simplenotebook.feartures.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.simplenotebook.data.model.NoteItem
import com.example.simplenotebook.feartures.home.domain.GetNoteItemByIdUseCase
import com.example.simplenotebook.feartures.home.domain.GetNoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNoteListUseCase: GetNoteListUseCase,
    private val getNoteItemByIdUseCase: GetNoteItemByIdUseCase
) :
    ViewModel() {
    private val _homeStateFlow: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState())
    val homeStateFlow = _homeStateFlow.asStateFlow()


    var allNoteItem: LiveData<List<NoteItem>>? = null

    init {
        getAllNotes()
       /* insert(
            NoteItem(
                id = Random.nextInt(),
                date = "21-04-2024",
                title = "Sample1",
                content = "Why do u care?"
            )
        )
        insert(
            NoteItem(
                id = Random.nextInt(),
                date = "22-04-2024",
                title = "Sample2",
                content = "STFU"
            )
        )
        insert(
            NoteItem(
                id = Random.nextInt(),
                date = "23-04-2024",
                title = "Sample3",
                content = "WTF"
            )
        )
        insert(
            NoteItem(
                id = Random.nextInt(),
                date = "24-04-2024",
                title = "Sample4",
                content = "NASTY"
            )
        )
        insert(
            NoteItem(
                id = Random.nextInt(),
                date = "25-04-2024",
                title = "Sample5",
                content = "YO BITCH!!!"
            )
        )*/
    }


    fun getNoteItemById(id: Int){
        viewModelScope.launch {
            getNoteItemByIdUseCase(id).onSuccess {
                _homeStateFlow.value = _homeStateFlow.value.copy(noteItem = it)
            }
        }
    }

    fun getAllNotes() = viewModelScope.launch {
        getNoteListUseCase().onSuccess {
            _homeStateFlow.value = _homeStateFlow.value.copy(noteItemList = it.asLiveData().value)
        }
    }

}