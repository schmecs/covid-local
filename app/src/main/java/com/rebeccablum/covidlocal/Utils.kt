package com.rebeccablum.covidlocal

import java.text.NumberFormat

fun Int?.toStringOrUnknown(): String {
    return if (this != null) {
        return NumberFormat.getInstance().format(this)
    } else {
        "Unknown"
    }
}
