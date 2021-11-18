import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("project started...");

        // create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Employee employee = new Employee();
        employee.setId(2);;
        employee.setUsername("Mark");
        employee.setPassword("password");
        employee.setGender("Male");
        employee.setAge(19);



        // save the employee
        session.save(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }
}
