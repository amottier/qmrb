package com.quelmarabout.controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.quelmarabout.dao.DaoService;
import com.quelmarabout.dto.Service;

/**
 * Servlet implementation class QmrbMapIdService
 */
@WebServlet("/service")
public class ServiceServlet extends HttpServlet {

	private static final long serialVersionUID = -4407369143645542952L;

	@Resource(name = "jdbc/qmrbds")
	private DataSource qmrbDatasource;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			List<Service> services = null;

			services = DaoService.getAllService(qmrbDatasource.getConnection());
			Gson gson = new Gson();
			String servicesJson = gson.toJson(services);
			out.println(servicesJson);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
