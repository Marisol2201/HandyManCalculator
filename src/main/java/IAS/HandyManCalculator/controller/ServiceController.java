package IAS.HandyManCalculator.controller;

import IAS.HandyManCalculator.domain.Service;
import IAS.HandyManCalculator.repository.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceRepository repository;

    public ServiceController(ServiceRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> listService() {
        return repository.listService();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createService(
            @RequestBody Service transaction) {
        repository.createService(transaction);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteService(
            @RequestBody Service transaction) {
        repository.deleteService(transaction);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void updateService(
            @PathVariable final int id,
            @RequestBody Service transaction) {
        repository.updateService(transaction);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getOneService(
            @PathVariable final int id) {
        return repository.getOneService(id);
    }
}
