package sipetor.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static Connection conn = null;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = (DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    +"databaseName=sipetor_170914070;"
                    +"username=sa25;"
                    +"password=sa17015;"));
            System.out.println("Connected to database!");
        }
        catch(SQLException sqle){
            System.out.println("SQL Exception : "+sqle.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found Exception : "+e.getMessage());
        }
        return conn;
    }
}