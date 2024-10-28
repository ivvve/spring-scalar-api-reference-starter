package devson.springmvcexample.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Tag(name = "User API", description = "User related APIs")
@RestController
@RequestMapping("/api/v1/users")
public class UserV1Controller {
    private List<User> users = new ArrayList<>() {{
        add(new User(1L, "Alice", "alice@xxxxx.com", "Seoul", true));
        add(new User(2L, "Bob", "bob@xxxxx.io", "New York", true));
        add(new User(3L, "Charlie", "real-charlie@xxxxx.com", "Hong Kong", false));
        add(new User(4L, "David", "david1122@xxxxx.com", "Busan", true));
    }};

    @Operation(description = "Get filtered users")
    @GetMapping
    public List<User> getUsers(
        @Parameter(description = "City where the user lives") @RequestParam(required = false) String city,
        @Parameter(description = "Is the user active") @RequestParam(required = false) Boolean isActive
    ) {
        var userStream = this.users.stream();

        if (city != null) {
            userStream = userStream.filter(user -> Objects.equals(user.city(), city));
        }

        if (isActive != null) {
            userStream = userStream.filter(user -> Objects.equals(user.isActive(), isActive));
        }

        return userStream.toList();
    }

    @Operation(description = "Add new user")
    @PostMapping
    public User addUser(@RequestBody User user) {
        this.users.add(user);
        return user;
    }
}
