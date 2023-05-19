package Utile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public enum AuditActionsSingleton {
    INSTANCE;

    private final String auditFile = "fisiere/audit.csv";
    private final DateTimeFormatter timeSt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    public void Action(String actionName) throws IOException {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(auditFile, true))){
            String line = actionName + "," + LocalDateTime.now().format(timeSt);
            printWriter.println(line);
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
