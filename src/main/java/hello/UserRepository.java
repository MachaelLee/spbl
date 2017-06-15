package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Add class description here.
 *
 * @author Li Guojie
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);

    List<User> findByName(String name, String email);
}
