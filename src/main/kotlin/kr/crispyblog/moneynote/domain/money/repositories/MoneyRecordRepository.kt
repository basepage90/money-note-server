package kr.crispyblog.moneynote.domain.money.repositories

import jakarta.persistence.Entity
import kr.crispyblog.moneynote.domain.money.models.MoneyRecord
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

interface MoneyRecordRepository : JpaRepository<MoneyRecord, Long> {

    @EntityGraph(attributePaths = ["period"])
    override fun findById(id: Long): Optional<MoneyRecord>


    fun findByUserIdAndRecordedDateBetween(userId: Long, startOfMonth: LocalDate, endOfMonth: LocalDate): Optional<List<MoneyRecord>>

    // 수입 지출 기록 리스트 조회
    fun findByPeriodIdOrderByRecordedDateAsc(periodId: Long): Optional<List<MoneyRecord>>

    // 수입지출 기록 리스트 조회 - 조건: 기록유형
    fun findByPeriodIdAndRecordTypeOrderByRecordedDateAsc(periodId: Long, recordType: String): Optional<List<MoneyRecord>>
}