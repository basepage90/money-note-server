package kr.crispyblog.moneynote.application.money.convert

import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.application.money.dto.TotalMoneyResponse
import kr.crispyblog.moneynote.constants.enums.CategoryType.Companion.findCategoryName
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import kr.crispyblog.moneynote.domain.money.models.Period
import org.springframework.stereotype.Component

@Component
class MoneyRecordConverter {

    /**
     * Entity 를 responseLists 로 변환
     */
    fun toMoneyRecordResponseLists(moneyRecordLists: List<List<MoneyRecord>>): List<List<MoneyRecordResponse>> {
        return moneyRecordLists.map { moneyRecordList ->
            moneyRecordList.map { moneyRecord ->
                MoneyRecordResponse(
                    recordedDate = moneyRecord.recordedDate,
                    memo = moneyRecord.memo,
                    recordType = moneyRecord.recordType,
                    periodName = findCategoryName(moneyRecord.categoryType),
                    amount = moneyRecord.amount
                )
            }
        }
    }

    fun toTotalMoneyResponses(periods: List<Period>, totalAmounts: List<Long> ): List<TotalMoneyResponse> {
        return periods.mapIndexed { index, period ->
            TotalMoneyResponse(
                startDate = period.startDate,
                endDate = period.endDate,
                periodName = period.periodName,
                totalAmount = totalAmounts[index]
            )
        }
    }

}