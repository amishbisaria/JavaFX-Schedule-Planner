package Data;

import java.time.LocalDate;

public class ScheduleItem {

    private String info;
    private String fullInfo;
    private LocalDate dueDate;

    public ScheduleItem(String info, String fullInfo, LocalDate dueDate) {
        this.info = info;
        this.fullInfo = fullInfo;
        this.dueDate = dueDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public void setFullInfo(String fullInfo) {
        this.fullInfo = fullInfo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return info;
    }
}
