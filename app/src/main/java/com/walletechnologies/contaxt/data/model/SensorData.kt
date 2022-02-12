package com.walletechnologies.contaxt.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class SensorData(
    val fsrResistance: Double = 0.0,
    val gps: GPS = GPS(),
    val accelerometer: Accelerometer = Accelerometer(),
    val timestamp: Date = Date(),
    val counter: Int = 0

    ) : Parcelable

@Parcelize
data class GPS(
    val longitude: Double = 0.0,
    val latitude: Double = 0.0,
    val altitude:Double = 0.0
) : Parcelable

@Parcelize
data class Accelerometer(
    val x: Int = 0,
    val y: Int = 0,
    val z: Int = 0
):Parcelable
