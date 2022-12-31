/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import View.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.String;
import javax.persistence.NamedQuery;
import static javax.swing.text.html.HTML.Tag.S;
import static org.hibernate.criterion.Projections.id;
import org.hibernate.query.Query;

/**
 *
 * @author ageudepetris
 */
public class memberDAO {

    
    Session session=null;
    newView newview = null;
    Member1 member=null;
    private MainView mainView = null;
    private Member_man memberView= null;
    private Trainer_man trainerView=null;
    Transaction tr = null;
    public memberDAO(Session ses) {
        session=ses;
        mainView = new MainView();
      memberView = new Member_man();
      trainerView = new Trainer_man();
   
     
    
    }
    
    public List<Member1> listAllmembers(){
     List<Member1> memlist = session.getNamedQuery("Member1.findAll").list();
        return memlist;
    }

    public void insertMember(Member1 member)throws Exception
    {
       // Transaction tra = session.beginTransaction();
        session.save(member);
      //  tra.commit();
        
    }
     public String lastid(Member1 member)
       {
        String string = null;
        
        session.createQuery("SELECT m FROM Member1 m WHERE m.mNum = :mNum").getQueryString();
       
      
    //  @NamedQuery(name = "Member1.findByMNum", query = "SELECT m FROM Member1 m WHERE m.mNum = :mNum"),
    //WHERE ID = (
  // SELECT MAX(ID) FROM Table)
        
         return string;
       }
     public String testquery(Member1 member)
       {
        String string = null;
        
        session.createQuery("SELECT p FROM Performs p").getQueryString();
       
      
    //  @NamedQuery(name = "Member1.findByMNum", query = "SELECT m FROM Member1 m WHERE m.mNum = :mNum"),
    //WHERE ID = (
  // SELECT MAX(ID) FROM Table)
        
         return string;
       }
     
   public void deleteMember(String codMember) throws Exception
    {
       Transaction tra = session.beginTransaction();
        member = session.get(Member1.class, codMember);
        session.delete(member);
        
      //  session.createQuery("DELETE FROM Member1 m WHERE M_NUM='"+"S00"+codMember+"'");
        //session.createSQLQuery("DELETE FROM MEMBER WHERE M_NUM='"+"S00"+codMember+"'");
       tra.commit();
    }
    
    
      
   
      
}
