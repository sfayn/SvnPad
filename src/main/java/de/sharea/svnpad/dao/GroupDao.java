package de.sharea.svnpad.dao;

import de.sharea.svnpad.dao.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Group DAO class
 */
public interface GroupDao extends JpaRepository<Group, Integer> {

    /**
     * Selects a group by given group id
     *
     * @param id Id of group
     * @return Group Object
     */
    Group findById(Integer id);

    /**
     * Selects a group by given group name
     *
     * @param name Name of group
     * @return Group Object
     */
    Group findByName(String name);

}
