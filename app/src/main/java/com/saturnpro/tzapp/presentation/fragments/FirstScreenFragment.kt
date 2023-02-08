package com.saturnpro.tzapp.presentation.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.saturnpro.tzapp.R
import com.saturnpro.tzapp.databinding.FragmentFirstScreenBinding
import com.saturnpro.tzapp.presentation.ProgressBarAnimation
import com.saturnpro.tzapp.presentation.SecondScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenFragment : Fragment() {
    private val viewModel: SecondScreenViewModel by viewModels()
    private lateinit var binding: FragmentFirstScreenBinding
    private lateinit var go_to_second_screen: Button
    private lateinit var start_anim_btn: Button
    private lateinit var stop_anim_btn: Button
    private lateinit var hide_anim_btn: Button
    private lateinit var open_dialog_btn: Button
    private lateinit var close_dialog_btn: Button
    private lateinit var my_Animation: LottieAnimationView
    private lateinit var percentage_progress: TextView
    lateinit var progressBar : ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        go_to_second_screen.setOnClickListener {
            findNavController().navigate(R.id.action_firstScreenFragment_to_secondScreenFragment)
        }
        startProgressAndLottie()
        stop_anim_btn.setOnClickListener {
            my_Animation.pauseAnimation()
        }
        hide_anim_btn.setOnClickListener {
            if(my_Animation.visibility != View.GONE) {
                my_Animation.visibility = View.GONE
            } else {
                my_Animation.visibility = View.VISIBLE
            }
        }
        open_dialog_btn.setOnClickListener {
            show_my_dialog()
        }
    }

    private fun init() {
        go_to_second_screen = binding.goToSecondScreenBtn
        start_anim_btn = binding.startAnimBtn
        stop_anim_btn = binding.stopAnimBtn
        hide_anim_btn = binding.hideShowAnimBtn
        open_dialog_btn = binding.showCustomAlertBtn
        progressBar = binding.progressBar
        percentage_progress = binding.percentage
        my_Animation = binding.lottieAnim
    }

    private fun startProgressBad(
        pb: ProgressBar,
        tv: TextView,
        duration: Long,
        from: Int
    ) {
        pb.max = 100
        pb.scaleY = 3f
        val anim = ProgressBarAnimation(pb, tv, from.toFloat(), 100f)
        anim.duration = duration
        pb.animation = anim
    }

    private fun show_my_dialog() {
        val builder = AlertDialog.Builder(activity)
        val customDialogView = LayoutInflater.from(activity).inflate(R.layout.custom_dialogview, null)
        builder.setView(customDialogView)
        val dialog = builder.create()

        close_dialog_btn = customDialogView.findViewById(R.id.close_alert_btn)
        close_dialog_btn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun saveLottie() {
        val anim = my_Animation
        viewModel.setLottie(anim.progress)
        anim.pauseAnimation()

    }
    private fun saveProgress(){
        viewModel.setProgress(binding.progressBar.progress)
        binding.progressBar.animation = null
    }

    override fun onStop() {
        super.onStop()
        saveLottie()
        saveProgress()
    }

    override fun onResume() {
        super.onResume()
        startProgressAndLottie()
    }
    private fun startProgressAndLottie() {
        var lottieP: Float? = viewModel.getLottiProgress()
        var progressB: Int? = viewModel.getPbProgress()
        viewModel.animatiponP.observe(this.viewLifecycleOwner, { progress ->
            lottieP = progress
        })
        viewModel.progressBar.observe(this.viewLifecycleOwner, { progress ->
            progressB = progressB
        })
        if (lottieP != null){
            my_Animation.progress = lottieP!!
            my_Animation.resumeAnimation()
        }else{
            my_Animation.playAnimation()
        }
        startProgressBad(progressBar, percentage_progress, 14000, progressB?: 0)
        start_anim_btn.setOnClickListener {
            my_Animation.playAnimation()
        }
    }
}