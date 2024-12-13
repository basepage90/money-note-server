package kr.crispyblog.moneynote.domain.user.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
    var username: String,
    val email: String,
    val password: String?,
    var phoneNumber: String?,
    var status: String,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    var userAuthentication: UserAuthentication? = null
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