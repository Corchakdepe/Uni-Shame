/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Table_model;
import org.hibernate.Session;
import Model.*;
import Model.Activity;
import View.ConsoleView;
import java.awt.event.ActionListener;
import View.LoginView;
import View.MainView;
import View.Member_man;
import View.newView;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import View.Trainer_man;
import View.activityView;
import View.newactivity;
import View.newmemberactivity;
import View.newtrainerview;
import static java.awt.PageAttributes.MediaType.A;

import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;


import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 *
 * @author ageudepetris
 */
class mainViewController implements ActionListener {
    
    
    private LoginView loginView = null;
    private LoginControl logincontrol = null;
    private MainView mainView = null;
    private Member_man memberView= null;
    private Trainer_man trainerView=null;
    Session  session;
    private Member1 member = null;
    private Activity activity = null;
    private Trainer trainer = null;
    private newView newview = null;
    private newtrainerview trainernewview = null;
    private Table_model table_model = null;
    private memberDAO memberdao=null;
    private trainerDAO trainerdao=null;
    private activityDAO activitydao = null;
    private activityView  activityview = null;
    private newactivity newActivity = null;
    private newmemberactivity newmemberactivity = null;
  
    Transaction tr = null;
    
          

    mainViewController(Session ses) {
        
     
      session=ses;
        loginView = new LoginView();
        mainView = new MainView();
        memberView = new Member_man();
        trainerView = new Trainer_man();
        activityview = new activityView();
        table_model = new Table_model();
        member = new Member1( ); 
        trainer = new Trainer();
        newview = new newView(memberView,true);
        trainernewview = new newtrainerview(trainerView,true);
        newActivity = new newactivity(activityview,true);
        newmemberactivity = new newmemberactivity(activityview,true);
        memberdao = new memberDAO(ses);
        trainerdao = new trainerDAO(ses);
        activitydao = new activityDAO(ses);
        
         
        //mainmenu buttons
        mainView.member_man_menu.addActionListener(this);
        mainView.members_menu.addActionListener(this);
        mainView.trainer_menu.addActionListener(this);
        mainView.trainer_man_menu.addActionListener(this);
        //mainView.activities_menu.addActionListener(this);//not working im sorry
   
          //member window buttons
        memberView.Update_button.addActionListener(this);
        memberView.delete_button.addActionListener(this);
        memberView.new_button.addActionListener(this);
        memberView.back_button.addActionListener(this);
        memberView.member_ac_button.addActionListener(this);
        //trainer window buttons
        trainerView.Update_button.addActionListener(this);
        trainerView.delete_button.addActionListener(this);
        trainerView.new_button.addActionListener(this);
        //member window buttons
        newview.Insert_button.addActionListener(this);
        newview.close_button.addActionListener(this);
        newview.code_field.setEditable(false);
       
        
        
        
        //trainer window buttons
        trainernewview.close_button.addActionListener(this);
        trainernewview.Insert_button.addActionListener(this);
        trainernewview.code_field.setEditable(false);
        
        
        //activity window buttons
        activityview.Search_button.addActionListener(this);
        activityview.return_button.addActionListener(this);
       
        activityview.add_ac_b.addActionListener(this);
        activityview.add_m_ac.addActionListener(this);
        activityview.delete_ac.addActionListener(this);
        //activity window buttons
        newActivity.add_ac_button.addActionListener(this);
        newActivity.id_field.setEditable(false);
        newmemberactivity.add_to_ac_m_button.addActionListener(this);
        
      
    }
    
       
    
   
    
    
      

     
   
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
     
    
       
    switch(e.getActionCommand())
    {
        
        case "Members Management": //self explained
            mainView.dispose();
            memberView.setLocationRelativeTo(null);
            memberView.setVisible(true);
            table_model.cleartablemember();
            table_model.setuptableMember(memberView);
            table_model.filltableMember(memberdao.listAllmembers());
             newview.code_field.setText("S0"+table_model.countmember(member));
           
           
            break;

        
            
        case "Trainers Management"://self explained
             mainView.dispose();
             trainerView.setLocationRelativeTo(null);
             trainerView.setVisible(true); 
             
             table_model.cleartabletrainer();
             
             table_model.setuptableTrainer(trainerView);
            
             table_model.filltableTrainer(trainerdao.listAlltrainer());
             
             trainernewview.code_field.setText("M0"+table_model.countTrainer(trainer));
          
             
             break;
            
        case "Member Activities": //this is a sub-menu inside member management to MANAGE members and activities
            
            memberView.dispose();
            activityview.setLocationRelativeTo(null);
            activityview.setVisible(true);
            table_model.cleartableactivity();
            table_model.setuptableActivity(activityview);
            table_model.filltableActivity(activitydao.listAllactivities());
            newActivity.id_field.setText("AC"+table_model.countActivity(activity));
         
        break;
        
      
        
            
            case "Back": //close Member Window and re open main View
                memberView.dispose();
                mainView.setLocationRelativeTo(null);
                mainView.setVisible(true);
            break;  
            
            case "back": //close Trainer Window and re open main View //to be fixed
                
                trainerView.dispose();
                mainView.setLocationRelativeTo(null);
                mainView.setVisible(true);
            
            break;
            
            
            
            case "Update": //update member window
                Transaction tra = session.beginTransaction();
                System.out.println("Update test");
                table_model.cleartablemember();  
                table_model.filltableMember(memberdao.listAllmembers());
                tra.commit();
            break;
            
            
            case "update": //update trainer window
                Transaction tr = session.beginTransaction();
                table_model.cleartabletrainer();
                table_model.filltableTrainer(trainerdao.listAlltrainer());
                tr.commit();
                System.out.println("Update test"); 
            break;
            case "update table": //update values on Members-Activities management
                     //activityview.dispose();
                     //memberView.setLocationRelativeTo(null);
                     //memberView.setVisible(true);
                     
            memberView.dispose();
            activityview.setLocationRelativeTo(null);
            activityview.setVisible(true);
            table_model.cleartableactivity();
            table_model.setuptableActivity(activityview);
            table_model.filltableActivity(activitydao.listAllactivities());
                 break;
            case "New": // new member
                newview.setLocationRelativeTo(null);
                newview.setVisible(true);
                newview.code_field.setText(table_model.countmember(member));
                System.out.println("Running New");
                break;
                
            case "new": // new trainer
                
                trainernewview.setLocationRelativeTo(null);
                trainernewview.setVisible(true);
                newview.code_field.setText(table_model.countTrainer(trainer));
                System.out.println("new running");
                 
                          break;
                          
                          
                           case "add activity": //new activity
                     
                     newActivity.setLocationRelativeTo(null);
                     newActivity.setVisible(true);
                     System.out.println("test");
                    
                    // public Activity(String aId, String aName, String aDescription, BigInteger aPrice)
                    
                     
                     
                     break;
            
                case "add member to ac":
                    System.out.println("test");
                    newmemberactivity.setLocationRelativeTo(null);
                    newmemberactivity.setVisible(true);
                    break;
                 
                 
                
                 case "Insert": //insert a new member 
                  
           
                Member1 m = new Member1(newview.code_field.getText(),newview.name_field.getText(), newview.DNI_field.getText(),newview.phone_field.getText(),newview.birth_field.getText(), newview.email_field.getText(), newview.start_field.getText(), newview.cat_field.getText());
        {
            try {
                memberdao.insertMember(m);
            } catch (Exception ex) {
                Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               
           
                  
                
                System.out.println("Insert Running");
                break;

                
                 case "insert": // insert a new trainer
                     
                   
                  Trainer t = new Trainer(trainernewview.code_field.getText(),trainernewview.name_field.getText(),trainernewview.DNI_field.getText(),trainernewview.phone_field.getText(),trainernewview.email_field.getText(),trainernewview.start_field.getText(),trainernewview.nick_field.getText());
        {
            try {
                trainerdao.insertTrainer(t);
            } catch (Exception ex) {
                Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                 
        
        
                      
                              
                      
                     break;

                     
                     case "add":
                   
        BigInteger s_p = BigInteger.valueOf(Integer.parseInt(newActivity.price_field.getText()));
                
                        
                        
                Activity activity = new Activity(newActivity.id_field.getText(),newActivity.name_field.getText(),newActivity.description_field.getText(),s_p);
                
                activitydao.addactivity(activity);
               
                     break;
                     
                     
                     case "add member to activity": //self explained
                    
                         
                         String ac_code = newmemberactivity.ac_code.getText();
                         String mb = newmemberactivity.m_code.getName();
                         activitydao.addMemberToActivity(ac_code, mb);
                         System.out.println("running");
                     break;
                     
                     
                     

                
                 case "Delete": //delete a member
                  
                     
                     int p = memberView.jtablemember.getSelectedRow();
                     String s = (String) table_model.modeltableMember.getValueAt(p, 0);
                     
                    if (p == -1) {
                       JOptionPane.showMessageDialog(null, "Select a Row first");
                    } else 
                        
                        try {
                            memberdao.deleteMember(s);
                            table_model.cleartablemember();//
            table_model.setuptableMember(memberView);
            table_model.filltableMember(memberdao.listAllmembers());
                            
     } catch (Exception ex) {
         Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
     }
                     
                  
                      
                   
                    
                    break;
               
            
                 case "delete"://delete a trainer
                     
                    int t_r = trainerView.jtabletrainer.getSelectedRow(); 
                    String ts = (String) table_model.modeltableTrainer.getValueAt(t_r, 0);
                    
                    if(t_r== -1)  {JOptionPane.showMessageDialog(null, "Select a Row first");
                    } else 
                     
                        try {
                            trainerdao.deleteTrainer(ts);
                            table_model.cleartabletrainer();
                            table_model.setuptableTrainer(trainerView);
                            table_model.filltableTrainer(trainerdao.listAlltrainer());
     } catch (Exception ex) {
         Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
     }
                 
                    
                      
       
                     break;
                     
                      case "delete activity": //self explained
                     
                      int i = activityview.activity_table.getSelectedRow();
                    String ss = (String) table_model.modeltableActivity.getValueAt(i, 0);
                    
                    if(i == -1)  {JOptionPane.showMessageDialog(null, "Select a Row first");
                    } else 
                     
                        try {
                            activitydao.deleteActivity(ss);
                           table_model.cleartableactivity();
                           table_model.setuptableActivity(activityview);
                           table_model.filltableActivity(activitydao.listAllactivities());
     } catch (Exception ex) {
         Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
     }
                     
                     System.out.println("test");
                     break;
                 case "Close"://close Member management window
                     newview.dispose();                   
                  break;   
                 case "close"://close trainer management window
                     trainernewview.dispose();
                     break;
                 
                 case "Search": //look for a member in a activity (does not work well)
                     table_model.cleartableactivity();
                     table_model.setuptableActivity(activityview);
                     String ac = activityview.activity_box.getText();
                  List a =   activitydao.listAllMembersFromActivity(ac);
                     table_model.filltableActivity(a);
                    
                     System.out.println(activityview.activity_box.getText());
                 break;
                 
                 
                
                
                
                  
                
                
    }
      
    
   
     
    
    
    }}

     
    
    

