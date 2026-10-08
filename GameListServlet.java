package com.gameranker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/games")
public class GameListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<String[]> games = new ArrayList<>();

        String sql =
            "SELECT g.id, g.name, g.genre, g.release_year, g.platform, " +
            "COALESCE(AVG((r.story + r.gameplay + r.graphics + r.sound + r.replayability) / 5.0), 0) AS rating " +
            "FROM games g " +
            "LEFT JOIN ratings r ON g.id = r.game_id " +
            "GROUP BY g.id, g.name, g.genre, g.release_year, g.platform " +
            "ORDER BY rating DESC";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result =
                    statement.executeQuery();

            int rank = 1;

            while (result.next()) {

                String[] game = new String[6];

                game[0] = String.valueOf(
                        result.getInt("id"));

                game[1] = result.getString("name");

                game[2] = result.getString("genre");

                game[3] = String.valueOf(
                        result.getInt("release_year"));

                game[4] = result.getString("platform");

                game[5] = String.format("%.1f",
                        result.getDouble("rating"));

                games.add(game);

                rank++;
            }

            result.close();
            statement.close();
            connection.close();

            request.setAttribute("games", games);

            request.getRequestDispatcher("games.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "Error loading games: " + e.getMessage()
            );
        }
    }
}