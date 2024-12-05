package kr.crispyblog.moneynote.application.convert

import kr.crispyblog.moneynote.application.dto.BudgetInfoResponse
import kr.crispyblog.moneynote.constants.enums.BudgetCategory.Companion.findCategoryName
import kr.crispyblog.moneynote.domain.money.models.Budget
import org.springframework.stereotype.Component

@Component
class BudgetConverter {

    /**
     * Entity 를 responseList 로 변환
     */
    fun toBudgetInfoResponseList(budgetList: List<Budget>): List<BudgetInfoResponse> {
        return budgetList.map { budget ->
            BudgetInfoResponse(
                recordedDate = budget.recordedDate,
                memo = budget.memo,
                recordType = budget.recordType,
                categoryName = findCategoryName(budget.categoryType),
                amount = budget.amount
            )
        }
    }

    /**
     * Entity 를 responseList 로 변환
     */
    fun toBudgetInfoResponseLists(budgetLists: List<List<Budget>>): List<List<BudgetInfoResponse>> {
        return budgetLists.map { budgetList ->
            budgetList.map { budget ->
                BudgetInfoResponse(
                    recordedDate = budget.recordedDate,
                    memo = budget.memo,
                    recordType = budget.recordType,
                    categoryName = findCategoryName(budget.categoryType),
                    amount = budget.amount
                )
            }
        }
    }

}