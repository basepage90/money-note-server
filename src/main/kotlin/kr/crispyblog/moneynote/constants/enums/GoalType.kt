package kr.crispyblog.moneynote.constants.enums

import kr.crispyblog.moneynote.constants.enums.CategoryType.NORMAL

enum class GoalType(val goalName: String) {
    SAVING("저축"),
    CONSUMPTION("소비");

    companion object {
        fun findGoalName(goal: String): String {
            return GoalType.entries.find { it.name == goal }?.goalName ?: SAVING.goalName
        }
    }
}