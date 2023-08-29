package com.bakooor.guessit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bakooor.guessit.databinding.FragmentGameBinding



class GameFragment : Fragment() {
    private var word = ""
    private var score = 0
    private lateinit var movieList: MutableList<String>
    private lateinit var binding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentGameBinding.inflate(inflater)
        resetList()
        nextWord()
        binding.b2.setOnClickListener { onCorrect() }
        binding.b3.setOnClickListener { onSkip() }
        updateWord()
        updateScore()
        return binding.root
    }
    private fun resetList(){
        movieList= mutableListOf(
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
    private fun gameFinished(){
        findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(score))
    }
    private fun nextWord() {
        if (movieList.isEmpty()){
            gameFinished()
        }
        else{
            word = movieList.removeAt(0)
        }
        updateScore()
        updateWord()
    }
    private fun onCorrect(){
        score++
        nextWord()
    }
    private fun onSkip(){
        score--
        nextWord()
    }


    private fun updateWord(){
        binding.tv4.text=word
    }
    private fun updateScore(){
        binding.tvscore.text=score.toString()
    }


}