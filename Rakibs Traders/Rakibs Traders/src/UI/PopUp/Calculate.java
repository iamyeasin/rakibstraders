package UI.PopUp;

import Others.Functions;
import UI.Sell;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author RH Rafi
 */
public class Calculate extends javax.swing.JFrame {

    /**
     * Creates new form Delete
     */
    public Calculate() {
        initComponents();
        setIcon();
        initComboProductID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldPcs = new javax.swing.JTextField();
        jTextFieldProductId = new javax.swing.JTextField();
        lblTimeanddate2 = new javax.swing.JLabel();
        lblTimeanddate5 = new javax.swing.JLabel();
        txtFieldBox = new javax.swing.JTextField();
        jButtonAddPayment = new javax.swing.JButton();
        lblPaymentType = new javax.swing.JLabel();
        txtFieldFeet = new javax.swing.JTextField();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFieldPcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPcsActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldPcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, 23));

        jTextFieldProductId.setText("Product ID");
        jTextFieldProductId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldProductIdFocusLost(evt);
            }
        });
        jTextFieldProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductIdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 180, -1));

        lblTimeanddate2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimeanddate2.setForeground(new java.awt.Color(255, 255, 255));
        lblTimeanddate2.setText("Pcs");
        getContentPane().add(lblTimeanddate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 40, 23));

        lblTimeanddate5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimeanddate5.setForeground(new java.awt.Color(255, 255, 255));
        lblTimeanddate5.setText("Feet");
        getContentPane().add(lblTimeanddate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 40, 23));

        txtFieldBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldBoxActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 180, 23));

        jButtonAddPayment.setBackground(new java.awt.Color(0, 51, 153));
        jButtonAddPayment.setFont(new java.awt.Font("Titillium Web", 1, 12)); // NOI18N
        jButtonAddPayment.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddPayment.setText("Calculate");
        jButtonAddPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPaymentActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAddPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 180, 30));

        lblPaymentType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPaymentType.setForeground(new java.awt.Color(255, 255, 255));
        lblPaymentType.setText("Box");
        getContentPane().add(lblPaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 60, 23));

        txtFieldFeet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldFeetActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldFeet, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 180, 23));

        jLabelBackground.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPaymentActionPerformed
        // TODO add your handling code here:
        if(txtFieldFeet.getText().equals("")){
           Functions.boxAndPcsToFeet(jTextFieldProductId,txtFieldBox,txtFieldPcs,txtFieldFeet);
        } else {
            Functions.feetToBoxAndPcs(jTextFieldProductId,txtFieldBox,txtFieldPcs,txtFieldFeet);
        }
    }//GEN-LAST:event_jButtonAddPaymentActionPerformed

    private void txtFieldFeetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldFeetActionPerformed
        // TODO add your handling code here:
        Functions.feetToBoxAndPcs(jTextFieldProductId,txtFieldBox,txtFieldPcs,txtFieldFeet);
    }//GEN-LAST:event_txtFieldFeetActionPerformed

    private void jTextFieldProductIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductIdFocusGained
        // TODO add your handling code here:
         if(jTextFieldProductId.getText().equals("Product ID")){
                   jTextFieldProductId.setText("");
           }
           this.jTextFieldProductId.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextFieldProductIdFocusGained

    private void jTextFieldProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductIdActionPerformed

    private void jTextFieldProductIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductIdFocusLost
        // TODO add your handling code here:
        if (jTextFieldProductId.getText().isEmpty()) {
                jTextFieldProductId.setForeground(new Color(204,204,204));
                jTextFieldProductId.setText("Product ID");
            }
    }//GEN-LAST:event_jTextFieldProductIdFocusLost

    private void txtFieldBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldBoxActionPerformed
        // TODO add your handling code here:
        Functions.boxAndPcsToBoxAndPcs(jTextFieldProductId,txtFieldBox,txtFieldPcs);
        Functions.boxAndPcsToFeet(jTextFieldProductId,txtFieldBox,txtFieldPcs,txtFieldFeet);
    }//GEN-LAST:event_txtFieldBoxActionPerformed

    private void txtFieldPcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPcsActionPerformed
        // TODO add your handling code here:
        Functions.boxAndPcsToBoxAndPcs(jTextFieldProductId,txtFieldBox,txtFieldPcs);
        Functions.boxAndPcsToFeet(jTextFieldProductId,txtFieldBox,txtFieldPcs,txtFieldFeet);
    }//GEN-LAST:event_txtFieldPcsActionPerformed

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
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPayment;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JTextField jTextFieldProductId;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JLabel lblTimeanddate2;
    private javax.swing.JLabel lblTimeanddate5;
    private javax.swing.JTextField txtFieldBox;
    private javax.swing.JTextField txtFieldFeet;
    private javax.swing.JTextField txtFieldPcs;
    // End of variables declaration//GEN-END:variables
    
    //custom variable
    private ArrayList<String> productID = new ArrayList<>();
    //end of custom variable
    
    private void setIcon(){
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icons/Icon.png")).getImage());
    }
    
    
    private void initComboProductID(){
        productID = Functions.productID();
        Functions.setupAutoComplete(jTextFieldProductId, productID); 
    }
    
   @Override
    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            Sell page = Sell.getRef();
            page.setEnabled(true);
            dispose();
        }
    }
    
}
