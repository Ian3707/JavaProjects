package xml_servlet1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Jim");
        alien.setColor("blue");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(alien);

    }

    public static void makeConnection() throws SQLException {
        Connection connection = null;
        try{
            ///Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:7000/jdbc_postgres_db", "postgres", "aDwaqG1");

//            if(connection != null){
//                System.out.println("connected");
//                String sql = "CREATE TABLE Persons (\n" +
//                        "    PersonID int,\n" +
//                        "    LastName varchar(255),\n" +
//                        "    FirstName varchar(255),\n" +
//                        "    Address varchar(255),\n" +
//                        "    City varchar(255)\n" +
//                        ");";
//                Statement statement = connection.createStatement();
//                int rows = statement.executeUpdate(sql);
//                if(rows > 0){
//                    System.out.println(rows + " rows written");
//                }
//            }else {
//                System.out.println("failed");
//            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }
}