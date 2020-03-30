package com.davidmendozamartinez.mvvm.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.davidmendozamartinez.mvvm.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val presenter = MainPresenter(this, lifecycleScope)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                presenter.onButtonClicked(user.text.toString(), pass.text.toString())
            }
        }
    }

    override fun setProgressVisible(visible: Boolean) {
        binding.progress.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun setMessage(message: String) {
        binding.message.text = message
    }
}