package com.saturnpro.tzapp.presentation.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.saturnpro.tzapp.R
import com.saturnpro.tzapp.databinding.FragmentFirstScreenBinding
import com.saturnpro.tzapp.databinding.FragmentSecondScreenBinding
import java.util.*
import java.util.concurrent.TimeUnit

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

    private var duration = 3700

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
            findNavController().navigate(R.id.action_secondScreenFragment_to_firstScreenFragment)
        }

        randomizeValuesButton.setOnClickListener {
            startProgress()
        }

        startTimer()

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

    private fun startTimer() {



        object : CountDownTimer((duration * 1000).toLong(), 1000) { // 10 saniye içinde 1 saniye aralıklarla işimizi yapıyoruz.
            override fun onTick(millisUntilFinished: Long) {
                var time = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
                    Locale.getDefault()
                )
                var hms: List<String> = time.split(":")
                hoursTxt.text = hms[0]
                minutesTxt.text = hms[1]
                secondsTxt.text = hms[2]

            }

            override fun onFinish() {
                startTimer()
            }
        }.start()
    }
}