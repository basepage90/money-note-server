package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "총 수입/지출 금액 response")
data class TotalMoneyResponse(
    @Schema(description = "기간 시작일", example = "2024-12-01")
    val startDate: LocalDate,

    @Schema(description = "기간 종료일", example = "2024-12-31")
    val endDate: LocalDate,

    @Schema(description = "기간 이름", example = "홋카이도 여행 예산")
    val periodName: String,

    @Schema(description = "기간별 총 잔액", example = "350000")
    val totalAmount: Long
)
