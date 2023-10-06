package com.example.dialogs.Broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.dialogs.databinding.ActivityMainBinding

class Battery: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

//        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
//
//        if (isAirplaneModeEnabled) {
//
//            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
//        } else {
//
//            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
//        }

        //Internet
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo

        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting){
            Toast.makeText(context, "Internet is connected", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Internet is not connected", Toast.LENGTH_LONG).show()
        }
    }
}