package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.ProductBean;
import com.capgemini.exception.ProductException;
@Repository
public class ProductDaoImplementation implements ProductDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean createProduct(ProductBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			isAdded=true;
			System.out.println("Added");
		}catch(Exception e) {
			e.printStackTrace();
			throw  new ProductException(e.getMessage());
		}finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean update(ProductBean bean) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			String jpql="update ProductBean m set m.productName=:name where m.price=:id";
			Query query=manager.createQuery(jpql);
			query.setParameter("name", bean.getProductName());
			query.setParameter("id", bean.getPrice());
			int m=query.executeUpdate();
			//emp.setId(id);

			transaction.commit();
			isUpdated=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean delete(String productName) {

		boolean isDeleted =false;
		EntityManager manager = factory.createEntityManager();
		ProductBean empInfo = manager.find(ProductBean.class, productName);

		if(empInfo !=null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(empInfo);
			transaction.commit();
			isDeleted = true;
		}
		manager.close();
		return isDeleted;
	}

	@Override
	public ProductBean getProduct(String productName) {
		EntityManager manager = factory.createEntityManager();
		ProductBean empInfo = manager.find(ProductBean.class, productName);

		manager.close();

		return empInfo;
	}

	@Override
	public List<ProductBean> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from ProductBean e";
		Query query =manager.createQuery(jpql);
		List<ProductBean> emplist= query.getResultList();

		manager.close();

		return emplist;
	}

}
