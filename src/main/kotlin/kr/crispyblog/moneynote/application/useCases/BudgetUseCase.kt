package kr.crispyblog.moneynote.application.useCases

import kr.crispyblog.moneynote.application.convert.BudgetConverter
import kr.crispyblog.moneynote.application.dto.BudgetInfoRequest
import kr.crispyblog.moneynote.application.dto.BudgetInfoResponse
import kr.crispyblog.moneynote.domain.money.models.Budget
import kr.crispyblog.moneynote.domain.money.repositories.BudgetRepository
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.services.BudgetService
import kr.crispyblog.moneynote.domain.money.services.PeriodService
import org.springframework.stereotype.Service

@Service
class BudgetUseCase(
    val budgetService: BudgetService,
    val periodService: PeriodService,
    val budgetRepository: BudgetRepository,
    val periodRepository: PeriodRepository,
    val converter: BudgetConverter,
) {

    fun searchMyBudgets(request: BudgetInfoRequest): List<List<BudgetInfoResponse>> {
        val userId: Int = 1

        val periods = periodService.findMyPeriods(userId, request.startDate, request.endDate)


        periods.forEach({period ->
            budgetService.findMyBudgetByPeriod(period.id)
        })

        val budgetLists: List<List<Budget>> = periods.map { period ->
            budgetService.findMyBudgetByPeriod(period.id)
        }

        return converter.toBudgetInfoResponseLists(budgetLists)
    }

}