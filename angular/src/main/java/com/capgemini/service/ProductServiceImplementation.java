package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.ProductBean;
import com.capgemini.dao.ProductDao;
@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public boolean createProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.createProduct(bean);
	}

	@Override
	public boolean update(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.update(bean);
	}

	@Override
	public boolean delete(String productName) {
		// TODO Auto-generated method stub
		return dao.delete(productName);
	}

	@Override
	public ProductBean getProduct(String productName) {
		// TODO Auto-generated method stub
		return dao.getProduct(productName);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

}
