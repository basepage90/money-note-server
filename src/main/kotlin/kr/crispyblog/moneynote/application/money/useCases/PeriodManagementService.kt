package kr.crispyblog.moneynote.application.money.useCases

import kr.crispyblog.moneynote.application.money.convert.PeriodConverter
import kr.crispyblog.moneynote.application.money.dto.CreatePeriodRequest
import kr.crispyblog.moneynote.application.money.dto.EditPeriodRequest
import kr.crispyblog.moneynote.application.money.dto.PeriodResponse
import kr.crispyblog.moneynote.application.money.dto.PeriodsRequest
import kr.crispyblog.moneynote.domain.money.repositories.PeriodRepository
import kr.crispyblog.moneynote.domain.money.services.PeriodManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PeriodManagementService(
    val periodManager: PeriodManager,
    val periodRepository: PeriodRepository,
    val converter: PeriodConverter,
) : PeriodUseCase {

    val userId: Long = 1

    /**
     * 기간 정보 조회
     */
    override fun getPeriodResponse(id: Long): PeriodResponse? {
        val periodDto = periodManager.findPeriod(id) ?: return null

        return converter.toPeriodResponse(periodDto)
    }

    /**
     * 기간 정보 리스트 조회
     */
    override fun searchPeriodResponses(request: PeriodsRequest): List<PeriodResponse> {
        val periodDtos = periodManager.findPeriods(request, userId)

        return converter.toPeriodResponses(periodDtos)
    }

    /**
     * 기간 정보 생성
     */
    override fun create(request: CreatePeriodRequest) {
        val period = converter.toEntity(request, userId)
        periodRepository.save(period)
    }

    /**
     * 기간 편집
     */
    @Transactional
    override fun edit(request: EditPeriodRequest) {
        val period = periodRepository.findById(request.id)
            .orElseThrow { IllegalArgumentException("Period with ID ${request.id} does not exist") }
        period.modify(request)
    }

}