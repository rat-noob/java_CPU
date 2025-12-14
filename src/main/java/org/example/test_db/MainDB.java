package org.example.test_db;

import java.sql.*;

public class MainDB {
    public static void main(String[] args) {
        Connection c;
        try {
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection(
                    "jdbc:sqlite:all_commands.db");
            System.out.println("Opened database successfully");
            Statement st = c.createStatement();
            ResultSet r= st.executeQuery(
                    "select * from commands");
            while (r.next()){
                System.out.println("Command :" + r.getString("Command"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("не найден драйвер");
        } catch (SQLException ex) {
            System.out.println("не удалось подключиться к СУБД");
        }
    }
}
