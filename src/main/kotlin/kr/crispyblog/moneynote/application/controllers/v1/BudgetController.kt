package kr.crispyblog.moneynote.application.controllers.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.crispyblog.moneynote.application.dto.BudgetInfoRequest
import kr.crispyblog.moneynote.application.dto.BudgetInfoResponse
import kr.crispyblog.moneynote.application.useCases.BudgetUseCase
import kr.crispyblog.moneynote.domain.money.services.BudgetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Budget API", description = "예산 API")
@RestController
@RequestMapping("/v1/budget")
class BudgetController(
    private val budgetUseCase: BudgetUseCase,
    private val budgetService: BudgetService
) {

    @Operation(summary = "기간별 나의 예산 조회", description = "지정된 기간동안 나의 예산 정보들을 반환합니다.")
    @GetMapping("")
    fun searchBudget(request: BudgetInfoRequest): List<List<BudgetInfoResponse>> {
        return budgetUseCase.searchMyBudgets(request);
    }

}