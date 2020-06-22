package quiz.quizusers1.controller

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import quiz.quizusers1.model.Questions
import quiz.quizusers1.model.Role
import quiz.quizusers1.model.Test
import quiz.quizusers1.model.User
import quiz.quizusers1.repository.QuestionRepo
import quiz.quizusers1.repository.TestRepo
import quiz.quizusers1.repository.UserRepo
import java.util.*
import javax.validation.Valid


@RestController

@RequestMapping("/admin")
class AdminController {

    @Autowired
    private lateinit var userRepo: UserRepo

    @Autowired
    private lateinit var testRepo: TestRepo

    @Autowired
    private lateinit var questionRepo: QuestionRepo
/*
    @GetMapping("/sayhello")
    @PreAuthorize("hasAuthority('ADMIN')")
    fun justSay() = "Hello";

*/
    @GetMapping("/findall")
    @PreAuthorize("hasAuthority('ADMIN')")
    fun findAll() = userRepo.findAll();

    @GetMapping("/showtests")
    @PreAuthorize("hasAuthority('ADMIN')")
    fun showTests() = testRepo.findAll();

    @PostMapping("/registration")
    fun registration(@RequestBody user : User) : String {
        return if(!userRepo.existsByUsername(user.username.toString())){
            user.active = true
            //user.password= bCryptPasswordEncoder.encode(user.password)
            user.roles = Collections.singleton(Role.ADMIN)
            userRepo!!.save(user)
            "ADMIN ${user.username} WAS BORN!"
        }
        else {
            "Admin ${user.username} already exists!"
        }

    }

    //--------------------------------------------------------------
    @PostMapping("/createtest")
    //@PreAuthorize("hasAuthority('ADMIN')")
    fun createTest(@RequestBody newtest : Test) : String {
        return if(!testRepo.existsByTest(newtest.test.toString())){
            testRepo.save(newtest)
            "The test  ${newtest.test} was created!"
        }
        else {
            "Test ${newtest.test} already exists!"
        }
    }

@PostMapping("/createquest/{test_id}")
open fun addAssignment(@PathVariable test_id: Int,
                       @RequestBody questions: Questions): Questions? {

    return testRepo.findById(test_id)
            .map({ test ->
                questions.setTest(test)
                print(questions.questtext);
                questionRepo.save(questions)
            }).orElseThrow({ NotFoundException("Student not found!") });

}

/*

    @PostMapping("/createquest/{test_id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    fun createQuestion(@PathVariable test_id: String?, @RequestBody question: @Valid Questions?) : Questions?
    {

        return test_id?.let {
            testRepo.findById(it.toInt())
                    .map { test ->
                        question?.setTest(test)
                        questionRepo.save(question)
                    }.orElseThrow{ NotFoundException("Test not found!") }
        }

    }
*/




/*
    @PostMapping("/addUser")
    fun addUser(login: String, mail: String, password: String): quizuser {
        val user = quizuser(login = login, mail = mail, password = password)
        return userRepository.save(user)
    }*/

}