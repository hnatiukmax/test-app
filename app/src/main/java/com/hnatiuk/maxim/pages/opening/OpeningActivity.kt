package com.hnatiuk.maxim.pages.opening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.hnatiuk.maxim.R
import com.hnatiuk.maxim.databinding.OpeningActivityBinding
import com.hnatiuk.maxim.pages.second.SecondPageActivity

class OpeningActivity : AppCompatActivity() {

	private lateinit var binding: OpeningActivityBinding
	private lateinit var viewModel: OpeningViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.opening_activity)
		viewModel = ViewModelProviders.of(this).get(OpeningViewModel::class.java)

		binding.apply {
			lifecycleOwner = this@OpeningActivity
			viewModel = this@OpeningActivity.viewModel
		}

		viewModel.onOpenSecondPage.observe(this) {
			startActivity(Intent(this, SecondPageActivity::class.java))
		}
	}
}