/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package group2;

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
public class PnMayTram extends javax.swing.JPanel {

    private final String url = "jdbc:mysql://localhost:3306/managercenntergaming";
    private final String user = "root";
    private final String password = "Nhan2792003@";

    public PnMayTram() {
        initComponents();
    }

    void displayDataFromDatabase() {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT m.computer_id, kh.customer_name, kh.remaining_time, m.status, kh.GhiChu " +
                     "FROM computers m " +
                     "JOIN customers kh ON m.computer_id = kh.ID_may";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID Máy");
                model.addColumn("Tên Khách Hàng");
                model.addColumn("Thời Gian Còn Lại");
                model.addColumn("Trạng Thái");
                model.addColumn("Ghi Chú");
                JTable table = new JTable(model);

                // Add more columns as needed
                while (resultSet.next()) {
                    String column1Value = resultSet.getString("computer_id");
                    String column2Value = resultSet.getString("customer_name");
                    String column3Value = resultSet.getString("remaining_time");
                    String column4Value = resultSet.getString("status");
                    String column5Value = resultSet.getString("GhiChu");

                    model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value});
                }

                jTable1.setModel(model);

// Tính toán tỷ lệ cho từng cột
                    int columnCount = jTable1.getColumnCount();
                    int[] columnWidths = new int[columnCount];

                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = jTable1.getColumnModel().getColumn(i);
                        int maxWidth = 0;

                        // Lặp qua từng dòng và tính toán độ dài lớn nhất của cột
                        for (int j = 0; j < jTable1.getRowCount(); j++) {
                            TableCellRenderer cellRenderer = jTable1.getCellRenderer(j, i);
                            Object value = jTable1.getValueAt(j, i);
                            Component cellComponent = cellRenderer.getTableCellRendererComponent(jTable1, value, false, false, j, i);
                            maxWidth = Math.max(maxWidth, cellComponent.getPreferredSize().width);
                        }

                        // Gán kích thước ước lượng của cột
                        columnWidths[i] = maxWidth;
                    }

// Tính tỷ lệ dựa trên tổng kích thước của JTable
                    int totalWidth = jTable1.getWidth();

// Gán kích thước ước lượng cho từng cột với tỷ lệ phù hợp
                    for (int i = 0; i < columnCount; i++) {
                        TableColumn column = jTable1.getColumnModel().getColumn(i);
                        int columnWidth = (int) ((double) columnWidths[i] / totalWidth * totalWidth);
                        column.setPreferredWidth(columnWidth);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                // Create an instance of UI_staff_maytram
//                PnMayTram ui = new PnMayTram();
//
//                // Set the frame title
//                javax.swing.JFrame frame = new javax.swing.JFrame("Máy trạm");
//
//                // Add the panel to the frame's content pane
//                frame.getContentPane().add(ui);
//
//                // Set default close operation and pack the frame
//                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//
//                // Set the frame to be visible
//                frame.setVisible(true);
//
//                // Call the displayDataFromDatabase method after making the frame visible
//                ui.displayDataFromDatabase();
//            }
//        });
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maytrampanel = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        maytrampanel.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(maytrampanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(maytrampanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane maytrampanel;
    // End of variables declaration//GEN-END:variables
}
