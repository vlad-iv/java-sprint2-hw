import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportService {
    InMemoryStorage storage = new InMemoryStorage();

    public void loadMonthReports() {
        ArrayList<Item> items = loadMonthReport("./resources/m.202101.csv");
        storage.saveMonthReport(2021, 1, items);
    }

    ArrayList<Item> loadMonthReport(String path) {
        List<String> lines = readFileContents(path);
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] rows = line.split(",");
            Item item = new Item(rows[0], Boolean.parseBoolean(rows[1]),
                    Integer.parseInt(rows[2]),
                    Long.parseLong(rows[3]));
            items.add(item);
        }
        return items;
    }


    public void printMonthReportInfo() {
        System.out.println(storage.monthReports);
        int month = 1;
        System.out.println("Месяц: " + getMonthName(month));
        Item maxEarning = storage.getMaxEarning(month);
        System.out.println("Максимальный доход. Товар: " + maxEarning.name + ". Сумма: " + maxEarning.getTotal());
        Item maxExpense = storage.getMaxExpense(month);
        System.out.println("Максимальный трата. Товар: " + maxExpense.name + ". Сумма: " + maxExpense.getTotal());
    }

    private String getMonthName(int month) {
        return "Январь";
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

}
