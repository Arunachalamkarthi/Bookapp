package com.chainsys.jdbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BookDAO {
//	Connection connection = null;
//	PreparedStatement preparedStatement= null;
//	ResultSet resultSet = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * @paramid
	 * @paramname
	 * @paramprice
	 * precondition id,name,price must be valid
	 */
	public void addBook(Book book) throws Exception{
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "insert into books(id,name,price,publish_Date) values(BOOKS_ID_SEQ.nextval,?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			//preparedStatement.setInt(1, id);
			preparedStatement.setString(1, book.name);
			preparedStatement.setInt(2, book.price);
			preparedStatement.setDate(3, Date.valueOf(book.publishDate));
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows affected"+rows);
			ConnectionUtils.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to insert book");
		}
	}
	
	public void updateBook(Book book) throws Exception{
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "update books set name = ?,price=? where id = ?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, book.name);
			preparedStatement.setInt(2, book.price);
			preparedStatement.setInt(3, book.id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows affected"+rows);
			ConnectionUtils.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to update book");
		}
	}
	
	public void deleteBook(Book book) throws SQLException{
		Connection connection = ConnectionUtils.getConnection();
		String sql = "delete books where id = ?";
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows affected"+rows);
		ConnectionUtils.close(connection, preparedStatement, null);
	}
	
	public ArrayList<Book> findAll() throws SQLException{
		Connection connection = ConnectionUtils.getConnection();
		String sql = "select id,name,price,publish_date from books";
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		while(resultSet.next()){
			Book book = new Book();
			book.id = resultSet.getInt("id");
			book.name = resultSet.getString("name");
			book.price = resultSet.getInt("price");
			book.publishDate = resultSet.getDate("publishDate").toLocalDate();
			list.add(book);
//			System.out.println(resultSet.getInt("id"));
//			System.out.println(resultSet.getString("Name"));
//			System.out.println(resultSet.getInt("price"));
		}
		ConnectionUtils.close(connection, preparedStatement, resultSet);
		return list;
	}
	
	public Book fingBYId(Book book) throws SQLException{
		Connection connection = ConnectionUtils.getConnection();
		String sql = "select id,name,price,publish_date from books where id =?";
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setInt(1, book. id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Book b = null;
		if (resultSet.next()){
			b = new Book();
			b.id = resultSet.getInt("id");
			b.name = resultSet.getString("name");
			b.price = resultSet.getInt("price");
			b.publishDate = resultSet.getDate("publishDate").toLocalDate();
			ConnectionUtils.close(connection, preparedStatement, resultSet);
//			System.out.println(resultSet.getInt("b.id"));
//			System.out.println(resultSet.getString("b.Name"));
//			System.out.println(resultSet.getInt("b.Price"));
//			System.out.println(resultSet.getInt("b.publishDate"));	
		}
		return b;
//		else
//		{
//			return null;
//		}
		
	}
	
	
}
