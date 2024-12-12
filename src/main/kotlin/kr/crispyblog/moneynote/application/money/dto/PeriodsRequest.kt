package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "기간 정보 리스트 request")
data class PeriodsRequest(
    @Schema(description = "기간 시작일", example = "2024-12-01")
    val startDate: LocalDate?,

    @Schema(description = "기간 종료일", example = "2025-03-31")
    val endDate: LocalDate?,
)
