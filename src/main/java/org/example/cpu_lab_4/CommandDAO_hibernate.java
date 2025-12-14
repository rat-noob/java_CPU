package org.example.cpu_lab_4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO_hibernate extends CommandDAO{
    Session session = null;
    Transaction transaction = null;

//    void connect(){
//        try {
//            Class.forName("org.sqlite.JDBC");
//
//            c = DriverManager.getConnection(
//                    "jdbc:sqlite:all_commands.db");
//            System.out.println("Opened database successfully");
//
//
//        } catch (ClassNotFoundException ex) {
//            System.out.println("не найден драйвер");
//        } catch (SQLException ex) {
//            System.out.println("не удалось подключиться к СУБД");
//        }
//    }
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void add(Command command) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.persist(command);

            transaction.commit();
            System.out.println("Комманда сохранена: " + command);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }



    @Override
    public void remove(Command command) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.remove(command);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Command> getComarr() {
        ArrayList<Command> all_Commands = super.getComarr();
        all_Commands.clear();

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Command> commands = session.createQuery("FROM Command", Command.class).getResultList();
            commands.forEach(all_Commands::add);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return all_Commands;
    }

//    public CommanDAO_JDBC() {
//        connect();
//    }

    @Override
    public Command get(int index) {
        return super.get(index);
    }

}
