package UI.BigPopUp;

import Database.DBConnectionProvider;
import UI.PopUp.EditVendor;
import UI.PopUp.NoConnection;
import com.placeholder.PlaceHolder;
import java.awt.List;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rakibs.traders.RakibsTraders;

/**
 
 * 
 */
public class VendorList extends javax.swing.JFrame {
    /**
     * Creates new form ProductsTable
     */
    PlaceHolder place,place2;
    
    public VendorList() {
        initComponents();
        initTable();
        setIcon();
        place = new PlaceHolder(jTextFieldSearchVendor,"Vendor ID,Name,Phone Number");
        place2 = new PlaceHolder(jTextFieldVendorID,"Enter Vendor ID");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextFieldSearchVendor = new javax.swing.JTextField();
        scrPaneTable2 = new javax.swing.JScrollPane();
        lblReturnedHistory = new javax.swing.JLabel();
        jButtonGO = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jTextFieldVendorID = new javax.swing.JTextField();
        jButtonEditVendor = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Search Vendor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 140, 50));

        jTextFieldSearchVendor.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchVendorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 280, 30));
        getContentPane().add(scrPaneTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1020, 330));

        lblReturnedHistory.setFont(new java.awt.Font("Titillium", 0, 22)); // NOI18N
        lblReturnedHistory.setForeground(new java.awt.Color(67, 196, 114));
        lblReturnedHistory.setText("Vendor List");
        getContentPane().add(lblReturnedHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 304, 43));

        jButtonGO.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGO.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGO.setText("GO");
        jButtonGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 60, 30));

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 110, 30));

        jTextFieldVendorID.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldVendorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVendorIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldVendorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 180, 30));

        jButtonEditVendor.setBackground(new java.awt.Color(0, 51, 153));
        jButtonEditVendor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditVendor.setText("Edit Vendor");
        jButtonEditVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditVendorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 160, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 2540, 1380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchVendorActionPerformed
        // TODO add your handling code here:
        getTheSearchDone();
    }//GEN-LAST:event_jTextFieldSearchVendorActionPerformed

    private void jButtonGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGOActionPerformed
        // TODO add your handling code here:

        String searchData = jTextFieldSearchVendor.getText();
//        if (searchData.matches(".*[a-z].*") || searchData.matches(".*[A-Z].*")) { 
//                // Do something
//                System.err.println("Fuck you dataa");
//        }
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        if( !searchData.equals("Vendor ID,Name,Phone Number") ){
            String query1 = "select * from vendors  where phone1 like ? ";
            String query2 = "select * from vendors where phone2 like ?";
            String query3 = "select * from vendors where vendor_name like ?";
            String query4 = "select * from vendors where vendor_id = ? ";
            String query5 = "select * from vendors where shop_name like ?";
             
            Connection con = DBConnectionProvider.getDBConnection();
            if( searchData.startsWith("#V") ){ //search in vendor ID
                try { 
                    PreparedStatement pstmt = con.prepareStatement(query4);
                    pstmt.setString(1, searchData );
                    ResultSet rs = pstmt.executeQuery();
                    
                    if( rs.next() ){
                            do{
                                String col1 = rs.getString("vendor_id");
                                String col2 = rs.getString("vendor_name");
                                String col3 = rs.getString("shop_name");
                                String col4 = rs.getString("address");
                                String col5 = rs.getString("phone1");
                                String col6 = rs.getString("phone2");
                                String col7 = rs.getString("email");
                                String col8 = rs.getString("dealerships");
                                String col9 = rs.getString("no_of_bus");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                    
                    
                } catch (SQLException ex) {
//                    Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                       Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if( searchData.matches(".*[0-9].*") ){ // check if the data is a mobile number
                try{
                        PreparedStatement pstmt = con.prepareStatement(query1);
                        pstmt.setString(1, "%" + searchData + "%" );
                        ResultSet rs = pstmt.executeQuery();
                        PreparedStatement pstmt2 = con.prepareStatement(query2);
                        pstmt2.setString(1,"%" + searchData + "%");
                        ResultSet rs2 = pstmt2.executeQuery();
                        
                        if( rs.next() ){ // search in phone1
                            do{
                                String col1 = rs.getString("vendor_id");
                                String col2 = rs.getString("vendor_name");
                                String col3 = rs.getString("shop_name");
                                String col4 = rs.getString("address");
                                String col5 = rs.getString("phone1");
                                String col6 = rs.getString("phone2");
                                String col7 = rs.getString("email");
                                String col8 = rs.getString("dealerships");
                                String col9 = rs.getString("no_of_bus");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                        else {
                            if( rs2.next() ){ //search in phone 2
                                do{ 
                                    String col1 = rs2.getString("vendor_id");
                                    String col2 = rs2.getString("vendor_name");
                                    String col3 = rs2.getString("shop_name");
                                    String col4 = rs2.getString("address");
                                    String col5 = rs2.getString("phone1");
                                    String col6 = rs2.getString("phone2");
                                    String col7 = rs2.getString("email");
                                    String col8 = rs2.getString("dealerships");
                                    String col9 = rs2.getString("no_of_bus");

                                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                                }while(rs2.next());
                                table.setModel(data);
                                rs2.close();
                            }
                        }

                    }catch(Exception ex){
//                        System.out.println("No database connection with customer DB"+ex);
//                        NoConnection no = new NoConnection();
//                        RakibsTraders.popUp(no);
                           Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            }
            else { // Or if its a name; first in vendor name ,then shop name
                PreparedStatement pstmt3,pstmt4;
                try {
                    pstmt3 = con.prepareStatement(query3);
                    pstmt3.setString(1,"%" + searchData + "%");
                    ResultSet rs3 = pstmt3.executeQuery();
                    
                    pstmt4 = con.prepareStatement(query5); // for searching in the shop name field
                    pstmt4.setString(1, "%" +searchData + "%" );
                    ResultSet rs4 = pstmt4.executeQuery();
                            
                    if( rs3.next() ){
                        do{
                                String col1 = rs3.getString("vendor_id");
                                String col2 = rs3.getString("vendor_name");
                                String col3 = rs3.getString("shop_name");
                                String col4 = rs3.getString("address");
                                String col5 = rs3.getString("phone1");
                                String col6 = rs3.getString("phone2");
                                String col7 = rs3.getString("email");
                                String col8 = rs3.getString("dealerships");
                                String col9 = rs3.getString("no_of_bus");

                           data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                        }while(rs3.next());
                        table.setModel(data);
                        rs3.close();
                    }
                    if( rs4.next() ){
                        do{
                                String col1 = rs4.getString("vendor_id");
                                String col2 = rs4.getString("vendor_name");
                                String col3 = rs4.getString("shop_name");
                                String col4 = rs4.getString("address");
                                String col5 = rs4.getString("phone1");
                                String col6 = rs4.getString("phone2");
                                String col7 = rs4.getString("email");
                                String col8 = rs4.getString("dealerships");
                                String col9 = rs4.getString("no_of_bus");

                           data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                        }while(rs4.next());
                        table.setModel(data);
                        rs4.close();
                    }
                
                } catch (SQLException ex) {
                    Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }   
        }
    }//GEN-LAST:event_jButtonGOActionPerformed
    
    private void getTheSearchDone()
    {
        
        String searchData = jTextFieldSearchVendor.getText();
//        if (searchData.matches(".*[a-z].*") || searchData.matches(".*[A-Z].*")) { 
//                // Do something
//                System.err.println("Fuck you dataa");
//        }
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        if( !searchData.equals("Vendor ID,Name,Phone Number") ){
            String query1 = "select * from vendors  where phone1 like ? ";
            String query2 = "select * from vendors where phone2 like ?";
            String query3 = "select * from vendors where vendor_name like ?";
            String query4 = "select * from vendors where vendor_id = ? ";
            String query5 = "select * from vendors where shop_name like ?";
             
            Connection con = DBConnectionProvider.getDBConnection();
            if( searchData.startsWith("#V") ){ //search in vendor ID
                try { 
                    PreparedStatement pstmt = con.prepareStatement(query4);
                    pstmt.setString(1, searchData );
                    ResultSet rs = pstmt.executeQuery();
                    
                    if( rs.next() ){
                            do{
                                String col1 = rs.getString("vendor_id");
                                String col2 = rs.getString("vendor_name");
                                String col3 = rs.getString("shop_name");
                                String col4 = rs.getString("address");
                                String col5 = rs.getString("phone1");
                                String col6 = rs.getString("phone2");
                                String col7 = rs.getString("email");
                                String col8 = rs.getString("dealerships");
                                String col9 = rs.getString("no_of_bus");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                    
                    
                } catch (SQLException ex) {
//                    Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                       Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if( searchData.matches(".*[0-9].*") ){ // check if the data is a mobile number
                try{
                        PreparedStatement pstmt = con.prepareStatement(query1);
                        pstmt.setString(1, "%" + searchData + "%" );
                        ResultSet rs = pstmt.executeQuery();
                        PreparedStatement pstmt2 = con.prepareStatement(query2);
                        pstmt2.setString(1,"%" + searchData + "%");
                        ResultSet rs2 = pstmt2.executeQuery();
                        
                        if( rs.next() ){ // search in phone1
                            do{
                                String col1 = rs.getString("vendor_id");
                                String col2 = rs.getString("vendor_name");
                                String col3 = rs.getString("shop_name");
                                String col4 = rs.getString("address");
                                String col5 = rs.getString("phone1");
                                String col6 = rs.getString("phone2");
                                String col7 = rs.getString("email");
                                String col8 = rs.getString("dealerships");
                                String col9 = rs.getString("no_of_bus");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                        else {
                            if( rs2.next() ){ //search in phone 2
                                do{ 
                                    String col1 = rs2.getString("vendor_id");
                                    String col2 = rs2.getString("vendor_name");
                                    String col3 = rs2.getString("shop_name");
                                    String col4 = rs2.getString("address");
                                    String col5 = rs2.getString("phone1");
                                    String col6 = rs2.getString("phone2");
                                    String col7 = rs2.getString("email");
                                    String col8 = rs2.getString("dealerships");
                                    String col9 = rs2.getString("no_of_bus");

                                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                                }while(rs2.next());
                                table.setModel(data);
                                rs2.close();
                            }
                        }

                    }catch(Exception ex){
//                        System.out.println("No database connection with customer DB"+ex);
//                        NoConnection no = new NoConnection();
//                        RakibsTraders.popUp(no);
                           Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            }
            else { // Or if its a name; first in vendor name ,then shop name
                PreparedStatement pstmt3,pstmt4;
                try {
                    pstmt3 = con.prepareStatement(query3);
                    pstmt3.setString(1,"%" + searchData + "%");
                    ResultSet rs3 = pstmt3.executeQuery();
                    
                    pstmt4 = con.prepareStatement(query5); // for searching in the shop name field
                    pstmt4.setString(1, "%" +searchData + "%" );
                    ResultSet rs4 = pstmt4.executeQuery();
                            
                    if( rs3.next() ){
                        do{
                                String col1 = rs3.getString("vendor_id");
                                String col2 = rs3.getString("vendor_name");
                                String col3 = rs3.getString("shop_name");
                                String col4 = rs3.getString("address");
                                String col5 = rs3.getString("phone1");
                                String col6 = rs3.getString("phone2");
                                String col7 = rs3.getString("email");
                                String col8 = rs3.getString("dealerships");
                                String col9 = rs3.getString("no_of_bus");

                           data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                        }while(rs3.next());
                        table.setModel(data);
                        rs3.close();
                    }
                    if( rs4.next() ){
                        do{
                                String col1 = rs4.getString("vendor_id");
                                String col2 = rs4.getString("vendor_name");
                                String col3 = rs4.getString("shop_name");
                                String col4 = rs4.getString("address");
                                String col5 = rs4.getString("phone1");
                                String col6 = rs4.getString("phone2");
                                String col7 = rs4.getString("email");
                                String col8 = rs4.getString("dealerships");
                                String col9 = rs4.getString("no_of_bus");

                           data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                        }while(rs4.next());
                        table.setModel(data);
                        rs4.close();
                    }
                
                } catch (SQLException ex) {
                    Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }   
        }

    }
    
    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        setData();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jTextFieldVendorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVendorIDActionPerformed
        // TODO add your handling code here:
        getTheEditDone();
    }//GEN-LAST:event_jTextFieldVendorIDActionPerformed

    private void jButtonEditVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditVendorActionPerformed
        // TODO add your handling code here:
        EditVendor page = new EditVendor();
        page.setCaller(this);
        String vendorID = jTextFieldVendorID.getText();

        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from vendors where vendor_id = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString( 1, vendorID );
            ResultSet rs = pstmt.executeQuery();

            while( rs.next() ){
                page.setData( vendorID, rs.getString("vendor_name") ,rs.getString("shop_name"),rs.getString("address"),rs.getString("phone1"),rs.getString("phone2"),rs.getString("email"),rs.getString("dealerships"),Integer.toString(rs.getInt("no_of_bus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }

        RakibsTraders.popUp(page);
        this.setEnabled(false);

    }//GEN-LAST:event_jButtonEditVendorActionPerformed
    private void getTheEditDone()
    {
        EditVendor page = new EditVendor();
        String vendorID = jTextFieldVendorID.getText();

        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from vendors where vendor_id = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString( 1, vendorID );
            ResultSet rs = pstmt.executeQuery();

            while( rs.next() ){
                page.setData( vendorID, rs.getString("vendor_name") ,rs.getString("shop_name"),rs.getString("address"),rs.getString("phone1"),rs.getString("phone2"),rs.getString("email"),rs.getString("dealerships"),Integer.toString(rs.getInt("no_of_bus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }

        RakibsTraders.popUp(page);
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorList().setVisible(true);
            }
        });
    }
    private DefaultTableModel data = new DefaultTableModel(new String[]{"Vendor ID "," Vendor Name", "Shop Name","Address","Phone 1", "Phone 2" ,"Email", "Dealerships" ,"Business Done"}, 0);
    private void initTable(){
        setData();  
        JTable tables = new JTable();
        tables.setModel(data);
        scrPaneTable2.getViewport().add(tables);
        
    }
    
    private void setData(){
        
        Connection con = DBConnectionProvider.getDBConnection();
        String query= "select * from vendors";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if(rs.next()){
                do{
                    String col1 = rs.getString("vendor_id");
                    String col2 = rs.getString("vendor_name");
                    String col3 = rs.getString("shop_name");
                    String col4 = rs.getString("address");
                    String col5 = rs.getString("phone1");
                    String col6 = rs.getString("phone2");
                    String col7 = rs.getString("email");
                    String col8 = rs.getString("dealerships");
                    String col9 = rs.getString("no_of_bus");
                    
                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9 });
                }while(rs.next());
                table.setModel(data);
                rs.close();
            }

        }catch(Exception ex){
//            System.out.println("No database connection with customer DB"+ex);
//            NoConnection no = new NoConnection();
//            RakibsTraders.popUp(no);
                Logger.getLogger(VendorList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //custom variable
    private JTable table = new JTable();
    private JFrame caller;
    //end of custom variable
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditVendor;
    private javax.swing.JButton jButtonGO;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldSearchVendor;
    private javax.swing.JTextField jTextFieldVendorID;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblReturnedHistory;
    private javax.swing.JScrollPane scrPaneTable2;
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
