package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	public List<Payment> findAllByCardnumb(String cardnumb);

}
 