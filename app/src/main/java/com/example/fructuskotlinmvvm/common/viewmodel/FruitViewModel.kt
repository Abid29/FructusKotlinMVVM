package com.example.fructuskotlinmvvm.common.viewmodel

import FruitRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel

class FruitViewModel(
    private val app : Application,
    private val fruitRepository: FruitRepository)
    :AndroidViewModel(app){

//    fun addNote(note: Note) =
//        viewModelScope.launch {
//            noteRepository.insertNote(note)
//        }
//
//    fun deleteNote(note: Note) =
//        viewModelScope.launch {
//            noteRepository.deleteNote(note)
//        }
//
//    fun updateNote(note: Note) =
//        viewModelScope.launch {
//            noteRepository.updateNote(note)
//        }

    fun getAllFruits() = fruitRepository.getAllFruits()

//    fun searchNote(query: String?) =
//        noteRepository.searchNote(query)
}