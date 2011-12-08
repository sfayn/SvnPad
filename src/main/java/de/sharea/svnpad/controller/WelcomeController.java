package de.sharea.svnpad.controller;

import de.sharea.svnpad.controller.beans.UserDataBean;
import de.sharea.svnpad.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Patrick Trautmann
 * <p/>
 * Contact: patrick.trautmann@gmail.com
 * Date: 29.11.11
 * Time: 21:03
 */
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private UserDao userDao;

    private UserDataBean userBean;

    private boolean usernameNotTaken;
    private boolean emailNotTaken;

    private String usernameFieldStyleClass = "";
    private String emailFieldStyleClass = "";

    public void registerUsernameValueChangeEvent() {

        logger.debug("Username ValueChange event called");
        Integer userCount = userDao.checkIfUsernameAlreadyTaken(userBean.getUsername()).intValue();

        setUsernameNotTaken((userCount == 0));
    }

    public void registerEmailValueChangeEvent() {

        logger.debug("Email ValueChange event called");
        Integer emailUserCount = userDao.checkIfEmailAlreadyTaken(userBean.getEmail()).intValue();

        setEmailNotTaken((emailUserCount == 0));

    }

    public UserDataBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserDataBean userBean) {
        this.userBean = userBean;
    }

    public boolean isEmailNotTaken() {
        return emailNotTaken;
    }

    public void setEmailNotTaken(boolean emailNotTaken) {
        if (emailNotTaken) {
            logger.debug("Setting Email StyleClass to success");
            setEmailFieldStyleClass("success");
        } else {
            logger.debug("Setting Email StyleClass to error");
            setEmailFieldStyleClass("error");
        }
        this.emailNotTaken = emailNotTaken;
    }

    public boolean isUsernameNotTaken() {
        return usernameNotTaken;
    }

    public void setUsernameNotTaken(boolean usernameNotTaken) {
        if (usernameNotTaken) {
            logger.debug("Setting Username StyleClass to success");
            setUsernameFieldStyleClass("success");
        } else {
            logger.debug("Setting Username StyleClass to error");
            setUsernameFieldStyleClass("error");
        }
        this.usernameNotTaken = usernameNotTaken;
    }

    public String getUsernameFieldStyleClass() {
        return usernameFieldStyleClass;
    }

    public void setUsernameFieldStyleClass(String usernameFieldStyleClass) {
        this.usernameFieldStyleClass = usernameFieldStyleClass;
    }

    public String getEmailFieldStyleClass() {
        return emailFieldStyleClass;
    }

    public void setEmailFieldStyleClass(String emailFieldStyleClass) {
        this.emailFieldStyleClass = emailFieldStyleClass;
    }
}
