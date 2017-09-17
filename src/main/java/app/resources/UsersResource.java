package app.resources;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import app.interfaces.UserDAOInterface;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersResource {

    @Autowired
    UserDAOInterface userDAOInterface;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        userDAOInterface.save(user);
    }
    git rm -r --cached .
    @RequestMapping(value = "/")
    public List<User> readAll() {
        Iterable<User> iterable = userDAOInterface.findAll();
        List<User> users = new ArrayList<>();
        iterable.forEach(users::add);
        return users;
    }

    @RequestMapping(value = "/{id}")
    public User read(@PathVariable long id) {
        return userDAOInterface.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        userDAOInterface.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userDAOInterface.delete(id);
    }
}