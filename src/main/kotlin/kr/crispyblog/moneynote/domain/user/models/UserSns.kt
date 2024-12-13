package kr.crispyblog.moneynote.domain.user.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user_sns")
class UserSns(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = true)
    val user: User,
    val sns_provider: String,
    val sns_id: String,
    val sns_name: String,
    val profileUrl: String,
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