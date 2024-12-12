package kr.crispyblog.moneynote.application.money.dto

import io.swagger.v3.oas.annotations.media.Schema
import kr.crispyblog.moneynote.constants.enums.CategoryType
import java.time.LocalDate

@Schema(description = "수입지출 정보 수정 request")
data class EditMoneyRecordRequest(
    @Schema(description = "기록 id", example = "1", required = true)
    val id: Long,

    @Schema(description = "기록 유형", example = "INCOME", required = true)
    val recordType: String,

    @Schema(description = "카테고리 유형", example = "TRAVEL")
    val categoryType: String = CategoryType.NORMAL.name,

    @Schema(description = "금액", example = "50000", required = true)
    val amount: Long,

    @Schema(description = "메모 유형", example = "항공권 왕복 금액")
    val memo: String?,

    @Schema(description = "기록일", example = "2024-12-10", required = true)
    val recordedDate: LocalDate,

    @Schema(description = "기간 id")
    val periodId: Long
)
