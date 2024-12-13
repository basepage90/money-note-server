package kr.crispyblog.moneynote.application.user.dto

import kr.crispyblog.moneynote.constants.enums.SnsProvider

data class SignUpWithSnsRequest(
    val snsProvider: SnsProvider,
    val accessToken: String,
)
