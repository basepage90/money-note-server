package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.application.money.dto.TotalMoneyResponse
import kr.crispyblog.moneynote.constants.enums.RecordType
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import kr.crispyblog.moneynote.domain.money.models.Period
import kr.crispyblog.moneynote.domain.money.repositories.MoneyRecordRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MoneyRecordService(
    val moneyRecordRepository: MoneyRecordRepository
) {

    /**
     * 기록유형에 따라 수입지출 기록을 조회한다.
     * 기록유형이 null 이면, 조건에서 무시한다.
     */
    fun findMoneyRecordsByPeriod(periodId: Int, recordType: String?): List<MoneyRecord> {
        val optionalMoneyRecord: Optional<List<MoneyRecord>> = recordType?.let {
            moneyRecordRepository.findByPeriodIdAndRecordTypeOrderByRecordedDateAsc(periodId, it)
        } ?: moneyRecordRepository.findByPeriodIdOrderByRecordedDateAsc(periodId)

        return optionalMoneyRecord.orElse(emptyList())
    }

    fun sumPeriodAmount(periodId: Int, recordType: String?): Long {
        val moneyRecords = findMoneyRecordsByPeriod(periodId, recordType)

        val totalAmount = moneyRecords.sumOf {
            when (it.recordType) {
                RecordType.INCOME.name -> it.amount // INCOME일 경우 양수
                RecordType.EXPENSE.name -> -it.amount // EXPENSE일 경우 음수
                else -> 0 // 그 외의 경우는 0으로 처리
            }
        }

        return totalAmount
    }
}