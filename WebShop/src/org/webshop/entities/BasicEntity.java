package org.webshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.webshop.utils.UtilsMethods;


public abstract class BasicEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2156973367342327643L;


	public BasicEntity(){
		this.setId(Integer.MIN_VALUE);
		this.columnsName = new ArrayList<String>();
		this.columnsName.add("id");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicEntity other = (BasicEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Metoda koja vraca nazive kolona koje entity ima tabeli.
	 * @return
	 */
	public List<String> columnsName(){
		return this.columnsName;
	}
	/**
	 * Metoda koja 
	 * @param columnName
	 * @param value
	 */
	public void setValueForColumnName(String columnName, Object value){
		if( ID.equals(columnName) ){
			setId(UtilsMethods.saftyConversionInt(value));
		}
	}
	
	/**
	 * Metoda koja vraca vrednost za prosledjeni naziv kolone.
	 * @param columnName
	 */
	public Object getValueForColumnName(String columnName){
		if( ID.equals(columnName) ){
			return this.id;
		}
		
		return null;
	}
	
	/**
	 * Metoda koja vraca nazim kolene za primarni kljuc nasih entiteta
	 * @return
	 */
	public String primaryKeyColumnName(){
		return ID;
	}

	// getter and setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	// property
	private int id;
	/**
	 * Lista koja sadrzi naziv svih kolona.
	 */
	protected List<String> columnsName;
	
	// constant
	private static final String ID = "id";
}
