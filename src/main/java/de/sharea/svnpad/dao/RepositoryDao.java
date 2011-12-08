package de.sharea.svnpad.dao;

import de.sharea.svnpad.dao.entities.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryDao extends JpaRepository<Repository, Integer> {

    /**
     * Selects a repository by given repository name
     *
     * @param name Name of Repository
     * @return Repository object
     */
    Repository findByName(String name);

    /**
     * Selects a repository by given repository id
     *
     * @param id Id of Repository
     * @return Repository object
     */
    Repository findById(Integer id);

    /**
     * Selects all available public Repositories
     *
     * @return List with available Repositories
     */
    @Query("select r from Repository r where r.publicRepository = true")
    List<Repository> findAllPublicRepositories();

}
