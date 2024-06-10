/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.RoomBookingDAO;
import dao.ServiceDAO;

import java.text.SimpleDateFormat;
import java.util.List;
import model.RoomBooking;
import model.Service;

/**
 *
 * @author Thang
 */
public class TrackYourRequested extends javax.swing.JFrame {

    private String userID;

    public TrackYourRequested() {
        setTitle("Track Your Requested");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();
        loadRoomBookingTalbe();
        loadRoomServiceTable();
    }

    public TrackYourRequested(String userID) {
        this.userID = userID;
        System.out.println("Track Your Requested: " + userID);

        setTitle("Track Your Requested");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();
        loadRoomBookingTalbe();
        loadRoomServiceTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        UsernameTxt9 = new javax.swing.JLabel();
        UsernameTxt8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomServiceTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomBookingTable = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));

        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        UsernameTxt9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        UsernameTxt9.setForeground(java.awt.Color.red);
        UsernameTxt9.setText("Room Booking");

        UsernameTxt8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        UsernameTxt8.setForeground(java.awt.Color.red);
        UsernameTxt8.setText("Room Service");

        roomServiceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(roomServiceTable);

        roomBookingTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(roomBookingTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(846, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UsernameTxt8)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UsernameTxt9)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(UsernameTxt9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(UsernameTxt8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadRoomBookingTalbe(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        List<RoomBooking> roomBookingList = new RoomBookingDAO().getRoomBookingByGuestID(userID);

        String[][] data = new String[roomBookingList.size()][6];
        for (int i = 0; i < roomBookingList.size(); i++) {
            data[i][0] = String.valueOf(roomBookingList.get(i).getRoomNumber());
            data[i][1] = roomBookingList.get(i).getStartDate().toString();
            data[i][2] = roomBookingList.get(i).getEndDate().toString();
            if (roomBookingList.get(i).getCheckIn() == null) {
                data[i][3] = "Not yet";
            } else {
                data[i][3] = format.format(roomBookingList.get(i).getCheckIn());
            }
            if (roomBookingList.get(i).getCheckOut() == null) {
                data[i][4] = "Not yet";
            } else {
                data[i][4] = format.format(roomBookingList.get(i).getCheckOut());
            }
            data[i][5] = roomBookingList.get(i).getBookingStatus().toString();
        }

        roomBookingTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Room Number", "Start Date", "End Date", "Check In", "Check Out", "Booking Status"
                }
        ));
    }

    private void loadRoomServiceTable(){
        List<Integer> bookingIDList = new RoomBookingDAO().getBookingID(userID);
        List<Service> serviceList = new ServiceDAO().getServiceByBookingID(bookingIDList);

        String[][] data = new String[serviceList.size()][5];
        for (int i = 0; i < serviceList.size(); i++) {
            data[i][0] = serviceList.get(i).getDescription();
            data[i][1] = serviceList.get(i).getIssueAt().toString();
            data[i][2] = String.valueOf(serviceList.get(i).getRoomNumber());
            data[i][3] = serviceList.get(i).getServiceStatus().toString();
            data[i][4] = String.valueOf(serviceList.get(i).getServiceAmount());
        }

        roomServiceTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Description", "Issue At", "Room Number", "Service Status", "Service Amount"
                }
        ));        
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        // if userID starts with "G" then back to DashboardGuest, with "R" then back to DashboardReceptionist, with "M" then back to DashboardManager
        if (userID.startsWith("G")) {
            new DashboardGuest(userID).setVisible(true);
        } else if (userID.startsWith("R")) {
            try {
                new DashboardReceptionist(userID).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userID.startsWith("M")) {
            try {
                new DashboardManager(userID).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TrackYourRequested.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackYourRequested.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackYourRequested.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackYourRequested.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackYourRequested().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsernameTxt8;
    private javax.swing.JLabel UsernameTxt9;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable roomBookingTable;
    private javax.swing.JTable roomServiceTable;
    // End of variables declaration//GEN-END:variables
}
