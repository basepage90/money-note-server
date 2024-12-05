package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.domain.money.models.Budget
import kr.crispyblog.moneynote.domain.money.repositories.BudgetRepository
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class BudgetService(
    val budgetRepository: BudgetRepository
) {

    fun findMyBudget(userId: Int, startDate: LocalDate?, endDate: LocalDate?): List<Budget> {
        val optionalBudgets = budgetRepository.findByUserIdOrderByRecordedDateAsc(userId)

        val budgets: List<Budget> = optionalBudgets.map { it }.orElse(emptyList())

        return budgets
    }

    fun findMyBudgetByPeriod(periodId: Int): List<Budget> {
        val optionalBudgets = budgetRepository.findByPeriodIdOrderByRecordedDateAsc(periodId)

        val budgets: List<Budget> = optionalBudgets.map { it }.orElse(emptyList())

        return budgets
    }

}