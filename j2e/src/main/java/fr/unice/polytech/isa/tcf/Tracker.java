package fr.unice.polytech.isa.tcf;

import fr.unice.polytech.isa.entities.OrderStatus;
import fr.unice.polytech.isa.exceptions.UnknownOrderId;

import javax.ejb.Local;

@Local
public interface Tracker {

	OrderStatus status(String orderId) throws UnknownOrderId;

}
