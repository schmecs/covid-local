package com.rebeccablum.covidlocal.models

import com.squareup.moshi.Json

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
)

