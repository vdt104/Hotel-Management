/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

import dao.PersonDAO;
import dao.AccountDAO;
import dao.GuestDAO;
import dao.NumberReadRequestDAO;
import dao.ReceptionistDAO;
import dto.Guest;
import dto.Person;
import dto.Receptionist;
import types.AccountType;

import java.util.List;

/**
 *
 * @author Thang
 */
public class ManageStaff extends javax.swing.JFrame {

    private String userID;

    public ManageStaff() {
        setTitle("Manage Staff");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();
        loadTable("All");
    }

    public ManageStaff(String userID) {
        this.userID = userID;
        System.out.println("Manage Staff: " + userID);

        setTitle("Manage Staff");
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        initComponents();
        loadTable("All");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        passwordField = new javax.swing.JTextField();
        UsernameTxt1 = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        UsernameTxt4 = new javax.swing.JLabel();
        UsernameTxt5 = new javax.swing.JLabel();
        fullnameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        UsernameTxt6 = new javax.swing.JLabel();
        UsernameTxt7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        choiceBox = new javax.swing.JComboBox<>();
        jLabel = new javax.swing.JLabel();
        UsernameTxt2 = new javax.swing.JLabel();
        actionBox = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        searchChoiceBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        contentField = new javax.swing.JTextField();
        searchButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));

        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        passwordField.setDisabledTextColor(java.awt.Color.black);
        passwordField.setEnabled(false);

        UsernameTxt1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt1.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt1.setText("Password");

        UsernameTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt.setText("Username");

        usernameField.setDisabledTextColor(java.awt.Color.black);
        usernameField.setEnabled(false);

        UsernameTxt4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt4.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt4.setText("Address");

        UsernameTxt5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt5.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt5.setText("Fullname");

        fullnameField.setDisabledTextColor(java.awt.Color.black);
        fullnameField.setEnabled(false);

        addressField.setDisabledTextColor(java.awt.Color.black);
        addressField.setEnabled(false);

        UsernameTxt6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt6.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt6.setText("Phone");

        UsernameTxt7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt7.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt7.setText("Email");

        emailField.setDisabledTextColor(java.awt.Color.black);
        emailField.setEnabled(false);

        phoneField.setDisabledTextColor(java.awt.Color.black);
        phoneField.setEnabled(false);

        choiceBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Only Guest", "Only Receptionist" }));
        choiceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceBoxActionPerformed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel.setForeground(new java.awt.Color(215, 210, 203));
        jLabel.setText("View");

        UsernameTxt2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UsernameTxt2.setForeground(new java.awt.Color(215, 210, 203));
        UsernameTxt2.setText("Action");

        actionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View", "Edit", "Add Guest", "Add Receptionist" }));
        actionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBoxActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        confirmButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        searchChoiceBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Phone" }));
        searchChoiceBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchChoiceBoxMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(215, 210, 203));
        jLabel1.setText("Search By");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(choiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(278, 278, 278)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(contentField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fullnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(phoneField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addressField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UsernameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(67, 67, 67)
                                .addComponent(UsernameTxt2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmButton))))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addGap(431, 431, 431))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UsernameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UsernameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fullnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(choiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(contentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTable(String Type){
        List<Person> persons = new PersonDAO().getAllPersons(Type);

        String[][] data = new String[persons.size()][6];
        for (int i = 0; i < persons.size(); i++) {
            data[i][0] = persons.get(i).getID();
            data[i][1] = persons.get(i).getName();
            data[i][2] = persons.get(i).getAddress();
            data[i][3] = persons.get(i).getEmail();
            data[i][4] = persons.get(i).getPhone();
            data[i][5] = persons.get(i).getAccountType().toString();
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "ID", "Name", "Address", "Email", "Phone", "Type"
            }
        ));
    }

    private void setFieldEditable(boolean value) {
        usernameField.setEnabled(value);
        passwordField.setEnabled(value);
        fullnameField.setEnabled(value);
        addressField.setEnabled(value);
        emailField.setEnabled(value);
        phoneField.setEnabled(value);
    }

    private void clearField() {
        usernameField.setText("");
        passwordField.setText("");
        fullnameField.setText("");
        addressField.setText("");
        emailField.setText("");
        phoneField.setText("");
        jTable1.clearSelection();
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

    private void choiceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceBoxActionPerformed
        // TODO add your handling code here:
        String choice = choiceBox.getSelectedItem().toString();
        if (choice.equals("All")) {
            loadTable("All");
        } else if (choice.equals("Only Guest")) {
            loadTable("Guest");
        } else if (choice.equals("Only Receptionist")) {
            loadTable("Receptionist");
        }
    }//GEN-LAST:event_choiceBoxActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();

        String ID = jTable1.getValueAt(row, 0).toString();
        Person person = new PersonDAO().getPersonByID(ID);

        setFieldEditable(false);
        actionBox.setSelectedIndex(0);

        usernameField.setText(person.getUsername());
        passwordField.setText(person.getPassword());
        fullnameField.setText(person.getName());
        addressField.setText(person.getAddress());
        emailField.setText(person.getEmail());
        phoneField.setText(person.getPhone());
    }//GEN-LAST:event_jTable1MousePressed

    private void actionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBoxActionPerformed
        // TODO add your handling code here:
        String action = actionBox.getSelectedItem().toString();
        
        if (action.equals("View")) {
            setFieldEditable(false);
        } else if (action.equals("Edit")) {
            if (jTable1.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to edit!");
                actionBox.setSelectedIndex(0);
                setFieldEditable(false);
                return;
            }
            setFieldEditable(true);
        } else if (action.equals("Add Guest")) {
            setFieldEditable(true);
            clearField();
        } else if (action.equals("Add Receptionist")) {
            setFieldEditable(true);
            clearField();
        }
    }//GEN-LAST:event_actionBoxActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        String action = actionBox.getSelectedItem().toString();

        if (action.equals("View")) {
            JOptionPane.showMessageDialog(null, "Nothing has been changed! Hehe");
            return;
        }

        String username = usernameField.getText();
        String password = passwordField.getText();
        String fullname = fullnameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        
        if (username.equals("") || password.equals("") || fullname.equals("") || address.equals("") || email.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!phone.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (new AccountDAO().isUserNameExist(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (new PersonDAO().findPersonIDByPhone(phone) != null) {
            JOptionPane.showMessageDialog(null, "Phone number already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (new PersonDAO().isEmailExist(email)) {
            JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (action.equals("Edit")) {
            int row = jTable1.getSelectedRow();
            String ID = jTable1.getValueAt(row, 0).toString();

            try {
                Person person = new PersonDAO().getPersonByID(ID);
                person.setUsername(username);
                person.setPassword(password);
                person.setName(fullname);
                person.setAddress(address);
                person.setEmail(email);
                person.setPhone(phone);
    
                new PersonDAO().updatePersonByID(person);
                new AccountDAO().updateAccountByID(person);
    
                JOptionPane.showMessageDialog(null, "Person updated successfully!");
                clearField();
                setFieldEditable(false);
                actionBox.setSelectedIndex(0);
                loadTable(choiceBox.getSelectedItem().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } 

        if (action.equals("Add Guest")) {
            try {
                String ID = new PersonDAO().generateId(AccountType.GUEST);

                Guest guest = new Guest();
                guest.setID(ID);
                guest.setUsername(username);
                guest.setPassword(password);
                guest.setName(fullname);
                guest.setAddress(address);
                guest.setEmail(email);
                guest.setPhone(phone);
                guest.setAccountType(AccountType.GUEST);
                guest.setTotalRoomCheckedIn(0);

                new AccountDAO().insertAccount(guest);
                new PersonDAO().insertPerson(guest);
                new GuestDAO().insertGuest(guest);
                new NumberReadRequestDAO().insertNumberReadRequest(ID);

                JOptionPane.showMessageDialog(null, "Guest added successfully!");
                clearField();
                loadTable(choiceBox.getSelectedItem().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }

        if (action.equals("Add Receptionist")) {
            try {
                String ID = new PersonDAO().generateId(AccountType.RECEPTIONIST);

                Receptionist receptionist = new Receptionist();
                receptionist.setID(ID);
                receptionist.setUsername(username);
                receptionist.setPassword(password);
                receptionist.setName(fullname);
                receptionist.setAddress(address);
                receptionist.setEmail(email);
                receptionist.setPhone(phone);
                receptionist.setAccountType(AccountType.RECEPTIONIST);

                new AccountDAO().insertAccount(receptionist);
                new PersonDAO().insertPerson(receptionist);
                new ReceptionistDAO().insertReceptionist(receptionist);

                JOptionPane.showMessageDialog(null, "Receptionist added successfully!");
                clearField();
                loadTable(choiceBox.getSelectedItem().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
        
        loadTable(choiceBox.getSelectedItem().toString());
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void searchChoiceBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchChoiceBoxMousePressed
        // TODO add your handling code here:
        contentField.setText("");
    }//GEN-LAST:event_searchChoiceBoxMousePressed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String choice = searchChoiceBox.getSelectedItem().toString();
        String content = contentField.getText().trim();

        if (content.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill the search field!");
            return;
        }

        if (choice.equals("ID")) {
            Person person = new PersonDAO().getPersonByID(content);
            if (person == null) {
                JOptionPane.showMessageDialog(null, "Person not found!");
                contentField.setText("");
                return;
            }

            String[][] data = new String[1][6];
            data[0][0] = person.getID();
            data[0][1] = person.getName();
            data[0][2] = person.getAddress();
            data[0][3] = person.getEmail();
            data[0][4] = person.getPhone();
            data[0][5] = person.getAccountType().toString();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String [] {
                    "ID", "Name", "Address", "Email", "Phone", "Type"
                }
            ));
        }

        if (choice.equals("Phone")) {
            Person person = new PersonDAO().getPersonByPhone(content);
            if (person == null) {
                JOptionPane.showMessageDialog(null, "Person not found!");
                contentField.setText("");
                return;
            }

            String[][] data = new String[1][6];
            data[0][0] = person.getID();
            data[0][1] = person.getName();
            data[0][2] = person.getAddress();
            data[0][3] = person.getEmail();
            data[0][4] = person.getPhone();
            data[0][5] = person.getAccountType().toString();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String [] {
                    "ID", "Name", "Address", "Email", "Phone", "Type"
                }
            ));
        }

        if (choice.equals("Name")) {
            List<Person> persons = new PersonDAO().getPersonByName(content);

            if (persons.size() == 0) {
                JOptionPane.showMessageDialog(null, "Person not found!");
                contentField.setText("");
                return;
            }

            String[][] data = new String[persons.size()][6];
            for (int i = 0; i < persons.size(); i++) {
                data[i][0] = persons.get(i).getID();
                data[i][1] = persons.get(i).getName();
                data[i][2] = persons.get(i).getAddress();
                data[i][3] = persons.get(i).getEmail();
                data[i][4] = persons.get(i).getPhone();
                data[i][5] = persons.get(i).getAccountType().toString();
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String [] {
                    "ID", "Name", "Address", "Email", "Phone", "Type"
                }
            ));
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
            return;
        }

        int row = jTable1.getSelectedRow();
        String ID = jTable1.getValueAt(row, 0).toString();
        String type = jTable1.getValueAt(row, 5).toString();

        if (type.equals("MANAGER")) {
            JOptionPane.showMessageDialog(null, "Cannot delete Manager!");
            return;
        }

        if (type.equals("GUEST")) {
            JOptionPane.showMessageDialog(null, "Cannot delete Guest!");
            return;
        }

        try {
            new ReceptionistDAO().deleteReceptionistByID(ID);
            new PersonDAO().deletePersonByID(ID);
            new AccountDAO().deleteAccountByID(ID);
            

            JOptionPane.showMessageDialog(null, "Person deleted successfully!");
            clearField();
            loadTable(choiceBox.getSelectedItem().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsernameTxt;
    private javax.swing.JLabel UsernameTxt1;
    private javax.swing.JLabel UsernameTxt2;
    private javax.swing.JLabel UsernameTxt4;
    private javax.swing.JLabel UsernameTxt5;
    private javax.swing.JLabel UsernameTxt6;
    private javax.swing.JLabel UsernameTxt7;
    private javax.swing.JComboBox<String> actionBox;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> choiceBox;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField contentField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fullnameField;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JComboBox<String> searchChoiceBox;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
