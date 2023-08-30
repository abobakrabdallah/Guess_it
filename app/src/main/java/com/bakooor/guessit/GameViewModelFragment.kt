package com.bakooor.guessit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModelFragment: ViewModel() {
    lateinit var movieList: MutableList<String>
    var word = ""
    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score
    init{
        Log.i("GameViewModelFragment","okkkkkkkkkkkkkkkkkk")
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
    private fun nextWord() {
        if (movieList.isEmpty()) {
            //gameFinished()
        } else {
            word = movieList.removeAt(0)
        }
        }
        fun onCorrect() {
            _score.value = (_score.value)?.plus(1)
            nextWord()
        }

        fun onSkip() {
            _score.value = (_score.value)?.minus(1)
            nextWord()
        }
        override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModelFragment", "kfkfkfkfkfkfkkkfkkfkkfkfkfkkfkfff")
    }

}