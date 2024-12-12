package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate


@Schema(description = "기간 정보 수정 request")
data class EditPeriodRequest(

    @Schema(description = "기간 id", required = true)
    val id: Long,

    @Schema(description = "기간 제목", required = true, example = "두바이 여행")
    val name: String,

    @Schema(description = "기간 시작일", required = true, example = "2025-02-12")
    val startDate: LocalDate,

    @Schema(description = "기간 종료일", required = true, example = "2025-02-22")
    val endDate: LocalDate,
)

