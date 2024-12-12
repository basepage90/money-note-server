package kr.crispyblog.moneynote.constants.enums

enum class NotificationType(val notificationName: String) {
    GOAL_ACHIEVED("저축"),
    GOAL_PROGRESS("소비");

    companion object {
        fun findNotificationName(notification: String): String {
            return GoalType.entries.find { it.name == notification }?.goalName ?: GOAL_ACHIEVED.notificationName
        }
    }
}