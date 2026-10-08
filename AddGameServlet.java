package com.gameranker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-game")
public class AddGameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        String genre = request.getParameter("genre");

        int releaseYear = Integer.parseInt(
                request.getParameter("release_year"));

        String platform = request.getParameter("platform");


        String sql =
                "INSERT INTO games " +
                "(name, genre, release_year, platform) " +
                "VALUES (?, ?, ?, ?)";


        try {

            Connection connection =
                    DBConnection.getConnection();

            if (connection == null) {

                response.getWriter().println(
                    "Database connection failed."
                );

                return;
            }


            PreparedStatement statement =
                    connection.prepareStatement(sql);


            statement.setString(1, name);

            statement.setString(2, genre);

            statement.setInt(3, releaseYear);

            statement.setString(4, platform);


            statement.executeUpdate();


            statement.close();

            connection.close();


            response.sendRedirect("games");


        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "Error adding game: " + e.getMessage()
            );
        }
    }
}