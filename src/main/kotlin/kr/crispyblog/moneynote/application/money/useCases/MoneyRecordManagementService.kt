package kr.crispyblog.moneynote.application.money.useCases

import kr.crispyblog.moneynote.application.money.convert.MoneyRecordConverter
import kr.crispyblog.moneynote.application.money.dto.CreateMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.EditMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.domain.money.repositories.MoneyRecordRepository
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.services.MoneyRecordManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.YearMonth

@Service
class MoneyRecordManagementService(
    val moneyRecordManager: MoneyRecordManager,
    val converter: MoneyRecordConverter,
    private val moneyRecordRepository: MoneyRecordRepository,
    private val periodRepository: PeriodRepository,
): MoneyRecordUseCase {

    val userId: Long = 1

    /**
     * 특정 수입지출 기록 조회
     */
    override fun searchMoneyRecord(id: Long): MoneyRecordResponse? {
        val moneyRecord = moneyRecordManager.findMoneyRecord(id) ?: return null

        return converter.toMoneyRecordResponse(moneyRecord)
    }

    /**
     * 월별 수입지출 기록 리스트 조회
     */
    override fun searchMoneyRecords(month: YearMonth): List<MoneyRecordResponse> {
        val moneyRecords = moneyRecordManager.findMoneyRecords(month, userId)

        return converter.toMoneyRecordResponses(moneyRecords)
    }

    override fun create(request: CreateMoneyRecordRequest) {
        val period = periodRepository.findById(request.periodId).orElse(null)
        val moneyRecord = converter.toEntity(request, userId, period)
        moneyRecordRepository.save(moneyRecord)
    }

    @Transactional
    override fun edit(request: EditMoneyRecordRequest) {
        val moneyRecord = moneyRecordRepository.findById(request.id).orElseThrow { IllegalArgumentException("MoneyRecord with ID ${request.id} does not exist") }
        val period = periodRepository.findById(request.periodId).orElse(null)
        moneyRecord.modify(request, period)
    }
}