package net.gb.shoppingbackend.dao;

import java.util.List;

import net.gb.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list(); 
	
	Category get(int id);
	
	

}
