package net.gb.gbshoppingbackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.gb.shoppingbackend.dao.ProductDAO;
import net.gb.shoppingbackend.dto.Category;
import net.gb.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.gb.gbshoppingbackend");
		context.scan("net.gb.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
/*	@Test
	public void testCRUDCategory() {
		
		//Create Operation
		product = new Product();
		
		product.setName("Oppo Selfie S93");
		product.setBrand("Oppo");
		product.setDescription("This is some description for Oppo Mobile Phones !");
		product.setUnitPrice(48000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something went wrong while inserting this New Product into the table!",true,productDAO.add(product));

		//Fetching and Updating the Category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S6");
		assertEquals("Something went wrong while updating the existing record !",
				true,productDAO.update(product));
		
		assertEquals("Something went wrong while deleting the existing record !",
				true,productDAO.delete(product));
		
		//List
		assertEquals("Something went wrong while fetching the list of products !",
				8,productDAO.list().size());

	}*/
	
/*	@Test
	public void testListActiveProducts() {
		
		assertEquals("Something went wrong while fetching the list of products !",
				7,productDAO.listActiveProducts().size());

		
	}*/
	
/*	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals("Something went wrong while fetching the list of products !",
				5,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products !",
				3,productDAO.listActiveProductsByCategory(1).size());

		
	}*/
	
	@Test
	public void testGetLatestActiveProduct() {
		
		assertEquals("Something went wrong while fetching the list of products !",
				3,productDAO.getLatestActiveProducts(3).size());
		
	}
	
	
	
}
