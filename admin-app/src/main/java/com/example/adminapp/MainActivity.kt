package com.example.adminapp

import android.app.Activity
import android.os.Bundle
import android.widget.*
import java.util.UUID

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val key = UUID.randomUUID().toString().replace("-", "").take(12).uppercase()
        val keyView = TextView(this).apply {
            text = "PAIRING KEY\n$key"
            textSize = 22f
            setPadding(30, 40, 30, 20)
        }

        val device = EditText(this).apply { hint = "Device pairing key" }
        val lock = Button(this).apply {
            text = "Send Lock Command"
            setOnClickListener {
                Toast.makeText(this@MainActivity,
                    "Lock command queued for: ${device.text}", Toast.LENGTH_SHORT).show()
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(30, 30, 30, 30)
            addView(keyView)
            addView(device)
            addView(lock)
        }
        setContentView(layout)
    }
}
