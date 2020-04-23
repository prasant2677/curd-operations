package com.capgemini.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
	
	private boolean error;
	private String message;
	private ProductBean empInfo;
	private List<ProductBean> empList;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProductBean getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(ProductBean empInfo) {
		this.empInfo = empInfo;
	}
	public List<ProductBean> getEmpList() {
		return empList;
	}
	public void setEmpList(List<ProductBean> empList) {
		this.empList = empList;
	}
	
	

}
