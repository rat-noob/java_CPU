package org.example.test_db;

import org.example.cpu_lab_4.HibernateUtil;
import org.example.cpu_lab_4.Command;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MainDB_H {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            Command cm1 = new Command("init 30 7");
            session.persist(cm1);

            Command cm2 = new Command("init 40 20");
            session.persist(cm2);

            transaction.commit();
            System.out.println("Комманда сохранена: " + cm1);
            System.out.println("КОмманда сохранена: " + cm2);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Command> pairs = session.createQuery("FROM Command", Command.class).getResultList();
            pairs.forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }


    }
}
