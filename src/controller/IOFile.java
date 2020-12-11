package controller;

import com.sun.xml.internal.ws.api.message.Header;
import model.Account;
import model.ENUM_STATIC;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class IOFile {
    private boolean checkFile = true;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    // Create Object
    public IOFile() {
    };

    public static IOFile getInstance() {
        return IOFileHelper.INSTANCE;
    }

    private static class IOFileHelper {
        private static final IOFile INSTANCE = new IOFile();
    }

    // Read File
    public ArrayList<Object> readeFileAccount(String path, ArrayList<Object> list) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not found");
            return null;
        }
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splitData = line.split(ENUM_STATIC.getCommaDelimiter());
            if (splitData[0].equals("IDAccount")) continue;
            Account object = new Account(Integer.parseInt(splitData[0]), splitData[1], splitData[2], splitData[3]);
            list.add(object);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }

    // Write File
    public void writerFile(String path, ArrayList<Object> list, String HEADER_LINE) throws IOException {
        File file = new File(path);
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        String[] attributesObject = HEADER_LINE.split(ENUM_STATIC.getCommaDelimiter());

        bufferedWriter.append(HEADER_LINE);
        bufferedWriter.append(ENUM_STATIC.getNewLineSeparator());
        for (Object object : list) {
            bufferedWriter.append(object.toString());
            bufferedWriter.append(ENUM_STATIC.getNewLineSeparator());
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
