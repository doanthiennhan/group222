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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setLayout(null);

        staffToggleButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        staffToggleButton.setText("Staff");
        staffToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffToggleButtonActionPerformed(evt);
            }
        });
        add(staffToggleButton);
        staffToggleButton.setBounds(308, 30, 85, 26);

        adminToggleButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adminToggleButton.setText("Admin");
        adminToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminToggleButtonActionPerformed(evt);
            }
        });
        add(adminToggleButton);
        adminToggleButton.setBounds(204, 30, 92, 25);

        LoginLable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LoginLable.setForeground(new java.awt.Color(255, 255, 51));
        LoginLable.setText("Đăng nhập với tư cách");
        add(LoginLable);
        LoginLable.setBounds(14, 29, 172, 23);

        passwordLable.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        passwordLable.setForeground(new java.awt.Color(255, 255, 0));
        passwordLable.setText("Mật khẩu");
        add(passwordLable);
        passwordLable.setBounds(72, 155, 70, 25);

        userNameField.setBackground(new java.awt.Color(153, 255, 255));
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        add(userNameField);
        userNameField.setBounds(195, 94, 129, 25);

        passwordField.setBackground(new java.awt.Color(153, 255, 255));
        add(passwordField);
        passwordField.setBounds(195, 155, 129, 25);

        userNameLable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userNameLable.setForeground(new java.awt.Color(255, 255, 0));
        userNameLable.setText("Tên đăng nhập");
        add(userNameLable);
        userNameLable.setBounds(72, 94, 91, 25);

        LoginButton.setText("Đăng nhập");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        add(LoginButton);
        LoginButton.setBounds(34, 227, 100, 23);

        ForgetPasswordButton.setText("Quên Mật khẩu");
        ForgetPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgetPasswordButtonActionPerformed(evt);
            }
        });
        add(ForgetPasswordButton);
        ForgetPasswordButton.setBounds(158, 227, 130, 23);

        ExitButton.setText("Thoát");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        add(ExitButton);
        ExitButton.setBounds(309, 227, 72, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hinh-nen-gaming-48.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -70, 400, 420);

        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(30, 130, 37, 16);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JToggleButton staffToggleButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLable;
    // End of variables declaration//GEN-END:variables
}
