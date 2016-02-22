package fr.unice.polytech.isa.tcf;

// business imports
import fr.unice.polytech.isa.tcf.components.CartStateFullBean;
import fr.unice.polytech.isa.tcf.entities.Cookies;
import fr.unice.polytech.isa.tcf.entities.Customer;
import fr.unice.polytech.isa.tcf.entities.Item;

import java.util.*;
// component test framework import
import fr.unice.polytech.isa.tcf.utils.Database;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
// java annotations
import org.jboss.arquillian.container.test.api.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.ejb.EJB;
// static import to lighten test writing
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CartTest extends AbstractTCFTest {

	@EJB private Database memory;
	@EJB(name = "cart-stateless") private Cart cart;
	@EJB CustomerRegistry registry;

	private Customer john;

	@Before
	public void setUpContext() throws Exception {
		memory.flush();
		registry.register("John", "credit card number");
		john = registry.findByName("John").get();
	}

	@Test
	public void emptyCartByDefault() {
		Set<Item> data = cart.contents(john);
		assertArrayEquals(new Item[] {}, data.toArray());
	}

	@Test
	public void addItems() {
		cart.add(john, new Item(Cookies.CHOCOLALALA, 2));
		cart.add(john, new Item(Cookies.DARK_TEMPTATION, 3));
		Item[] oracle = new Item[] {new Item(Cookies.CHOCOLALALA, 2), new Item(Cookies.DARK_TEMPTATION, 3)  };
		assertEquals(new HashSet<>(Arrays.asList(oracle)), cart.contents(john));
	}

	@Test
	public void removeItems() {
		cart.add(john, new Item(Cookies.CHOCOLALALA, 2));
		cart.remove(john, new Item(Cookies.CHOCOLALALA, 2));
		assertArrayEquals(new Item[] {}, cart.contents(john).toArray());
		cart.add(john, new Item(Cookies.CHOCOLALALA, 6));
		cart.remove(john, new Item(Cookies.CHOCOLALALA, 5));
		assertArrayEquals(new Item[] {new Item(Cookies.CHOCOLALALA, 1)}, cart.contents(john).toArray());
	}

	@Test
	public void modifyQuantities() {
		cart.add(john, new Item(Cookies.CHOCOLALALA, 2));
		cart.add(john, new Item(Cookies.DARK_TEMPTATION, 3));
		cart.add(john, new Item(Cookies.CHOCOLALALA, 3));
		Item[] oracle = new Item[] {new Item(Cookies.CHOCOLALALA, 5), new Item(Cookies.DARK_TEMPTATION, 3)  };
		assertEquals(new HashSet<>(Arrays.asList(oracle)), cart.contents(john));
	}

}