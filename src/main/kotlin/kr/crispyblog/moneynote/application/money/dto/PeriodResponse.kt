package kr.crispyblog.moneynote.application.money.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.ALWAYS)
@Schema(description = "기간 정보 response")
data class PeriodResponse(
    @Schema(description = "기간 이름", example = "일본 여행")
    val name: String,

    @Schema(description = "시작일", example = "2024-12-01")
    val startDate: LocalDate,

    @Schema(description = "종료일", example = "2024-12-31")
    val endDate: LocalDate,

    @Schema(description = "총 수입", example = "100000")
    val totalIncome: Long?,

    @Schema(description = "총 지출", example = "950000")
    val totalExpense: Long?,
)
