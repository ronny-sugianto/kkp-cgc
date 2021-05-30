/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.sales;

import core.models.Inventory;
import core.services.InventoryService;
import core.services.SalesService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import screens.SignInScreen;
import screens.administrator.AdministratorScreen;

/**
 *
 * @author ronny
 */
public class SalesScreen extends javax.swing.JFrame {

    private DefaultTableModel modelSales;
    private static int USER_ID;
    int selectedId = 999999999;
    int totBeli = 0;
    InventoryService inventoryService = new InventoryService();
    ArrayList<Integer> kodeBarang = new ArrayList<>();

    /**
     * Creates new form SalesScreen
     */
    public SalesScreen(int userId) {
        initComponents();
        setLocationRelativeTo(null);
        USER_ID = userId;
        modelSales = new DefaultTableModel();
        tblViewSales.setModel(modelSales);
        modelSales.addColumn("Nama Barang");
        modelSales.addColumn("Harga Barang");
        modelSales.addColumn("Jumlah Beli");
        modelSales.addColumn("Total Beli");
        tblViewSales.getColumnModel().getColumn(2).setPreferredWidth(5);
        if (selectedId != 999999999) {
            btnHapus.setEnabled(true);
        } else {
            btnHapus.setEnabled(false);
        }
        if (modelSales.getRowCount() > 0) {
            btnTransaksikan.setEnabled(true);
        } else {
            btnTransaksikan.setEnabled(false);
        }

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
        tblViewSales = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtKodeBarang = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtJumlah = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        lblTotBel = new javax.swing.JLabel();
        lblAmontTotBel = new javax.swing.JLabel();
        jPanel_left_second = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        btnHapus = new javax.swing.JButton();
        btnTransaksikan = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menus = new javax.swing.JMenu();
        menuReport = new javax.swing.JMenuItem();
        menuSignOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblViewSales.setModel(new javax.swing.table.DefaultTableModel(
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
        tblViewSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewSalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewSales);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtKodeBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKodeBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKodeBarangFocusLost(evt);
            }
        });
        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });
        txtKodeBarang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtKodeBarangPropertyChange(evt);
            }
        });
        txtKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeBarangKeyPressed(evt);
            }
        });

        txtJumlah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJumlahFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJumlahFocusLost(evt);
            }
        });
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        txtJumlah.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtJumlahPropertyChange(evt);
            }
        });
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });

        lblJumlah.setText("Jumlah");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        lblTotBel.setText("Total Pembelian");

        lblAmontTotBel.setFont(new java.awt.Font("Lucida Grande", 2, 18)); // NOI18N
        lblAmontTotBel.setText("Rp. 0");

        jPanel_left_second.setBackground(new java.awt.Color(255, 255, 255));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_left_secondLayout = new javax.swing.GroupLayout(jPanel_left_second);
        jPanel_left_second.setLayout(jPanel_left_secondLayout);
        jPanel_left_secondLayout.setHorizontalGroup(
            jPanel_left_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_left_secondLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_left_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_left_secondLayout.setVerticalGroup(
            jPanel_left_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_left_secondLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnTransaksikan.setText("Transaksikan");
        btnTransaksikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel_left_second, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKodeBarang)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJumlah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnTransaksikan, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotBel)
                                    .addComponent(lblAmontTotBel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJumlah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_left_second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransaksikan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotBel)
                .addGap(2, 2, 2)
                .addComponent(lblAmontTotBel)
                .addGap(5, 5, 5))
        );

        menus.setText("Akun");

        menuReport.setText("Cetak Laporan Hari Ini");
        menuReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportActionPerformed(evt);
            }
        });
        menus.add(menuReport);

        menuSignOut.setText("Keluar");
        menuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSignOutActionPerformed(evt);
            }
        });
        menus.add(menuSignOut);

        jMenuBar1.add(menus);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKodeBarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangFocusGained

    private void txtKodeBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKodeBarangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangFocusLost

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void txtKodeBarangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtKodeBarangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangPropertyChange

    private void txtKodeBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBarangKeyPressed
        txtKodeBarang.setEditable((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || (evt.getKeyCode() == 8 || evt.getKeyCode() == 127));
    }//GEN-LAST:event_txtKodeBarangKeyPressed

    private void txtJumlahFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJumlahFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahFocusGained

    private void txtJumlahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJumlahFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahFocusLost

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtJumlahPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtJumlahPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahPropertyChange

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        txtJumlah.setEditable((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || (evt.getKeyCode() == 8 || evt.getKeyCode() == 127));        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void menuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSignOutActionPerformed
        this.dispose();
        new SignInScreen().setVisible(true);
    }//GEN-LAST:event_menuSignOutActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed

        if (txtKodeBarang.getText().trim().length() != 0 && txtJumlah.getText().trim().length() != 0) {
            Inventory inv = inventoryService.getById(Integer.parseInt(txtKodeBarang.getText()));

            if (inv != null && inv.getName() != null) {
                System.out.println(inv.getId());
                Object[] obj = new Object[4];
                obj[0] = inv.getName();
                obj[1] = inv.getPrice();
                obj[2] = Integer.parseInt(txtJumlah.getText());
                obj[3] = (inv.getPrice() * Integer.parseInt(txtJumlah.getText()));
                kodeBarang.add(inv.getId());
                modelSales.addRow(obj);

                totBeli += (inv.getPrice() * Integer.parseInt(txtJumlah.getText()));
                lblAmontTotBel.setText("Rp. " + totBeli);

                txtKodeBarang.setText("");
                txtJumlah.setText("");

                if (modelSales.getRowCount() > 0) {
                    btnTransaksikan.setEnabled(true);
                } else {
                    btnTransaksikan.setEnabled(false);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Kode Barang Tidak Ditemukan !");
            }
        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblViewSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSalesMouseClicked
        int row = tblViewSales.getSelectedRow();

        selectedId = row;
        if (selectedId != 999999999) {
            btnHapus.setEnabled(true);
        } else {
            btnHapus.setEnabled(false);
        }
    }//GEN-LAST:event_tblViewSalesMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String value = modelSales.getValueAt(selectedId, 3).toString();
        totBeli -= Integer.parseInt(value);
        lblAmontTotBel.setText("Rp. " + totBeli);
        modelSales.removeRow(selectedId);
        selectedId = 999999999;
        if (selectedId != 999999999) {
            btnHapus.setEnabled(true);
        } else {
            btnHapus.setEnabled(false);
        }
        if (modelSales.getRowCount() > 0) {
            btnTransaksikan.setEnabled(true);
        } else {
            btnTransaksikan.setEnabled(false);
        }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTransaksikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksikanActionPerformed
        SalesService salesService = new SalesService();

        int lastId = salesService.insert(totBeli);

        if (lastId != 0) {

            for (int i = 0; i < modelSales.getRowCount(); i++) {
                String valueQty = modelSales.getValueAt(i, 2).toString();
                String valuePrice = modelSales.getValueAt(i, 3).toString();

                inventoryService.updateQtyById(kodeBarang.get(i), Integer.parseInt(valueQty));
                salesService.insertItem(lastId, kodeBarang.get(i), USER_ID, Integer.parseInt(valueQty), Integer.parseInt(valuePrice));
                modelSales.removeRow(i);

            }
            totBeli = 0;
            lblAmontTotBel.setText("Rp. " + totBeli);
            JOptionPane.showMessageDialog(null, "Berhasil Ditransaksikan");
        }

    }//GEN-LAST:event_btnTransaksikanActionPerformed

    private void menuReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportActionPerformed
//        SELECT users.full_name as "Sales Name",inventory.name as "Product Name", transaction_detail.qty as "Qty", transaction_detail.price as "Total Price" FROM transaction_detail INNER JOIN transaction on transaction.id = transaction_detail.transaction_id INNER JOIN inventory ON inventory.id = transaction_detail.inventory_id INNER JOIN users on users.id = transaction_detail.user_id WHERE users.id = transaction_detail.user_id AND transaction.timestamp = ambil hari ini"
<<<<<<< HEAD
        AdministratorScreen obj = new AdministratorScreen();
        HashMap _hash = new HashMap();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
        Date date = new Date();  
        
        _hash.put("today",formatter.format(date));
        _hash.put("USER_ID", USER_ID);
        obj.printOut("ReportSalesScreen.jasper", _hash);
=======
>>>>>>> bfe0b3524a509f1e1b75fa4338e5c0ac6ed4a839

    }//GEN-LAST:event_menuReportActionPerformed

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
            java.util.logging.Logger.getLogger(SalesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalesScreen(USER_ID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTransaksikan;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_left_second;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAmontTotBel;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblTotBel;
    private javax.swing.JMenuItem menuReport;
    private javax.swing.JMenuItem menuSignOut;
    private javax.swing.JMenu menus;
    private javax.swing.JTable tblViewSales;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKodeBarang;
    // End of variables declaration//GEN-END:variables
}
