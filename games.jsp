<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>GameRanker - Games</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<header>

    <div class="logo">
        🎮 GameRanker
    </div>

    <nav>
        <a href="index.jsp">Home</a>
        <a href="games">Games</a>
    </nav>

</header>

<main>

    <h1>Game Rankings</h1>

    <div class="game-grid">

        <%
            List<String[]> games =
                (List<String[]>) request.getAttribute("games");

            if (games != null && !games.isEmpty()) {

                int rank = 1;

                for (String[] game : games) {
        %>

        <div class="game-card">

            <div class="rank">
                #<%= rank %>
            </div>

            <h2>
                <%= game[1] %>
            </h2>

            <div class="rating">
                ⭐ <%= game[5] %> / 10
            </div>

            <p>
                <strong>Genre:</strong>
                <%= game[2] %>
            </p>

            <p>
                <strong>Release Year:</strong>
                <%= game[3] %>
            </p>

            <p>
                <strong>Platform:</strong>
                <%= game[4] %>
            </p>

            <a href="rate-game.jsp?gameId=<%= game[0] %>"
               class="rate-btn">
                Rate Game
            </a>

        </div>

        <%
                    rank++;
                }

            } else {
        %>

        <p>No games found.</p>

        <%
            }
        %>

    </div>

</main>

</body>

</html>