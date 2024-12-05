package kr.crispyblog.moneynote.domain.money.repositories

import kr.crispyblog.moneynote.domain.money.models.Period
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface PeriodRepository : JpaRepository<Period, Long> {

    fun findByUserIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(userId: Int, startDate: LocalDate?, endDate: LocalDate?): Optional<List<Period>>
}