package quiz.quizusers1.repository

import org.springframework.data.jpa.repository.JpaRepository
import quiz.quizusers1.model.User


interface UserRepo : JpaRepository<User?, Long?> {
    fun findByUsername(username: String?): User
    fun existsByUsername(username : String?) : Boolean

}
