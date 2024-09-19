package edu.eci.cvds.parcial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class ParcialApplicationTests {

	StockService stock;
	@BeforeEach
	public void setup(){
		Observer agent1 = new AdvertencyAgent();
		Observer agent2 = new LogAgent();
		stock = new StockService(agent1,agent2);
	}
	@Test
	void addNullProduct() {
		Product product = null;
		stock.addProduct(product);
		assertEquals(0,stock.getProducts().size());
	}

	@Test
	void addCorrectProduct() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		assertEquals(1,stock.getProducts().size());
	}

	@Test
	void updateProduct() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		stock.updateStock("Camiseta manga larga",3);
		assertEquals(3,stock.getProducts().get("Camiseta manga larga").getQuantity());
	}

	@Test
	void addingObserver() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		assertEquals(2,stock.getProducts().get("Camiseta manga larga").getObservers().size());
	}
	@Test
	void updatingNullProduct() {
		Product product = null;
		stock.updateStock(null,4);
		assertFalse(stock.updateStock(null,4));
	}

	@Test
	void updatingStockLessThan0() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		assertFalse(stock.updateStock("Camiseta manga larga",-1));
	}
	@Test
	void deleteaProduct() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		stock.deleteProduct(product);
		assertEquals(0,stock.getProducts().size());
	}
	@Test
	void deleteProduct() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		stock.deleteProduct(product);
		assertEquals(0,stock.getProducts().size());
	}
	@Test
	void deleteInexistingProduct() {
		stock.deleteProduct(null);
		assertEquals(0,stock.getProducts().size());
	}
	@Test
	void UpdatingInexistingProduct() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.updateStock("Camiseta manga larga",2);
		assertFalse(stock.updateStock("Camiseta manga larga",2));
	}
	@Test
	void RemovingInxistingObservers() {
		Product product = new Product("Camiseta manga larga",5000,5,"Camisetas");
		stock.addProduct(product);
		stock.getProducts().get("Camiseta manga larga").removeObserver(null);
		assertEquals(2,stock.getProducts().get("Camiseta manga larga").getObservers().size());
	}


}
