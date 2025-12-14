package org.example.cpu_lab_4;

import java.sql.*;
import java.util.ArrayList;

public class CommanDAO_JDBC extends CommandDAO{
    Connection c;

    void connect(){
        try {
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection(
                    "jdbc:sqlite:all_commands.db");
            System.out.println("Opened database successfully");


        } catch (ClassNotFoundException ex) {
            System.out.println("не найден драйвер");
        } catch (SQLException ex) {
            System.out.println("не удалось подключиться к СУБД");
        }
    }
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void add(Command command) {
        try {
            PreparedStatement pst = c.prepareStatement(
                    "INSERT INTO commands(Command) VALUES (?)");
            pst.setString(1, command.getStrcom());
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("БД не доступна");
        }
    }



    @Override
    public void remove(Command command) {
        try {
            PreparedStatement pst = c.prepareStatement(
                    "DELETE FROM Commands WHERE id = ?");
            pst.setInt(1, command.getId());
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("БД не доступна");
        }
    }

    @Override
    public ArrayList<Command> getComarr() {
        ArrayList<Command> all_Commands = super.getComarr();
        all_Commands.clear();
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(
                    "select * from commands");



            while (r.next()) {
                all_Commands.add(new Command(r.getInt("id"),r.getString("Command")));
                System.out.println("Command :" + r.getString("Command"));
            }
        }catch (SQLException ex) {
            System.out.println("БД недоступна");
        }
        return all_Commands;
    }

    public CommanDAO_JDBC() {
        connect();
    }

    @Override
    public Command get(int index) {
        return super.get(index);
    }
}
