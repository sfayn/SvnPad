package de.sharea.svnpad.dao;

import de.sharea.svnpad.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    /**
     * Selects an user by given user id
     *
     * @param id Id of User
     * @return User Object
     */
    User findById(Integer id);

    /**
     * Selects an user by given email address
     *
     * @param email Email of User
     * @return User Object
     */
    User findByEmail(String email);

    /**
     * Selects an user by given username
     *
     * @param username Username of User
     * @return User Object
     */
    User findByUsername(String username);

    @Query("select count(u) from User u where u.username = :username")
    Long checkIfUsernameAlreadyTaken(@Param(value = "username") String username);

    @Query("select count(u) from User u where u.email = :email")
    Long checkIfEmailAlreadyTaken(@Param(value = "email") String email);

    /**
     * Counts all existing users
     *
     * @return number of all existing users
     */
    @Query("select count(u) from User u")
    Integer countAllUsers();

}
