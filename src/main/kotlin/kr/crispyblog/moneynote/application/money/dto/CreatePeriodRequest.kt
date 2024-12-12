package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate


@Schema(description = "기간 생성 request")
data class CreatePeriodRequest(

    @Schema(description = "기간 제목", required = true, example = "일본 여행")
    val name: String,

    @Schema(description = "기간 시작일", required = true, example = "2025-02-04")
    val startDate: LocalDate,

    @Schema(description = "기간 종료일", required = true, example = "2025-02-14")
    val endDate: LocalDate,
)

