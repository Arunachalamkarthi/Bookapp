package com.chainsys.jdbc;

public class BookValidator {
	
	public void validateAdd(Book book) throws Exception{
		if(book.name == null){
			throw new Exception("Invalid Name");
		}
		if (book.price <= 0){
			throw new Exception("Invalid price! Price cannot be less than Zero");
		}
	}
	
	public void validateUpdate(Book book) throws Exception{
		if (book.id<=0){
			throw new Exception("Invalid Id");
		}
		if(book.name == null){
			throw new Exception("Invalid Name");
		}
		if (book.price <= 0){
			throw new Exception("Invalid price! Price cannot be less than Zero");
		}
	}
	
	public void validateDelete(Book book) throws Exception{
		if (book.id<=0){
			throw new Exception("Invalid Id");
		}
		
	}
	
	public void validateSelect(Book book) throws Exception{
		if (book.id<=0){
			throw new Exception("Invalid Id");
		}
		
	}

}
