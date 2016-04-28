package com.quelmarabout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.quelmarabout.common.DbTool;
import com.quelmarabout.common.QmrbException;
import com.quelmarabout.dto.Marabout;
import com.quelmarabout.dto.Query;

public class DaoMarabout {

	private static final String TABLE_NAME_MARABOUT = "marabout";

	private static final String TABLE_NAME_MARABOUT_SERVICE = "marabout_service";

	@SuppressWarnings("unused")
	private static final String COL_NAME_MARABOUT_ID = "idmarabout";

	private static final String COL_NAME_MARABOUT_NAME = "name";

	private static final String COL_NAME_MARABOUT_TITLE = "title";

	private static final String COL_NAME_MARABOUT_GUARANTY = "guaranty";

	private static final String COL_NAME_MARABOUT_GUARANTY_TIMEFRAME = "guaranty_timeframe";

	@SuppressWarnings("unused")
	private static final String COL_NAME_MARABOUT_SERVICE_FK_MARABOUT = "fkmarabout";

	@SuppressWarnings("unused")
	private static final String COL_NAME_MARABOUT_SERVICE_FK_SERVICE = "fkservice";

	private static final String SQL_QUERY_ALL_MARABOUT_ALL_COLS = "SELECT * FROM " + TABLE_NAME_MARABOUT + ";";

	private static final String SQL_QUERY_ALL_MARABOUT_ALL_COLS_BEGIN = "SELECT * FROM " + TABLE_NAME_MARABOUT + " AS t1 INNER JOIN "
			+ TABLE_NAME_MARABOUT_SERVICE + " AS t2 ON t1.idmarabout = t2.fkmarabout WHERE ";

	public static final Set<Marabout> getAllMarabout(Connection connection) throws QmrbException {
		Set<Marabout> marabouts = new HashSet<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ALL_MARABOUT_ALL_COLS)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					Marabout marabout = new Marabout();

					marabout.setName(resultSet.getString(COL_NAME_MARABOUT_NAME));
					marabout.setGuaranty(resultSet.getBoolean(COL_NAME_MARABOUT_GUARANTY));
					marabout.setGuarantyTimeframe(resultSet.getInt(COL_NAME_MARABOUT_GUARANTY_TIMEFRAME));

					marabouts.add(marabout);
				}
			}
		} catch (SQLException e) {
			DbTool.cleanUp(connection);
			throw new QmrbException(e);
		} finally {
			DbTool.cleanUp(connection);
		}

		return marabouts;

	}

	public static Set<Marabout> searchMarabouts(Connection connection, Query searchQuery) throws QmrbException {
		Set<Marabout> marabouts = new HashSet<>();

		/*
		 * SELECT * FROM qmrbdb.marabout AS t1 INNER JOIN qmrbdb.marabout_service AS t2 ON t1.idmarabout = t2.fkmarabout WHERE t2.fkservice
		 * IN (1, 4) GROUP BY t1.idmarabout;
		 */

		/*
		 * SELECT qmrbdb.marabout.name FROM qmrbdb.marabout INNER JOIN qmrbdb.marabout_service AS t1 ON qmrbdb.marabout.idmarabout =
		 * t1.fkmarabout AND t1.fkservice = 1
		 * 
		 * INNER JOIN qmrbdb.marabout_service AS t2 ON qmrbdb.marabout.idmarabout = t2.fkmarabout AND t2.fkservice = 2;
		 */

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(SQL_QUERY_ALL_MARABOUT_ALL_COLS_BEGIN);

		int[] serviceIds = searchQuery.getServiceIds();

		if (serviceIds.length != 0) {
			sqlQuery.append(" t2.fkservice IN ( ? ");
		}

		for (int i = 1; i < serviceIds.length; i++) {
			sqlQuery.append(", ? ");
		}

		if (serviceIds.length != 0) {
			sqlQuery.append(" ) ");
		}

		sqlQuery.append("GROUP BY t1.idmarabout;");

		try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())) {

			int paramIndex = 1;
			for (int serviceId : serviceIds) {
				preparedStatement.setInt(paramIndex, serviceId);
				paramIndex++;
			}

			// TODO à compléter

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					Marabout marabout = new Marabout();

					marabout.setName(resultSet.getString(COL_NAME_MARABOUT_NAME));
					marabout.setGuaranty(resultSet.getBoolean(COL_NAME_MARABOUT_GUARANTY));
					marabout.setGuarantyTimeframe(resultSet.getInt(COL_NAME_MARABOUT_GUARANTY_TIMEFRAME));
					marabout.setTitle(resultSet.getString(COL_NAME_MARABOUT_TITLE));

					marabouts.add(marabout);
				}
			}
		} catch (SQLException e) {
			DbTool.cleanUp(connection);
			throw new QmrbException(e);
		} finally {
			DbTool.cleanUp(connection);
		}

		return marabouts;
	}
}
