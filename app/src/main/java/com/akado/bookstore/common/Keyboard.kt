package com.akado.bookstore.common

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object Keyboard {

    fun showKeyboard(context: Context, view: EditText) {
        val manager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun hideKeyboard(context: Context, view: EditText) {
        val manager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}