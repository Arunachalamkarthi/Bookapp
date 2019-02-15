package com.chainsys.jdbc.Test;

import java.sql.Connection;

import com.chainsys.jdbc.ConnectionUtils;

public class TestConnectionUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionUtils.getConnection();
		System.out.println(connection);

	}

}
