package Data;

import java.time.LocalDate;

public class ScheduleItem {

    private String info;
    private String allInfo;
    private LocalDate dueDate;

    public ScheduleItem(String info, String allInfo, LocalDate dueDate) {
        this.info = info;
        this.allInfo = allInfo;
        this.dueDate = dueDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAllInfo() {
        return allInfo;
    }

    public void setAllInfo(String allInfo) {
        this.allInfo = allInfo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
