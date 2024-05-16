package com.example.chatapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun String.formatToDate (): Date? {
    val dateFormat = SimpleDateFormat("HH:mm:ss yyyy-MM-dd", Locale.getDefault())

    return dateFormat.parse(this)
}