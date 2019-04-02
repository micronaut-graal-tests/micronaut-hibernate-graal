package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post("/save")
    public User save(String username, String firstName, String lastName) {
        return userService.save(username, firstName, lastName);
    }

//    @Get("/{id}")
//    public User findById(Long id) {
//        return userService.findById(id)
//                .orElse(null);
//    }
}
