package Control;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author jacinto
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    //private static final SessionFactory sessionFactoryM = buildSessionFactorymaria();
    

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
           
            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            
            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /*private static SessionFactory buildSessionFactorymaria() {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg_m.xml").build();
           
            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            
            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }*/
    
    
    public static SessionFactory getSessionFactoryOracle() {
        return sessionFactory;
    }
    
    /*public static SessionFactory getSessionFactoryMaria()
    {
        return sessionFactoryM;
    }*/

    public static void close() {
        if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
             sessionFactory.close();
        sessionFactory.close();
        }
    }
    
     

}