package com.gameranker;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/gameranker?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "ShIvAm@143";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("================================");
            System.out.println("DATABASE CONNECTION SUCCESSFUL");
            System.out.println("================================");

            return con;

        } catch (Exception e) {

            System.out.println("================================");
            System.out.println("DATABASE CONNECTION FAILED");
            System.out.println("================================");

            e.printStackTrace();

            return null;
        }
    }
}