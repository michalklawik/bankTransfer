package com.epamsystems.Service;

import com.epamsystems.DAO.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static List<String> readCSV() throws IOException {
        String csvFile = "C:\\Users\\dell\\mklawikowski\\bankTransfer\\src\\main\\resources\\accounts.csv";
        List<String> records = new ArrayList<>();
        String record;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(csvFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((record = bufferedReader.readLine()) != null) {
            records.add(record);
        }
        return records;
    }

    public static void writeCSV(Account account) {
        String csvFile = "C:\\Users\\dell\\mklawikowski\\bankTransfer\\src\\main\\resources\\accounts.csv";
        File file = new File(csvFile);
        file.deleteOnExit();
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.append(account.getAccountNumber() + ","
                    + account.getCustomer().getName() + ","
                    + account.getCustomer().getSurName() + ","
                    + account.getAccountBalance() + ","
                    + account.getAccountCurrency()
                    + System.lineSeparator());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(List<Account> accounts) {
        accounts.forEach(a -> writeCSV(a));
    }
}
