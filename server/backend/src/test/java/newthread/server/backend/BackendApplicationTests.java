package newthread.server.backend;

import newthread.server.backend.Repository.UserRepository;
import newthread.server.backend.Service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    UserServiceImpl userService;


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
    }

    @Test
    public void testCardService() {

    }

}
