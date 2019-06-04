package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Payment;

public class PaymentDAO {

	private final String QUERY_ALL = "select * from payments";
	private final String QUERY_INSERT = "insert into payments (card_type, card_number, card_owner, card_expire, cvv) values (?,?,?,?,?)";
	private final String QUERY_READ = "select * from payments where pay_id = ?";

	private final String QUERY_UPDATE = "UPDATE payments SET card_type = ?, card_number = ?, card_owner = ?, card_expire = ?, cvv = ? WHERE pay_id = ?";
	private final String QUERY_DELETE = "delete from payments where pay_id = ?";

	public PaymentDAO() {

	}

	public List<Payment> getAllPayment() {
		List<Payment> paymentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Payment payment;
			while (resultSet.next()) {
				int pay_id = resultSet.getInt("pay_id");
				String card_type = resultSet.getString("card_type");
				String card_number = resultSet.getString("card_number");
				String card_owner = resultSet.getString("card_owner");
				String card_expire = resultSet.getString("card_expire");
				int CVV = resultSet.getInt("cvv");
				payment = new Payment(card_type, card_number, card_owner, card_expire, CVV);
				payment.setPay_id(pay_id);
				paymentsList.add(payment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paymentsList;
	}

	public boolean insertPayment(Payment payment) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, payment.getCard_type());
			preparedStatement.setString(2, payment.getCard_number());
			preparedStatement.setString(3, payment.getCard_owner());
			preparedStatement.setString(4, payment.getCard_expire());
			preparedStatement.setInt(5, payment.getCVV());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Payment readPayment(int pay_Id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, pay_Id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String card_type, card_number, card_owner, card_expire;
			int CVV;

			card_type = resultSet.getString("card_type");
			card_number = resultSet.getString("card_number");
			card_owner = resultSet.getString("card_owner");
			card_expire = resultSet.getString("card_expire");
		    CVV = resultSet.getInt("cvv");
			Payment payment = new Payment(card_type, card_number, card_owner, card_expire, CVV);
			payment.setPay_id(resultSet.getInt("pay_id"));

			return payment;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updatePayment(Payment paymentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (paymentToUpdate.getPay_id() == 0)
			return false;

		Payment paymentRead = readPayment(paymentToUpdate.getPay_id());
		if (!paymentRead.equals(paymentToUpdate)) {
			try {
				// Fill the paymentToUpdate object
				
				
                if (paymentToUpdate.getCard_type() == null || paymentToUpdate.getCard_type().equals("")) {
					paymentToUpdate.setCard_type(paymentRead.getCard_type());
				}
                if (paymentToUpdate.getCard_number() == null || paymentToUpdate.getCard_number().equals("")) {
					paymentToUpdate.setCard_number(paymentRead.getCard_number());
				}
                if (paymentToUpdate.getCard_owner() == null || paymentToUpdate.getCard_owner().equals("")) {
					paymentToUpdate.setCard_owner(paymentRead.getCard_owner());
				}
                if (paymentToUpdate.getCard_expire() == null || paymentToUpdate.getCard_expire().equals("")) {
					paymentToUpdate.setCard_expire(paymentRead.getCard_expire());
				}
				
				if (paymentToUpdate.getCVV() < 0) {
					paymentToUpdate.setCVV(paymentRead.getCVV());
				}
				// Update the payment
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, paymentToUpdate.getCard_type());
				preparedStatement.setString(2, paymentToUpdate.getCard_number());
				preparedStatement.setString(3, paymentToUpdate.getCard_owner());
				preparedStatement.setString(4, paymentToUpdate.getCard_expire());
				preparedStatement.setInt(5, paymentToUpdate.getCVV());
				preparedStatement.setInt(6, paymentToUpdate.getPay_id());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deletePayment(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
