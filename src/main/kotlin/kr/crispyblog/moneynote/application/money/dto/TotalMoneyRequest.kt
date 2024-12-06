package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "총 수입지출 금액 request")
data class TotalMoneyRequest(
    @Schema(description = "수입지출 시작일", example = "2024-12-01")
    val startDate: LocalDate?,

    @Schema(description = "수입지출 종료일", example = "2025-03-31")
    val endDate: LocalDate?,

    @Schema(description = "기록 유형", example = "INCOME")
    val recordType: String?,
)
