package quiz.quizusers1.repository
import org.springframework.data.jpa.repository.JpaRepository
import quiz.quizusers1.model.Questions
import quiz.quizusers1.model.Test

/*
interface QuestionRepo: JpaRepository<Questions?, Int> {
    abstract fun findByTestId(testId: Int): List<Questions?>?

    abstract fun save(question: Questions?): Questions

    //fun findByTest(test_id: Test?): Questions


}

*/
interface QuestionRepo : JpaRepository<Questions, Int> {

    fun findByTestIdtest(idtest : Int): MutableList<Questions?>?
    fun save(question: Questions?): Questions
}