package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.application.money.dto.TotalMoneyResponse
import kr.crispyblog.moneynote.domain.money.models.Period
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.repositories.querydsl.PeriodQueryRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PeriodService(
    val periodRepository: PeriodRepository,
    val periodQueryRepository: PeriodQueryRepository
) {

    /**
     * 내가 등록한 기간들을 조회한다.
     */
    fun findPeriods(userId: Int, startDate: LocalDate?, endDate: LocalDate?): List<Period> {
        val optionalPeriods = periodQueryRepository.findMyPeriods(userId,startDate, endDate)

        return optionalPeriods.orElse(emptyList())
    }
}