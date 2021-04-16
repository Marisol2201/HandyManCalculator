//package IAS.HandyManCalculator.repository;
//
//import IAS.HandyManCalculator.domain.Week;
//import IAS.HandyManCalculator.test.WeekDatabase;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class WeekRepository {
//    private final WeekDatabase database;
//
//    // DEPENDENCY INVERSION
//    public WeekRepository(WeekDatabase weekDatabase) {
//        this.database = weekDatabase;
//    }
//
//    //post
//    public void createWeek(Week weeks) {
//        database.insertDataWeek(weeks);
//    }
//
//    //get list
//    public List<Object> listWeek() {
//        return database.listDataWeek();
//    }
//
//    //delete
//    public void deleteWeek(Week weeks) {
//        database.deleteDataWeek(weeks);
//    }
//
//    //put(update)
//    public Object updateWeek(Week weeks) {
//        return database.updateDataWeek(weeks);
//    }
//
//    //get one
//    public Object getOneWeek(int id) {
//        return database.getOneDataWeek(id);
//    }
//}
