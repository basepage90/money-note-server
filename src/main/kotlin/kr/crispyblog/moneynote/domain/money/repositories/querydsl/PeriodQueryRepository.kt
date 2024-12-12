package kr.crispyblog.moneynote.domain.money.repositories.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import kr.crispyblog.moneynote.domain.money.models.Period
import kr.crispyblog.moneynote.domain.money.models.QPeriod.period
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
class PeriodQueryRepository(private val entityManager: EntityManager) {

    private val queryFactory: JPAQueryFactory = JPAQueryFactory(entityManager)

    fun findMyPeriods(userId: Long, startDate: LocalDate?, endDate: LocalDate?): Optional<List<Period>> {
        val query = queryFactory
            .selectFrom(period)
            .where(period.userId.eq(userId))
            .where(period.startDate.goe(startDate))
            .where(period.endDate.loe(endDate))
            .orderBy(period.startDate.asc())

        val result = query.fetch() ?: return Optional.empty()

        return Optional.of(result)

    }
}

