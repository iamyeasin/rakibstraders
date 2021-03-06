package UI.BigPopUp;

import Database.DBConnectionProvider;
import UI.PopUp.EditCustomer;
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
 * Profit report would be like, 
 * For todays profit report it will be show the profit of every sell today. Parameter( Date, Invoice ID, Selling Amount, Profit amount)
 * For Month profit report it will show the profit of every day sell. Parameter( date, profit amount )
 * Same goes for 3 months,6 months and for year. Relation would be months to days, 3 months to months,years to months.
 *
 * 
 * 
 * 
 */
public class CustomerList extends javax.swing.JFrame {
    /**
     * Creates new form ProductsTable
     */
    PlaceHolder place,place2;
    
    public CustomerList() {
        initComponents();
        initTable();
        setIcon();
        place = new PlaceHolder(jTextFieldSearchCustomer1,"Customer ID,Name,Phone Number");
        place2 = new PlaceHolder(jTextFieldCustomerID,"Customer ID");
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
        jTextFieldSearchCustomer1 = new javax.swing.JTextField();
        scrPaneTable2 = new javax.swing.JScrollPane();
        lblReturnedHistory = new javax.swing.JLabel();
        jButtonGO = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jTextFieldCustomerID = new javax.swing.JTextField();
        jButtonEditCustomer = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Search Customer");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 140, 50));

        jTextFieldSearchCustomer1.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchCustomer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchCustomer1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 260, 30));
        getContentPane().add(scrPaneTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1010, 330));

        lblReturnedHistory.setFont(new java.awt.Font("Titillium", 0, 22)); // NOI18N
        lblReturnedHistory.setForeground(new java.awt.Color(67, 196, 114));
        lblReturnedHistory.setText("Customer List");
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
        getContentPane().add(jButtonGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 60, 30));

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 110, 30));

        jTextFieldCustomerID.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 180, 30));

        jButtonEditCustomer.setBackground(new java.awt.Color(0, 51, 153));
        jButtonEditCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditCustomer.setText("Edit Customer");
        jButtonEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 160, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 2540, 1380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchCustomer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomer1ActionPerformed
        // TODO add your handling code here:
        getTheSearchDone();
    }//GEN-LAST:event_jTextFieldSearchCustomer1ActionPerformed

    private void jButtonGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGOActionPerformed
        // TODO add your handling code here:

        String searchData = jTextFieldSearchCustomer1.getText();
//        if (searchData.matches(".*[a-z].*") || searchData.matches(".*[A-Z].*")) { 
//                // Do something
//                System.err.println("Fuck you dataa");
//        }
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        if( !searchData.equals("Customer ID,Name,Phone Number") ){
            String query1 = "select * from customer where phone_number1 like ? ";
            String query2 = "select * from customer where phone_number2 like ?";
            String query3 = "select * from customer where customer_name like ?";
            String query4 = "select * from customer where customer_ID = ? ";
            
            Connection con = DBConnectionProvider.getDBConnection();
            if( searchData.startsWith("#C") ){
                try { 
                    PreparedStatement pstmt = con.prepareStatement(query4);
                    pstmt.setString(1, searchData );
                    ResultSet rs = pstmt.executeQuery();
                    
                    if( rs.next() ){
                            do{
                                String col1 = rs.getString("customer_ID");
                                String col2 = rs.getString("customer_name");
                                String col3 = rs.getString("phone_number1");
                                String col4 = rs.getString("phone_number2");
                                String col5 = rs.getString("mail");
                                String col6 = rs.getString("address");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
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
                        
                        if( rs.next() ){
                            do{
                                String col1 = rs.getString("customer_ID");
                                String col2 = rs.getString("customer_name");
                                String col3 = rs.getString("phone_number1");
                                String col4 = rs.getString("phone_number2");
                                String col5 = rs.getString("mail");
                                String col6 = rs.getString("address");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                        else {
                            if( rs2.next() ){
                                do{
                                    String col1 = rs2.getString("customer_ID");
                                    String col2 = rs2.getString("customer_name");
                                    String col3 = rs2.getString("phone_number1");
                                    String col4 = rs2.getString("phone_number2");
                                    String col5 = rs2.getString("mail");
                                    String col6 = rs2.getString("address");

                                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                                }while(rs2.next());
                                table.setModel(data);
                                rs2.close();
                            }
                        }

                    }catch(Exception ex){
//                        System.out.println("No database connection with customer DB"+ex);
//                        NoConnection no = new NoConnection();
//                        RakibsTraders.popUp(no);
                          Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            }
            else { // Or if its a name
                PreparedStatement pstmt3;
                try {
                    pstmt3 = con.prepareStatement(query3);
                    pstmt3.setString(1,"%" + searchData + "%");
                    ResultSet rs3 = pstmt3.executeQuery();
                    
                    if( rs3.next() ){
                        do{
                            String col1 = rs3.getString("customer_ID");
                            String col2 = rs3.getString("customer_name");
                            String col3 = rs3.getString("phone_number1");
                            String col4 = rs3.getString("phone_number2");
                            String col5 = rs3.getString("mail");
                            String col6 = rs3.getString("address");

                            data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                        }while(rs3.next());
                        table.setModel(data);
                        rs3.close();
                    }
                
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }   
        }
    }//GEN-LAST:event_jButtonGOActionPerformed

    private void getTheSearchDone()
    {
        
        String searchData = jTextFieldSearchCustomer1.getText();
//        if (searchData.matches(".*[a-z].*") || searchData.matches(".*[A-Z].*")) { 
//                // Do something
//                System.err.println("Fuck you dataa");
//        }
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        if( !searchData.equals("Customer ID,Name,Phone Number") ){
            String query1 = "select * from customer where phone_number1 like ? ";
            String query2 = "select * from customer where phone_number2 like ?";
            String query3 = "select * from customer where customer_name like ?";
            String query4 = "select * from customer where customer_ID = ? ";
            
            Connection con = DBConnectionProvider.getDBConnection();
            if( searchData.startsWith("#C") ){
                try { 
                    PreparedStatement pstmt = con.prepareStatement(query4);
                    pstmt.setString(1, searchData );
                    ResultSet rs = pstmt.executeQuery();
                    
                    if( rs.next() ){
                            do{
                                String col1 = rs.getString("customer_ID");
                                String col2 = rs.getString("customer_name");
                                String col3 = rs.getString("phone_number1");
                                String col4 = rs.getString("phone_number2");
                                String col5 = rs.getString("mail");
                                String col6 = rs.getString("address");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
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
                        
                        if( rs.next() ){
                            do{
                                String col1 = rs.getString("customer_ID");
                                String col2 = rs.getString("customer_name");
                                String col3 = rs.getString("phone_number1");
                                String col4 = rs.getString("phone_number2");
                                String col5 = rs.getString("mail");
                                String col6 = rs.getString("address");

                                data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                            }while(rs.next());
                            table.setModel(data);
                            rs.close();
                        }
                        else {
                            if( rs2.next() ){
                                do{
                                    String col1 = rs2.getString("customer_ID");
                                    String col2 = rs2.getString("customer_name");
                                    String col3 = rs2.getString("phone_number1");
                                    String col4 = rs2.getString("phone_number2");
                                    String col5 = rs2.getString("mail");
                                    String col6 = rs2.getString("address");

                                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                                }while(rs2.next());
                                table.setModel(data);
                                rs2.close();
                            }
                        }

                    }catch(Exception ex){
//                        System.out.println("No database connection with customer DB"+ex);
//                        NoConnection no = new NoConnection();
//                        RakibsTraders.popUp(no);
                          Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            }
            else { // Or if its a name
                PreparedStatement pstmt3;
                try {
                    pstmt3 = con.prepareStatement(query3);
                    pstmt3.setString(1,"%" + searchData + "%");
                    ResultSet rs3 = pstmt3.executeQuery();
                    
                    if( rs3.next() ){
                        do{
                            String col1 = rs3.getString("customer_ID");
                            String col2 = rs3.getString("customer_name");
                            String col3 = rs3.getString("phone_number1");
                            String col4 = rs3.getString("phone_number2");
                            String col5 = rs3.getString("mail");
                            String col6 = rs3.getString("address");

                            data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                        }while(rs3.next());
                        table.setModel(data);
                        rs3.close();
                    }
                
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jTextFieldCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerIDActionPerformed
        // TODO add your handling code here:
        getTheEditDone();
    }//GEN-LAST:event_jTextFieldCustomerIDActionPerformed

    private void jButtonEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCustomerActionPerformed
        // TODO add your handling code here:
       EditCustomer page = new EditCustomer();
       page.setCaller(this);
       String customerID = jTextFieldCustomerID.getText();
       
       Connection con = DBConnectionProvider.getDBConnection();
       String query = "select * from customer where customer_ID = ?";
       
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString( 1, customerID );
            ResultSet rs = pstmt.executeQuery();
            
            while( rs.next() ){
                page.setData( customerID, rs.getString("customer_name") ,rs.getString("phone_number1"),rs.getString("phone_number2"),rs.getString("address"),rs.getString("mail"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       
       RakibsTraders.popUp(page);
        
    }//GEN-LAST:event_jButtonEditCustomerActionPerformed
    
    private void getTheEditDone()
    {
          EditCustomer page = new EditCustomer();
       String customerID = jTextFieldCustomerID.getText();
       
       Connection con = DBConnectionProvider.getDBConnection();
       String query = "select * from customer where customer_ID = ?";
       
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString( 1, customerID );
            ResultSet rs = pstmt.executeQuery();
            
            while( rs.next() ){
                page.setData( customerID, rs.getString("customer_name") ,rs.getString("phone_number1"),rs.getString("phone_number2"),rs.getString("address"),rs.getString("mail"));
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
                new CustomerList().setVisible(true);
            }
        });
    }
    private DefaultTableModel data = new DefaultTableModel(new String[]{"Customer ID "," Customer Name", "Phone 1", "Phone 2" ,"Email", "Address" }, 0);
    private void initTable(){
        setData();  
        JTable tables = new JTable();
        tables.setModel(data);
        scrPaneTable2.getViewport().add(tables);
        
    }
    
    private void setData(){
        
        Connection con = DBConnectionProvider.getDBConnection();
        String query= "select * from customer";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if(rs.next()){
                do{
                    String col1 = rs.getString("customer_ID");
                    String col2 = rs.getString("customer_name");
                    String col3 = rs.getString("phone_number1");
                    String col4 = rs.getString("phone_number2");
                    String col5 = rs.getString("mail");
                    String col6 = rs.getString("address");
                    
                    data.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
                }while(rs.next());
                table.setModel(data);
                rs.close();
            }

        }catch(Exception ex){
            System.out.println("No database connection with customer DB"+ex);
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
    }

    //custom variable
    private JTable table = new JTable();
    private JFrame caller;
    //end of custom variable
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditCustomer;
    private javax.swing.JButton jButtonGO;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldCustomerID;
    private javax.swing.JTextField jTextFieldSearchCustomer1;
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
