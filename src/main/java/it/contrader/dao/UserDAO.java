package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;

public class UserDAO {

	private final String QUERY_ALL = "select * from users";
	private final String QUERY_INSERT = "insert into users (name, type) values (?,?)";
	private final String QUERY_INSERT_PLAYER = "insert into player (id_user) values (?)";
	private final String QUERY_READ = "select * from users where id_user=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE user SET name=?, type=? WHERE id_user=?";
	private final String QUERY_DELETE = "delete from user where id_user=?";
	private final String QUERY_DELETE_CHECK = "select (type) from user where id_user = ?";
	private final String QUERY_ADD_PLAYER_INFO = "UPDATE player SET info=? WHERE id_user=?";
	
	private final String QUERY_CREATE_B_DATA = "insert into biomedical_data () values ()";
	private final String QUERY_GET_LAST_B_DATA = "select max(id_biomedical_data) as id_biomedical_data from biomedical_data";
	private final String QUERY_INSERT_B_DATA_PLAYER = "update player set id_biomedical_data = ? where id_user = ?";

	private final String QUERY_ALL_PLAYER_TRAINING = "select user.id_user, user.name, player.role, player.id_training, training.info as 'training type', player.info as 'player info' \n" + 
													 "from user \n" + 
													 "join player\n" + 
													 "on user.id_user = player.id_user\n" + 
													 "left join training\n" + 
													 "on player.id_training = training.id_training;";
	
	private final String QUERY_ALL_PLAYER_TEAM = "select user.id_user, user.name, player.role\n" +
												 "from user\n" +
												 "join player\n" + 
												 "on user.id_user = player.id_user\n" +
												 "left join playerteam\n" + 
				