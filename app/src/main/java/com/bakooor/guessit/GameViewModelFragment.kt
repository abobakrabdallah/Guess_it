package com.bakooor.guessit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModelFragment : ViewModel() {

    private lateinit var movieList: MutableList<String>

    private val _eventGameFinished = MutableLiveData<Boolean>()
    val eventGameFinished: LiveData<Boolean>
        get() = _eventGameFinished

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    init {
        _eventGameFinished.value = false
        resetList()
        nextWord()
        _score.value = 0
    }

    private fun resetList() {
        movieList = mutableListOf(
            "The Shawshank Redemption",
            "The Godfather",
            "The Dark Knight",
            "Taxi Driver",
            "Green Book",
            "There Will Be Blood",
            "Casino",
            "Shutter Island",
            "A Beautiful Mind",
            "No Country for Old Men",
            "Prisoners",
            "The Hunt",
            "Joker",
            "Django Unchained",
            "Memento",
            "The Prestige",
            "Whiplash",
            "The Departed",
            "The Pianist",
            "Goodfellas",
        )
        movieList.shuffle()
    }

    fun goToScore() {
        _eventGameFinished.value = true
    }

    private fun nextWord() {
        if (movieList.isEmpty()) {
            resetList()
        }
        _word.value = movieList.removeAt(0)
    }

    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }

    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onGameFinishedDone() {
        _eventGameFinished.value = false
    }
}