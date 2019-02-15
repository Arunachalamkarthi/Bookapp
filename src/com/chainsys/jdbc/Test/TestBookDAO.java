package com.chainsys.jdbc.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.jdbc.Book;
import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.BookValidator;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {		
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		BookDAO bookDAO = new BookDAO();
		Book book  = new Book();
		BookValidator validator = new BookValidator();
		char ch;
		do {
			System.out.println("Welcome to Movie Entry Screen");
			System.out.println("1 for Insert");
			System.out.println("2 for Update");
			System.out.println("3 for Delete");
			System.out.println("4 for Moviewise");
			System.out.println("5 for All Movie");
			int bookid = scanner.nextInt();
			int bookid1 = bookid;
		switch (bookid1) {
		case 1:
			
				System.out.println("Enter name,price,publishDate() to add");
				
				
				//int id = scanner.nextInt();
				String name = scanner.next();
				book.name = name;
				int price = scanner.nextInt();
				book.price = price;
				String Date = scanner.next();
				//book.publishDate = publishDate;
				book.publishDate = LocalDate.parse(Date);
			 try{
				validator.validateAdd(book);
				bookDAO.addBook(book);
			 }
				catch (Exception e) {				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Book bookResult = bookDAO.fingBYId(book);
			 if(bookResult!=null){
				 System.out.println(bookResult.id);
				 System.out.println(bookResult.name);
				 System.out.println(bookResult.price);
			 }else{
				 System.out.println("No record Found");
			 }
			 //bookDAO.findAll();
			ArrayList<Book> bookList = bookDAO.findAll();
			if(bookList.isEmpty()){
				System.out.println("No Records Found");
			}
			else{
				for(Book b:bookList){
					System.out.println(b.id);
					 System.out.println(b.name);
					 System.out.println(b.price);
				}
			}
			 break;
		case 2:
			System.out.println("Enter id,name,price to Update");
			int id1 = scanner.nextInt();
			book.id = id1;
			String name1 = scanner.next();
			book.name = name1;
			int price1 = scanner.nextInt();
			book.price = price1;
			bookDAO.updateBook(book);
			bookDAO.findAll();
			break;
		case 3:
			System.out.println("Enter id to delete");
			int id2 = scanner.nextInt();
			book.id = id2;
			bookDAO.deleteBook(book);
			bookDAO.findAll();
			break;

		case 4:
			System.out.println("Enter to find id");
			int id3 = scanner.nextInt();
			book = new Book();
			book.id =id3;
			try{
				validator.validateUpdate(book);
				book = bookDAO.fingBYId(book);
				if(book == null){
					
				}
			} catch(Exception e){
				e.printStackTrace();
				e.getMessage();
			}
			break;

		case 5:
			bookDAO.findAll();
			break;
			// GetAll(connection);
		}
		System.out.println("If you want to continue press y else n");
		ch= scanner.next().charAt(0);

	} while (ch == 'y');
	scanner.close();
	}

}
