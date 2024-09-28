package com.sercan.yigit.weros_health_app.helper

import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import com.sercan.yigit.weros_health_app.presentation.MainViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SensorManagerHelper(private val context: Context, private val listener: SensorEventListener) {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)
    private val stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
    private val stepDetectSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)

    fun registerSensors() {
        heartRateSensor?.let { sensorManager.registerListener(listener, it, SensorManager.SENSOR_DELAY_NORMAL) }
        stepCountSensor?.let { sensorManager.registerListener(listener, it, SensorManager.SENSOR_DELAY_NORMAL) }
        stepDetectSensor?.let { sensorManager.registerListener(listener, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    fun unregisterSensors() {
        sensorManager.unregisterListener(listener)
    }

    fun handleSensorEvent(event: SensorEvent?, viewModel: MainViewModel) {
        event?.let {
            when (it.sensor.type) {
                Sensor.TYPE_HEART_RATE -> viewModel.setHeartRate(it.values[0].toInt())
                Sensor.TYPE_STEP_COUNTER -> viewModel.setSteps(it.values[0].toInt())
                Sensor.TYPE_STEP_DETECTOR -> Log.d(TAG, "STEP DETECTED at ${currentTimeStr()}")
                else -> Log.d(TAG, "Unknown sensor type")
            }
        }
    }

    private fun currentTimeStr(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}