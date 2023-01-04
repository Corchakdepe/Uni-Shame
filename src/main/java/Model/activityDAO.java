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
    
    public activityDAO(Session ses) {
        
        this.session=ses;
    }
    
    public List<Activity> listAllactivities(){
     List<Activity> alist = session.getNamedQuery("Activity.findAll").list();
        return alist;
    }
    
    
 
    public List<Activity> listAllMembersFromActivity(String A_ID) {
        Transaction tr = session.beginTransaction();
        Query query = session.createNativeQuery("SELECT * FROM PERFORMS p INNER JOIN \"MEMBER\" m ON p.P_NUM = m.M_NUM WHERE p.P_ID = \'" + A_ID + "\'");
        
        List<Activity> list = query.list();

        tr.commit();
        
        return list;
    }
}
