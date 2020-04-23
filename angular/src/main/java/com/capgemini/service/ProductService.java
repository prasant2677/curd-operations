package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.ProductBean;

public interface ProductService {
	
public boolean createProduct(ProductBean bean);
	
	public boolean update(ProductBean bean);
	
	public boolean delete(String productName);
	
	public ProductBean getProduct(String productName);
	
	public List<ProductBean> getAllProduct();
		

}
