package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.Request;
import it.contrader.utils.ConnectionSingleton;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from users where username = ? AND cf = ?";
    /**
     * 
     * @param username
     * @param password
     * @return the type of user of null if nothing is found
     */
    public Request login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            Request request = new Request();
            ResultSet rs;
            if(statement.executeQuery().next()) {
            	rs = statement.executeQuery();
            	rs.next();
            	
            	String type = rs.getString("user_type");
            	int id = rs.getInt("user_id");
            	request.put("user_type",type);
            	request.put("user_id", id);
            }
            
            return request;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        	GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }
}
