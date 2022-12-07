package newthread.server.backend.Controller;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Service.UserServiceImpl;
import newthread.server.backend.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/user/register")
    public BaseResponse<Boolean> register(@RequestBody UserDto userDto) {
        System.out.println("User registered query" + userDto);
        return new BaseResponse<>(userService.registration(userDto),
                "Registration completed");
    }

    @PostMapping(value = "/user/login")
    public BaseResponse<Boolean> login(@RequestBody UserDto userDto) {
        System.out.println("User login query" + userDto);
        return new BaseResponse<>(userService.login(userDto),
                "Login completed");
    }

    @GetMapping(value = "/users")
    public BaseResponse<List<UserDto>> getUsers() {
        return new BaseResponse<>(userService.getUsers(),
                "List of users");
    }

    @GetMapping(value = "/user")
    public BaseResponse<UserDto> getUser(@RequestParam Long id) {
        return new BaseResponse<>(userService.getUserById(id),
                "User by id");
    }

    @DeleteMapping(value = "/user")
    public BaseResponse<Boolean> deleteUser(@RequestParam Long id) {
        return new BaseResponse<>(userService.deleteUser(id),
                "User was deleted");
    }

    @PutMapping(value = "/user")
    public BaseResponse<Boolean> updateUser(@RequestBody UserDto userDto) {
        return new BaseResponse<>(userService.updateUser(userDto),
                "User was updated");
    }

    @GetMapping(value = "/user/refresh")
    public BaseResponse<Boolean> refreshCards(@RequestParam Long id) throws IOException {
        return new BaseResponse<>(userService.refreshCards(id),
                "Cards were refreshed");
    }

}
