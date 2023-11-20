/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package group2.LoginVsLogout;

import UserInterFace.AccountControl;
import UserInterFace.UI_StaffvsAD;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ADMIN
 */
public class LoginAdminStaff extends javax.swing.JPanel {

    AccountControl accoutControl;
    private UI_StaffvsAD bangdieukhien;
    public String table="";
    private void showBangDieuKhien(){
        bangdieukhien = new UI_StaffvsAD();
        bangdieukhien.setVisible(true);
        // Đóng cửa sổ đăng nhập nếu cần thiết
        SwingUtilities.getWindowAncestor(this).dispose();
    }
    public LoginAdminStaff() {
        initComponents();
        accoutControl =new AccountControl();
    }

    public static void main(String[] args) {
        // Create and display the form
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdminStaff().setVisible(true);
            }
        });
       javax.swing.JFrame frame = new javax.swing.JFrame("Đăng nhập");

        // Create an instance of dangnhap panel
        LoginAdminStaff loginPanel = new LoginAdminStaff();

        // Add the panel to the frame's content pane
        frame.getContentPane().add(loginPanel);

        // Set default close operation and pack the frame
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();

        // Set the frame to be visible
        frame.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staffToggleButton = new javax.swing.JToggleButton();
        adminToggleButton = new javax.swing.JToggleButton();
        LoginLable = new javax.swing.JLabel();
        passwordLable = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        userNameLable = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        ForgetPasswordButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        staffToggleButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        staffToggleButton.setText("Staff");
        staffToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffToggleButtonActionPerformed(evt);
            }
        });

        adminToggleButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adminToggleButton.setText("Admin");
        adminToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminToggleButtonActionPerformed(evt);
            }
        });

        LoginLable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LoginLable.setText("Đăng nhập với tư cách");

        passwordLable.setText("Mật khẩu");

        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        userNameLable.setText("Tên đăng nhập");

        LoginButton.setText("Đăng nhập");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        ForgetPasswordButton.setText("Quên Mật khẩu");
        ForgetPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgetPasswordButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Thoát");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(LoginLable)
                        .addGap(18, 18, 18)
                        .addComponent(adminToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(staffToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLable, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(LoginButton)
                        .addGap(32, 32, 32)
                        .addComponent(ForgetPasswordButton)
                        .addGap(33, 33, 33)
                        .addComponent(ExitButton)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginLable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(ForgetPasswordButton)
                    .addComponent(ExitButton))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void adminToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminToggleButtonActionPerformed
        if (adminToggleButton.isSelected()) {
            staffToggleButton.setSelected(false);
        }
    }//GEN-LAST:event_adminToggleButtonActionPerformed

    private void staffToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffToggleButtonActionPerformed
        if (staffToggleButton.isSelected()) {
            adminToggleButton.setSelected(false);
        }
    }//GEN-LAST:event_staffToggleButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ForgetPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgetPasswordButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgetPasswordButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String username = userNameField.getText().trim();
        String password = passwordField.getText().trim();
        
        if(adminToggleButton.isSelected()){
            table="admin";
        }
        if (staffToggleButton.isSelected()) {
            table="staff";
        }
        if(table.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn tư cách đăng nhập");
            return;
        }
        if (!username.equals("") && !password.equals("")) {
            Boolean check = accoutControl.loginaADStaff(username, password, table);
            if (check == true) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                showBangDieuKhien();
            } else {
                JOptionPane.showConfirmDialog(this, "username hoặc password không đúng", "lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showConfirmDialog(this, "username hoặc password chưa nhập", "lỗi", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_LoginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ForgetPasswordButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLable;
    private javax.swing.JToggleButton adminToggleButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JToggleButton staffToggleButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLable;
    // End of variables declaration//GEN-END:variables
}
