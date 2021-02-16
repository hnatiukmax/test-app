package com.hnatiuk.maxim.pages.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import coil.load
import com.hnatiuk.maxim.R
import com.hnatiuk.maxim.databinding.ActivitySecondPageBinding

class SecondPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondPageBinding
    private lateinit var viewModel: SecondPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_page)
        viewModel = ViewModelProviders.of(this).get(SecondPageViewModel::class.java)

        binding.apply {
            lifecycleOwner = this@SecondPageActivity
            viewModel = this@SecondPageActivity.viewModel
        }

        observeViewModel()
        viewModel.load()
    }

    private fun observeViewModel() = with(viewModel) {
        openingTimes.observe(this@SecondPageActivity) {
            val text = getString(R.string.opened, it.toString())
            binding.numberOfTime.text = text
        }

        id.observe(this@SecondPageActivity) {
            val text = getString(R.string.user_id, it.toString())
            binding.userId.text = text
        }

        title.observe(this@SecondPageActivity) {
            val text = getString(R.string.title, it.toString())
            binding.title.text = text
        }

        statusLogo.observe(this@SecondPageActivity) {
            binding.status.load(it)
        }
    }
}