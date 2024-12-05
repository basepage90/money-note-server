package kr.crispyblog.moneynote.application.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "예산 정보 response")
data class BudgetInfoResponse(
    @Schema(description = "기록일시", example = "2024-12-05 17:06:57.000000")
    val recordedDate: LocalDate,

    @Schema(description = "메모", example = "12월의 꽁돈")
    val memo: String,

    @Schema(description = "예산 유형", example = "INCOME")
    val recordType: String,

    @Schema(description = "카테고리 이름", example = "일반")
    val categoryName: String,

    @Schema(description = "금액", example = "1000000")
    val amount: Long
)
