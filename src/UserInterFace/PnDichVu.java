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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author ADMIN
 */
public class PnDichVu extends javax.swing.JPanel {

    private final String url = "jdbc:mysql://localhost:3306/managercenntergaming";
    private final String user = "root";
    private final String password = "Nhan2792003@";
    public PnDichVu() {
        initComponents();
    }
    void displayDataFromDatabase() {
        int dem = 1;
        try ( Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT kh.username, kh.remaining_amount, kh.GhiChu "
                    + "FROM customers kh ";

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                try ( ResultSet resultSet = statement.executeQuery()) {
                    DefaultTableModel model = new DefaultTableModel();
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

                    TBDichvu.setModel(model);

// Tính toán tỷ lệ cho từng cột
                    int columnCount = TBDichvu.getColumnCount();
                    int[] columnWidths = new int[columnCount];

                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = TBDichvu.getColumnModel().getColumn(i);
                        int maxWidth = 0;

                        // Lặp qua từng dòng và tính toán độ dài lớn nhất của cột
                        for (int j = 0; j < TBDichvu.getRowCount(); j++) {
                            TableCellRenderer cellRenderer = TBDichvu.getCellRenderer(j, i);
                            Object value = TBDichvu.getValueAt(j, i);
                            Component cellComponent = cellRenderer.getTableCellRendererComponent(TBDichvu, value, false, false, j, i);
                            maxWidth = Math.max(maxWidth, cellComponent.getPreferredSize().width);
                        }

                        // Gán kích thước ước lượng của cột
                        columnWidths[i] = maxWidth;
                    }

// Tính tỷ lệ dựa trên tổng kích thước của JTable
                    int totalWidth = TBDichvu.getWidth();

// Gán kích thước ước lượng cho từng cột với tỷ lệ phù hợp
                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = TBDichvu.getColumnModel().getColumn(i);
                        int columnWidth = (int) ((double) columnWidths[i] / totalWidth * totalWidth);
                        column.setPreferredWidth(columnWidth);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        PnDichvu = new javax.swing.JPanel();
        nutDichvu = new javax.swing.JPanel();
        BTmenu = new javax.swing.JButton();
        BTxoa = new javax.swing.JButton();
        BTthem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDichvu = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 520));

        nutDichvu.setPreferredSize(new java.awt.Dimension(1000, 50));
        nutDichvu.setLayout(null);

        BTmenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTmenu.setText("Menu");
        BTmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmenuActionPerformed(evt);
            }
        });
        nutDichvu.add(BTmenu);
        BTmenu.setBounds(20, 10, 140, 27);

        BTxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTxoa.setText("Xóa");
        nutDichvu.add(BTxoa);
        BTxoa.setBounds(320, 10, 140, 27);

        BTthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTthem.setText("Thêm");
        nutDichvu.add(BTthem);
        BTthem.setBounds(170, 10, 140, 27);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 470));
        jPanel1.setLayout(new java.awt.CardLayout());

        TBDichvu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TBDichvu);

        jPanel1.add(jScrollPane1, "card2");

        javax.swing.GroupLayout PnDichvuLayout = new javax.swing.GroupLayout(PnDichvu);
        PnDichvu.setLayout(PnDichvuLayout);
        PnDichvuLayout.setHorizontalGroup(
            PnDichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnDichvuLayout.createSequentialGroup()
                .addGroup(PnDichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nutDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnDichvuLayout.setVerticalGroup(
            PnDichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnDichvuLayout.createSequentialGroup()
                .addComponent(nutDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PnDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmenuActionPerformed
        displayDataFromDatabase();
    }//GEN-LAST:event_BTmenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTmenu;
    private javax.swing.JButton BTthem;
    private javax.swing.JButton BTxoa;
    private javax.swing.JPanel PnDichvu;
    private javax.swing.JTable TBDichvu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nutDichvu;
    // End of variables declaration//GEN-END:variables
}
