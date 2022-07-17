package com.example.calculator

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.model.MainViewModel

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
   val model:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = model
        binding.events = ClickEvents()
        binding.lifecycleOwner = this
    }
}


