package quiz.quizusers1.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.Valid


@Entity
 class Questions
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var idquest: Int? = null
         var questtext: String? = null

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "test_id")
        @JsonIgnore
        private var test: Test? = null
        fun setTest(test: Test?) {
                this.test = test
        }



        fun getTest(): Test? {
                return this.test
        }



}