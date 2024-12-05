package kr.crispyblog.moneynote.application.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "예산 정보 request")
data class BudgetInfoRequest(
    @Schema(description = "예산 시작 날짜", example = "2024-12-01")
    val startDate: LocalDate?,
    @Schema(description = "예산 종료 날짜", example = "2024-12-31")
    val endDate: LocalDate?,
    @Schema(description = "예산 타입", example = "INCOME")
    val budgetType: String,
)
