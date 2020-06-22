package quiz.quizusers1.controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import quiz.quizusers1.model.Role
import quiz.quizusers1.model.User
import quiz.quizusers1.repository.UserRepo
import java.util.*

@RestController
@RequestMapping("/newaccount")
class RegistrationController (/*private val bCryptPasswordEncoder: BCryptPasswordEncoder*/) {
	@Autowired
	private lateinit var userRepo: UserRepo


	@PostMapping("/registration")
	fun registration(@RequestBody user : User) : String {
		return if(!userRepo.existsByUsername(user.username.toString())){
			user.active = true
			//user.password= bCryptPasswordEncoder.encode(user.password)
			user.roles = Collections.singleton(Role.USER)
			userRepo!!.save(user)
			"User ${user.username} successfuly registered!"
		}
		else {
			"User ${user.username} already exists!"
		}
		

	}


	/*@PostMapping("/registration")
	fun addUser(user: User): Any? {

		val userFromDb: User? = userRepo?.findByUsername(user.getUsername())
		return if (userFromDb != null) {
			 "User exists!"
		}
		else {
			user.setActive(true)
			user.setRoles(Collections.singleton(Role.USER))
			userRepo?.save(user)

			//return "redirect:/login"
		}
	}


*/






}
//http://localhost:8080/quizusers/addUser?login=oracle&mail=newman1992@gmail.com&password=13man445
//http://localhost:8080/users/registration?_username=Orca&_password=qwer