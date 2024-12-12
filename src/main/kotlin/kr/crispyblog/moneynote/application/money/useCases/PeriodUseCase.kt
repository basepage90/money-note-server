package kr.crispyblog.moneynote.application.money.useCases

import kr.crispyblog.moneynote.application.money.dto.CreatePeriodRequest
import kr.crispyblog.moneynote.application.money.dto.EditPeriodRequest
import kr.crispyblog.moneynote.application.money.dto.PeriodResponse
import kr.crispyblog.moneynote.application.money.dto.PeriodsRequest

interface PeriodUseCase {

    fun getPeriodResponse(id: Long): PeriodResponse?
    fun searchPeriodResponses(request: PeriodsRequest): List<PeriodResponse>
    fun create(request: CreatePeriodRequest)
    fun edit(request: EditPeriodRequest)
}