package de.sharea.svnpad.dao;


import de.sharea.svnpad.dao.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserDaoTest {

    @Autowired
    private UserDao dao;

    private User testUser;

    @Before
    public void insertTestUser() {

        testUser = new User();

        testUser.setEmail("patrick.trautmann@gmail.com");
        testUser.setPrename("Patrick");
        testUser.setLastname("Trautmann");
        testUser.setUsername("Promichel");

        dao.save(testUser);

    }

    @Test
    public void selectByEmail() {

        User test = dao.findByEmail("patrick.trautmann@gmail.com");

        assertTrue(test != null);
        assertTrue(test.getPrename().equals("Patrick"));
        assertTrue(test.getLastname().equals("Trautmann"));
        assertTrue(test.getUsername().equals("Promichel"));
        assertTrue(test.getEmail().equals("patrick.trautmann@gmail.com"));

    }

    @After
    public void deleteTestUser() {

        dao.delete(testUser);

    }

}
