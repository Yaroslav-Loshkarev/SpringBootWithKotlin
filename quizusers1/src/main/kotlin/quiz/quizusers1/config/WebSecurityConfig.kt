package quiz.quizusers1.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private val dataSource: DataSource? = null
//"/users/showquestions/{testId}",
    //"/users/showquestions/{testId}","/admin/showtests","/newaccount/**","/admin/createtest","/admin/createquest/{test_id}"
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .httpBasic()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                   // .antMatchers("/admin/sayhello").hasRole("ADMIN")
                    .antMatchers("/newaccount/**").permitAll()
                    .anyRequest().authenticated()

                .and()
                    .formLogin().loginPage("/users/login")
                   .permitAll()
                .disable()
                    .logout()
                    .permitAll()
    }


    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
       /* auth.inMemoryAuthentication()
                .withUser("bestadmin")
                .password("controlyourworld")
                .roles("ADMIN")
                .and()*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?")
    }
}