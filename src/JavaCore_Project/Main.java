package JavaCore_Project;

import JavaCore_Project.Exceptions.InvalidAmountException;
import JavaCore_Project.Exceptions.TransferException;
import JavaCore_Project.Model.Transfer;
import JavaCore_Project.Service.ParserService;
import JavaCore_Project.Service.ReportService;
import JavaCore_Project.Service.TransferService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransferService transferService = new TransferService();
        ParserService parserService = new ParserService();
        ReportService reportService = new ReportService("report.txt");

        try {
            transferService.loadAccounts("accounts.txt");
        } catch (IOException e) {
            System.out.println("Invalid account number.");
            return;
        }
        System.out.println("Enter the operation number to perform: (1 - process files from input | 2 - show report)");
        int command = scanner.nextInt();
        if (command == 1) {
            try {
                List<Transfer> operations = parserService.parseFiles("input", "archive", reportService);
                for (Transfer operation : operations) {
                    try {
                        transferService.transfer(operation.getAccFrom(), operation.getAccTo(), operation.getAmount());
                        reportService.log(operation.getInputFile(), operation.getAccFrom(), operation.getAccTo(), operation.getAmount(), "Successfully.");
                    } catch (TransferException | InvalidAmountException e) {
                        reportService.log(operation.getInputFile(), operation.getAccFrom(), operation.getAccTo(), operation.getAmount(), "Exception:" + e.getMessage());
                    }
                }
                transferService.saveAccounts("accounts.txt");
            } catch (IOException e) {
                System.out.println("Data processing error.\n");
            }
        } else if (command == 2) {
            System.out.println("See file 'report.txt'");
        }
        scanner.close();
    }
}
