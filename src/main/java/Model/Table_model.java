/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ageudepetris
 */



import View.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Table_model {
    
    public Table_model()
  {
  
  } 
    
     public DefaultTableModel modeltableMember = new DefaultTableModel()
   {
       public boolean iscelleditable(int row, int column)
       {
           return false;
       }
       
   }; 
    
     
     public DefaultTableModel modeltableTrainer = new DefaultTableModel()
   {
       public boolean iscelleditable(int row, int column)
       {
           return false;
       }
   }; 
     
     public DefaultTableModel modeltableActivity = new DefaultTableModel()
     {
         public boolean iscelleditable(int row, int column)
         {
             return false;
         }
     };
      public void setuptableMember(Member_man memberView)
   {
     
       memberView.jtablemember.setModel(modeltableMember);
       
       String[] columnNames = {"ID", "Name", "DNI","Phone","Birth Date","email", "start date","cat"};
       modeltableMember.setColumnIdentifiers(columnNames);
       memberView.jtablemember.getTableHeader().setResizingAllowed(false);
       memberView.jtablemember.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
       
       
       memberView.jtablemember.getColumnModel().getColumn(0).setPreferredWidth(40);
        memberView.jtablemember.getColumnModel().getColumn(1).setPreferredWidth(240);
         memberView.jtablemember.getColumnModel().getColumn(2).setPreferredWidth(70);
          memberView.jtablemember.getColumnModel().getColumn(3).setPreferredWidth(70);
           memberView.jtablemember.getColumnModel().getColumn(4).setPreferredWidth(70);
            memberView.jtablemember.getColumnModel().getColumn(5).setPreferredWidth(240);
             memberView.jtablemember.getColumnModel().getColumn(6).setPreferredWidth(1);
             memberView.jtablemember.getColumnModel().getColumn(7).setPreferredWidth(1);
   }
       public void setuptableTrainer(Trainer_man trainerView)
   {
     
       
       trainerView.jtabletrainer.setModel(modeltableTrainer);
       String[] columnNames = {"code", "Name", "Phone","Birth date","email", "DNI", "nick"};
       modeltableTrainer.setColumnIdentifiers(columnNames);
       trainerView.jtabletrainer.getTableHeader().setResizingAllowed(false);
       trainerView.jtabletrainer.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
       
       
       trainerView.jtabletrainer.getColumnModel().getColumn(0).setPreferredWidth(40);
        trainerView.jtabletrainer.getColumnModel().getColumn(1).setPreferredWidth(70);
         trainerView.jtabletrainer.getColumnModel().getColumn(2).setPreferredWidth(70);
          trainerView.jtabletrainer.getColumnModel().getColumn(3).setPreferredWidth(70);
           trainerView.jtabletrainer.getColumnModel().getColumn(4).setPreferredWidth(240);
            trainerView.jtabletrainer.getColumnModel().getColumn(5).setPreferredWidth(110);
            trainerView.jtabletrainer.getColumnModel().getColumn(6).setPreferredWidth(70);  
   }
      
       public void setuptableActivity(activityView activityview)
       {
           activityview.activity_table.setModel(modeltableActivity);
           String[] columnNames = {"id","name","price","trainer","description"};
           
           modeltableActivity.setColumnIdentifiers(columnNames);
           activityview.activity_table.getTableHeader().setResizingAllowed(false);
           activityview.activity_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
           
           activityview.activity_table.getColumnModel().getColumn(0).setPreferredWidth(40);
           activityview.activity_table.getColumnModel().getColumn(1).setPreferredWidth(40);
           activityview.activity_table.getColumnModel().getColumn(2).setPreferredWidth(40);
           activityview.activity_table.getColumnModel().getColumn(3).setPreferredWidth(40);
           activityview.activity_table.getColumnModel().getColumn(4).setPreferredWidth(40);
           
       }
     
      
       public void filltableMember(List<Model.Member1> lmember)
     {
         
         
         Object[] row = new Object[8];
         int numRows = lmember.size();
         for (int i = 0; i < numRows; i++) {
         
             row[0] = lmember.get(i).getMNum();
              row[1] = lmember.get(i).getMName();
               row[2] = lmember.get(i).getMId();
                row[3] = lmember.get(i).getMPhone();
                 row[4] = lmember.get(i).getMBirhtdate();
                  row[5] = lmember.get(i).getMEmailmember();
                   row[6] = lmember.get(i).getMStartingdatemember();
                    row[7] = lmember.get(i).getMCathegorymember();
                    
                    modeltableMember.addRow(row);
                    
            
         }
     }
       
       
           public String countmember(Member1 member)
     {
         
         
            int i;
            
            i = modeltableMember.getRowCount();
            
            i++;
            
            String p = Integer.toString(i);
            
            
            return p;
         
     }
       
             public String countTrainer(Trainer trainer)
     {
         
         
            int i;
            
            i = modeltableTrainer.getRowCount();
            
            i++;
            
            String p = Integer.toString(i);

            return p;
         
     }
     
        public void filltableTrainer(List<Model.Trainer> ltrainer)
     {
         
         
         Object[] row = new Object[7];
         int numRows = ltrainer.size();
         for (int i = 0; i < numRows; i++) {
         
             row[0] = ltrainer.get(i).getTCod();
              row[1] = ltrainer.get(i).getTName();
               row[2] = ltrainer.get(i).getTPhonenumber();
                row[3] = ltrainer.get(i).getTDate();
                 row[4] = ltrainer.get(i).getTEmail();
                  row[5] = ltrainer.get(i).getTIdnumber();
                   row[6] = ltrainer.get(i).getTNick();
                   
                    
                    modeltableTrainer.addRow(row);
                    
            
         }
     }
        
        public void filltableActivity(List<Model.Activity> lactivity)
        {
            Object[] row = new Object[5];
            
            int numRows=lactivity.size();
            for(int i = 0;i<numRows;i++)
            {
                row[0]=lactivity.get(i).getAId();
                row[1]=lactivity.get(i).getAName();
                row[2]=lactivity.get(i).getAPrice();
                row[3]=lactivity.get(i).getATrainerincharge();
                row[4]=lactivity.get(i).getADescription();
               
                modeltableActivity.addRow(row);
                
            }
        }
       
        
        
       public void cleartablemember()
       {
           for(int i=modeltableMember.getRowCount() - 1; i>=0; i--)
           {
               modeltableMember.removeRow(i);
           }
       }
       
       public void cleartabletrainer()
       {
           for(int i=modeltableTrainer.getRowCount() - 1; i>0; i--)
           {
               modeltableTrainer.removeRow(i);
           }
       }
       
       
       public void cleartableactivity()
       {
           for(int i=modeltableActivity.getRowCount() - 1;i>0;i--)
           {
               modeltableActivity.removeRow(i);
           }
       }
       
       
       
       
 
    
}
