package kr.crispyblog.moneynote.application.money.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.ALWAYS)
@Schema(description = "수입지출 정보 response")
data class MoneyRecordResponse(
    @Schema(description = "기록유형 이름", example = "지출")
    val recordTypeName: String,

    @Schema(description = "카테고리 유형", example = "여행")
    val categoryType: String?,

    @Schema(description = "금액", example = "800000")
    val amount: Long,

    @Schema(description = "메모", example = "몽골 항공권 왕복권")
    val memo: String?,

    @Schema(description = "기록일", example = "2024-12-16")
    val recordedDate: LocalDate,

    @Schema(description = "기간 타이틀", example = "몽골여행")
    val periodTitle: String?,
)
