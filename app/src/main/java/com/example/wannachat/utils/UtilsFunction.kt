package com.example.wannachat.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun String.formatToDate(): Date? {
    val dateFormat = SimpleDateFormat("HH:mm:ss yyyy-MM-dd", Locale.getDefault())
    return dateFormat.parse(this)
}


fun Date.formatToStringDateTime(): String {
    val dateTimeFormat = SimpleDateFormat("dd MMM yyyy    HH:mm", Locale.getDefault()) // output format  hour and date
    return dateTimeFormat.format(this)
}


fun Date.formatToStringDate(): String {
    val dateTimeFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return dateTimeFormat.format(this)
}