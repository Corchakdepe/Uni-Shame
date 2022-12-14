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

    Session session=null;
    Trainer trainer = null;
    
    
    public trainerDAO(Session ses) {
        
        session=ses;
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
       
      
    
   public void deleteTrainer(int codTrainer) throws Exception
    {
        if(codTrainer>=10){
        session.createQuery("DELETE FROM Member1 m WHERE M_NUM='"+"M0"+codTrainer+"'");}
        else   { session.createQuery("DELETE FROM Member1 m WHERE M_NUM='"+"M00"+codTrainer+"'");}
    }
    
}
 
   

