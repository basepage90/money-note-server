package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "수입지출 정보 request")
data class MoneyRecordRequest(
    @Schema(description = "기간 시작일", example = "2024-12-01")
    val startDate: LocalDate?,

    @Schema(description = "기간 종료일", example = "2024-12-31")
    val endDate: LocalDate?,

    @Schema(description = "기록 유형", example = "INCOME")
    val recordType: String?,
)
