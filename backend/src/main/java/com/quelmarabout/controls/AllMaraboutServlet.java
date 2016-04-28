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

@WebServlet("/all-marabout")
public class AllMaraboutServlet extends HttpServlet {

    private static final long serialVersionUID = -6204554613992827055L;

    @Resource(name = "jdbc/qmrbds")
    private DataSource qmrbDatasource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html;charset=UTF-8");

	try (PrintWriter out = response.getWriter()) {
	    Set<Marabout> messagesData = null;

	    messagesData = DaoMarabout.getAllMarabout(qmrbDatasource.getConnection());

	    Gson gson = new Gson();
	    String marabouts = gson.toJson(messagesData);
	    out.println(marabouts);
	} catch (Exception ex) {
	    throw new ServletException(ex);
	}
    }

}
