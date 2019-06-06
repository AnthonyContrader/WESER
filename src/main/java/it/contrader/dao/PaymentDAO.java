package it.contrader.dao;
import it.contrader.model.Payment;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

	private final String QUERY_ALL = "select * from payments";
	private final String QUERY_INSERT = "insert into payments (cardtype,cardnum,cardown,cardexp,cvv) values (?,?,?,?,?)";
	private final String QUERY_READ = "select * from payments where payId=?";

	private final String QUERY_UPDATE = "UPDATE payments SET cardtype=?, cardnum=?, cardown=?,cardexp=?,cvv=? WHERE payId=?";
	private final String QUERY_DELETE = "delete from payments where payId=?";

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
				int payId = resultSet.getInt("payId");
				String cardtype = resultSet.getString("cardtype");
				String cardnum = resultSet.getString("cardnum");
				String cardown = resultSet.getString("cardown");
				String cardexp = resultSet.getString("cardexp");
				int cvv = resultSet.getInt("cvv");
				payment = new Payment(cardtype,cardnum,cardown,cardexp,cvv);
				payment.setPayId(payId);
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
			preparedStatement.setString(1, payment.getCardown());
			preparedStatement.setString(2, payment.getCardnum());
			preparedStatement.setString(3, payment.getCardown());
			preparedStatement.setString(4, payment.getCardexp());
			preparedStatement.setInt(5, payment.getCVV());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Payment readPayment(Payment payment) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int payId = payment.getPayId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, payId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String cardtype,cardnum,cardown,cardexp;
			int cvv;

			cardtype = resultSet.getString("cardtype");
			cardnum = resultSet.getString("cardnum");
			cardown = resultSet.getString("cardown");
			cardexp = resultSet.getString("cardexp");
			cvv = resultSet.getInt("cvv");
			payment = new Payment(cardtype,cardnum,cardown,cardexp,cvv);
			payment.setPayId(resultSet.getInt("payId"));

			return payment;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updatePayment(Payment paymentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (paymentToUpdate.getPayId() == 0)
			return false;

		// Payment paymentRead = readPayment(paymentToUpdate);
		// if (!paymentRead.equals(paymentToUpdate)) {
		try {
			// Fill the paymentToUpdate object
			/*
			if (paymentToUpdate.getPaymentname() == null || paymentToUpdate.getPaymentname().equals("")) {
			 
				paymentToUpdate.setPayment(paymentRead.getPaymentname());
			}

			if (paymentToUpdate.getPassword() == null || paymentToUpdate.getPassword().equals("")) {
				paymentToUpdate.setPassword(paymentRead.getPassword());
			}

			if (paymentToUpdate.getPaymenttype() == null || paymentToUpdate.getPaymenttype().equals("")) {
				paymentToUpdate.setPaymenttype(paymentRead.getPaymenttype());
			}
			
			*/
			// Update the payment
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, paymentToUpdate.getCardown());
			preparedStatement.setString(2, paymentToUpdate.getCardnum());
			preparedStatement.setString(3, paymentToUpdate.getCardown());
			preparedStatement.setString(4, paymentToUpdate.getCardexp());
			preparedStatement.setInt(5, paymentToUpdate.getCVV());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			return false;
		}
		//}

		//return false;

	}

	public boolean deletePayment(Payment payment) {
		int payId = payment.getPayId();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, payId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

	
	
}
