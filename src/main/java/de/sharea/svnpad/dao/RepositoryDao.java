package de.sharea.svnpad.dao;

import de.sharea.svnpad.dao.entities.Repository;

public interface RepositoryDao {

    void insertRepository(Repository repository);

    void deleteRepository(Repository repository);

    void updateRepository(Repository repository);

}
