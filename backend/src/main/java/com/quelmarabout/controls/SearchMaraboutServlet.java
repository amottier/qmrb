package com.quelmarabout.controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.quelmarabout.dao.DaoMarabout;
import com.quelmarabout.dto.Marabout;
import com.quelmarabout.dto.Query;

@WebServlet("/search")
public class SearchMaraboutServlet extends HttpServlet {

	private static final long serialVersionUID = -6204554613992827055L;

	private static final String PARAMETER_NAME_SERVICE_IDS = "serviceIds";

	@Resource(name = "jdbc/qmrbds")
	private DataSource qmrbDatasource;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			// Result of the search
			Set<Marabout> messagesData = null;

			Gson gson = new Gson();

			// Query searchQuery = gson.fromJson(request.getReader(), Query.class);

			String[] servicesIdsAsString = request.getParameterValues(PARAMETER_NAME_SERVICE_IDS);
			int[] servicesIds = new int[servicesIdsAsString.length];
			for (int i = 0; i < servicesIdsAsString.length; i++) {
				String serviceIdAsString = servicesIdsAsString[i];
				servicesIds[i] = Integer.parseInt(serviceIdAsString);
			}

			Query searchQuery = new Query();
			searchQuery.setServiceIds(servicesIds);

			messagesData = DaoMarabout.searchMarabouts(qmrbDatasource.getConnection(), searchQuery);

			String[][] searchResultForTableDisplay = new String[messagesData.size()][2];

			int i = 0;
			for (Marabout marabout : messagesData) {
				searchResultForTableDisplay[i][0] = marabout.getName();
				searchResultForTableDisplay[i][1] = marabout.getTitle();
				i++;
			}

			String servicesJson = gson.toJson(searchResultForTableDisplay);
			out.println(servicesJson);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
