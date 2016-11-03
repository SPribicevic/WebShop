package org.webshop.entities;

import org.webshop.utils.UtilsMethods;

public class Product extends BasicEntity{
	
	public Product() {
		super();
		this.columnsName.add(NAME);
		this.columnsName.add(PRICE);
	}
	
	private static final long serialVersionUID = 1l;
	private String name;
	private Double price;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public void setValueForColumnName(String columnName, Object value) {
		if(NAME.equals(columnName)) {
			setName(UtilsMethods.saftyConversionToStr(value));
			return;
		}
		if(PRICE.equals(columnName)) {
			setPrice(UtilsMethods.saftyConversionDouble(value));
			return;
		}
		
		super.setValueForColumnName(columnName, value);
	}
	
	@Override
	public Object getValueForColumnName(String columnName) {
		if(NAME.equals(columnName)) {
			return getName();
		}
		if(PRICE.equals(columnName)) {
			return getPrice();
		}
		
		return super.getValueForColumnName(columnName);
	}

	private static final String NAME = "name";
	private static final String PRICE = "price";
}
