package stazhirovka;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDAO dao = new UserDAO();

    @GetMapping
    public List<User> getAll() {
        return dao.findAll();
    }

    @PostMapping
    public void add(@RequestBody User user) {
        dao.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.deleteById(id);
    }

    @PutMapping("/{id}/language")
    public void updateLanguage(
            @PathVariable int id,
            @RequestParam String language) {
        dao.updateLanguage(id, language);
    }

    @PutMapping("/{id}/stack")
    public void updateStack(
            @PathVariable int id,
            @RequestParam String stack) {
        dao.updateStack(id, stack);
    }
}