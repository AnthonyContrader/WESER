package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;

public class RegisterDAO {

    private final String QUERY_REGISTER = "INSERT INTO users (username, user_type, password, name, surname, cf) VALUES (?,?,?,?,?,?)";
    
    public String register(String username, String usertype, String password, String name, String surname, String ssc) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_REGISTER);
            statement.setString(1, username);
            statement.setString(2, usertype);
            statement.setString(3, password);
            statement.setString(4, name);
            statement.setString(5, surname);
            statement.setString(6, ssc);
            //String userType=null;
            //ResultSet rs = null;
            //if(statement.executeQuery().next()) {
            //	rs.next();
      
            	statement.execute();	
            //}
            
            //return userType;
            	return "";
           // return register(username, usertype, password, name, surname, ssc);
            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
		
        
    }
}
