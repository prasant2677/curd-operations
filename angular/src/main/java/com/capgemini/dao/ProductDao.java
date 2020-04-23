package com.capgemini.dao;

import java.util.List;

import com.capgemini.beans.ProductBean;

public interface ProductDao {

	public boolean createProduct(ProductBean bean);
	
	public boolean update(ProductBean bean);
	
	public boolean delete(String productName);
	
	public ProductBean getProduct(String productName);
	
	public List<ProductBean> getAllProduct();
		
	
	
}
