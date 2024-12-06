package kr.crispyblog.moneynote.domain.money.repositories

import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

interface MoneyRecordRepository : JpaRepository<MoneyRecord, Long> {

    // 수입 지출 기록 리스트 조회
    fun findByPeriodIdOrderByRecordedDateAsc(periodId: Int): Optional<List<MoneyRecord>>

    // 수입지출 기록 리스트 조회 - 조건: 기록유형
    fun findByPeriodIdAndRecordTypeOrderByRecordedDateAsc(periodId: Int, recordType: String): Optional<List<MoneyRecord>>

}