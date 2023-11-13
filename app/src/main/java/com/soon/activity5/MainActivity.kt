package com.soon.activity5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.soon.activity5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check and display the status of location permission
        updateLocationStatus(
            if (isLocationPermissionGranted()) "Granted"
            else "Not granted"
        )

        // Check and display the status of camera permission
        updateCameraStatus(
            if (isCameraPermissionGranted()) "Granted"
            else "Not granted"
        )

        updateMicrophoneStatus(
            if (isMicrophonePermissionGranted()) "Granted"
            else "Not granted"
        )

        binding.settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isLocationPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isCameraPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isMicrophonePermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun updateLocationStatus(status: String) {
        binding.locationStatus.text = status
    }

    private fun updateCameraStatus(status: String) {
        binding.cameraStatus.text = status
    }

    private fun updateMicrophoneStatus(status: String) {
        binding.microphoneStatus.text = status
    }
}
