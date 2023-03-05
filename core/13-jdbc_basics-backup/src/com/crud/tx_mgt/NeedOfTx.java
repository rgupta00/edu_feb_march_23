package com.crud.tx_mgt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.ConnectionFactory;

//declartive tx mgt: spring tx mgt

public class NeedOfTx {

	public static void main(String[] args) {

		
		//why me doing the tx... why spring do for me ... (AOP)
		
		
		Connection connection = ConnectionFactory.getConnection();

		//tx mgt:  :( problem with jdbc is u have to write lots of lots ... spring declarticve @Tranactional
		try {
			connection.setAutoCommit(false);
			
			//connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			PreparedStatement pstmt = connection.
					prepareStatement("update account2 set balance=balance-10 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update accunt2 set balance=balance+10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

			connection.commit();
			System.out.println("transfer is done");

		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
