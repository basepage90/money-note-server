package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.domain.money.models.Budget
import kr.crispyblog.moneynote.domain.money.models.Period
import kr.crispyblog.moneynote.domain.money.repositories.BudgetRepository
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PeriodService(
    val periodRepository: PeriodRepository
) {

    fun findMyPeriods(userId: Int, startDate: LocalDate?, endDate: LocalDate?): List<Period> {
        val optionalPeriods  = periodRepository.findByUserIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(userId, startDate, endDate)

        val periods = optionalPeriods.map { it }.orElse(emptyList())

        return periods
    }
}