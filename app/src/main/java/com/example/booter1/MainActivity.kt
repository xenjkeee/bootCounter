package com.example.booter1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.booter1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    //todo: ask permission to show notification
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            DataBindingUtil.inflate<ActivityMainBinding>(
                layoutInflater,
                R.layout.activity_main,
                null, false
            ).apply {
                lifecycleOwner = this@MainActivity
                model = viewModel
            }.root
        )
    }
}