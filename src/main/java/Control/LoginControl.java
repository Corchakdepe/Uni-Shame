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

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.View;
import static oracle.sql.NUMBER.e;

/**
 *
 * @author ageudepetris
 */
public class LoginControl implements ActionListener{
    
      
      private boolean sessionOK = false;
      private LoginView loginView = null;
      private ConsoleView view = new ConsoleView();
      private DialogWindow dialogWindow = null;
      private MainView mainView = null;
      private mainViewController mainViewcontroller = null;
      
      
      
      public LoginControl() throws SQLException
    {
        loginView = new LoginView();
        Session session = HibernateUtil.getSessionFactoryOracle().openSession();
        
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
        loginView.EXIT_button.addActionListener(this);
        loginView.connect_button.addActionListener(this);
        dialogWindow= new DialogWindow();
        mainView = new MainView();
        mainViewcontroller = new mainViewController(session);
        
        mainView.member_man_menu.addActionListener(mainViewcontroller);
        mainView.trainer_menu.addActionListener(mainViewcontroller);
        mainView.trainer_menu.addActionListener(mainViewcontroller);
        mainView.trainer_man_menu.addActionListener(mainViewcontroller);
        
    }

    @Override
   public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case "Connect":
                
                
               
                     
                      sessionOK = connect();
                       
                       
                          
                        if(sessionOK)
                        {
                           
                           
                           smainView();
                           loginView.dispose();
                        }
                        
                        break;
            
            case "EXIT":
                        loginView.dispose();
                        System.exit(0);
                        break;
           
        }
    
    
    
    }
   public void smainView() 
{
    mainView.setLocationRelativeTo(null);
    mainView.setVisible(true);
    
}
   
   
   public boolean connect()
{
    boolean variable =false;
    sessionOK =  HibernateUtil.getSessionFactoryOracle().isOpen();
    variable = true;
    String text = "connection is OK";
    dialogWindow.Menssage("info", text);
    return sessionOK;
   
}
}
