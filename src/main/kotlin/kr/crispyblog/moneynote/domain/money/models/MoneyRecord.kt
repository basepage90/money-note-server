package kr.crispyblog.moneynote.domain.money.models;

import jakarta.persistence.*
import kr.crispyblog.moneynote.application.money.dto.EditMoneyRecordRequest
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "money_records")
class MoneyRecord(
    val userId: Long,
    var recordType: String,
    var categoryType: String,
    var amount: Long,
    var memo: String?,
    var recordedDate: LocalDate,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodId", nullable = true)
    var period: Period? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var createdAt: LocalDateTime? = null

    var updatedAt: LocalDateTime? = null

    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }

    fun modify(request: EditMoneyRecordRequest, period: Period?) {
        recordType = request.recordType
        categoryType = request.categoryType
        amount = request.amount
        memo = request.memo
        recordedDate = request.recordedDate
        this.period = period
    }
}
