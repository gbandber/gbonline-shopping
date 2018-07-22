package net.gb.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.gb.shoppingbackend.dao.CategoryDAO;
import net.gb.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		//Adding First Category
		category.setId(1);
		category.setName("Television");
		category.setDescriprion("This is some description for Television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//Adding Second Category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescriprion("This is some description for Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//Adding Third Category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescriprion("This is some description for Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//Enhanced For Loop
		for(Category category : categories) {
			if(category.getId() == id)  return category;
		}
		
		return null;
	}

}
