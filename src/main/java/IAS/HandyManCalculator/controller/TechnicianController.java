package IAS.HandyManCalculator.controller;
import IAS.HandyManCalculator.repository.TechnicianRepository;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.domain.Technician;
import java.util.List;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    private final TechnicianRepository repository;

    public TechnicianController(TechnicianRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> listTransactions() {
        return repository.listTechnician();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTransaction(
            @RequestBody Technician transaction) {
        repository.createTechnician(transaction);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTransaction(
            @RequestBody Technician transaction) {
        repository.deleteTechnician(transaction);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void updateTransaction(
            @PathVariable final int id,
            @RequestBody Technician transaction) {
        repository.updateTechnician(transaction);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getOneTechnician(
            @PathVariable final int id) {
        return repository.getOneTechnician(id);
    }
}
