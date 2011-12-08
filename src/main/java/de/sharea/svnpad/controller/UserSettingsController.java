package de.sharea.svnpad.controller;

import de.sharea.svnpad.dao.UserDao;
import de.sharea.svnpad.dao.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Patrick Trautmann
 * <p/>
 * Contact: patrick.trautmann@gmail.com
 * Date: 08.12.11
 * Time: 21:15
 */
public class UserSettingsController {

    private final Logger logger = LoggerFactory.getLogger(UserSettingsController.class);

    @Autowired
    private UserDao userDao;

    private User userEntity;

    public UserSettingsController() {

    }

    public String changeUserData() {

        logger.info("Changed User Data for {}", userEntity.getUsername());

        if (userEntity != null) {
            logger.debug("Save Changes to Database");
            try {
                userDao.save(userEntity);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Updated your Data"));
            } catch (Exception e) {
                logger.error("Error while updating User Data for {}", userEntity.getUsername(), e);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while saving changed Data", "An Error occurred while saving your data"));
            }
        }

        return null;
    }

    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User userEntity) {
        this.userEntity = userEntity;
    }
}
