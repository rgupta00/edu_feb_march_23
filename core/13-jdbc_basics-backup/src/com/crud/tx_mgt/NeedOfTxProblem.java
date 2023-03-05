package com.crud.tx_mgt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.ConnectionFactory;


//declartive tx mgt: spring tx mgt

public class NeedOfTxProblem {

	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection.
					prepareStatement("update account2 set balance=balance-10 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update accont2 set balance=balance+10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

			System.out.println("transfer is done");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
