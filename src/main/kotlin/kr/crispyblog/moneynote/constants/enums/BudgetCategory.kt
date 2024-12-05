package kr.crispyblog.moneynote.constants.enums

enum class BudgetCategory(val categoryName: String) {
    NORMAL("일반"),
    TRAVEL("야헹");

    companion object {
        fun findCategoryName(category: String): String {
            return entries.find { it.name == category }?.categoryName ?: NORMAL.categoryName
        }
    }
}