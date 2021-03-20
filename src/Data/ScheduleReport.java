package Data;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class ScheduleReport
{
    private static ScheduleReport instance = new ScheduleReport();
    private static String file = "ItemList.txt";

    private List<ScheduleItem> scheduleItems;
    private DateTimeFormatter df;

    public static ScheduleReport getInstance()
    {
        return instance;
    }
    private ScheduleReport()
    {
        df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    }

    public List<ScheduleItem> getScheduleItems()
    {
        return scheduleItems;
    }

//    public void setScheduleItems(List<ScheduleItem> scheduleItems)
//    {
//        this.scheduleItems = scheduleItems;
//    }

    //store items in file
    public void storeItems() throws IOException
    {
        Path path = Paths.get(file);

        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator <ScheduleItem> iter = scheduleItems.iterator();
            while (iter.hasNext())
            {
                ScheduleItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s", item.getInfo(), item.getFullInfo(), item.getDueDate().format(df)));
                bw.newLine();
            }
        }
        finally{
            if (bw != null)
            {
                bw.close();
            }
        }
    }

    //load items from file
    public void loadItems() throws IOException
    {
        scheduleItems = FXCollections.observableArrayList();
        Path path = Paths.get(file);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try
        {
            while ((input = br.readLine()) != null)
            {
                String[] itemSplit = input.split("\t"); //set delimiter

                String info = itemSplit[0];
                String fullInfo = itemSplit[1];
                String dateShow = itemSplit[2];

                LocalDate date = LocalDate.parse(dateShow, df);
                ScheduleItem scheduleItem = new ScheduleItem(info, fullInfo, date);
                scheduleItems.add(scheduleItem);
            }
        }
        finally
        {
            if (br != null)
            {
                br.close();
            }
        }
    }



}
