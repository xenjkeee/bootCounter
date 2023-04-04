package com.example.booter1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BootCompletedBroadcastReceiver : BroadcastReceiver() {
    @Inject
    internal lateinit var repository: BootsRepository

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.action
            ?.equals(Intent.ACTION_BOOT_COMPLETED)
//            ?.equals("com.example.booter1.BOOT")
            ?.takeIf { it }
            ?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    repository.addBoot(System.currentTimeMillis())
                }
            }
    }
}

