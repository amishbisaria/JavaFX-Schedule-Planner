package Schedule;

import Data.ScheduleItem;
import Data.ScheduleReport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.format.DateTimeFormatter;
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

        scheduleView.getItems().setAll(ScheduleReport.getInstance().getScheduleItems()); //puts items in schItems into scheduleView
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
