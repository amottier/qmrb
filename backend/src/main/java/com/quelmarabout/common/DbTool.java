package com.quelmarabout.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbTool {

	public static final void cleanUp(Connection connection) {
		cleanUp(connection, null);
	}

	public static final void cleanUp(Connection connection, PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				preparedStatement = null;
			} catch (SQLException e) {
				// Nothing to do
			}
		}

		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// Nothing to do
			}
		}
	}

	// public static final Connection createConnection(DataSource datasource) {
	// Connection connection = null;
	// try {
	// connection = datasource.getConnection();
	// } catch (SQLException e) {
	// new QmrbException(e);
	// } finally {
	// cleanUp(connection, null);
	// }
	//
	// return connection;
	// }
	//
	// public static final ResultSet runQueyr(Connection connection,
	// PreparedStatement preparedStatement) {
	// ResultSet resultSet = null;
	//
	// try {
	// resultSet = preparedStatement.executeQuery();
	// } catch (SQLException e) {
	// new QmrbException(e);
	// } finally {
	// cleanUp(connection, preparedStatement);
	// }
	//
	// return resultSet;
	// }

}
