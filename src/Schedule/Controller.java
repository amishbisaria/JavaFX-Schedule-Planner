package Schedule;

import Data.ScheduleItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ScheduleItem> schItems;

    public void initialize()
    {
        ScheduleItem item1 = new ScheduleItem("Field Trip", "Prepare backpack for field trip", LocalDate.of(2021, Month.MARCH, 12));
        ScheduleItem item2 = new ScheduleItem("Math Homework", "Complete algebra homework online", LocalDate.of(2021, Month.APRIL, 22));
        ScheduleItem item3 = new ScheduleItem("Pants", "Purchase new pants", LocalDate.of(2021, Month.MAY, 12));
        ScheduleItem item4 = new ScheduleItem("Airplane Tickets", "Book tickets for summer trip", LocalDate.of(2021, Month.JUNE, 17));
        ScheduleItem item5 = new ScheduleItem("Birthday", "Today is Mom's birthday", LocalDate.of(2021, Month.JULY, 21));

        schItems = new ArrayList<ScheduleItem>();
        schItems.add(item1);
        schItems.add(item2);
        schItems.add(item3);
        schItems.add(item4);
        schItems.add(item5);

    }



}
