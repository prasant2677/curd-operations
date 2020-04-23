package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.ProductBean;
import com.capgemini.beans.ProductResponse;
import com.capgemini.service.ProductService;

@Controller
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping(path="/getProduct" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductResponse getProduct(String productName) {
		
		ProductBean empInfo = service.getProduct(productName);
		ProductResponse response = new ProductResponse();
		if (empInfo!=null) {
			response.setMessage("Data is present");
			response.setEmpInfo(empInfo);;
			
		}else {
			response.setError(true);
			response.setMessage("Name is incorrect");
		}
		return response;
	}
	@PostMapping(path="/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE,
									  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductResponse addProduct(@RequestBody ProductBean bean) {
		
		boolean isAdded = service.createProduct(bean);
		ProductResponse response = new ProductResponse();
		
		if (isAdded) {
			response.setMessage("Is Inserted");
		}else {
			response.setError(true);
			response.setMessage("Not Inserted");
		}
		return response;
	}
	@GetMapping(path="/getAllProduct" , produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ProductResponse getAllEmployee() {
		List<ProductBean> empList = service.getAllProduct();
		ProductResponse response = new ProductResponse();
		if (empList!=null && !empList.isEmpty()) {
			response.setEmpList(empList);
			
		}else {
			response.setError(true);
			response.setMessage("No Data Present");
		}
		return response;
	}
	
	@DeleteMapping(path="/deleteProduct/{productName}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductResponse getDeleteEmployee(@PathVariable(name="productName") String productName) {
		boolean isDeleted = service.delete(productName);
		ProductResponse response = new ProductResponse();
		if(isDeleted) {
			response.setMessage("Deleted");
		}else {
			response.setError(true);
			response.setMessage("Not Deleted");
		}
		return response;
	}
	
	@PutMapping(path="/updateProduct" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductResponse getUpdateProduct(ProductBean bean) {
		boolean isUpdated = service.update(bean);
		ProductResponse response = new ProductResponse();
		if(isUpdated) {
			response.setMessage("Updated");
		}else {
			response.setError(true);
			response.setMessage("Not Updated");
		}
		return response;
	}

}
