package com.example.userapp

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var dpm: DevicePolicyManager
    private lateinit var admin: ComponentName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dpm = getSystemService(DevicePolicyManager::class.java)
        admin = ComponentName(this, DeviceAdminReceiver::class.java)

        val status = TextView(this).apply {
            text = "Managed User Device\n\nPair this device with your Admin panel.\nDevice Owner/Kiosk provisioning is required for full dedicated-device behavior."
            textSize = 18f
            setPadding(40, 60, 40, 30)
        }

        val lock = Button(this).apply {
            text = "Lock Device"
            setOnClickListener {
                if (dpm.isAdminActive(admin)) dpm.lockNow()
                status.text = "Device lock requested."
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(30, 30, 30, 30)
            addView(status)
            addView(lock)
        }
        setContentView(layout)
    }
}
