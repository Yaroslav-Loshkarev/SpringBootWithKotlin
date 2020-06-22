package quiz.quizusers1.repository

import org.springframework.data.jpa.repository.JpaRepository
import quiz.quizusers1.model.Test
import quiz.quizusers1.model.User

interface TestRepo : JpaRepository<Test?, Int> {
   // fun findByTest(idtest: Int): Test

    fun existsByTest(test : String?) : Boolean
}