package newthread.server.backend.Controller;


import com.sun.net.httpserver.Authenticator;
import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.User;
import newthread.server.backend.Service.UserService;
import newthread.server.backend.Service.UserServiceImpl;
import newthread.server.backend.Utils.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/user/register")
    public SuccessResponse<Boolean> register(@RequestBody UserDto userDto) {
        return new SuccessResponse<>(userService.registration(userDto));
    }

    @PostMapping(value = "/user/login")
    public SuccessResponse<Boolean> login(@RequestBody UserDto userDto) {
        return new SuccessResponse<>(userService.login(userDto));
    }

    @GetMapping(value = "/users")
    public SuccessResponse<List<UserDto>> getUsers() {
        return new SuccessResponse<>(userService.getUsers());
    }

    @GetMapping(value = "/user")
    public SuccessResponse<UserDto> getUser(@RequestParam Long id) {
        return new SuccessResponse<>(userService.getUserById(id));
    }

    @DeleteMapping(value = "/user")
    public SuccessResponse<Boolean> deleteUser(@RequestParam Long id) {
        return new SuccessResponse<>(userService.deleteUser(id));
    }

}
