package com.bakooor.guessit

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.bakooor.guessit.databinding.FragmentGameBinding

const val ONE_SECOND = 1000L
const val COUNTDOWN_TIME = 20000L

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModelFragment
    private lateinit var binding: FragmentGameBinding
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                val time = millisUntilFinished / 1000
                binding.tvTimer.text = time.toString()
            }

            override fun onFinish() {
                viewModel.goToScore()
            }
        }

        viewModel = ViewModelProvider(this)[GameViewModelFragment::class.java]

        viewModel.score.observe(this) { newScore ->
            binding.tvscore.text = newScore.toString()
        }

        viewModel.word.observe(this) { newWord -> binding.tvWord.text = newWord.toString() }

        viewModel.eventGameFinished.observe(this) { gameFinished ->
            if (gameFinished) {
                gameFinished()
                viewModel.onGameFinishedDone()
            }
        }

        binding.b2.setOnClickListener {
            viewModel.onCorrect()
        }

        binding.b3.setOnClickListener {
            viewModel.onSkip()
        }

        timer.start()

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    private fun gameFinished() {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToScoreFragment(
                viewModel.score.value ?: 0
            )
        )
    }


}

