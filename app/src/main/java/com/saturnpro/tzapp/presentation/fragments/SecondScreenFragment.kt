package com.saturnpro.tzapp.presentation.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saturnpro.tzapp.R
import com.saturnpro.tzapp.databinding.FragmentFirstScreenBinding
import com.saturnpro.tzapp.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {

    private lateinit var binding: FragmentSecondScreenBinding
    private lateinit var randomValuePercentageTxt: TextView
    private lateinit var randomValuePercentageTxtTwo: TextView
    private lateinit var hoursTxt: TextView
    private lateinit var minutesTxt: TextView
    private lateinit var secondsTxt: TextView
    private lateinit var loadDataPercentageTxt: TextView

    private lateinit var randomProgressBar: ProgressBar
    private lateinit var randomProgressBarTwo: ProgressBar
    private lateinit var downloadDataProgressBar: ProgressBar

    private lateinit var backButton: ImageView
    private lateinit var randomizeValuesButton: Button

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater)
        randomValuePercentageTxt = binding.randomValueTitleTxtPercentage
        randomValuePercentageTxtTwo = binding.randomValueTitleTxtPercentageTwo
        hoursTxt = binding.hoursTv
        minutesTxt = binding.minutesTv
        secondsTxt = binding.secondsTv
        loadDataPercentageTxt = binding.downloadFromServeTittlePercentageTxt

        randomProgressBar = binding.randomProgressBar
        randomProgressBarTwo = binding.randomProgressBartwo
        downloadDataProgressBar = binding.downloadFromServerProgressBar
        backButton = binding.backbutton
        randomizeValuesButton = binding.randomizeBtn
        recyclerView = binding.rv
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton.setOnClickListener {

        }

        randomizeValuesButton.setOnClickListener {
            startProgress()
        }

    }

    private fun startProgress() {
        val randomOne = (5000..25000).random()
        val randomTwo = (5000..25000).random()
        val animator = ValueAnimator.ofInt(0, 100)
        val animator2 = ValueAnimator.ofInt(0, 100)
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            randomProgressBar.setProgress(progress)
            randomValuePercentageTxt.text = "${progress}%"
        }
        animator2.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            randomProgressBarTwo.setProgress(progress)
            randomValuePercentageTxtTwo.text = "${progress}%"
        }

        //animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = randomOne.toLong()
        animator2.duration = randomTwo.toLong()
        animator.start()
        animator2.start()
    }
}