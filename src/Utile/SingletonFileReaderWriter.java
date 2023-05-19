package Utile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SingletonFileReaderWriter {
    INSTANCE;

    public static final String delimiter = ",";
    public static List<String[]> read(String csvFile) {
        List<String[]> fileList = new ArrayList<>();
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] listWords;
            while ((line = br.readLine()) != null) {
                listWords = line.split(delimiter);
                fileList.add(listWords);
            }
            return fileList;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return fileList;
    }

    public static String convertToCSV(String[] item){
        return Stream.of(item).
                collect(Collectors.joining(","));
    }

    public static void writeToCsv(String fileName, List<String[]> content) throws FileNotFoundException {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            content.stream()
                    .map(item -> convertToCSV(item))
                    .forEach(printWriter::println);
        }
    }
}
