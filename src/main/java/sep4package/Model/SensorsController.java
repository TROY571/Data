package sep4package.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SensorsController
{
    private final SensorsRepository repository;

    public SensorsController(SensorsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    List<Sensors> all() {
        return repository.findAll();
    }

    @GetMapping("/sensors/{id}")
    Sensors one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(
                () -> new SensorsNotFoundException(id)
        );
    }


}
