package com.example.acuitytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.acuitytestapp.viewmodel.ScoreViewModel
import com.example.acuitytestapp.viewmodel.ScoreViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var scoreViewModelFactory : ScoreViewModelFactory
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreViewModelFactory = ScoreViewModelFactory()
        scoreViewModel = ViewModelProvider(this, scoreViewModelFactory).get(ScoreViewModel::class.java)
    }
}