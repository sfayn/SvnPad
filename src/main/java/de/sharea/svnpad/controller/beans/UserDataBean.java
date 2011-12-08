package de.sharea.svnpad.controller.beans;

/**
 * Created by Patrick Trautmann
 * <p/>
 * Contact: patrick.trautmann@gmail.com
 * Date: 29.11.11
 * Time: 21:21
 */
public class UserDataBean {

    private String username;
    private String preName;
    private String lastName;
    private String email;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDataBean{" +
                "email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preName='" + preName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
