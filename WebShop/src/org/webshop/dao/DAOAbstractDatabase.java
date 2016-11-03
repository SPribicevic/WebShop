package org.webshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.webshop.entities.BasicEntity;

public abstract class DAOAbstractDatabase<T extends BasicEntity> implements IDAOAbstract<T> {

	public DAOAbstractDatabase(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public boolean add(T object) {
		// TODO Auto-generated method stub
		if(object == null) {
			return false;
		}
		
		Connection conn = this.createConnection();
		if(conn == null) {
			return false;
		}
		
		String columnsName = "";
		String questionMarks = "";
		for(String columnName : object.columnsName()){
			if(object.primaryKeyColumnName().equals(columnName)) 
				continue;
			columnsName = columnsName == "" ? columnName : String.format("%s, %s", columnsName, columnName);
			questionMarks = questionMarks == "" ? "?" : String.format("%s, ?", questionMarks);
		}
		
		String strQuery = String.format("INSERT INTO %s (%s) VALUES (%s)", this.clazz.getSimpleName(), columnsName, questionMarks);
		
		try {
			PreparedStatement st = conn.prepareStatement(strQuery);
			int parameterIndex = 1;
			for(String columnName : object.columnsName()){
				if(object.primaryKeyColumnName().equals(columnName)) 
					continue;
				st.setObject(parameterIndex++, object.getValueForColumnName(columnName));
			}
			return st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean reomoveById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> getAll() {
		Connection conn = createConnection();
		if (conn == null) {
			return null;
		}
		try {
			PreparedStatement st = conn.prepareStatement(String.format("select * from %s", this.clazz.getSimpleName()));
			ResultSet rs = st.executeQuery();
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				list.add(readFromResultSet(rs));
			}
			closeStat(st);
			closeResultSet(rs);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return null;
	}

	@Override
	public T getById(int id) {
		Connection conn = createConnection();
		if (conn == null) {
			return null;
		}
		
		try {
			T objectForIdName = clazz.newInstance();
			PreparedStatement st = conn.prepareStatement(String.format("select * from %s where %s=?", this.clazz.getSimpleName(), objectForIdName.primaryKeyColumnName()));
			st.setObject(1, id);
			
			ResultSet rs = st.executeQuery();
			T object = null;
			if( rs.next()) {
				object = readFromResultSet(rs);
			}
			closeStat(st);
			closeResultSet(rs);
			return object;
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return null;
	}
	
	private void closeConnection(Connection conn) {
		if (conn == null) {
			return;
		}

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO nekim log framework-om ovo bi trebalo da se upisuje u log
			e.printStackTrace();
		}
		
	}

	private void closeStat(PreparedStatement stat) {
		if (stat == null) {
			return;
		}

		try {
			stat.close();
		} catch (SQLException e) {
			// TODO nekim log framework-om ovo bi trebalo da se upisuje u log
			e.printStackTrace();
		}
		
	}

	private void closeResultSet(ResultSet rs) {
		if( rs == null ){
			return;
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private T readFromResultSet(ResultSet rs) {
		if( rs == null ){
			return null;
		}
		
		try {
			T object = this.clazz.newInstance();
			object = clazz.newInstance();
			for(String columnName : object.columnsName()){
				object.setValueForColumnName(columnName, rs.getObject(columnName));
			}
			
			return object;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/webshop", USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Class<T> clazz;
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Faste9faste9!";
}
