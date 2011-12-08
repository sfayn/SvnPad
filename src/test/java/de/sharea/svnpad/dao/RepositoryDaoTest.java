package de.sharea.svnpad.dao;

import de.sharea.svnpad.dao.entities.Repository;
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
public class RepositoryDaoTest {

    @Autowired
    private RepositoryDao dao;

    private Repository repository;

    @Before
    public void insertTestRepository() {

        repository = new Repository();

        repository.setName("Testrepo");
        repository.setUrl("http://127.0.0.1/svn/testrepo");

        dao.save(repository);

    }

    @Test
    public void selectByName() {

        Repository testRepo = dao.findByName("Testrepo");

        assertTrue(testRepo != null);
        assertTrue("Check if name is correct", testRepo.getName().equals("Testrepo"));
        assertTrue("Check if url is correct", testRepo.getUrl().equals("http://127.0.0.1/svn/testrepo"));

    }

    @After
    public void deleteTestRepository() {

        dao.delete(repository);

    }


}
