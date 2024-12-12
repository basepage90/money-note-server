package kr.crispyblog.moneynote.application.money.convert

import kr.crispyblog.moneynote.application.money.dto.CreateMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import kr.crispyblog.moneynote.domain.money.models.Period
import org.springframework.stereotype.Component

@Component
class MoneyRecordConverter {

    fun toMoneyRecordResponse(moneyRecord: MoneyRecord): MoneyRecordResponse {
        return MoneyRecordResponse(
            recordTypeName = moneyRecord.recordType,
            categoryType = moneyRecord.categoryType,
            amount = moneyRecord.amount,
            memo = moneyRecord.memo,
            recordedDate = moneyRecord.recordedDate,
            periodTitle = moneyRecord.period?.name
        )
    }

    fun toMoneyRecordResponses(moneyRecords: List<MoneyRecord>): List<MoneyRecordResponse> {
        return moneyRecords.map { moneyRecord ->
            MoneyRecordResponse(
                recordTypeName = moneyRecord.recordType,
                categoryType = moneyRecord.categoryType,
                amount = moneyRecord.amount,
                memo = moneyRecord.memo,
                recordedDate = moneyRecord.recordedDate,
                periodTitle = moneyRecord.period?.name
            )
        }
    }

    fun toEntity(request: CreateMoneyRecordRequest, userId: Long, period: Period?): MoneyRecord {
        return MoneyRecord(
            recordType = request.recordType,
            categoryType = request.categoryType,
            amount = request.amount,
            memo = request.memo,
            recordedDate = request.recordedDate,
            userId = userId,
            period = period
        )
    }

}