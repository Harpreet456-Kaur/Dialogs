package com.example.dialogs

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogs.Broadcast.Battery
import com.example.dialogs.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var receiver = Battery()

    private val batteryPercentage: BroadcastReceiver = object : BroadcastReceiver() {
        //onReceive method will receive updates
        override fun onReceive(c: Context, i: Intent) {

            val level = i.getIntExtra("level", 0)
           // binding.progressBar1.progress = level
            binding.textView1.text = "Battery level:$level%"

//            if (level == 100) {
//                try {
//                    //Save small.mp4 in assets folder
//                    //we can not start a media file from the drawable folder directly in broadcast method
//                    //hence we used the assets folder
//                    val afd = assets.openFd("small.mp4")
//                    val mp = MediaPlayer()
//                    //set file and starting point and ending point in bytes
//                    mp.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
//                    mp.prepare()
//                    //start song
//                    mp.start()
//                } catch (e: IOException) {
//                }
//            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerReceiver(batteryPercentage,IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        receiver = Battery()

        // Airplane Mode On or not
//        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
//
//            registerReceiver(receiver, it)
//        }

        // Internet Connectivity
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
           registerReceiver(receiver,it,RECEIVER_EXPORTED)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        }
    }
