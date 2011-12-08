package de.sharea.svnpad.controller;

import de.sharea.svnpad.controller.beans.UserDataBean;
import de.sharea.svnpad.dao.UserDao;
import de.sharea.svnpad.dao.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Patrick Trautmann
 * <p/>
 * Contact: patrick.trautmann@gmail.com
 * Date: 29.11.11
 * Time: 22:54
 */
public class SignUpController {

    private final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserDao userDao;

    private UserDataBean userBean;

    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;


    public String signUpNewUser() {

        User newUser = new User();

        newUser.setUsername(userBean.getUsername());
        newUser.setEmail(userBean.getEmail());
        newUser.setPrename(userBean.getPreName());
        newUser.setLastname(userBean.getLastName());

        PasswordEncoder encoder = new Md5PasswordEncoder();
        String hashedPass = encoder.encodePassword(userBean.getPassword(), null);

        newUser.setPassword(hashedPass);

        logger.info("Save new User at Database. Data: {}", userBean.toString());
        userDao.save(newUser);

        //Login the newly generated user
        loginUser();

        return "start.html?faces-redirect=true";
    }

    private void loginUser() {

        User newUser = userDao.findByUsername(userBean.getUsername());

        PasswordEncoder encoder = new Md5PasswordEncoder();
        String hashedPass = encoder.encodePassword(userBean.getPassword(), null);

        UsernamePasswordAuthenticationToken usernameAndPassword =
                new UsernamePasswordAuthenticationToken(
                        newUser.getUsername(), userBean.getPassword(), newUser.getAuthorities());
        usernameAndPassword.setDetails(newUser);

        // Authenticate, just to be sure
        Authentication auth = authenticationManager.authenticate(usernameAndPassword);

        // Place the new Authentication object in the security context.
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    public UserDataBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserDataBean userBean) {
        this.userBean = userBean;
    }
}
