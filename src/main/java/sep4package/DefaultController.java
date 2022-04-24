package sep4package;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    String health() {
        return "This is the cloud workshop app modified for sep4";
    }
}
