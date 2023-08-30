package com.bakooor.guessit

import android.accounts.AccountManager.get
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import com.bakooor.guessit.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModelFragment
    private lateinit var binding: FragmentGameBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)


        viewModel = ViewModelProvider(this)[GameViewModelFragment::class.java]

        viewModel.score.observe(this, Observer{ newScore ->
            binding.tvscore.text = newScore.toString()
        })


        binding.b2.setOnClickListener { viewModel.onCorrect()
            updateWord()
            }
        binding.b3.setOnClickListener { viewModel.onSkip()
            updateWord()
            }
        return binding.root
    }



    private fun gameFinished() {
        findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(viewModel.score.value ?:0))
    }

    private fun updateWord() {
        binding.tvWord.text = viewModel.word
    }




}