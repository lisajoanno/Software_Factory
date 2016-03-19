package fr.unice.polytech.isa.tcf;


import fr.unice.polytech.isa.utils.BankAPI;
import fr.unice.polytech.isa.entities.Customer;
import fr.unice.polytech.isa.entities.Item;
import fr.unice.polytech.isa.exceptions.PaymentException;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface Payment {

	String payOrder(Customer customer, Set<Item> items) throws PaymentException ;

	void useBankReference(BankAPI bank);
}
