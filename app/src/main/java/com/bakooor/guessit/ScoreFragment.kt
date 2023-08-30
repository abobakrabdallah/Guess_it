package com.bakooor.guessit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bakooor.guessit.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private val args: ScoreFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentScoreBinding.inflate(inflater, container, false)
        binding.tvScore.text = args.score.toString()
        binding.b4.setOnClickListener { findNavController().navigate(R.id.action_scoreFragment_to_gameFragment) }

        return binding.root
    }


}