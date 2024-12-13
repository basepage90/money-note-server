package kr.crispyblog.moneynote.domain.user.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user_authentication")
class UserAuthentication(
    val userId: Long,
    val signupMethod: String,
    var emailVerified: Boolean,
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