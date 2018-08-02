package net.gb.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.gb.shoppingbackend.dao.ProductDAO;
import net.gb.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	//Method for GETTING a SINGLE PRODUCT based on ID
	@Override
	public Product get(int productId) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	
	//Method for GETTING a FULL LIST of Products
	@Override
	public List<Product> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
		
	}

	
	//Method to INSERT a New Product
	@Override
	public boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	
	//Updating a Single Product Details
	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	
	//Deleting a Particular Product from the Product Table - Actually a SOFT DELETE
	@Override
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			return this.update(product);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId", categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
