package com.gameranker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rate-game")
public class RateGameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        int story = Integer.parseInt(
                request.getParameter("story"));

        int gameplay = Integer.parseInt(
                request.getParameter("gameplay"));

        int graphics = Integer.parseInt(
                request.getParameter("graphics"));

        int sound = Integer.parseInt(
                request.getParameter("sound"));

        int replayability = Integer.parseInt(
                request.getParameter("replayability"));

        int gameId = Integer.parseInt(
                request.getParameter("gameId"));

        String sql =
                "INSERT INTO ratings " +
                "(game_id, username, story, gameplay, graphics, sound, replayability) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

        	Connection connection = DBConnection.getConnection();

        	if (connection == null) {
        	    response.getWriter().println(
        	        "Database connection failed. Check Eclipse Console."
        	    );
        	    return;
        	}

        	PreparedStatement statement =
        	        connection.prepareStatement(sql);

            statement.setInt(1, gameId);
            statement.setString(2, username);
            statement.setInt(3, story);
            statement.setInt(4, gameplay);
            statement.setInt(5, graphics);
            statement.setInt(6, sound);
            statement.setInt(7, replayability);

            statement.executeUpdate();

            statement.close();
            connection.close();

            response.sendRedirect("success.jsp");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error saving rating: " + e.getMessage());
        }
    }
}