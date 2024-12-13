package kr.crispyblog.moneynote.application.money.controllers.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.crispyblog.moneynote.application.money.dto.CreatePeriodRequest
import kr.crispyblog.moneynote.application.money.dto.EditPeriodRequest
import kr.crispyblog.moneynote.application.money.dto.PeriodResponse
import kr.crispyblog.moneynote.application.money.dto.PeriodsRequest
import kr.crispyblog.moneynote.application.money.useCases.PeriodUseCase
import org.springframework.web.bind.annotation.*

@Tag(name = "Period API", description = "기간 정보 API")
@RestController
@RequestMapping("/v1/period")
class PeriodController(
    private val periodUseCase: PeriodUseCase
) {

    @Operation(summary = "기간 정보 조회", description = "특정 기간 정보를 조회한다.")
    @GetMapping("")
    fun getPeriod(id: Long): PeriodResponse? {
        return periodUseCase.getPeriodResponse(id)
    }

    @Operation(summary = "기간 정보 리스트 조회", description = "특정 일자사이의 기간 정보 리스트를 조회한다.")
    @GetMapping("/list")
    fun searchPeriods(request: PeriodsRequest): List<PeriodResponse> {
        return periodUseCase.searchPeriodResponses(request);
    }

    @Operation(summary = "기간 정보 등록")
    @PostMapping("/")
    fun createPeriod(@RequestBody request: CreatePeriodRequest) {
        periodUseCase.create(request)
    }

    @Operation(summary = "기간 정보 편집")
    @PutMapping("/")
    fun editPeriod(@RequestBody request: EditPeriodRequest) {
        periodUseCase.edit(request)
    }

}