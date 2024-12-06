package kr.crispyblog.moneynote.application.money.controllers.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.application.money.dto.TotalMoneyRequest
import kr.crispyblog.moneynote.application.money.dto.TotalMoneyResponse
import kr.crispyblog.moneynote.application.money.useCases.MoneyRecordUseCase
import kr.crispyblog.moneynote.domain.money.services.MoneyRecordService
import org.springframework.web.bind.annotation.*

@Tag(name = "Money API", description = " API")
@RestController
@RequestMapping("/v1/money")
class MoneyRecordController(
    private val moneyRecordUseCase: MoneyRecordUseCase,
    private val moneyRecordService: MoneyRecordService
) {

    @Operation(summary = "기간별 나의 수입지출 조회", description = "지정된 기간동안 나의 수입지출 정보들을 조회한다.")
    @GetMapping("")
    fun searchMoney(request: MoneyRecordRequest): List<List<MoneyRecordResponse>> {
        return moneyRecordUseCase.searchMoneyRecordLists(request);
    }

    @Operation(summary = "기간별 나의 총 수입지출 조회", description = "지정된 기간동안 나의 총 수입지출(잔금)을 조회한다")
    @GetMapping("/total")
    fun searchTotalMoney(request: TotalMoneyRequest): List<TotalMoneyResponse> {
        return moneyRecordUseCase.searchTotalAmount(request);
    }

    @Operation(summary = "수입지출 기록 등록", description = "수입지출을 기록한다")
    @PostMapping("/record")
    fun registerRecord(@RequestBody request: MoneyRecordRequest) {

    }

    @Operation(summary = "수입지출 기록 등록")
    @PutMapping("/record")
    fun editRecord(@RequestBody request: MoneyRecordRequest) {

    }

    @Operation(summary = "기간 등록")
    @PostMapping("/period")
    fun registerPeriod(@RequestBody request: MoneyRecordRequest) {

    }

    @Operation(summary = "기간 편집")
    @PutMapping("/period")
    fun editPeriod(@RequestBody request: MoneyRecordRequest) {

    }


}