package com.gmail.adipriyanto023.workshomobile.model

import java.io.Serializable

data class Jadwal(
        val date_for: String,
        val fajr: String,
        val dhuhr: String,
        val asr: String,
        val maghrib: String,
        val isha: String
): Serializable