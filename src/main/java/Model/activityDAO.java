/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
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
    
    
 
   public ArrayList<Object[]> listAllMembersFromActivity(String A_ID) {
        Transaction tr = session.beginTransaction();
        Query query = session.createNativeQuery("SELECT m.M_NUM, m.M_NAME, m.M_EMAILMEMBER FROM PERFORMS p INNER JOIN \"MEMBER\" m ON p.P_NUM = m.M_NUM WHERE p.P_ID = \'" + A_ID + "\'");

        ArrayList<Object[]> list = (ArrayList<Object[]>) query.list();

        tr.commit();
        
        return list;
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
        
        session.createNativeQuery("INSERT INTO PERFORMS VALUES (\'" + m_id + "\', \'" + ac_id + "\')").executeUpdate();

        tr.commit();
    }
   
    public void addactivity(Activity activity) {
        Transaction tr = session.beginTransaction();
        session.save(activity);
        tr.commit();
    }
   
}
