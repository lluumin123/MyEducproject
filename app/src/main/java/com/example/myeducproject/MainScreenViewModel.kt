package com.example.myeducproject

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {
    private val _currentIndex = mutableIntStateOf(0)
    val currentIndex: State<Int> = _currentIndex
    val factsList = listOf<Pair<String, Boolean>>(
        Pair("У улитки три сердца.", true),
        Pair("Человек использует только 10% своего мозга.", false),
        Pair("Молния может ударить дважды в одно и то же место.", true),
        Pair("Бананы растут на деревьях.", false),
        Pair("Сахар вызывает гиперактивность у детей.", false),
        Pair("Хамелеоны меняют цвет, чтобы сливаться с окружением.", false)
    )
    val currentFact: State<Pair<String, Boolean>> = derivedStateOf {
        factsList[currentIndex.value]
    }

    fun nextFact(){
        if (_currentIndex.intValue < factsList.size - 1)
            _currentIndex.intValue += 1
        else if (_currentIndex.intValue == factsList.size - 1)
                _currentIndex.intValue = 0
    }

    fun checkAnswer(answer: Boolean): Boolean{
        return currentFact.value.second == answer
    }


}