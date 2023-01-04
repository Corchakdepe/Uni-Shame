/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ageudepetris
 */
public class trainerDAO {

    Session session;
    Trainer trainer = null;
    
    
    public trainerDAO(Session ses) {
        
        this.session=ses;
    }
    
    public List<Trainer> listAlltrainer()
    {
       List<Trainer> trelist = session.getNamedQuery("Trainer.findAll").list();
       return trelist;
    }
    
       public void insertTrainer(Trainer trainer)throws Exception
    {
        //Transaction tra = session.beginTransaction();
        session.save(trainer);
       // tra.commit();
        
    }
       
      
    
   public void deleteTrainer(String codTrainer) throws Exception
    {
       
           Transaction tra = session.beginTransaction();
   
        
        
    
       trainer = session.get(Trainer.class, codTrainer);
       session.delete(trainer);
       tra.commit();
        
    }
    
}
 
   

