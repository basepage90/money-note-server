package kr.crispyblog.moneynote.application.money.dto

import kr.crispyblog.moneynote.domain.money.models.Period

data class PeriodDto(
    val period: Period,
    val totalIncome: Long,
    val totalExpense: Long,
)
