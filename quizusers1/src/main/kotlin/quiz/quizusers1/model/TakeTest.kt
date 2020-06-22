package quiz.quizusers1.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
class TakeTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    @ManyToOne
    @JoinColumn(name = "test_id")
    var test: Test? = null

    var registeredAt: LocalDateTime? =LocalDateTime.now();
           // java.util.Calendar.getInstance();
    //val currentDateTime = LocalDateTime.now()
    //.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    var grade = 0
}