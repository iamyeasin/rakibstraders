package UI.BigPopUp;

import Database.DBConnectionProvider;
import UI.PopUp.NoConnection;
import com.placeholder.PlaceHolder;
import java.awt.List;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rakibs.traders.RakibsTraders;

/**
 *
 * @author RH Rafi
 */
public class UserList extends javax.swing.JFrame {

    /**
     * Creates new form ProductsTable
     */
    
    PlaceHolder place;
    public UserList() {
        initComponents();
        initTable();
        setIcon();
        place = new PlaceHolder(jTextFieldSearchVendor,"Enter possible user name ");
    }
    
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPaneTable = new javax.swing.JScrollPane();
        lblExpenseHistory = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSearchVendor = new javax.swing.JTextField();
        jButtonGO = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(scrPaneTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1017, 390));

        lblExpenseHistory.setFont(new java.awt.Font("Titillium", 0, 22)); // NOI18N
        lblExpenseHistory.setForeground(new java.awt.Color(67, 196, 114));
        lblExpenseHistory.setText("USER LIST");
        getContentPane().add(lblExpenseHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 304, 43));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Search User");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 140, 60));

        jTextFieldSearchVendor.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchVendorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 280, 40));

        jButtonGO.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGO.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGO.setText("GO");
        jButtonGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, 60, 40));

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 110, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 2540, 1380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchVendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchVendorActionPerformed

    private void jButtonGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGOActionPerformed
        // TODO add your handling code here:
        
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable.getViewport().add(table);
        
       PreparedStatement pstmt3;
       String query3 = "select * from user_list where user_name like ?";
       String searchData = jTextFieldSearchVendor.getText();
       Connection con = DBConnectionProvider.getDBConnection();
       
       try {
            pstmt3 = con.prepareStatement(query3);
            pstmt3.setString(1,"%" + searchData + "%");
            ResultSet rs3 = pstmt3.executeQuery();

            if( rs3.next() ){
                do{
                        String col1 = rs3.getString("user_name");
                        String col2 = rs3.getString("access_level");
                        
                   data.addRow(new Object[]{ col1, col2 });
                }while(rs3.next());
                table.setModel(data);
                rs3.close();
            }
       }
       catch(Exception ex){
           System.out.println("No database connection"+ex);
           NoConnection no = new NoConnection();
           RakibsTraders.popUp(no);
       }
        
    }//GEN-LAST:event_jButtonGOActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable.getViewport().add(table);
        setData();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    // for showing table
    /*
     Connection con = DBConnectionProvider.getDBConnection();
        String query= "select * from products";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if(rs.next()){
                do{
                System.out.println(rs.getString("products_id"));
                System.out.println(rs.getString("company_name"));
                System.out.println(rs.getString("model"));
                System.out.println(rs.getString("dimension"));
                System.out.println(Integer.toString(rs.getInt("pcs_per_box")));
                System.out.println(Integer.toString(rs.getInt("item_unit")));
                System.out.println(Double.toString(rs.getInt("purchase_price")));
                System.out.println(Double.toString(rs.getInt("selling_price")));
                System.out.println(rs.getString("notes"));
                }while(rs.next());
            }

        }catch(Exception ex){
            System.out.println("No database connection"+ex);
            /*NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);*/
  //      }
   // */
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
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserList().setVisible(true);
            }
        });
    }

    private void initTable(){
        setData();
        scrPaneTable.getViewport().add(table);
    }
     DefaultTableModel data = new DefaultTableModel(new String[]{"User Name", "Access Level"}, 0);
    private void setData(){
       
        Connection con = DBConnectionProvider.getDBConnection();
        String query= "select * from user_list";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if(rs.next()){
                do{
                    String col1 = rs.getString("user_name");
                    String col2 = rs.getString("access_level");
                    data.addRow(new Object[]{col1, col2});
                }while(rs.next());
                table.setModel(data);
                rs.close();
            }

        }catch(Exception ex){
            System.out.println("No database connection"+ex);
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
    }

    //custom variable
    private JTable table = new JTable();
    private JFrame caller;
    //end of custom variable
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGO;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldSearchVendor;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblExpenseHistory;
    private javax.swing.JScrollPane scrPaneTable;
    // End of variables declaration//GEN-END:variables
   
    private void setIcon(){
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icons/Icon.png")).getImage());
    }

    public void setCaller(JFrame frame){
        this.caller = frame;
    }
    
    @Override
    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                caller.setEnabled(true);
                dispose();
        }
    }
}