package com.akado.bookstore.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.akado.bookstore.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<DetailViewModel>()
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun intent(context: Context, isbn13: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("isbn13", isbn13);
            return intent;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        val isbn13: String? = if (intent == null) null else intent.getStringExtra("isbn13")
        if (isbn13 == null) {
            finish()
        } else {
            viewModel.request(isbn13)
        }
    }
}