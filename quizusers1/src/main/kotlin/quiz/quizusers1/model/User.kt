package quiz.quizusers1.model

import javax.persistence.*


@Entity
@Table(name = "usr")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
         var id: Long? = null
         var username: String? = null
         var password: String? = null
         var active = false

        @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
        @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
        @Enumerated(EnumType.STRING)
        var roles: Set<Role?>? = null

    @OneToMany(mappedBy = "user")
    var taketest: Set<TakeTest>? = null

        /*fun getId(): Long? {
                return id
        }

        fun setId(id: Long?) {
                this.id = id
        }
/*
        fun getUsername(): String? {
                return username
        }

        fun setUsername(username: String?) {
                this.username = username
        }
*/
        fun getPassword(): String? {
                return password
        }

        fun setPassword(password: String?) {
                this.password = password
        }

        fun isActive(): Boolean {
                return active
        }

        fun setActive(active: Boolean) {
                this.active = active
        }

        fun getRoles(): Set<Role?>? {
                return roles
        }

        fun setRoles(roles: Set<Role?>?) {
                this.roles = roles
        }
*/
/*
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")], inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
    private val roles: Collection<Role>? = null*/
}