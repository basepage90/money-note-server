package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import kr.crispyblog.moneynote.constants.enums.CategoryType
import java.time.LocalDate

@Schema(description = "수입지출 기록 등록 request")
data class CreateMoneyRecordRequest(
    @Schema(description = "기록 유형", example = "INCOME")
    val recordType: String,

    @Schema(description = "카테고리 유형", example = "TRAVEL")
    val categoryType: String = CategoryType.NORMAL.name,

    @Schema(description = "금액", example = "50000")
    val amount: Long,

    @Schema(description = "메모 유형", example = "항공권 왕복 금액")
    val memo: String?,

    @Schema(description = "기록일", example = "2024-12-10")
    val recordedDate: LocalDate,

    @Schema(description = "기간 id")
    val periodId: Long

)
