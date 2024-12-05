package kr.crispyblog.moneynote.domain.money.repositories

import kr.crispyblog.moneynote.domain.money.models.Budget
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BudgetRepository : JpaRepository<Budget, Long> {

    fun findByUserIdOrderByRecordedDateAsc(userId: Int): Optional<List<Budget>>

    fun findByPeriodIdOrderByRecordedDateAsc(periodId: Int): Optional<List<Budget>>
}