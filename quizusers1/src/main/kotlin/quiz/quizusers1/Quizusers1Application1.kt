package quiz.quizusers1

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication

class Quizusers1Application1 {
    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}

fun main(args: Array<String>) {
    runApplication<Quizusers1Application1>(*args)
}
