/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ageudepetris
 */
public class activityDAO {

    
    Session session=null;
    
    public activityDAO(Session ses) {
        
        session=ses;
    }
    
    public List<Member1> listAllmembers(){
     List<Member1> memlist = session.createQuery("SELECT * FROM MEMBER").list();
        return memlist;
    }
    
}
