/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

/**
 *
 * @author ageudepetris
 */
public class activityView extends javax.swing.JDialog {

    /**
     * Creates new form activityView
     */
    public activityView() {
       
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        activity_table = new javax.swing.JTable();
        return_button = new javax.swing.JButton();
        Search_button = new javax.swing.JButton();
        activity_box = new javax.swing.JTextField();
        add_ac_b = new javax.swing.JButton();
        add_m_ac = new javax.swing.JButton();
        delete_ac = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Activity");

        activity_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(activity_table);

        return_button.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        return_button.setText("update table");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        Search_button.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        Search_button.setText("Search");
        Search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_buttonActionPerformed(evt);
            }
        });

        activity_box.setText("AC01");
        activity_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_boxActionPerformed(evt);
            }
        });

        add_ac_b.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        add_ac_b.setText("add activity");
        add_ac_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ac_bActionPerformed(evt);
            }
        });

        add_m_ac.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        add_m_ac.setText("add member to ac");

        delete_ac.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        delete_ac.setText("delete activity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(return_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_ac_b, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_m_ac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_ac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(activity_box, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_button)
                    .addComponent(activity_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delete_ac)
                        .addGap(18, 18, 18)
                        .addComponent(add_m_ac)
                        .addGap(18, 18, 18)
                        .addComponent(add_ac_b)
                        .addGap(18, 18, 18)
                        .addComponent(return_button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_buttonActionPerformed

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_buttonActionPerformed

    private void activity_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activity_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activity_boxActionPerformed

    private void add_ac_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ac_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ac_bActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Search_button;
    public javax.swing.JTextField activity_box;
    public javax.swing.JTable activity_table;
    public javax.swing.JButton add_ac_b;
    public javax.swing.JButton add_m_ac;
    public javax.swing.JButton delete_ac;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton return_button;
    // End of variables declaration//GEN-END:variables
}
