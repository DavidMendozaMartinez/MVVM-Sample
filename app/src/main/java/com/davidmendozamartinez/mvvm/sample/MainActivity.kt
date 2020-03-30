package com.davidmendozamartinez.mvvm.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.davidmendozamartinez.mvvm.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.progressVisibility.observe(this, Observer { visible ->
            binding.progress.visibility = if (visible) View.VISIBLE else View.GONE
        })
        viewModel.message.observe(this, Observer { message ->
            binding.message.text = message
        })

        with(binding) {
            button.setOnClickListener {
                viewModel.onButtonClicked(user.text.toString(), pass.text.toString())
            }
        }
    }
}