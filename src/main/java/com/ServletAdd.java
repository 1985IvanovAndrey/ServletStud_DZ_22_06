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

@WebServlet("/add")
public class ServletAdd extends HttpServlet {
    Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null && req.getParameter("id").equals("addStudent")) {
            add(req, resp);
//            myRedirect(req, resp);
//            return;
        }
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    private void myRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String secName = req.getParameter("secName");
        String sex = req.getParameter("sex");
        try {
            if (connection.isClosed() || connection == null) {
                {
                    connection = ConnectionToBd.myCreateConnection();
                }
                String script = "INSERT INTO studentsinweb(name, sec_name, sex) VALUES (" + "'" + name + "','" + secName + "','" + sex + "')";
                try {
                    PreparedStatement pr = connection.prepareStatement(script);
                    ResultSet rs = pr.executeQuery();
                    pr.close();
                    rs.close();
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Новый студент добавлен в таблицу!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}