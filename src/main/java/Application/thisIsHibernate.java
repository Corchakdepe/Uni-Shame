/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Model.Member1;
import Model.Trainer;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.Transaction;
import Control.*;
import Model.Activity;
import View.*;
import java.sql.SQLException;

/**
 *
 * @author ageudepetris
 */
public class thisIsHibernate {
    
    
    
    
    public static void main(String[] args) throws SQLException {
        
        LoginControl cLogin = new LoginControl();
        
       /* Transaction tr = session.beginTransaction();
      // Session session = HibernateUtil.getSessionFactory().openSession();
        
        Member1 member = session.get(Member1.class, "S003");
        Activity activity = session.get(Activity.class,"AC03");
        activity.getMember1Set().add(member);
        member.getActivitySet().add(activity);
        
        session.save(member);
        tr.commit();
        System.out.println(member.getActivitySet());
                     */ 
       
        

        
      



// Transaction tr = session.beginTransaction();
           // Query query = session.getNamedQuery("Trainer.findAll");
            //List<Trainer> traList = query
            
          //  Trainer t = session.get(Trainer.class, "M001");
         
     //    System.out.println(t.getTName());
        
     //    Member1 member = new Member1("S993","Jack","0000000C","17/12/2020",'A');
         
    /*     try
         {
             session.save(member);
             tr.commit();

         }
         catch(Exception e)
         {
           System.out.println(t.getTName());  
         } 
              */ 
    }
    
   
   
    
    
}
