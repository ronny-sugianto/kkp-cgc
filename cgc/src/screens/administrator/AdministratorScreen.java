/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.administrator;

import core.models.Tickets;
import core.models.Users;
import core.services.AuthService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import screens.SignInScreen;
import screens.UpdatePasswordScreen;

/**
 *
 * @author ronny
 */
public class AdministratorScreen extends javax.swing.JFrame {

    private static int USER_ID;
    private DefaultTableModel modelUser, modelUserFillter, modelTickets;
    AuthService authService = new AuthService();

    int selectedUserId = 0;

    /**
     * Creates new form AdministratorScreen
     *
     * @param userId
     */
    public AdministratorScreen(int userId) {
        initComponents();
        setLocationRelativeTo(null);
        USER_ID = userId;
        modelUser = new DefaultTableModel();
        tblViewUsers.setModel(modelUser);
        modelUser.addColumn("Id");
        modelUser.addColumn("Nama Lengkap");
        modelUser.addColumn("Jabatan");
        modelUser.addColumn("Email");
        tblViewUsers.getColumnModel().getColumn(0).setPreferredWidth(5);
        ArrayList<Users> data;
        data = authService.getAllUser();
        if (data != null) {

            for (int i = 0; i < data.toArray().length; i++) {
                Object[] obj = new Object[4];
                obj[0] = data.get(i).getId();
                obj[1] = data.get(i).getFullName();
                obj[2] = data.get(i).getRoleEntity().getName();
                obj[3] = data.get(i).getEmail();
                modelUser.addRow(obj);
            }

        }

        modelTickets = new DefaultTableModel();
        tblViewTickets.setModel(modelTickets);
        modelTickets.addColumn("Id");
        modelTickets.addColumn("Receive Date");
        modelTickets.addColumn("From User");
        modelTickets.addColumn("Title");
        tblViewTickets.getColumnModel().getColumn(0).setPreferredWidth(5);
        ArrayList<Tickets> ticketsData;
        ticketsData = authService.getTicketsByRoleId(1);
        if (ticketsData != null) {

            for (int i = 0; i < ticketsData.toArray().length; i++) {
                // Parse DateFormat
                SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, hh:mm");
                Object[] obj = new Object[4];

                obj[0] = ticketsData.get(i).getId();
                obj[1] = formatter.format(ticketsData.get(i).getTimestamp());
                obj[2] = ticketsData.get(i).getFullName();
                obj[3] = ticketsData.get(i).getTicket();
                modelTickets.addRow(obj);
            }

        }
    }

    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewUsers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblViewTickets = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFillterName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuChangePassword = new javax.swing.JMenuItem();
        jMenuSignOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnInsert.setBackground(new java.awt.Color(153, 169, 193));
        btnInsert.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(153, 169, 193));
        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 169, 193));
        btnDelete.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblViewUsers.setAutoCreateRowSorter(true);
        tblViewUsers.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tblViewUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        tblViewUsers.setCellSelectionEnabled(true);
        tblViewUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblViewUsers.setShowGrid(true);
        tblViewUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblViewUsers);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Tickets");

        tblViewTickets.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblViewTickets);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("All Users");

        txtFillterName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFillterNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFillterNameFocusLost(evt);
            }
        });
        txtFillterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFillterNameActionPerformed(evt);
            }
        });
        txtFillterName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFillterNamePropertyChange(evt);
            }
        });
        txtFillterName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFillterNameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Find By Name");

        jMenu2.setText("Profile");

        jMenuChangePassword.setText("Change Password");
        jMenuChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuChangePasswordActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuChangePassword);

        jMenuSignOut.setText("Sign Out");
        jMenuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSignOutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuSignOut);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(txtFillterName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFillterName)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        this.dispose();
        new UsersIUScreen(USER_ID, 0).setVisible(true);

    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedUserId != 0) {
            this.dispose();
            new UsersIUScreen(USER_ID, selectedUserId).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Oops! Mohon Pilih User Terlebih Dahulu !");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        modelUser.removeRow(tblViewUsers.getSelectedRow());
        authService.deleteUser(selectedUserId);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblViewUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewUsersMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblViewUsers.getSelectedRow();
            String tableClick = (tblViewUsers.getModel().getValueAt(row, 0).toString());

            selectedUserId = Integer.parseInt(tableClick);

        } catch (NumberFormatException e) {
            System.out.println("[tblViewUsersMouseClicked] ERROR : " + e);

        }
    }//GEN-LAST:event_tblViewUsersMouseClicked

    private void jMenuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSignOutActionPerformed
        this.dispose();
        new SignInScreen().setVisible(true);
    }//GEN-LAST:event_jMenuSignOutActionPerformed

    private void jMenuChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuChangePasswordActionPerformed
        this.dispose();
        new UpdatePasswordScreen(USER_ID).setVisible(true);
    }//GEN-LAST:event_jMenuChangePasswordActionPerformed

    private void txtFillterNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFillterNameFocusGained
        _fillterUser();
    }//GEN-LAST:event_txtFillterNameFocusGained

    private void txtFillterNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFillterNameFocusLost
        _fillterUser();
    }//GEN-LAST:event_txtFillterNameFocusLost

    private void txtFillterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFillterNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFillterNameActionPerformed

    private void txtFillterNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFillterNameKeyPressed
        _fillterUser();
    }//GEN-LAST:event_txtFillterNameKeyPressed

    private void txtFillterNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFillterNamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFillterNamePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdministratorScreen(USER_ID).setVisible(true);
        });
    }

    private void _fillterUser() {

        DefaultTableModel _tempUserModel = modelUser;
        ArrayList<Users> data;
        data = authService.getAllUser();
        if (txtFillterName.getText().trim().length() != 0) {
            data = authService.getUserByName(txtFillterName.getText());

        }

        for (int i = tblViewUsers.getRowCount() - 1; i >= 0; i--) {
            modelUser.removeRow(i);
        }
        tblViewUsers.removeAll();

        if (data != null) {

            for (int i = 0; i < data.toArray().length; i++) {
                Object[] obj = new Object[4];
                obj[0] = data.get(i).getId();
                obj[1] = data.get(i).getFullName();
                obj[2] = data.get(i).getRoleEntity().getName();
                obj[3] = data.get(i).getEmail();
                modelUser.addRow(obj);
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuChangePassword;
    private javax.swing.JMenuItem jMenuSignOut;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblViewTickets;
    private javax.swing.JTable tblViewUsers;
    private javax.swing.JTextField txtFillterName;
    // End of variables declaration//GEN-END:variables
}
