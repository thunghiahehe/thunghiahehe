package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import model.Account;
import sevice.AccountService;

public class QMK extends javax.swing.JFrame {

    private AccountService service = new AccountService();

    public QMK() {
        initComponents();
        setLocationRelativeTo(null);
        labelLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelLogin.setText("<html><u><font color='000080'>Login</font></u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelLogin.setText("<html>Login</html>");
            }
        });

        txtUserNameCreate.setBackground(new Color(0, 0, 0, 1));
        txtEmailCreate.setBackground(new Color(0, 0, 0, 1));
        txtPassWordCreate.setBackground(new Color(0, 0, 0, 1));
        txtRePasswordCreate.setBackground(new Color(0, 0, 0, 1));
    }

    private Account getToForm() {
        String user = txtUserNameCreate.getText();
        String gmail = txtEmailCreate.getText();
        String pass = txtPassWordCreate.getText();
        String repass = txtRePasswordCreate.getText();
        if (user.isBlank() || gmail.isBlank() || pass.isBlank() || repass.isBlank()) {
            JOptionPane.showMessageDialog(this, "Các ô không được để trống");
            return null;
        }
        String kt = "[^@]{2,64}@[^.]{2,253}\\.[0-9a-z-.]{2,63}";
        if(!gmail.matches(kt)){
            JOptionPane.showMessageDialog(this, "Gmail không đúng định dạng");
            return null;
        }
        if (pass.equals(repass) == false) {
            JOptionPane.showMessageDialog(this, "Password và Repasswword phải trùng nhau");
            return null;
        }
        return new Account(user, gmail, pass);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        Jlable8 = new javax.swing.JLabel();
        btnChange = new javax.swing.JButton();
        txtEmailCreate = new javax.swing.JTextField();
        txtRePasswordCreate = new javax.swing.JPasswordField();
        disible = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUserNameCreate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPassWordCreate = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/71.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("x");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanel2.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 30, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Change The Password");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 470, 36));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("We will help you change your account!");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 470, 24));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 430, 22));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("      ___________________________________________________________________________");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 394, 20));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        labelLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText("Login");
        labelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLoginMouseClicked(evt);
            }
        });
        jPanel2.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 70, 22));

        Jlable8.setForeground(new java.awt.Color(255, 255, 255));
        Jlable8.setText("      ___________________________________________________________________________");
        jPanel2.add(Jlable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 394, 20));

        btnChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChange.setForeground(new java.awt.Color(0, 102, 255));
        btnChange.setText("CHANGE");
        btnChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        jPanel2.add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 209, 35));

        txtEmailCreate.setFont(txtEmailCreate.getFont().deriveFont(txtEmailCreate.getFont().getSize()+2f));
        txtEmailCreate.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailCreate.setBorder(null);
        jPanel2.add(txtEmailCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 360, 30));

        txtRePasswordCreate.setFont(txtRePasswordCreate.getFont().deriveFont(txtRePasswordCreate.getFont().getSize()+2f));
        txtRePasswordCreate.setForeground(new java.awt.Color(255, 255, 255));
        txtRePasswordCreate.setBorder(null);
        jPanel2.add(txtRePasswordCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 360, 30));

        disible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disibleMouseClicked(evt);
            }
        });
        jPanel2.add(disible, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("     Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 450, 22));

        txtUserNameCreate.setFont(txtUserNameCreate.getFont().deriveFont(txtUserNameCreate.getFont().getSize()+2f));
        txtUserNameCreate.setForeground(new java.awt.Color(255, 255, 255));
        txtUserNameCreate.setBorder(null);
        jPanel2.add(txtUserNameCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 360, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("      ___________________________________________________________________________");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 394, 20));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("    Confirm New Password");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 280, 440, 22));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sign Up");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 80, 22));

        txtPassWordCreate.setFont(txtPassWordCreate.getFont().deriveFont(txtPassWordCreate.getFont().getSize()+2f));
        txtPassWordCreate.setForeground(new java.awt.Color(255, 255, 255));
        txtPassWordCreate.setBorder(null);
        txtPassWordCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordCreateActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassWordCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 360, 30));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("     New Password");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 443, 22));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("      ___________________________________________________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 394, 26));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1064, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void labelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLoginMouseClicked
        // TODO add your handling code here:
        DN loginFrame = new DN();
        loginFrame.setVisible(true);
        loginFrame.pack();
        this.dispose();
        loginFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_labelLoginMouseClicked

    private void disibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disibleMouseClicked
        // TODO add your handling code here:
        txtRePasswordCreate.setEchoChar((char) 0);
        disible.setVisible(false);
        disible.setVisible(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disibleMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        // TODO add your handling code here:
        txtRePasswordCreate.setEchoChar((char) 8226);
        disible.setVisible(true);
        disible.setVisible(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void txtPassWordCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordCreateActionPerformed

    }//GEN-LAST:event_txtPassWordCreateActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        List<Account> list = service.getAll();
        for (Account o : list) {
            if (o.getGmail().equals(txtEmailCreate.getText())) {
                if (getToForm() == null) {
                    JOptionPane.showMessageDialog(this, "Thay đổi thất bại");
                } else {
                    service.update(getToForm());
                    JOptionPane.showMessageDialog(this, "Thay đổi thành công", "ĐỀ XUẤT", 2);
                    int check = JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN ĐĂNG NHẬP KHÔNG?");
                    if (check == JOptionPane.YES_OPTION) {
                        DN dn = new DN();
                        dn.setVisible(true);
                        this.dispose();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        DK view = new DK();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(QMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QMK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlable8;
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel disible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel show;
    private javax.swing.JTextField txtEmailCreate;
    private javax.swing.JPasswordField txtPassWordCreate;
    private javax.swing.JPasswordField txtRePasswordCreate;
    private javax.swing.JTextField txtUserNameCreate;
    // End of variables declaration//GEN-END:variables
}
