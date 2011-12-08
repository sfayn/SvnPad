package de.sharea.svnpad.services.login;

import de.sharea.svnpad.dao.UserDao;
import de.sharea.svnpad.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserService implements UserDetailsService {

    @Autowired
    UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        User user;

        try {
            user = dao.findByUsername(username);
        } catch (EmptyResultDataAccessException e) {

            throw new UsernameNotFoundException("Username don't exists!");

        }

        return user;
    }

}
