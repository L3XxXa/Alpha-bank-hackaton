package newthread.server.backend.Controller;


import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Service.UserService;
import newthread.server.backend.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping(value = "/register")
    public boolean register(@RequestBody UserDto userDto){
        return userService.registration(userDto);
    }

    @PostMapping(value = "/login")
    public boolean login(@RequestBody UserDto userDto){
        return userService.login(userDto);
    }
}
