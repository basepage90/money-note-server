package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.application.money.dto.PeriodDto
import kr.crispyblog.moneynote.application.money.dto.PeriodsRequest
import kr.crispyblog.moneynote.constants.enums.RecordType
import kr.crispyblog.moneynote.domain.money.models.Period
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.repositories.querydsl.PeriodQueryRepository
import org.springframework.stereotype.Service

@Service
class PeriodManager(
    val periodRepository: PeriodRepository,
    val periodQueryRepository: PeriodQueryRepository
) {

    fun findPeriod(id: Long): PeriodDto? {
        val period = periodRepository.findById(id).orElse(null) ?: return null
        val totalIncome = period.moneyRecords.filter { it.recordType == RecordType.INCOME.name }.sumOf { it.amount }
        val totalExpense = period.moneyRecords.filter { it.recordType == RecordType.EXPENSE.name }.sumOf { it.amount }

        return PeriodDto(
            period = period,
            totalIncome = totalIncome,
            totalExpense = totalExpense
        )
    }

    fun findPeriods(request: PeriodsRequest, userId: Long): List<PeriodDto> {
        val periods = periodRepository.findByUserIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
            userId, request.startDate, request.endDate
        ).orElse(emptyList())

        return periods.map { period ->
            val totalIncome: Long = period.moneyRecords.filter { it.recordType == RecordType.INCOME.name }.sumOf { it.amount }
            val totalExpense = period.moneyRecords.filter { it.recordType == RecordType.EXPENSE.name }.sumOf { it.amount }

            PeriodDto(
                period = period,
                totalIncome = totalIncome,
                totalExpense = totalExpense
            )
        }
    }

}