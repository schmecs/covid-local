package com.rebeccablum.covidlocal.models

import com.rebeccablum.covidlocal.toStringOrUnknown
import com.squareup.moshi.Json
import kotlin.math.round

data class CurrentStateInfo(
    @field:Json(name = "state") val state: String,
    @field:Json(name = "positive") val positive: Int?,
    @field:Json(name = "negative") val negative: Int?,
    @field:Json(name = "grade") val grade: String?,
    @field:Json(name = "hospitalizedCurrently") val hospitalizedCurrently: Int?,
    @field:Json(name = "hospitalizedCumulative") val hospitalizedCumulative: Int?,
    @field:Json(name = "inIcuCurrently") val inIcuCurrently: Int?,
    @field:Json(name = "inIcuCumulative") val inIcuCumulative: Int?,
    @field:Json(name = "onVentilatorCurrently") val onVentilatorCurrently: Int?,
    @field:Json(name = "onVentilatorCumulative") val onVentilatorCumulative: Int?,
    @field:Json(name = "recovered") val recovered: Int?,
    @field:Json(name = "lastUpdateEt") val lastUpdateEt: String,
    @field:Json(name = "death") val deaths: Int?,
    @field:Json(name = "totalTestResults") val totalTestResults: Int?
) {
    fun positiveString() = positive.toStringOrUnknown()
    fun negativeString() = negative.toStringOrUnknown()
    fun hospitalizedCurrentlyString() = hospitalizedCurrently.toStringOrUnknown()
    fun hospitalizedCumulativeString() = hospitalizedCumulative.toStringOrUnknown()
    fun deathsString() = deaths.toStringOrUnknown()

    fun percentPositiveString() = if (positive != null && negative != null) {
        ((positive.toFloat() / (positive.toFloat() + negative.toFloat())) * 100).toInt().toString() + "%"
    } else {
        "Unknown"
    }

    fun mortalityRateString() = if (positive != null && deaths != null) {
        round(deaths.toFloat() / positive.toFloat() * 100).toString() + "%"
    } else {
        "Unknown"
    }
}
