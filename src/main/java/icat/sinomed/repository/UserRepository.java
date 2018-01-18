package icat.sinomed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import icat.sinomed.entity.User;

/**
 * Created by liucong on  16-4-5-005.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update User u " +
            "set u.username =:username, " +
            "u.displayName =:displayName, " +
            "u.role =:role, " +
            "u.enabled =:enabled " +
            "where u.uuid=:uuid")
    int updateUserIgnorePassword(@Param("uuid") String uuid,
                                 @Param("username") String username,
                                 @Param("displayName") String displayName,
                                 @Param("role") String role,
                                 @Param("enabled") boolean enabled);

}
