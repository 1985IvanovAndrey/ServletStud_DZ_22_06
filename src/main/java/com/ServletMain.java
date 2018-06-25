package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/")
public class ServletMain extends HttpServlet {
    Connection connection = null;
    private ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("mainTable", "Таблица всех студентов:");
        req.setAttribute("studentsList", studentsList);

        try {
            getStudentsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (req.getParameter("id") != null && req.getParameter("id").equals("add")) {
            myRedirect(req, resp);
            return;

        }
        req.getRequestDispatcher("first.jsp").forward(req, resp);

    }

    private ArrayList<Student> getStudentsList() throws SQLException {
        String script = "Select * From studentsinweb";
        if (connection==null) {
            connection = ConnectionToBd.myCreateConnection();
        }
        PreparedStatement pr =connection.prepareStatement(script);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            studentsList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        pr.close();
        rs.close();
        connection.close();
        return studentsList;
    }

    private void myRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/add");
    }
}

