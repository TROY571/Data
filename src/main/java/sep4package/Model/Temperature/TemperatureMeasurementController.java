package sep4package.Model.Temperature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemperatureMeasurementController
{
    @Autowired
    private final TemperatureMeasurementRepository repository;

    TemperatureMeasurementController(TemperatureMeasurementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/temperatures")
    List<TemperatureMeasurement> all() {
        return repository.findAll();
    }

    @PostMapping("/temperature")
    TemperatureMeasurement newTemperature(@RequestBody TemperatureMeasurement newTemperature) {
        return repository.save(newTemperature);
    }

    @GetMapping("/temperature/{id}")
    TemperatureMeasurement one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(()
        -> new TemperatureMeasurementNotFoundException(id));
    }

    @PutMapping("/temperatures/{id}")
    TemperatureMeasurement updateTemperature(@RequestBody TemperatureMeasurement newTemperature, @PathVariable java.lang.Long id) {
        return repository.findById(id)
                .map(temperature -> {
                    temperature.setTemperature(newTemperature.getTemperature());
                    return repository.save(temperature);
                })
                .orElseGet(() -> {
                    newTemperature.setTemperatureId(id);
                    return repository.save(newTemperature);
                });
    }

    @DeleteMapping("temperatures/{id}")
    void deleteTemperature(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
