package kr.crispyblog.moneynote.domain.money.services

import kr.crispyblog.moneynote.constants.enums.RecordType
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import kr.crispyblog.moneynote.domain.money.repositories.MoneyRecordRepository
import org.springframework.stereotype.Service
import java.time.YearMonth
import java.util.*

@Service
class MoneyRecordManager(
    val moneyRecordRepository: MoneyRecordRepository

) {

    fun findMoneyRecord(id: Long): MoneyRecord? {
        return moneyRecordRepository.findById(id).orElse(null)
    }

    fun findMoneyRecords(month: YearMonth, userId: Long) : List<MoneyRecord> {
        val startOfMonth = month.atDay(1)   // 해당 월의 시작일
        val endOfMonth = month.atEndOfMonth()   // 해당 월의 마지막 날

        return moneyRecordRepository.findByUserIdAndRecordedDateBetween(userId, startOfMonth, endOfMonth).orElse(emptyList())
    }

    /**
     * 기록유형에 따라 수입지출 기록을 조회한다.
     * 기록유형이 null 이면, 조건에서 무시한다.
     */
    fun findMoneyRecordsByPeriod(periodId: Long, recordType: String?): List<MoneyRecord> {
        val optionalMoneyRecord: Optional<List<MoneyRecord>> = recordType?.let {
            moneyRecordRepository.findByPeriodIdAndRecordTypeOrderByRecordedDateAsc(periodId, it)
        } ?: moneyRecordRepository.findByPeriodIdOrderByRecordedDateAsc(periodId)

        return optionalMoneyRecord.orElse(emptyList())
    }

    fun sumPeriodAmount(periodId: Long, recordType: String?): Long {
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