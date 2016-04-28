package com.quelmarabout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quelmarabout.common.DbTool;
import com.quelmarabout.common.QmrbException;
import com.quelmarabout.dto.Service;

public class DaoService {

	private static final String TABLE_NAME = "service";

	private static final String COL_NAME_IDSERVICE = "idservice";

	private static final String COL_NAME_DESCRIPTION = "description";

	private static final String SQL_QUERY_ALL_SERVICES_ALL_COLS = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_NAME_DESCRIPTION + ";";

	public static final List<Service> getAllService(Connection connection) throws QmrbException {
		List<Service> services = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ALL_SERVICES_ALL_COLS)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					Service service = new Service();

					service.setId(resultSet.getInt(COL_NAME_IDSERVICE));
					service.setDescription(resultSet.getString(COL_NAME_DESCRIPTION));

					services.add(service);
				}
			}
		} catch (SQLException e) {
			DbTool.cleanUp(connection);
			throw new QmrbException(e);
		} finally {
			DbTool.cleanUp(connection);
		}

		return services;

	}

}
