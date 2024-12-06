package kr.crispyblog.moneynote.application.money.useCases

import kr.crispyblog.moneynote.application.money.convert.MoneyRecordConverter
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.application.money.dto.TotalMoneyRequest
import kr.crispyblog.moneynote.application.money.dto.TotalMoneyResponse
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import kr.crispyblog.moneynote.domain.money.repositories.MoneyRecordRepository
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.services.MoneyRecordService
import kr.crispyblog.moneynote.domain.money.services.PeriodService
import org.springframework.stereotype.Service

@Service
class MoneyRecordUseCase(
    val moneyRecordService: MoneyRecordService,
    val periodService: PeriodService,
    val moneyRecordRepository: MoneyRecordRepository,
    val periodRepository: PeriodRepository,
    val converter: MoneyRecordConverter,
) {

    /**
     * 수입지출 기록 리스트들을 조회한다.
     */
    fun searchMoneyRecordLists(request: MoneyRecordRequest): List<List<MoneyRecordResponse>> {
        val userId: Int = 1

        val periods = periodService.findPeriods(userId, request.startDate, request.endDate)

        val moneyRecordLists: List<List<MoneyRecord>> =
            periods.map { period -> moneyRecordService.findMoneyRecordsByPeriod(period.id, request.recordType) }

        return converter.toMoneyRecordResponseLists(moneyRecordLists)
    }

    /**
     * 기간별 잔금을 조회한다.
     */
    fun searchTotalAmount(request: TotalMoneyRequest): List<TotalMoneyResponse> {
        val userId: Int = 1

        val periods = periodService.findPeriods(userId, request.startDate, request.endDate)

        val totalAmounts = periods.map { period -> moneyRecordService.sumPeriodAmount(period.id, request.recordType) }

        return converter.toTotalMoneyResponses(periods, totalAmounts)
    }

}