package controller;

import com.sun.xml.internal.ws.api.message.Header;
import model.*;

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
    }

    ;

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

    public ArrayList<Object> readeFilePlayer(String path, ArrayList<Object> list) throws IOException {
        if (isCheckFile(path)) {
            System.out.println("File not found");
            return null;
        }
        fileReader = new FileReader(new File(path));
        bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splitData = line.split(ENUM_STATIC.getCommaDelimiter());
            if (splitData[0].equals("IdPlayer")) continue;
            Player player = new Player(Integer.parseInt(splitData[0]), splitData[1], splitData[2], Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]));
            list.add(player);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }

    public ArrayList<Object> readerHistory(String path, ArrayList<Object> list) throws IOException {
        if (isCheckFile(path)) {
            System.out.println("File not exist");
            return null;
        }
        fileReader = new FileReader(new File(path));
        bufferedReader = new BufferedReader(fileReader);
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals("idGame")) continue;
            HistoryGame historyGame = new HistoryGame(Integer.parseInt(data[0]), data[1],
                    Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6]);
            list.add(historyGame);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }

    public ArrayList<Object> readerListDataCard(String path,ArrayList<Object> list) throws  IOException{
        if (isCheckFile(path)) {
            System.out.println("No exist file");
            return null;
        }
        fileReader=new FileReader(new File(path));
        bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while ((line= bufferedReader.readLine())!=null){
            String[] data=line.split(",");
            if (data[0].equals("idCard")) continue;
            Cards cards=new Cards(Integer.parseInt(data[0]),data[1],
                                  Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4]);
            list.add(cards);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }

    public ArrayList<String> readerListMyCard(String path,ArrayList<String> list, int IDPlayer) throws IOException{
        if (isCheckFile(path)) {
            System.out.println("No exist file");
            return null;
        }
        fileReader=new FileReader(new File(path));
        bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while ((line= bufferedReader.readLine())!=null){
            String[] data=line.split(",");
            if (data[0].equals("idPlayer"))continue;
            else if (Integer.parseInt(data[0])==IDPlayer){
                for (int i = 1; i <data.length ; i++) {
                    list.add(data[i]);
                }
            }
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

    private boolean isCheckFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return false;
        }
        return true;
    }


}
