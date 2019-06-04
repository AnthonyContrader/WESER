package it.contrader.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import it.contrader.controller.GestoreEccezioni;


public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton() {
    }


    public static Connection getInstance() {
        if (connection == null) {
            try {
                String vendor = "mysql";
                String driver = "com.mysql.cj.jdbc.Driver";
                String host = "127.0.0.1";
                String port = "3306";
                String dbName = "weser";
                String username = "root";
                String password = "root";
                String jdbcAdditionalParams="useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                //Class c = Class.forName(driver);
                
                
    			Class c = Class.forName(driver);
                String url = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName+"?"+jdbcAdditionalParams;
    			connection = (Connection) DriverManager.getConnection(url, username, password);

                //DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
                //dataSource.setDriverClassName(driver);
                //connection = dataSource.getConnection();
            
            } catch (Exception e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
            }
        }
        return connection;
    }

}
