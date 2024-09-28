package com.sercan.yigit.weros_health_app.presentation

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.sercan.yigit.weros_health_app.helper.PermissionManager
import com.sercan.yigit.weros_health_app.helper.SensorManagerHelper
import com.sercan.yigit.weros_health_app.navigation.AppNavigation
import com.sercan.yigit.weros_health_app.presentation.theme.WearOSHealthAppTheme

class MainActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManagerHelper: SensorManagerHelper
    private lateinit var permissionManager: PermissionManager
    private lateinit var wakeLock: PowerManager.WakeLock
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)

        initScreen()
        setContent {
            WearOSHealthAppTheme {
                val navController = rememberSwipeDismissableNavController()
                AppNavigation(navController, viewModel = mainViewModel)
            }
        }
    }

    private fun initScreen() {
        wakeLock = createWakeLock()
        permissionManager = PermissionManager(this)
        sensorManagerHelper = SensorManagerHelper(this, this)

        if (!permissionManager.hasPermissions()) {
            permissionManager.requestPermissions()
        } else {
            sensorManagerHelper.registerSensors()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        sensorManagerHelper.handleSensorEvent(event, viewModel = mainViewModel)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d(TAG, "onAccuracyChanged - accuracy: $accuracy")
    }

    override fun onPause() {
        super.onPause()
        sensorManagerHelper.unregisterSensors()
        if (wakeLock.isHeld) {
            wakeLock.release()
        }
    }

    override fun onResume() {
        super.onResume()
        if (!wakeLock.isHeld) {
            wakeLock.acquire()
        }
        sensorManagerHelper.registerSensors()
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        permissionManager.handlePermissionsResult(requestCode, grantResults) {
            sensorManagerHelper.registerSensors()
        }
    }

    @SuppressLint("InvalidWakeLockTag")
    private fun createWakeLock(): PowerManager.WakeLock {
        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        return powerManager.newWakeLock(
            PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "WearOs-HealthApp"
        )
    }
}
