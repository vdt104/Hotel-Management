/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import com.rabbitmq.client.*;

import dao.NumberReadRequestDAO;
import dao.RequestDAO;

import javax.swing.*;




/**
 *
 * @author AnMacbook
 */
public class DashboardManager extends javax.swing.JFrame {

    private String userID;

    private Notification notification;

    private static final String EXCHANGE_NAME = "notifications";
    private Channel channel;

    private int numReadRequest = -1;
    private int maxRequest = -1;

    
    public DashboardManager() throws Exception{
        setTitle("Admin Dashboard");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();


        
        notification = new Notification();
        notification.setVisible(false);

        numReadRequest = new NumberReadRequestDAO().getNumberReadRequest(userID);
        System.out.println("numReadRequest: " + numReadRequest);
        maxRequest = new RequestDAO().getLastRequestID();
        System.out.println("maxRequest: " + maxRequest);

        if (maxRequest > numReadRequest) {
            notificationLabel.setVisible(true);
        } else {
            notificationLabel.setVisible(false);
        }

        add(notificationLabel, BorderLayout.SOUTH);
        setupRabbitMQ();
    }

    public DashboardManager(String userID) throws Exception{
        this.userID = userID;
        System.out.println("DashboardManager: " + userID);

        setTitle("Admin Dashboard");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();
        
        notification = new Notification();
        notification.setVisible(false);

        numReadRequest = new NumberReadRequestDAO().getNumberReadRequest(userID);
        System.out.println("numReadRequest: " + numReadRequest);
        maxRequest = new RequestDAO().getLastRequestID();
        System.out.println("maxRequest: " + maxRequest);

        if (maxRequest > numReadRequest) {
            notificationLabel.setVisible(true);
        } else {
            notificationLabel.setVisible(false);
        }


        add(notificationLabel, BorderLayout.SOUTH);

        setupRabbitMQ();
    }

    private void setupRabbitMQ() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
    
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "bookRoom");
        channel.queueBind(queueName, EXCHANGE_NAME, "callService");
    
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
    
            // Kiểm tra nếu thông báo là về việc đặt phòng hoặc gọi dịch vụ
            if (message.contains("bookRoom") || message.contains("callService")) {
                SwingUtilities.invokeLater(() -> {
                    notificationLabel.setVisible(true);
                });
            }
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkInButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        manageRoomButton = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        manageStaffButton = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        bookRoomButton = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        confirmBookButton = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        confirmServiceButton = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        notiButton = new javax.swing.JToggleButton();
        notificationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setResizable(false);

        checkInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check_in.png"))); // NOI18N
        checkInButton.setText("jButton1");
        checkInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInButtonActionPerformed(evt);
            }
        });

        checkOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check_out.png"))); // NOI18N
        checkOutButton.setText("jButton1");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        jTextField2.setBackground(java.awt.Color.darkGray);
        jTextField2.setForeground(java.awt.Color.white);
        jTextField2.setText("Check Out");
        jTextField2.setBorder(null);

        manageRoomButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/room.png"))); // NOI18N
        manageRoomButton.setText("jButton1");
        manageRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRoomButtonActionPerformed(evt);
            }
        });

        jTextField3.setBackground(java.awt.Color.darkGray);
        jTextField3.setForeground(java.awt.Color.white);
        jTextField3.setText("Manage Room");
        jTextField3.setBorder(null);

        manageStaffButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manageStaff.png"))); // NOI18N
        manageStaffButton.setText("jButton1");
        manageStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStaffButtonActionPerformed(evt);
            }
        });

        jTextField4.setBackground(java.awt.Color.darkGray);
        jTextField4.setForeground(java.awt.Color.white);
        jTextField4.setText("Manage People");
        jTextField4.setBorder(null);

        logoutButton.setText("Log Out");
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jTextField5.setBackground(java.awt.Color.darkGray);
        jTextField5.setForeground(java.awt.Color.white);
        jTextField5.setText("Check In");
        jTextField5.setBorder(null);

        bookRoomButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotelBooking.png"))); // NOI18N
        bookRoomButton.setText("jButton1");
        bookRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookRoomButtonActionPerformed(evt);
            }
        });

        jTextField6.setBackground(java.awt.Color.darkGray);
        jTextField6.setForeground(java.awt.Color.white);
        jTextField6.setText("Book Room");
        jTextField6.setBorder(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdminDashboard.png"))); // NOI18N

        confirmBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmBook.jpg"))); // NOI18N
        confirmBookButton.setText("jButton1");
        confirmBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBookButtonActionPerformed(evt);
            }
        });

        jTextField8.setBackground(java.awt.Color.darkGray);
        jTextField8.setForeground(java.awt.Color.white);
        jTextField8.setText("Confirm Book");
        jTextField8.setBorder(null);

        confirmServiceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmService.png"))); // NOI18N
        confirmServiceButton.setText("jButton1");
        confirmServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmServiceButtonActionPerformed(evt);
            }
        });

        jTextField9.setBackground(java.awt.Color.darkGray);
        jTextField9.setForeground(java.awt.Color.white);
        jTextField9.setText("Confirm Service");
        jTextField9.setBorder(null);

        notiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notiIcon (1).png"))); // NOI18N
        notiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notiButtonActionPerformed(evt);
            }
        });

        notificationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pointRequest1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(manageStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(manageRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(41, 41, 41))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(notificationLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(notiButton))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(notiButton)
                            .addComponent(notificationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(manageStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(manageRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(confirmBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(confirmServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookRoomButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new BookRoom(userID).setVisible(true);
    }//GEN-LAST:event_bookRoomButtonActionPerformed

    private void checkInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CheckIn(userID).setVisible(true);
    }//GEN-LAST:event_checkInButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CheckOut(userID).setVisible(true);
    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void manageStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStaffButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ManageStaff(userID).setVisible(true);
    }//GEN-LAST:event_manageStaffButtonActionPerformed

    private void manageRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRoomButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ManageRoom(userID).setVisible(true);
    }//GEN-LAST:event_manageRoomButtonActionPerformed

    private void confirmBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBookButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ConfirmBook(userID).setVisible(true);
    }//GEN-LAST:event_confirmBookButtonActionPerformed

    private void confirmServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmServiceButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ConfirmService(userID).setVisible(true);
    }//GEN-LAST:event_confirmServiceButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        int yesORno =
        JOptionPane.showConfirmDialog(
            null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

        if (yesORno == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            System.out.println("Exited from DashBoard class");
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void notiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        numReadRequest = new NumberReadRequestDAO().getNumberReadRequest(userID);
        maxRequest = new RequestDAO().getLastRequestID();

        notificationLabel.setVisible(false);

        if(notification.isVisible()) {
            notification.setVisible(false);
        } else {
            java.awt.Point location = notiButton.getLocationOnScreen();
            notification.setLocation(location.x + notiButton.getWidth() - notification.getWidth(), location.y + notiButton.getHeight());
            
            // Gọi phương thức loadRequestTable
            int numHighlightedRows = maxRequest - numReadRequest;
            notification.loadRequestTable(numHighlightedRows);
            
            notification.setVisible(true);
        }
    
        new NumberReadRequestDAO().updateNumberReadRequest(userID, maxRequest);
        numReadRequest = maxRequest;
    }
    
    
   
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
            java.util.logging.Logger.getLogger(DashboardManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DashboardManager().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookRoomButton;
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton confirmBookButton;
    private javax.swing.JButton confirmServiceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageRoomButton;
    private javax.swing.JButton manageStaffButton;
    private javax.swing.JToggleButton notiButton;
    private javax.swing.JLabel notificationLabel;
    // End of variables declaration//GEN-END:variables
}
