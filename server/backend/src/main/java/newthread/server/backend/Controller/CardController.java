package newthread.server.backend.Controller;


import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Service.CardServiceImpl;
import newthread.server.backend.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CardController {
    @Autowired
    CardServiceImpl cardService;

    @PostMapping("/card")
    public BaseResponse<Boolean> addCard(@RequestBody CardDto dto) {
        return new BaseResponse<>(cardService.addCard(dto),
                "Card was added to your pocket");
    }
}
