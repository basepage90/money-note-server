package kr.crispyblog.moneynote.domain.money.models

import jakarta.persistence.*
import kr.crispyblog.moneynote.application.money.dto.EditPeriodRequest
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "periods")
class Period(
    var userId: Long,
    var name: String,
    var startDate: LocalDate,
    var endDate: LocalDate,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

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

    @OneToMany(mappedBy = "period", cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    var moneyRecords: List<MoneyRecord> = emptyList()

    fun modify(request: EditPeriodRequest) {
        name = request.name
        startDate = request.startDate
        endDate = request.endDate
    }

}