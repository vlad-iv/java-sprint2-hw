import java.util.Scanner;

public class BuhApplication {

    private Scanner scanner;
    private ReportService service;

    public void run() {
        System.out.println("Введите команду:");
        scanner = new Scanner(System.in);
        service = new ReportService();
        while (true) {
            printMenu();
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                return;
            } else if (line.equals("1")) {
                System.out.println("Начинаем считать все месячные отчёты");
                service.loadMonthReports();
                System.out.println("Завершили считать все месячные отчёты");
            } else if (line.equals("4")) {
                System.out.println("Начинаем выводить информацию о всех месячных отчётах");
                service.printMonthReportInfo();
                System.out.println("Завершили выводить информацию о всех месячных отчётах");
            } else {
                System.out.println("Неизвестная команда");
            }
        }

    }

    private void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 — Считать все месячные отчёты");
        System.out.println("2 — Считать годовой отчёт");
        System.out.println("3 — Сверить отчёты");
        System.out.println("4 — Вывести информацию о всех месячных отчётах");
        System.out.println("5 — Вывести информацию о годовом отчёте");
        System.out.println("Нажмите Enter для завершения программы");
    }
}
