package com.saturnpro.tzapp.presentation.fragments

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.saturnpro.tzapp.R
import com.saturnpro.tzapp.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : Fragment() {
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
        go_to_second_screen = binding.goToSecondScreenBtn
        start_anim_btn = binding.startAnimBtn
        stop_anim_btn = binding.stopAnimBtn
        hide_anim_btn = binding.hideShowAnimBtn
        open_dialog_btn = binding.showCustomAlertBtn
        progressBar = binding.progressBar
        percentage_progress = binding.percentage
        my_Animation = binding.lottieAnim
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        go_to_second_screen.setOnClickListener {
            findNavController().navigate(R.id.action_firstScreenFragment_to_secondScreenFragment)
        }
        startProgress()
        start_anim_btn.setOnClickListener {
            my_Animation.playAnimation()
        }
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

    private fun startProgress() {
        val animator = ValueAnimator.ofInt(0, 100)
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            progressBar.setProgress(progress)
            percentage_progress.text = "${progress}%"
        }
        //animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 14000
        animator.start()
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

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}