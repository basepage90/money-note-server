package kr.crispyblog.moneynote.application.money.convert

import kr.crispyblog.moneynote.application.money.dto.CreatePeriodRequest
import kr.crispyblog.moneynote.application.money.dto.PeriodResponse
import kr.crispyblog.moneynote.application.money.dto.PeriodDto
import kr.crispyblog.moneynote.constants.enums.RecordType
import kr.crispyblog.moneynote.domain.money.models.Period
import org.springframework.stereotype.Component

@Component
class PeriodConverter {

    /**
     * 기간정보 response 로 변환
     */
    fun toPeriodResponse(periodDto : PeriodDto): PeriodResponse {
        return PeriodResponse(
            name = periodDto.period.name,
            startDate = periodDto.period.startDate,
            endDate = periodDto.period.endDate,
            totalIncome = periodDto.totalIncome,
            totalExpense = periodDto.totalExpense
        )
    }

    /**
     * 기간정보 response 리스트로 변환
     */
    fun toPeriodResponses(periodDtos : List<PeriodDto>): List<PeriodResponse> {
        return periodDtos.map { periodDto ->
            PeriodResponse(
                name = periodDto.period.name,
                startDate = periodDto.period.startDate,
                endDate = periodDto.period.endDate,
                totalIncome = periodDto.totalIncome,
                totalExpense = periodDto.totalExpense)
        }
    }



    fun toEntity(request: CreatePeriodRequest, userId: Long): Period {
        return Period(
            userId = userId,
            name = request.name,
            startDate = request.startDate,
            endDate = request.endDate
        )
    }

}