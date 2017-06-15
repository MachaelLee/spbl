package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Add class description here.
 *
 * @author Li Guojie
 */
@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/hello")
    public
    @ResponseBody
    String addNewUser(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "hello " + name + "!";
    }

    @GetMapping(path = "/add")
    public
    @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String passwd) {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPasswd(passwd);
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public
    @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/user1")
    public
    @ResponseBody
    List<User> findByName(@RequestParam String name) {
        try {
            return userRepository.findByName(name);
        } catch (NoSuchElementException e) {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/user2")
    public
    @ResponseBody
    List<User> findByName(@RequestParam String name, @RequestParam String email) {
        try {
            return userRepository.findByName(name, email);
        } catch (NoSuchElementException e) {

            return new ArrayList<>();
        }
    }
}
