package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "수입지출 정보 response")
data class MoneyRecordResponse(
    @Schema(description = "기록일시", example = "2024-12-05 17:06:57.000000")
    val recordedDate: LocalDate,

    @Schema(description = "메모", example = "12월의 꽁돈")
    val memo: String,

    @Schema(description = "수입지출 유형", example = "INCOME")
    val recordType: String,

    @Schema(description = "기간 이름", example = "일반")
    val periodName: String,

    @Schema(description = "금액", example = "1000000")
    val amount: Long
)
