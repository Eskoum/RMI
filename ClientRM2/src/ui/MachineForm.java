/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import daao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MachineForm extends javax.swing.JInternalFrame {
IDao<Machine> dao1=null;
IDao<Salle> dao2=null;

DefaultTableModel model = null;
int id=-1;

        
    /**
     * Creates new form MachineForm
     */
    public MachineForm() {
    try {
        initComponents();
        model=(DefaultTableModel) listem.getModel();
        dao1=(IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao1");
   dao2=(IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
        load();
        loadCombo();
        loadFBox();
    } catch (NotBoundException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void load(){
    try {
        model.setRowCount(0);
        for(Machine m: dao1.findAll())
            model.addRow(new Object[]{
                m.getId(),
                m.getRef(),
                m.getMarque(),
                m.getPrix(),
                m.getSalle().getCode(),
            });
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void loadCombo(){
    try {
        salleCombo.removeAllItems();
        for(Salle s: dao2.findAll()){
            salleCombo.addItem(s);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
      private void loadFBox() {
        try {
        fcombo.removeAllItems();
        for(Salle s: dao2.findAll()){
            fcombo.addItem(s);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        txtMarque = new javax.swing.JTextField();
        txtPrix = new javax.swing.JTextField();
        salleCombo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listem = new javax.swing.JTable();
        filtretxt = new javax.swing.JLabel();
        fcombo = new javax.swing.JComboBox();
        appliquer = new javax.swing.JCheckBox();

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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Machine");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "G machines"));

        jLabel1.setText("Reference:");

        jLabel2.setText("Marque:");

        jLabel3.setText("Prix:");

        jLabel4.setText("Salle:");

        txtRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefActionPerformed(evt);
            }
        });

        txtMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarqueActionPerformed(evt);
            }
        });

        salleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMarque)
                    .addComponent(txtRef)
                    .addComponent(txtPrix)
                    .addComponent(salleCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(salleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Actions"));

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setText("Modifier");
        modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifierMouseClicked(evt);
            }
        });
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(supprimer)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(163, 163, 163))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ajouter)
                .addGap(18, 18, 18)
                .addComponent(modifier)
                .addGap(18, 18, 18)
                .addComponent(supprimer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste des machines"));

        listem.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        listem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Reference", "Marque", "Prix", "Salle"
            }
        ));
        listem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listem);

        filtretxt.setText("Filtrer par salle");

        fcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        appliquer.setText("appliquer");
        appliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliquerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(filtretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(appliquer)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliquer))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRefActionPerformed

    private void txtMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarqueActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
    try {
        // TODO add your handling code here:
        String ref=txtRef.getText().toString();
        String marque=txtMarque.getText().toString();
        double prix =Double.parseDouble(txtPrix.getText().toString());
        Salle salle=(Salle)salleCombo.getSelectedItem();
        dao1.create(new Machine(ref, marque, prix, salle));
        load();
        JOptionPane.showMessageDialog(this, "La machine a été ajoutée");
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
   
        // TODO add your handling code here:
      try {
            String ref = txtRef.getText();
            String marque = txtMarque.getText();
            double prix = Double.parseDouble(txtPrix.getText());
            Salle salle = (Salle) salleCombo.getSelectedItem();
            Machine updatedMachine = new Machine(ref, marque, prix, salle);
            updatedMachine.setId(id);
            dao1.update(updatedMachine);
            load();
            JOptionPane.showMessageDialog(this, "La machine a été modifiée");
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modifierActionPerformed
    
    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
   
        // TODO add your handling code here:
     try {
            int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette machine ?");

            if (reponse == 0) {
                dao1.delete(dao1.findById(id));
                load();
                JOptionPane.showMessageDialog(this, "La machine a été supprimée");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "vous devez selectionner un client dans la liste");

        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifierMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_modifierMouseClicked

    private void listemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listemMouseClicked
        // TODO add your handling code here:
         int selectedRow = listem.getSelectedRow();
        if (selectedRow != -1) {
           try {
               id = Integer.parseInt(listem.getValueAt(selectedRow, 0).toString());
               txtRef.setText(dao1.findById(id).getRef());
               txtMarque.setText(dao1.findById(id).getMarque());
               txtPrix.setText(String.valueOf(dao1.findById(id).getPrix()));
               Salle selectedSalle = dao1.findById(id).getSalle();
               for (int i = 0; i < salleCombo.getItemCount(); i++) {
                   Salle item = (Salle) salleCombo.getItemAt(i);
                   if (item.getId() == selectedSalle.getId()) {
                       salleCombo.setSelectedIndex(i);
                       break;
                   }
               }
           } catch (RemoteException ex) {
               Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
    }//GEN-LAST:event_listemMouseClicked

    private void appliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliquerActionPerformed
        // TODO add your handling code here:
        
        if (appliquer.isSelected()) {
        model.setRowCount(0); // Clear the existing rows in the table

        // Get the selected Salle from the combo box
        Salle s = (Salle) fcombo.getSelectedItem();
 if (s != null) {
        // Repopulate the list with machines from the selected Salle
        for (Machine m : s.getMachines()) {
            model.addRow(new Object[] {
                m.getId(),
                m.getRef(),
                m.getMarque(),
                m.getPrix(),
                m.getSalle().getCode()
            });
        }
       } else {
        // Handle the case when the checkbox is not checked (optional)
        // You can clear the table or take other actions as needed.
        // For example, you can call model.setRowCount(0) to clear the table.
         load();    
    }
    
    }//GEN-LAST:event_appliquerActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JCheckBox appliquer;
    private javax.swing.JComboBox fcombo;
    private javax.swing.JLabel filtretxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable listem;
    private javax.swing.JButton modifier;
    private javax.swing.JComboBox salleCombo;
    private javax.swing.JButton supprimer;
    private javax.swing.JTextField txtMarque;
    private javax.swing.JTextField txtPrix;
    private javax.swing.JTextField txtRef;
    // End of variables declaration//GEN-END:variables

  
}