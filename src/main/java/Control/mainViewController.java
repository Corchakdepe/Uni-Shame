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
import View.newtrainerview;
import static java.awt.PageAttributes.MediaType.A;

import java.awt.event.ActionEvent;
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
    private MainView mainView = null;
    private Member_man memberView= null;
    private Trainer_man trainerView=null;
    Session  session = null;
    private Member1 member = null;
    private Activity activity = null;
    private Trainer trainer = null;
    private newView newview = null;
    private newtrainerview trainernewview = null;
    private Table_model table_model = null;
    private memberDAO memberdao=null;
    private trainerDAO trainerdao=null;
    private activityDAO activitydao = null;
    private MouseEvent evt;
    private activityView  activityview = null;
  
    Transaction tr = null;
    
          

    mainViewController(Session ses) {
    
        session = ses;
        loginView = new LoginView();
        mainView = new MainView();
        memberView = new Member_man();
        trainerView = new Trainer_man();
        table_model = new Table_model();
        member = new Member1( ); 
        trainer = new Trainer();
        newview = new newView(memberView,true);
        trainernewview = new newtrainerview(trainerView,true);
        activityview = new activityView(mainView,true);
        memberdao = new memberDAO(ses);
        trainerdao = new trainerDAO(ses);
        activitydao = new activityDAO(ses);
        
         
        
        mainView.member_man_menu.addActionListener(this);
        mainView.members_menu.addActionListener(this);
        mainView.trainer_menu.addActionListener(this);
        mainView.trainer_man_menu.addActionListener(this);
        
   
        
        memberView.Update_button.addActionListener(this);
        memberView.delete_button.addActionListener(this);
        memberView.new_button.addActionListener(this);
        memberView.back_button.addActionListener(this);
        memberView.member_ac_button.addActionListener(this);
        
        trainerView.Update_button.addActionListener(this);
        trainerView.delete_button.addActionListener(this);
        trainerView.new_button.addActionListener(this);
        
        newview.Insert_button.addActionListener(this);
        newview.close_button.addActionListener(this);
        newview.code_field.setEditable(false);
        
        
        
        
        
        trainernewview.close_button.addActionListener(this);
        trainernewview.Insert_button.addActionListener(this);
        trainernewview.code_field.setEditable(false);
        
        activityview.Search_button.addActionListener(this);
        activityview.return_button.addActionListener(this);
        activityview.erase_button.addActionListener(this);
    
       
        
      
    }
    
       
    
   
    
    
      

     
   
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
     
    
       
    switch(e.getActionCommand())
    {
        
        case "Members Management": 
            mainView.dispose();
            memberView.setLocationRelativeTo(null);
            memberView.setVisible(true);
            table_model.cleartablemember();
            table_model.setuptableMember(memberView);
            table_model.filltableMember(memberdao.listAllmembers());
            
            newview.code_field.setText("S0"+table_model.countmember(member));
           
            break;

        
            
        case "Trainers Management":
             mainView.dispose();
             trainerView.setLocationRelativeTo(null);
             trainerView.setVisible(true); 
             
             table_model.cleartabletrainer();
             
             table_model.setuptableTrainer(trainerView);
            
             table_model.filltableTrainer(trainerdao.listAlltrainer());
             
             trainernewview.code_field.setText("M0"+table_model.countTrainer(trainer));
          
             
             break;
            
        case "Member Activities":
            
            mainView.dispose();
            activityview.setLocationRelativeTo(null);
            activityview.setVisible(true);
            table_model.cleartableactivity();
            table_model.setuptableActivity(activityview);
            table_model.filltableActivity(activitydao.listAllactivities());
         
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
                
                 case "Insert": //insert a new member 
                  
                  Transaction trrr=null;
        
            try {
                trrr = session.beginTransaction();
                Member1 m = new Member1(newview.code_field.getText(),newview.name_field.getText(), newview.DNI_field.getText(),newview.phone_field.getText(),newview.birth_field.getText(), newview.email_field.getText(), newview.start_field.getText(), newview.cat_field.getText());
                memberdao.insertMember(m);
                trrr.commit();
            } catch (Exception ex) {
                if(ex!=null)
                {
                    trrr.rollback();
                }
                ex.printStackTrace();
                Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                  
                
                System.out.println("Insert Running");
                break;
                
                 case "insert": // insert a new trainer
                     
                    Transaction trr = null;
                     
                      System.out.println("Insert Running test");          
        {
            try {
                  trr = session.beginTransaction();
                  Trainer t = new Trainer(trainernewview.code_field.getText(),trainernewview.name_field.getText(),trainernewview.DNI_field.getText(),trainernewview.phone_field.getText(),trainernewview.email_field.getText(),trainernewview.start_field.getText(),trainernewview.nick_field.getText());
                  trainerdao.insertTrainer(t);
                  trr.commit();
            } catch (Exception ex) {
                Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
                if(ex!=null) trr.rollback();
            }
        }
                      
                              
                      
                     break;

                
                 case "Delete":
                  
                     
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
               
            
                 case "delete":
                     
                    int t = trainerView.jtabletrainer.getSelectedRow(); 
                    String ts = (String) table_model.modeltableTrainer.getValueAt(t, 0);
                    
                    if(t == -1)  {JOptionPane.showMessageDialog(null, "Select a Row first");
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
                 case "Close":
                     newview.dispose();                   
                  break;   
                 case "close":
                     trainernewview.dispose();
                     break;
                 case "return":
                     activityview.dispose();
                     mainView.setLocationRelativeTo(null);
                     mainView.setVisible(true);
                 break;
                 case "Search":
                     table_model.cleartableactivity();
                     table_model.setuptableActivity(activityview);
                     String ac = activityview.activity_box.getText();
                     
                     table_model.filltableActivity(activitydao.listAllMembersFromActivity(ac));
                    
                     System.out.println(activityview.activity_box.getText());
                 break;
                 case "erase": 
                     System.out.println("test");
                 break;   
                  

                
    }
      
    
   
     
    
    
    }}

     
    
    

