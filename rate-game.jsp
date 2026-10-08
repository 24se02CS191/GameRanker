<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Rate Game - GameRanker</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<header>

    <div class="logo">
        🎮 GameRanker
    </div>

    <nav>
        <a href="index.jsp">Home</a>
        <a href="add-game.jsp">Add Game</a>
    </nav>

</header>


<main>

    <div class="form-container">

        <h1>Rate Game</h1>

        <h2>Red Dead Redemption 2</h2>

        <form action="rate-game" method="post">
        
        <input type="hidden"
       name="gameId"
       value="<%= request.getParameter("gameId") %>">

            <label>Your Name</label>
            <input type="text" name="username" required>


            <label>Story (1-10)</label>
            <input type="number" name="story"
                   min="1" max="10" required>


            <label>Gameplay (1-10)</label>
            <input type="number" name="gameplay"
                   min="1" max="10" required>


            <label>Graphics (1-10)</label>
            <input type="number" name="graphics"
                   min="1" max="10" required>


            <label>Sound (1-10)</label>
            <input type="number" name="sound"
                   min="1" max="10" required>


            <label>Replayability (1-10)</label>
            <input type="number" name="replayability"
                   min="1" max="10" required>


            <button type="submit">
                Submit Rating
            </button>

        </form>

    </div>

</main>

</body>
</html>