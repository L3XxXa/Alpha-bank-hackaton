package newthread.server.backend.Controller;


import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Service.CardServiceImpl;
import newthread.server.backend.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/cards")
    public BaseResponse<List<CardDto>> getCards() {
        return new BaseResponse<>(cardService.getAllCards(),
                "All cards was printed");
    }

}
