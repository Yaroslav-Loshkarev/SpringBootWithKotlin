package quiz.quizusers1.controller

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import quiz.quizusers1.model.Questions
import quiz.quizusers1.model.User
import quiz.quizusers1.repository.QuestionRepo
import quiz.quizusers1.repository.TestRepo
import quiz.quizusers1.repository.UserRepo
import java.security.Principal


@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private lateinit var userRepo: UserRepo;

    @Autowired
    private lateinit var testRepo: TestRepo;

    @Autowired
    private lateinit var questionRepo: QuestionRepo;



/*
    @GetMapping("/show")
    fun Showme() : String {
        return "Hello!"
    }
    @GetMapping("/showuser/{id}")
    fun createQuestion(@PathVariable id: Long) : User {
        return userRepo.getOne(id);
    }
*/
    @GetMapping("/showtests")
        fun ShowTests() = testRepo.findAll();


    @PostMapping("/login")
    fun LoginUser() : String {
       return "Alright!"

    }
/*
    @GetMapping("/username")
    @ResponseBody
    fun currentUserName(principal: Principal): String? {
        return principal.name

    }
*/
   @GetMapping("/showquestions/{test_id}")
    fun getQuestionsByTest(@PathVariable test_id: Int?): List<Questions?>? {
        if (!testRepo.existsById(test_id!!)) {
            throw NotFoundException("Test not found!")
        }
        return questionRepo.findByTestIdtest(test_id)
    }





}