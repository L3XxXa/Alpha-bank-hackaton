package newthread.server.backend;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Repository.UserRepository;
import newthread.server.backend.Service.CardServiceImpl;
import newthread.server.backend.Service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CardServiceImpl cardService;

    @Test
    public void testUserService() {
        long id = 1;
        var firstUser = userService.getUserById(id);
        Assertions.assertEquals(firstUser.getId(), 1);
        Assertions.assertEquals(firstUser.getEmail(), "callback@mail.ru");
        Assertions.assertEquals(firstUser.getPassword(), "123456");
        Assertions.assertEquals(firstUser.getLastLon(), 83.0335);
        Assertions.assertEquals(firstUser.getLastLat(), 54.9022);

        id = 2;
        var secondUser = userService.getUserById(id);
        Assertions.assertEquals(secondUser.getId(), 2);
        Assertions.assertEquals(secondUser.getEmail(), "jak_Fresko@mail.ru");
        Assertions.assertEquals(secondUser.getPassword(), "123456");
        Assertions.assertEquals(secondUser.getLastLat(), 1.43534);
        Assertions.assertEquals(secondUser.getLastLon(), 2.3123);

        Assertions.assertEquals(2, userService.getUsers().size());

        UserDto userDto = new UserDto();
        userDto.setEmail("callback@mail.ru");
        userDto.setPassword("123456");

        Assertions.assertTrue(userService.login(userDto));

        userDto.setPassword("callback@mail.ru");
        Assertions.assertThrows(InvalidData.class, () -> {
            userService.login(userDto);
        });

        Assertions.assertThrows(NotFound.class, () ->
                userService.getUserById((long) 3));

        Assertions.assertThrows(NotFound.class, () ->
                userService.deleteUser((long) 3)
        );


    }

    @Test
    public void testCardService() {

        Assertions.assertEquals(6, cardService.getAllCards().size());

        Assertions.assertThrows(NotFound.class, () -> cardService.deleteCard((long) 10));


    }

}
