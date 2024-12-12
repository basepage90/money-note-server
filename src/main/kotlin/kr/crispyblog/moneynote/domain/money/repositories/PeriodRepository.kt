package kr.crispyblog.moneynote.domain.money.repositories

import kr.crispyblog.moneynote.domain.money.models.Period
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

interface PeriodRepository : JpaRepository<Period, Long> {

    fun findByUserIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(userId: Long, startDate: LocalDate?, endDate: LocalDate?): Optional<List<Period>>
}