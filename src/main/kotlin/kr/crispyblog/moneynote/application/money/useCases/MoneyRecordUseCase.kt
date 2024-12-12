package kr.crispyblog.moneynote.application.money.useCases

import kr.crispyblog.moneynote.application.money.dto.CreateMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.EditMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import java.time.YearMonth

interface MoneyRecordUseCase {

    fun searchMoneyRecord(id: Long): MoneyRecordResponse?
    fun searchMoneyRecords(month: YearMonth): List<MoneyRecordResponse>
    fun create(request: CreateMoneyRecordRequest)
    fun edit(request: EditMoneyRecordRequest)
}