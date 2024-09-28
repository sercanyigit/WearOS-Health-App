package com.sercan.yigit.weros_health_app.helper

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionManager(private val activity: ComponentActivity) {
    private val REQUEST_CODE_PERMISSIONS = 101
    private val requiredPermissions = arrayOf(
        Manifest.permission.BODY_SENSORS,
        Manifest.permission.ACTIVITY_RECOGNITION
    )

    fun hasPermissions(): Boolean {
        return requiredPermissions.all {
            ContextCompat.checkSelfPermission(activity, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissions() {
        ActivityCompat.requestPermissions(activity, requiredPermissions, REQUEST_CODE_PERMISSIONS)
    }

    fun handlePermissionsResult(requestCode: Int, grantResults: IntArray, onGranted: () -> Unit) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            val allGranted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
            if (allGranted) {
                onGranted()
            } else {
                showPermissionDeniedDialog()
            }
        }
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(activity)
            .setTitle("İzin Gerekli")
            .setMessage("Bu izinler uygulamanın düzgün çalışması için gereklidir.")
            .setPositiveButton("Tekrar Dene") { _, _ -> requestPermissions() }
            .setNegativeButton("Vazgeç") { _, _ -> activity.finish() }
            .show()
    }
}