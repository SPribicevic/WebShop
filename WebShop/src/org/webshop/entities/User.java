package org.webshop.entities;

import org.webshop.utils.UtilsMethods;

public class User extends BasicEntity{
	public User() {
		super();
		this.columnsName.add(NAME);
		this.columnsName.add(SURNAME);
		this.columnsName.add(CARD_NO);
		this.columnsName.add(USERNAME);
		this.columnsName.add(PASSWORD);
	}
	
	private static final long serialVersionUID = 1l;
	private String name;
	private String surname;
	private Integer card_no;
	private String username;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getCard_no() {
		return card_no;
	}
	public void setCard_no(Integer card_no) {
		this.card_no = card_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void setValueForColumnName(String columnName, Object value) {
		// TODO Auto-generated method stub
		if(NAME.equals(columnName)) {
			setName(UtilsMethods.saftyConversionToStr(value));
			return;
		}
		if(SURNAME.equals(columnName)) {
			setSurname(UtilsMethods.saftyConversionToStr(value));
			return;
		}
		if(CARD_NO.equals(columnName)) {
			setCard_no(UtilsMethods.saftyConversionInt(value));
			return;
		}
		if(USERNAME.equals(columnName)) {
			setUsername(UtilsMethods.saftyConversionToStr(value));
			return;
		}
		if(PASSWORD.equals(columnName)) {
			setPassword(UtilsMethods.saftyConversionToStr(value));
			return;
		}
		
		super.setValueForColumnName(columnName, value);
	}
	
	@Override
	public Object getValueForColumnName(String columnName) {
		// TODO Auto-generated method stub
		if(NAME.equals(columnName)) {
			return getName();
		}
		if(SURNAME.equals(columnName)) {
			return getSurname();
		}
		if(CARD_NO.equals(columnName)) {
			return getCard_no();
		}
		if(USERNAME.equals(columnName)) {
			return getUsername();
		}
		if(PASSWORD.equals(columnName)) {
			return getPassword();
		}
		
		return super.getValueForColumnName(columnName);
	}

	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String CARD_NO = "card_no";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
}
