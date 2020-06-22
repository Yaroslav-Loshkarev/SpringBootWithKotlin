package quiz.quizusers1.encoder

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Autowired
val passwordEncoder: PasswordEncoder? = null

@Bean
fun passwordEncoder(): PasswordEncoder? {
    return BCryptPasswordEncoder()
}