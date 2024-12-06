package kr.crispyblog.moneynote.constants.enums


enum class PeriodType(val periodName: String) {
    WEEK("주간"),
    MONTHLY("월간"),
    TRAVEL("여행");

    companion object {
        fun findCategoryName(period: String): String {
            return CategoryType.entries.find { it.name == period }?.categoryName ?: MONTHLY.periodName
        }
    }
}