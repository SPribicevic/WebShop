package org.webshop.entities;

import org.webshop.utils.UtilsMethods;

public class Transaction extends BasicEntity{
	
	public Transaction() {
		super();
		this.columnsName.add(ID_USER);
		this.columnsName.add(ID_PRODUCT);
		this.columnsName.add(COUNT);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id_user;
	private Integer id_product;
	private Integer count;

	
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

	@Override
	public void setValueForColumnName(String columnName, Object value) {
		if(ID_USER.equals(columnName)) {
			setId_user(UtilsMethods.saftyConversionInt(value));
			return;
		}
		if(ID_PRODUCT.equals(columnName)) {
			setId_product(UtilsMethods.saftyConversionInt(value));
			return;
		}
		if(COUNT.equals(columnName)) {
			setCount(UtilsMethods.saftyConversionInt(value));
		}
		
		super.setValueForColumnName(columnName, value);
	}
	@Override
	public Object getValueForColumnName(String columnName) {
		if(ID_USER.equals(columnName)) {
			return getId_user();
		}
		if(ID_PRODUCT.equals(columnName)) {
			return getId_product();
		}
		if(COUNT.equals(columnName)) {
			return getCount();
		}
		
		return super.getValueForColumnName(columnName);
	}

	private static final String ID_USER = "id_user";
	private static final String ID_PRODUCT = "id_product";
	private static final String COUNT = "count";

}
