package com.bakooor.guessit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bakooor.guessit.databinding.FragmentScoreBinding
import com.bakooor.guessit.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentScoreBinding.inflate(inflater)
        binding.b4.setOnClickListener { findNavController().navigate(R.id.action_scoreFragment_to_gameFragment) }
        return binding.root
    }


}