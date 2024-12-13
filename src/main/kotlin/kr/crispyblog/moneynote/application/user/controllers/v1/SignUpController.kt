package kr.crispyblog.moneynote.application.user.controllers.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.crispyblog.moneynote.application.money.dto.CreateMoneyRecordRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "SignUp API", description = "회원가입 API")
@RestController
@RequestMapping("/v1/sign-up")
class SignUpController {

    @Operation(summary = "수입지출 기록 등록")
    @PostMapping("/sns")
    fun signUpWithSns(@RequestBody request: SignUpWithSnsRequest) {
    }
}