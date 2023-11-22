/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterFace;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author ADMIN
 */
public class PnTaiKhoan extends javax.swing.JPanel {

    private final String url = "jdbc:mysql://localhost:3306/managercenntergaming";
    private final String user = "root";
    private final String password = "Nhan2792003@";

    public PnTaiKhoan() {
        initComponents();
    }

    void displayDataFromDatabase() {
        int dem = 1;
        try ( Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT kh.username, kh.remaining_amount, kh.GhiChu "
                    + "FROM customers kh ";

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                try ( ResultSet resultSet = statement.executeQuery()) {
                    DefaultTableModel model = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        // Chỉ cho phép sửa cột "Ghi Chú" (cột 3)
                        return column == 3;
                    }
                    };
                    model.addColumn("stt");
                    model.addColumn("tên tài khoản");
                    model.addColumn("số tiền còn lại ");
                    model.addColumn("Ghi Chú");
                    JTable table = new JTable(model);

                    // Add more columns as needed
                    while (resultSet.next()) {
                        String column1Value = String.valueOf(dem++);
                        String column2Value = resultSet.getString("username");
                        String column3Value = resultSet.getString("remaining_amount");
                        String column4Value = resultSet.getString("GhiChu");

                        model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value});
                    }
                    TableTaiKhoan.setEnabled(true);
                    TableTaiKhoan.setModel(model);

// Tính toán tỷ lệ cho từng cột
                    int columnCount = TableTaiKhoan.getColumnCount();
                    int[] columnWidths = new int[columnCount];

                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = TableTaiKhoan.getColumnModel().getColumn(i);
                        int maxWidth = 0;

                        // Lặp qua từng dòng và tính toán độ dài lớn nhất của cột
                        for (int j = 0; j < TableTaiKhoan.getRowCount(); j++) {
                            TableCellRenderer cellRenderer = TableTaiKhoan.getCellRenderer(j, i);
                            Object value = TableTaiKhoan.getValueAt(j, i);
                            Component cellComponent = cellRenderer.getTableCellRendererComponent(TableTaiKhoan, value, false, false, j, i);
                            maxWidth = Math.max(maxWidth, cellComponent.getPreferredSize().width);
                        }

                        // Gán kích thước ước lượng của cột
                        columnWidths[i] = maxWidth;
                    }

// Tính tỷ lệ dựa trên tổng kích thước của JTable
                    int totalWidth = TableTaiKhoan.getWidth();

// Gán kích thước ước lượng cho từng cột với tỷ lệ phù hợp
                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = TableTaiKhoan.getColumnModel().getColumn(i);
                        int columnWidth = (int) ((double) columnWidths[i] / totalWidth * totalWidth);
                        column.setPreferredWidth(columnWidth);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isUsernameExists(String taiKhoan) {
        // Thực hiện truy vấn kiểm tra xem tên đăng nhập đã tồn tại trong cơ sở dữ liệu chưa
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT COUNT(*) FROM customers WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, taiKhoan);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            // Đóng kết nối
            resultSet.close();
            preparedStatement.close();
            connection.close();

            // Nếu count > 0, tên đăng nhập đã tồn tại
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu");
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            // Chuyển đổi chuỗi thành số nguyên
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // Nếu không thể chuyển đổi thành số nguyên, trả về false
            return false;
        }
    }

    private void createAccount() {
        String taiKhoan = TFnhapTaiKhoan.getText();
        String matKhau = TFnhapMatKhau.getText();
        String nhapLaiMK = TFnhapLạiMK.getText();
        String soDienThoai = TFnhapSDT.getText();
        String soTienNap = TFnhapSoTien.getText();
        if ((!matKhau.equals("") && !taiKhoan.equals("") && !nhapLaiMK.equals("") && !soDienThoai.equals("") && !soTienNap.equals("")) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            return;
        }
        // Kiểm tra xem mật khẩu và nhập lại mật khẩu có khớp không
        if (!matKhau.equals(nhapLaiMK)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và nhập lại mật khẩu không khớp");
            return;
        }
        if ((isInteger(soDienThoai) && isInteger(soTienNap)) == false) {
            JOptionPane.showMessageDialog(this, "nhập sai số điện thoại hoặc số tiền nạp");
            return;
        }
        if (isUsernameExists(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại");
            return;
        }

        // Kết nối đến cơ sở dữ liệu và thêm thông tin tài khoản
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO customers (username, password, phone_number, remaining_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, taiKhoan);
            preparedStatement.setString(2, matKhau);
            preparedStatement.setString(3, soDienThoai);
            preparedStatement.setString(4, soTienNap);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công");
                // Thêm mã xử lý thêm tài khoản thành công nếu cần
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tạo tài khoản");
            }

            // Đóng kết nối
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu");
        }
    }

    // Biến instance để lưu trữ ID_khachhang được chọn
   

// Sự kiện chọn hàng cho JTable (đặt nó trong phương thức khởi tạo hoặc nơi khác phù hợp)
// Phương thức xóa khách hàng
    private void deleteSelectedCustomer() {
        int selectedRow = TableTaiKhoan.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedUsername = TableTaiKhoan.getValueAt(selectedRow, 1).toString(); // Giả sử cột "username" là cột đầu tiên

        int Click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này hay không?", "Thông Báo", JOptionPane.YES_NO_OPTION);

        if (Click == JOptionPane.YES_OPTION && selectedUsername != null) {
            try ( Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "DELETE FROM customers WHERE username = ?";

                try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, selectedUsername);

                    int rowsDeleted = statement.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Khách hàng đã được xóa thành công!");
                        // Gọi lại phương thức hiển thị dữ liệu và làm sạch các trường
                        displayDataFromDatabase();
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng để xóa!");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa khách hàng!");
            }
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

        PnTaikhoan = new javax.swing.JPanel();
        cacNuttaikhoan = new javax.swing.JPanel();
        BTxoataikhoan = new javax.swing.JButton();
        BTtatcataikhoan = new javax.swing.JButton();
        BTtaotaikhoan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cacPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tatcataikhoan = new javax.swing.JScrollPane();
        TableTaiKhoan = new javax.swing.JTable();
        Taotaikhoan = new javax.swing.JPanel();
        lableNhapTaiKhoan = new javax.swing.JLabel();
        TFnhapTaiKhoan = new javax.swing.JTextField();
        lableNhapMatKhau = new javax.swing.JLabel();
        TFnhapMatKhau = new javax.swing.JTextField();
        TFnhapLạiMK = new javax.swing.JTextField();
        lableNhapLaiMK = new javax.swing.JLabel();
        TFnhapSDT = new javax.swing.JTextField();
        lableSDT = new javax.swing.JLabel();
        TFnhapSoTien = new javax.swing.JTextField();
        lableSoTienNap = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        TaoTaiKhoan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        cacNuttaikhoan.setPreferredSize(new java.awt.Dimension(1000, 50));
        cacNuttaikhoan.setLayout(null);

        BTxoataikhoan.setBackground(new java.awt.Color(204, 255, 255));
        BTxoataikhoan.setText("Xóa tài khoản");
        BTxoataikhoan.setPreferredSize(new java.awt.Dimension(75, 30));
        BTxoataikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTxoataikhoanActionPerformed(evt);
            }
        });
        cacNuttaikhoan.add(BTxoataikhoan);
        BTxoataikhoan.setBounds(550, 10, 129, 30);

        BTtatcataikhoan.setBackground(new java.awt.Color(204, 255, 255));
        BTtatcataikhoan.setText("Tất cả tài khoản");
        BTtatcataikhoan.setPreferredSize(new java.awt.Dimension(75, 30));
        BTtatcataikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTtatcataikhoanActionPerformed(evt);
            }
        });
        cacNuttaikhoan.add(BTtatcataikhoan);
        BTtatcataikhoan.setBounds(240, 10, 128, 31);

        BTtaotaikhoan.setBackground(new java.awt.Color(204, 255, 255));
        BTtaotaikhoan.setText("Tạo tài khoản");
        BTtaotaikhoan.setPreferredSize(new java.awt.Dimension(75, 30));
        BTtaotaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTtaotaikhoanActionPerformed(evt);
            }
        });
        cacNuttaikhoan.add(BTtaotaikhoan);
        BTtaotaikhoan.setBounds(390, 10, 128, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/anh2.gif"))); // NOI18N
        cacNuttaikhoan.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 50);

        cacPanel.setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(null);

        tatcataikhoan.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tatcataikhoan.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tatcataikhoan.setPreferredSize(new java.awt.Dimension(1000, 470));

        TableTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tatcataikhoan.setViewportView(TableTaiKhoan);

        jPanel1.add(tatcataikhoan);
        tatcataikhoan.setBounds(30, 30, 960, 400);

        cacPanel.add(jPanel1, "card4");

        Taotaikhoan.setLayout(null);

        lableNhapTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lableNhapTaiKhoan.setForeground(new java.awt.Color(255, 255, 0));
        lableNhapTaiKhoan.setText("Nhập tài khoản");
        Taotaikhoan.add(lableNhapTaiKhoan);
        lableNhapTaiKhoan.setBounds(270, 120, 130, 20);

        TFnhapTaiKhoan.setBackground(new java.awt.Color(153, 255, 255));
        TFnhapTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFnhapTaiKhoanActionPerformed(evt);
            }
        });
        Taotaikhoan.add(TFnhapTaiKhoan);
        TFnhapTaiKhoan.setBounds(430, 110, 250, 30);

        lableNhapMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lableNhapMatKhau.setForeground(new java.awt.Color(255, 255, 0));
        lableNhapMatKhau.setText("Nhập mật khẩu");
        Taotaikhoan.add(lableNhapMatKhau);
        lableNhapMatKhau.setBounds(270, 160, 130, 20);

        TFnhapMatKhau.setBackground(new java.awt.Color(153, 255, 255));
        Taotaikhoan.add(TFnhapMatKhau);
        TFnhapMatKhau.setBounds(430, 150, 250, 30);

        TFnhapLạiMK.setBackground(new java.awt.Color(153, 255, 255));
        Taotaikhoan.add(TFnhapLạiMK);
        TFnhapLạiMK.setBounds(430, 190, 250, 30);

        lableNhapLaiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lableNhapLaiMK.setForeground(new java.awt.Color(255, 255, 0));
        lableNhapLaiMK.setText("Nhập lại mật khẩu");
        Taotaikhoan.add(lableNhapLaiMK);
        lableNhapLaiMK.setBounds(270, 200, 130, 22);

        TFnhapSDT.setBackground(new java.awt.Color(153, 255, 255));
        Taotaikhoan.add(TFnhapSDT);
        TFnhapSDT.setBounds(430, 230, 250, 30);

        lableSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lableSDT.setForeground(new java.awt.Color(255, 255, 0));
        lableSDT.setText("Số điện thoại");
        Taotaikhoan.add(lableSDT);
        lableSDT.setBounds(270, 240, 130, 20);

        TFnhapSoTien.setBackground(new java.awt.Color(153, 255, 255));
        Taotaikhoan.add(TFnhapSoTien);
        TFnhapSoTien.setBounds(430, 270, 250, 30);

        lableSoTienNap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lableSoTienNap.setForeground(new java.awt.Color(255, 255, 0));
        lableSoTienNap.setText("Số tiền nạp");
        Taotaikhoan.add(lableSoTienNap);
        lableSoTienNap.setBounds(270, 280, 130, 20);

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Nhập lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Taotaikhoan.add(jButton4);
        jButton4.setBounds(570, 320, 110, 30);

        TaoTaiKhoan.setBackground(new java.awt.Color(0, 153, 255));
        TaoTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaoTaiKhoan.setText("Xác nhận");
        TaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoTaiKhoanActionPerformed(evt);
            }
        });
        Taotaikhoan.add(TaoTaiKhoan);
        TaoTaiKhoan.setBounds(430, 320, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/anh3.gif"))); // NOI18N
        Taotaikhoan.add(jLabel2);
        jLabel2.setBounds(0, 0, 1006, 475);

        cacPanel.add(Taotaikhoan, "card3");

        javax.swing.GroupLayout PnTaikhoanLayout = new javax.swing.GroupLayout(PnTaikhoan);
        PnTaikhoan.setLayout(PnTaikhoanLayout);
        PnTaikhoanLayout.setHorizontalGroup(
            PnTaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTaikhoanLayout.createSequentialGroup()
                .addComponent(cacNuttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PnTaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(cacPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE))
        );
        PnTaikhoanLayout.setVerticalGroup(
            PnTaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTaikhoanLayout.createSequentialGroup()
                .addComponent(cacNuttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
            .addGroup(PnTaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTaikhoanLayout.createSequentialGroup()
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addComponent(cacPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTxoataikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTxoataikhoanActionPerformed
        deleteSelectedCustomer();
    }//GEN-LAST:event_BTxoataikhoanActionPerformed

    private void BTtatcataikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTtatcataikhoanActionPerformed
        cacPanel.removeAll();
        cacPanel.add(tatcataikhoan);
        cacPanel.revalidate();
        cacPanel.repaint();
    }//GEN-LAST:event_BTtatcataikhoanActionPerformed

    private void BTtaotaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTtaotaikhoanActionPerformed
        cacPanel.removeAll();
        cacPanel.add(Taotaikhoan);
        cacPanel.revalidate();
        cacPanel.repaint();
    }//GEN-LAST:event_BTtaotaikhoanActionPerformed

    private void TaoTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoTaiKhoanActionPerformed
        createAccount();
    }//GEN-LAST:event_TaoTaiKhoanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TFnhapTaiKhoan.setText("");
        TFnhapMatKhau.setText("");
        TFnhapSDT.setText("");
        TFnhapSoTien.setText("");
        TFnhapLạiMK.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TFnhapTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFnhapTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFnhapTaiKhoanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTtaotaikhoan;
    private javax.swing.JButton BTtatcataikhoan;
    private javax.swing.JButton BTxoataikhoan;
    private javax.swing.JPanel PnTaikhoan;
    private javax.swing.JTextField TFnhapLạiMK;
    private javax.swing.JTextField TFnhapMatKhau;
    private javax.swing.JTextField TFnhapSDT;
    private javax.swing.JTextField TFnhapSoTien;
    private javax.swing.JTextField TFnhapTaiKhoan;
    private javax.swing.JTable TableTaiKhoan;
    private javax.swing.JButton TaoTaiKhoan;
    private javax.swing.JPanel Taotaikhoan;
    private javax.swing.JPanel cacNuttaikhoan;
    private javax.swing.JPanel cacPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lableNhapLaiMK;
    private javax.swing.JLabel lableNhapMatKhau;
    private javax.swing.JLabel lableNhapTaiKhoan;
    private javax.swing.JLabel lableSDT;
    private javax.swing.JLabel lableSoTienNap;
    private javax.swing.JScrollPane tatcataikhoan;
    // End of variables declaration//GEN-END:variables
}
