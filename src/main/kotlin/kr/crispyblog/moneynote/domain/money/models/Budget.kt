package kr.crispyblog.moneynote.domain.money.models;

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.core.annotation.AliasFor
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "budgets")
class Budget(
    @Column(name = "user_id", nullable = false)
    val userId: Int,
    @Column
    var recordType: String,
    @Column
    var categoryType: String,
    @Column
    var amount: Long,
    @Column
    var memo: String = "",
    @Column
    var recordedDate: LocalDate,
    @Column
    var periodId: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
