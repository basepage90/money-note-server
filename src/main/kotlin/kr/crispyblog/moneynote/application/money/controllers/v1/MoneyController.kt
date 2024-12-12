package kr.crispyblog.moneynote.application.money.controllers.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.crispyblog.moneynote.application.money.dto.CreateMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.EditMoneyRecordRequest
import kr.crispyblog.moneynote.application.money.dto.MoneyRecordResponse
import kr.crispyblog.moneynote.application.money.useCases.MoneyRecordUseCase
import org.springframework.web.bind.annotation.*
import java.time.YearMonth

@Tag(name = "Money API", description = " API")
@RestController
@RequestMapping("/v1/money")
class MoneyRecordController(
    private val moneyRecordUseCase: MoneyRecordUseCase
) {

    @Operation(summary = "특정 수입지출 정보 조회", description = "특정 수입지출 정보를 조회한다.")
    @GetMapping("/")
    fun searchMoney(id: Long): MoneyRecordResponse? {
        return moneyRecordUseCase.searchMoneyRecord(id)
    }

    @Operation(summary = "월별 수입지출 정보 리스트 조회", description = "월별 수입지출 정보들을 조회한다.")
    @GetMapping("/month")
    fun searchTotalMoney(month: YearMonth): List<MoneyRecordResponse> {
        return moneyRecordUseCase.searchMoneyRecords(month);
    }

    @Operation(summary = "수입지출 기록 등록")
    @PostMapping("/record")
    fun createRecord(@RequestBody request: CreateMoneyRecordRequest) {
        moneyRecordUseCase.create(request)
    }

    @Operation(summary = "수입지출 기록 수정")
    @PutMapping("/record")
    fun editRecord(@RequestBody request: EditMoneyRecordRequest) {
        moneyRecordUseCase.edit(request)
    }

}