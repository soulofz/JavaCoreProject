package JavaCore_Project.Service;

import JavaCore_Project.Model.Transfer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ParserService {

    public List<Transfer> parseFiles(String inputDirection, String archiveDirection, ReportService reportService) throws IOException {
        List<Transfer> transfers = new ArrayList<>();

        File input = new File(inputDirection);
        if (!input.exists()) {
            return transfers;
        }

        File[] files = input.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null) {
            return transfers;
        }

        for (File file : files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.matches("^\\D.*")) {
                        continue;
                    }
                    String[] parts = line.split(";");
                    if (parts.length < 3) {
                        continue;
                    }
                    String accFrom = parts[0].trim();
                    String accTo = parts[1].trim();
                    int amount = 0;
                    try {
                        amount = Integer.parseInt(parts[2].trim());
                    } catch (NumberFormatException e) {
                        reportService.log(file.getName(), accFrom, accTo, amount, "Exception :" + e.getMessage());
                        continue;
                    }
                    transfers.add(new Transfer(accFrom, accTo, amount, file.getName()));
                }
            }
            Files.createDirectories(Paths.get(archiveDirection));
            Path target = Paths.get(archiveDirection, file.getName());
            Files.move(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
        }
        return transfers;
    }
}
