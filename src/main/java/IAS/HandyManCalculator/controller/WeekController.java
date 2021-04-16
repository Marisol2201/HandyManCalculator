//package IAS.HandyManCalculator.controller;
//
//import IAS.HandyManCalculator.domain.Week;
////import IAS.HandyManCalculator.repository.WeekRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/week")
//public class WeekController {
//
//    private final WeekRepository repository;
//
//    public WeekController(WeekRepository repository) {
//        this.repository = repository;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Object> listTransactions() {
//        return repository.listWeek();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void createTransaction(
//            @RequestBody Week weeks) {
//        repository.createWeek(weeks);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public void deleteTransaction(
//            @RequestBody Week weeks) {
//        repository.deleteWeek(weeks);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public void updateTransaction(
//            @PathVariable final int id,
//            @RequestBody Week weeks) {
//        repository.updateWeek(weeks);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object getOneWeek(
//            @PathVariable final int id) {
//        return repository.getOneWeek(id);
//    }
//}
