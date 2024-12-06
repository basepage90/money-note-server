package kr.crispyblog.moneynote.constants.enums

enum class CategoryType(val categoryName: String) {
    NORMAL("일반"),
    FOOD("음식"),
    CULTURE("문화"),
    FASHION("패션"),
    FITNESS("운동"),
    FINANCE("금융");

    companion object {
        fun findCategoryName(category: String): String {
            return entries.find { it.name == category }?.categoryName ?: NORMAL.categoryName
        }
    }
}