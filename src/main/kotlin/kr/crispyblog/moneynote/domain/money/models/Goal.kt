package kr.crispyblog.moneynote.domain.money.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "goals")
class Goal(
    var periodId: Long,
    var type: String,
    var targetAmount: Long,
    var status: String,
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

}