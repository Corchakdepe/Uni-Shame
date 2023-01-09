/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import org.hibernate.Session;

import Model.Member1;
import Model.Activity;
import View.*;
import View.LoginView;
import static java.awt.SystemColor.text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.View;
import static oracle.sql.NUMBER.e;

/**
 *
 * @author ageudepetris
 */
public class LoginControl implements ActionListener, ItemListener{
    
      
      private boolean sessionOK = false;
      private LoginView loginView = null;
      private ConsoleView view = new ConsoleView();
      private DialogWindow dialogWindow = null;
      private MainView mainView = null;
      private mainViewController mainViewcontroller = null;
      private Session session;
      
      
      public LoginControl() throws SQLException
    {
        loginView = new LoginView();
       
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
        
        dialogWindow= new DialogWindow();
        
       this.addListeners();

       /*mainView.member_man_menu.addActionListener(mainViewcontroller);
        mainView.trainer_menu.addActionListener(mainViewcontroller);
        mainView.trainer_menu.addActionListener(mainViewcontroller);
        mainView.trainer_man_menu.addActionListener(mainViewcontroller);*/
        
       
        
    }

    @Override
   public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case "Connect":
                
                
               
                     session = connectdb();
                     
                     
                       
                          
                        if(session!=null)
                        {
                           // connect();
                           mainViewcontroller = new mainViewController(session);
                          //mainView = new MainView();
                          // smainView();
                           loginView.dispose();
                        }
                        
                        break;
            
            case "EXIT":
                        loginView.dispose();
                        System.exit(0);
                        break;
           
        }
    
    
    
    }
   
   
   private void addListeners()
   {
       
        
        loginView.EXIT_button.addActionListener(this);
        loginView.connect_button.addActionListener(this);
        loginView.combobox.addItemListener(this);
   }
   public void smainView() 
{
    
    mainView.setLocationRelativeTo(null);
    mainView.setVisible(true);
    
}
   
   
   public boolean connect()
{
    sessionOK =  HibernateUtil.getSessionFactory().isOpen();
    String text = "connection is OK";
    dialogWindow.Menssage("info", text);
    return sessionOK;  
}

   
   public Session connectdb()
   {
       String box = loginView.combobox.getSelectedItem().toString();
            if  (box=="Oracle")
               
              session = HibernateUtil.getSessionFactory().openSession();

            if(box=="MariaDB") 
               
              session = HibernateUtil.getSessionFactorymaria().openSession();
        
     return session;
   }
   
    @Override
    public void itemStateChanged(ItemEvent e) {
        String combobox = loginView.combobox.getSelectedItem().toString();
      switch (combobox) {
            case "Oracle":
                 loginView.ip.setText("172.17.20.39");
                loginView.portbox.setText("1521");
                loginView.db_name_box.setText("ETSI");
                loginView.user_box.setText("ISDD_004");
                loginView.pass_box.setText("102030");
                break;

            case "MariaDB":
                 loginView.ip.setText("172.18.1.241");
                loginView.portbox.setText("3306");
                loginView.db_name_box.setText("ISDD_004");
                loginView.user_box.setText("ISDD_004");
                loginView.pass_box.setText("ISDD_004");
                break;
        }
          
    }
}
