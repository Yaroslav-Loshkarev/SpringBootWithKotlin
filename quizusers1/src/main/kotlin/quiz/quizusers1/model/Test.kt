package quiz.quizusers1.model

import javax.persistence.*


@Entity
class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
     var idtest: Int? = null
     var test: String? = null



    @OneToMany(mappedBy = "test")
    var taketest: Set<TakeTest>? = null


    @OneToMany(mappedBy = "test", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    private var questions: Set<Questions?>? = null

    fun setQuestions(questions: Set<Questions?>?) {
        this.questions = questions
    }

    fun getQuestions(): Set<Questions?>? {
        return this.questions
    }

}