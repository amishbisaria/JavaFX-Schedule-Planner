package Schedule;

import Data.ScheduleItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ScheduleItem> schItems;

    @FXML
    private ListView<ScheduleItem> scheduleView;

    @FXML
    private TextArea fullInfoTextArea;

    @FXML
    private Label dueLabel;

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

        //when the selection is changed update text for text area
        scheduleView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ScheduleItem>() {
            @Override
            public void changed(ObservableValue<? extends ScheduleItem> observableValue, ScheduleItem scheduleItem, ScheduleItem t1) {
                if (t1 != null)
                {
                    ScheduleItem item = scheduleView.getSelectionModel().getSelectedItem();
                    fullInfoTextArea.setText(item.getFullInfo());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dueLabel.setText(df.format(item.getDueDate()));
                }
            }
        });

        scheduleView.getItems().setAll(schItems); //puts items in schItems into scheduleView
        scheduleView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //lets only one item be selected
        scheduleView.getSelectionModel().selectFirst();
    }

    @FXML
    public void clickedListView()
    {
        ScheduleItem item = scheduleView.getSelectionModel().getSelectedItem(); //gets the selected item
        fullInfoTextArea.setText(item.getFullInfo());
        dueLabel.setText(item.getDueDate().toString());
    }

}
