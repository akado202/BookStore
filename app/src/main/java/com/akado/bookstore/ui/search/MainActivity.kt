package com.akado.bookstore.ui.search

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.akado.bookstore.common.Keyboard.hideKeyboard
import com.akado.bookstore.databinding.ActivityMainBinding
import com.akado.bookstore.domain.model.BookItemDomainModel
import com.akado.bookstore.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding.view = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.etEdit.setOnEditorActionListener { v, actionId, event ->
            var result = false
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.ivImage.performClick()
                result = true
            }
            result
        }

        binding.ivImage.setOnClickListener {
            request()
            hideKeyboard(MainActivity@ this, binding.etEdit)
        }

        binding.recyclerView.addOnScrollListener(
            LoadMoreOnScrollListener(object : LoadMoreOnScrollListener.Callback {
                override fun loadMore() {
                    request()
                }
            })
        )
    }

    fun onItemClick(model: BookItemDomainModel) {
        startActivity(DetailActivity.intent(this, model.isbn13))
    }

    private fun request() {
        viewModel.request(binding.etEdit.text.toString())
    }
}