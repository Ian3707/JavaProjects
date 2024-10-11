package hql_hibernate;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);

        try(ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession()){

            session.beginTransaction();
//            Random rnd = new Random();
//
//            for(int i = 0; i < 50; ++i){
//                Student newStudent = new Student();
//                newStudent.setId(i);
//                newStudent.setName("Student#" + i);
//                newStudent.setMarks(rnd.nextInt(4, 10));
//                session.save(newStudent);
//            }

            ////////// Query ///////////

//            String hql = "from m_student where marks >= 7";
//            Query query = session.createQuery(hql);
//            List<Student> students = query.list();
//
//            for(Student s : students){
//                System.out.println(s);
//            }
//
//            System.out.println("\n\n\n");
//            String sql = "select name, marks from m_student where id = 7";
//            Query query = session.createQuery(sql);
////            Student student = (Student) query.uniqueResult();
//            Object[] student = (Object[]) query.uniqueResult();
//
//            for(Object field : student){
//                System.out.println(field + " : " + field.getClass());
//            }

//            String sql = "select id, name from m_student where marks = 7";
//            Query query = session.createQuery(sql);
//            List<Object[]> student = (List<Object[]>) query.list();
//
//            for(Object[] currentStudent : student){
//                for(Object field : currentStudent){
//                    System.out.println(field);
//                }
//            }

//            int mark = 7;
//            String sql = "select sum(marks) from m_student where marks >= :mark";
//            Query query = session.createQuery(sql);
//            query.setParameter("mark", mark);
//            Long marks = (Long) query.uniqueResult();
//
//            System.out.println(marks);
//
//
//            session.getTransaction().commit();

//            String sql = "select * from m_student where marks >= 7";
//            SQLQuery sqlQuery = session.createSQLQuery(sql);
//            sqlQuery.addEntity(Student.class);
//            List<Student> students = sqlQuery.getResultList();
//
//            for(Student o : students){
//                System.out.println(o);
//            }

//            String sql = "select name, marks from m_student where marks >= 7";
//            SQLQuery sqlQuery = session.createSQLQuery(sql);
//            sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//            List students = sqlQuery.getResultList();
//
//            for(Object o : students){
//                Map m = (Map) o;
//                System.out.println(m.get("name") + " : " + m.get("marks"));
//            }


            String sql = "from m_student where id=0";
            Query query = session.createQuery(sql);
            Student gStudent = (Student) query.uniqueResult();
            gStudent.setName("Teacher");
            gStudent.setMarks(10);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}