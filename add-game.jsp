<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>GameRanker - Add Game</title>

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
        <a href="add-game.jsp">Add Game</a>
    </nav>

</header>

<main>

    <div class="form-container">

        <h1>➕ Add New Game</h1>

        <form action="add-game" method="post">

            <label>Game Name</label>

            <input type="text"
                   name="name"
                   placeholder="Enter game name"
                   required>


            <label>Genre</label>

            <input type="text"
                   name="genre"
                   placeholder="Example: Action RPG"
                   required>


            <label>Release Year</label>

            <input type="number"
                   name="release_year"
                   placeholder="Example: 2026"
                   required>


            <label>Platform</label>

            <input type="text"
                   name="platform"
                   placeholder="Example: PC, PS5, Xbox"
                   required>


            <button type="submit">
                Add Game
            </button>

        </form>

    </div>

</main>

</body>

</html>