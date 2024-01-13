package com.example.asesmen3

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.asesmen3.BottomSheetFragment2
import com.example.asesmen3.R
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.ncorti.slidetoact.SlideToActView

class ChatFragment : Fragment() {

    private lateinit var circularProgressBar: CircularProgressBar
    private lateinit var tvTimeLeft: TextView
    private lateinit var slideToActView: SlideToActView
    private var countDownTimer: CountDownTimer? = null

    private val timerDuration = 1 * 60 * 1000L // 1 minute (adjusted for testing)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        circularProgressBar = view.findViewById(R.id.circularProgressBar)
        tvTimeLeft = view.findViewById(R.id.tvTimeLeft)
        slideToActView = view.findViewById(R.id.example)

        // Set initial progress and max
        circularProgressBar.progressMax = timerDuration.toFloat()
        circularProgressBar.progress = timerDuration.toFloat()

        countDownTimer = object : CountDownTimer(timerDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = timerDuration - millisUntilFinished
                circularProgressBar.progress = progress.toFloat()
                tvTimeLeft.text = formatTime(millisUntilFinished)
            }

            override fun onFinish() {
                circularProgressBar.progress = 0f
                tvTimeLeft.text = "00:00:00"
            }
        }

        // Start the countdown timer when the fragment is created
        countDownTimer?.start()

        val bottomSheetFragment = BottomSheetFragment2()

        slideToActView.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                // Tampilkan BottomSheetFragment2 ketika SlideToActView diklik
                bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
                Handler().postDelayed({
                    // Pindah ke MainActivity3
                    val intent = Intent(activity, MainActivity3::class.java)
                    startActivity(intent)
                }, 3000)
            }
        }

        return view
    }

    private fun formatTime(millis: Long): String {
        val hours = millis / (1000 * 60 * 60)
        val minutes = millis % (1000 * 60 * 60) / (1000 * 60)
        val seconds = millis % (1000 * 60) / 1000
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    override fun onDestroy() {
        countDownTimer?.cancel()
        super.onDestroy()
    }
}

