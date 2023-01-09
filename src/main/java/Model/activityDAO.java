/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static java.lang.String.valueOf;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ageudepetris
 */
public class activityDAO {

    
    Session session;
    Activity activity = null;
    
    public activityDAO(Session ses) {
        
        this.session=ses;
    }
    
    public List<Activity> listAllactivities(){
     List<Activity> alist = session.getNamedQuery("Activity.findAll").list();
        return alist;
    }
    
    
 
   public List listAllMembersFromActivity(String A_ID) {
       
        ArrayList<Member1> s = new ArrayList();
        Transaction tr = session.beginTransaction();
        Query query = session.getNamedQuery("Member1.findAll");
        List<Member1> list = query.list();
       for (Member1 member: list) {
        Set<Activity>  activities = member.getActivitySet();
           for (Activity activity : activities) {
               if (activity.getAName().equals(A_ID)) {
                   s.add(member);
               }
           }
       }
        tr.commit();
        
        return list;
    }
   
                
    public List listAllactivitiesfrom_member(String A_ID) {
       
        ArrayList<Activity> s = new ArrayList();
        Transaction tr = session.beginTransaction();
        Query query = session.getNamedQuery("Activity.findAll");
        List<Activity> list = query.list();
       for (Activity Activity: list) {
        Set<Member1>  members = Activity.getMember1Set();
           for (Member1 member : members) {
               if (member.getMName().equals(A_ID)) {
                   s.add(activity);
                  
               }
           }
       }
        tr.commit();
        
        
        return list;
        
    }
    
    public BigInteger pricing(String A_ID) {
       
        BigInteger b = null;
        ArrayList<Activity> s = new ArrayList();
        Transaction tr = session.beginTransaction();
        Query query = session.getNamedQuery("Activity.findAll");
        List<Activity> list = query.list();
       for (Activity Activity: list) {
        Set<Member1>  members = Activity.getMember1Set();
           for (Member1 member : members) {
               if (member.getMName().equals(A_ID)) {
                   s.add(activity);
                   b =  activity.getAPrice();
                 
               }
           }
       }
       
       
        tr.commit();
        
        
        
        
        
        return b;
        
    }
    
    
    
   
   public void deleteActivity(String codAc) throws Exception
    {
       Transaction tra = session.beginTransaction();
        activity = session.get(Activity.class, codAc);
        session.delete(activity);
        
      
       tra.commit();
    }
   
   
   public void addMemberToActivity(String ac_id, String m_id) {
        Transaction tr = session.beginTransaction();
        
        
        tr.commit();
    }
   
    public void addactivity(Activity activity) {
        Transaction tr = session.beginTransaction();
        session.save(activity);
        tr.commit();
    }
    
     
   
}
