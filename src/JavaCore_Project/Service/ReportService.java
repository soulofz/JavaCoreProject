package JavaCore_Project.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportService {
    private final String reportFile;

    public ReportService(String reportFile) {
        this.reportFile = reportFile;
    }

    public void log(String file, String accFrom, String accTo, int amount, String status) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile, true))) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
            bufferedWriter.write(time + " | " + file + " | перевод с " + accFrom + " | на " + accTo + " " + amount + " | " + status);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи в отчет: " + e.getMessage());
        }
    }
}
