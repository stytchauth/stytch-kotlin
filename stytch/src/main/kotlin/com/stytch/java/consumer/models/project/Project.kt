package com.stytch.java.consumer.models.project

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
public enum class ProjectMetricMetricType {
    @Json(name = "UNKNOWN")
    UNKNOWN,

    @Json(name = "USER_COUNT")
    USER_COUNT,

    @Json(name = "ORGANIZATION_COUNT")
    ORGANIZATION_COUNT,

    @Json(name = "MEMBER_COUNT")
    MEMBER_COUNT,

    @Json(name = "M2M_CLIENT_COUNT")
    M2M_CLIENT_COUNT,
}

@JsonClass(generateAdapter = true)
public data class ProjectMetric
    @JvmOverloads
    constructor(
        @Json(name = "count")
        val count: UInt,
        @Json(name = "metric_type")
        val metricType: ProjectMetricMetricType? = null,
    )

@JsonClass(generateAdapter = true)
public class MetricsRequest
    @JvmOverloads
    constructor()

@JsonClass(generateAdapter = true)
public data class MetricsResponse
    @JvmOverloads
    constructor(
        @Json(name = "request_id")
        val requestId: String,
        @Json(name = "project_id")
        val projectId: String,
        @Json(name = "metrics")
        val metrics: List<ProjectMetric>,
        @Json(name = "status_code")
        val statusCode: Int,
    )
