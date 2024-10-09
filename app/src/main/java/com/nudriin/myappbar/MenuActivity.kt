package com.nudriin.myappbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nudriin.myappbar.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // with binding disini maksudnya biar bisa
        // binding.searchView atau binding.searchBar
        with(binding) {
            // seperti disini langsung searchView tanpa mengetikan binding
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                //aksi ketika input di-submit
                .setOnEditorActionListener { textView, actionId, event ->
                    // mengambil input dari SearchView menggunakan searchView.text
                    searchBar.setText(searchView.text)
                    searchView.hide()
                    Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }
    }
}