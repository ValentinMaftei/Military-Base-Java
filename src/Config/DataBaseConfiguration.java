package Config;

import Utile.SingletonFileReaderWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DataBaseConfiguration {
    private final Connection databaseConnection;

    public DataBaseConfiguration(){
        try {
            List<String[]> dbInfo = SingletonFileReaderWriter.INSTANCE.read("fisiere/db_info.csv");
            String[] connectionString = dbInfo.get(0);
            String url = connectionString[0];
            String username = connectionString[1];
            String pass = connectionString[2];
            databaseConnection = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getDatabaseConnection(){
        return databaseConnection;
    }

}

