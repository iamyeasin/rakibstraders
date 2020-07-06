package UI.BigPopUp;

import Database.DBConnectionProvider;
import UI.PopUp.NoConnection;
import UI.Reports;
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
public class BillingList extends javax.swing.JFrame {
    /**
     * Creates new form ProductsTable
     */
    PlaceHolder place;
    
    public BillingList() {
        initComponents();
        initTable();
        setIcon();
        place = new PlaceHolder(jTextFieldSearchBills1,"Show me the Bills");
        place = new PlaceHolder(jTextFieldSearchBills,"Search Bills");
        ref=this;
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
        jTextFieldSearchBills1 = new javax.swing.JTextField();
        scrPaneTable2 = new javax.swing.JScrollPane();
        lblInvoiceList = new javax.swing.JLabel();
        jTextFieldSearchBills = new javax.swing.JTextField();
        jButtonGetBills = new javax.swing.JButton();
        jButtonGO = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Search Bills");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 100, 50));

        jTextFieldSearchBills1.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchBills1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchBills1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchBills1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 180, 30));
        getContentPane().add(scrPaneTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 980, 310));

        lblInvoiceList.setFont(new java.awt.Font("Titillium", 0, 22)); // NOI18N
        lblInvoiceList.setForeground(new java.awt.Color(67, 196, 114));
        lblInvoiceList.setText("Billing List");
        getContentPane().add(lblInvoiceList, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 304, 43));

        jTextFieldSearchBills.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchBillsActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchBills, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 180, 30));

        jButtonGetBills.setBackground(new java.awt.Color(0, 51, 153));
        jButtonGetBills.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGetBills.setText("Get Bills");
        jButtonGetBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetBillsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetBills, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 160, 30));

        jButtonGO.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGO.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGO.setText("GO");
        jButtonGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 60, 30));

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 110, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 2540, 1380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchBills1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBills1ActionPerformed
        // TODO add your handling code here:
        getTheEditDone();
    }//GEN-LAST:event_jTextFieldSearchBills1ActionPerformed

    private void jTextFieldSearchBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillsActionPerformed
        // TODO add your handling code here:
        getTheSearchDone();
    }//GEN-LAST:event_jTextFieldSearchBillsActionPerformed

    private void jButtonGetBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetBillsActionPerformed
        // TODO add your handling code here:
       String SearchBillingID = jTextFieldSearchBills1.getText();
        
        if(SearchBillingID.startsWith("B#")){
            Bills page = Bills.getRef();
            page.setCaller(this);
            page.AccessSave = true;
            DefaultTableModel data = new DefaultTableModel(new String[]{"Products ID", "Company Name", "Model", "Box", "Pcs","Feet", "Unit", "Unit Price", "Total"}, 0);

            Connection con = DBConnectionProvider.getDBConnection();
            

            String query1 = "Select * from bill_list where billing_ID = ?";
            String query2 = "Select * from bill_products where billing_ID = ?";
            String query3 = "Select * from payment where billing_ID = ?";
            String query4 = "Select * from products where products_ID = ?";
            String query5 = "select sum(paid_amount) as total_paid_amount from payment where ID = ?";

            String timeAndDate="",vendorID="",PayableNumber;
            PreparedStatement pstmt;
            Double totalPrice = 0.0, totalPaidForBills = 0.0 , Discount = 0.0 , LabourCost=0.0 ;

            try {
                pstmt = con.prepareStatement(query1);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                    timeAndDate = rs.getString("time") + rs.getString("date");
                    vendorID = rs.getString("vendor_ID");
                    //totalPrice = rs.getDouble("total");
                    LabourCost = rs.getDouble("labour_cost");
                    Discount = rs.getDouble("discount");
                }

            } catch (SQLException ex) {
    //            Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No database connection"+ex);
                NoConnection no = new NoConnection();
                RakibsTraders.popUp(no);
            }

            String productID = "",companyName="", ItemUnit = "",model = "", buyAmount = "";
            Double unitPrice=0.0, TotalForSingleRow = 0.0 ;
            String Box = "", Pcs = "", Feet = "";
            
            try {
                pstmt = con.prepareStatement(query2);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();
                PreparedStatement pstmt2 = con.prepareStatement(query4);

                while( rs.next() ){
                       productID = rs.getString("products_ID");
                       TotalForSingleRow = rs.getDouble("price");
                       Box = rs.getString("Box");
                       Pcs = rs.getString("Pcs");
                       Feet = rs.getString("feet");

                       pstmt2.setString(1,productID);
                       ResultSet rs2 = pstmt2.executeQuery();

                       while( rs2.next() ) {
                           companyName = rs2.getString("company_name");
                           model = rs2.getString("model");
                           ItemUnit = rs2.getString("item_unit");
                           unitPrice = rs2.getDouble("purchase_price");
                       }
                       if( ItemUnit.equals("Pcs") || ItemUnit.equals("pcs") || ItemUnit.equals("PCS") )
                           buyAmount = rs.getString("Pcs");
                       else if( ItemUnit.equals("Box") || ItemUnit.equals("box") || ItemUnit.equals("BOX") ) { buyAmount = rs.getString("Box"); }
                       else { buyAmount = rs.getString("feet"); }

                       data.addRow(new Object[]{productID,companyName,model,Box,Pcs,Feet,ItemUnit,unitPrice,TotalForSingleRow});
                       rs2.close();
                }

            } catch (SQLException ex) {
    //            Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No database connection"+ex);
                NoConnection no = new NoConnection();
                RakibsTraders.popUp(no);
            }

            try {
                pstmt = con.prepareStatement(query5);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();

                while( rs.next() ){
                    totalPaidForBills = rs.getDouble("total_paid_amount"); 
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer row=0;
            for(int i=0; i<data.getRowCount(); i++)
                totalPrice+= (Double) data.getValueAt(row++,8);
            double netPay = totalPrice + LabourCost - Discount;

            page.setData(timeAndDate,SearchBillingID, vendorID, Double.toString(totalPrice), Double.toString( Discount ), Double.toString(LabourCost), Double.toString(netPay), data);
            if(!"Enter Invoice ID".equals(jTextFieldSearchBills1.getText()) ){ 
                page.setTables(jTextFieldSearchBills1.getText());
                page.setCaller(this);
                RakibsTraders.bigPopUp(page);
                this.setEnabled(false);
            }
        
        
        }
    }//GEN-LAST:event_jButtonGetBillsActionPerformed
    
    private void getTheEditDone()
    {
               String SearchBillingID = jTextFieldSearchBills1.getText();
        
        if(SearchBillingID.startsWith("B#")){
            Bills page = Bills.getRef();
            page.AccessSave = true;
            DefaultTableModel data = new DefaultTableModel(new String[]{"Products ID", "Company Name", "Model", "Buy Amount", "Unit", "Unit Price", "Total"}, 0);

            Connection con = DBConnectionProvider.getDBConnection();
            

            String query1 = "Select * from bill_list where billing_ID = ?";
            String query2 = "Select * from bill_products where billing_ID = ?";
            String query3 = "Select * from payment where billing_ID = ?";
            String query4 = "Select * from products where products_ID = ?";
            String query5 = "select sum(paid_amount) as total_paid_amount from payment where ID = ?";

            String timeAndDate="",vendorID="",PayableNumber;
            PreparedStatement pstmt;
            Double totalPrice = 0.0, totalPaidForBills = 0.0 , Discount = 0.0 , LabourCost=0.0 ;
            ////// FAK FAK FAK FAK FAK FAK labour cost value add kora lagbo

            try {
                pstmt = con.prepareStatement(query1);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                    timeAndDate = rs.getString("time") + rs.getString("date");
                    vendorID = rs.getString("vendor_ID");
                    //totalPrice = rs.getDouble("total");
                    LabourCost = rs.getDouble("labour_cost");
                    Discount = rs.getDouble("discount");
                }

            } catch (SQLException ex) {
    //            Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No database connection"+ex);
                NoConnection no = new NoConnection();
                RakibsTraders.popUp(no);
            }

            String productID = "",companyName="", ItemUnit = "",model = "", buyAmount = "";
            Double unitPrice=0.0, TotalForSingleRow = 0.0 ;
            try {
                pstmt = con.prepareStatement(query2);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();
                PreparedStatement pstmt2 = con.prepareStatement(query4);

                while( rs.next() ){
                       productID = rs.getString("products_ID");
                       TotalForSingleRow = rs.getDouble("price");

                       pstmt2.setString(1,productID);
                       ResultSet rs2 = pstmt2.executeQuery();

                       while( rs2.next() ) {
                           companyName = rs2.getString("company_name");
                           model = rs2.getString("model");
                           ItemUnit = rs2.getString("item_unit");
                           unitPrice = rs2.getDouble("purchase_price");
                       }
                       if( ItemUnit.equals("Pcs") || ItemUnit.equals("pcs") || ItemUnit.equals("PCS") )
                           buyAmount = rs.getString("Pcs");
                       else if( ItemUnit.equals("Box") || ItemUnit.equals("box") || ItemUnit.equals("BOX") ) { buyAmount = rs.getString("Box"); }
                       else { buyAmount = rs.getString("feet"); }

                       data.addRow(new Object[]{productID,companyName,model,buyAmount,ItemUnit,unitPrice,TotalForSingleRow});
                       rs2.close();
                }

            } catch (SQLException ex) {
    //            Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No database connection"+ex);
                NoConnection no = new NoConnection();
                RakibsTraders.popUp(no);
            }

            try {
                pstmt = con.prepareStatement(query5);
                pstmt.setString(1,SearchBillingID);
                ResultSet rs = pstmt.executeQuery();

                while( rs.next() ){
                    totalPaidForBills = rs.getDouble("total_paid_amount"); 
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(InvoiceList.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer row=0;
            for(int i=0; i<data.getRowCount(); i++)
                totalPrice+= (Double) data.getValueAt(row++,6);
            double netPay = totalPrice + LabourCost - Discount;

            page.setData(timeAndDate,SearchBillingID, vendorID, Double.toString(totalPrice), Double.toString( Discount ), Double.toString(LabourCost), Double.toString(netPay), data);
            if(!"Enter Invoice ID".equals(jTextFieldSearchBills1.getText()) ){ 
                page.setTables(jTextFieldSearchBills1.getText());
                page.setCaller(this);
                RakibsTraders.bigPopUp(page);
                this.setEnabled(false);
            }
        
        
        }
    }
    
    private void jButtonGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGOActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        String SearchBillingID = jTextFieldSearchBills.getText();
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from bill_list where billing_ID = ?";
        String query2 = "select sum(paid_amount) as total_paid_amount from payment where ID = ?";
        
        try{
            PreparedStatement pstmt2 = con.prepareStatement(query);
            pstmt2.setString(1,SearchBillingID);
            ResultSet rs = pstmt2.executeQuery();
            PreparedStatement pstmt = con.prepareStatement(query2);
            
            if(rs.next()){
                do{
                    String col1 = rs.getString("date");
                    String col2 = rs.getString("time");
                    String col3 = rs.getString("billing_ID");
                    String col4 = rs.getString("vendor_ID");
                    String col5 = Double.toString(rs.getDouble("total"));
                    String col6 = "0.0";
                    pstmt.setString(1,col3);
                    ResultSet rs2 = pstmt.executeQuery();
                    while(rs2.next()){
                        col6 = Double.toString(rs2.getDouble("total_paid_amount"));
                    }
                    Double total_due = (Double.parseDouble(col5)-Double.parseDouble(col6));
                    if( total_due < 0.0 )total_due = 0.0;
                    
                    data.addRow(new Object[]{col1, col2, col3, col4, col5,Double.toString(total_due)});
                }while(rs.next());
                table.setModel(data);
                rs.close();
            }

        }catch(Exception ex){
            System.out.println("No database connection"+ex);
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
    }//GEN-LAST:event_jButtonGOActionPerformed

    private void getTheSearchDone()
    {
                data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        
        String SearchBillingID = jTextFieldSearchBills.getText();
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from bill_list where billing_ID = ?";
        String query2 = "select sum(paid_amount) as total_paid_amount from payment where ID = ?";
        
        try{
            PreparedStatement pstmt2 = con.prepareStatement(query);
            pstmt2.setString(1,SearchBillingID);
            ResultSet rs = pstmt2.executeQuery();
            PreparedStatement pstmt = con.prepareStatement(query2);
            
            if(rs.next()){
                do{
                    String col1 = rs.getString("date");
                    String col2 = rs.getString("time");
                    String col3 = rs.getString("billing_ID");
                    String col4 = rs.getString("vendor_ID");
                    String col5 = Double.toString(rs.getDouble("total"));
                    String col6 = "0.0";
                    pstmt.setString(1,col3);
                    ResultSet rs2 = pstmt.executeQuery();
                    while(rs2.next()){
                        col6 = Double.toString(rs2.getDouble("total_paid_amount"));
                    }
                    Double total_due = (Double.parseDouble(col5)-Double.parseDouble(col6));
                    if( total_due < 0.0 )total_due = 0.0;
                    
                    data.addRow(new Object[]{col1, col2, col3, col4, col5,Double.toString(total_due)});
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
    
    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable2.getViewport().add(table);
        setData();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(BillingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingList().setVisible(true);
            }
        });
    }

    private void initTable(){
        setData();
        JTable tables = new JTable();
        tables.setModel(data);
        scrPaneTable2.getViewport().add(tables);
        
    }
    
    private DefaultTableModel data = new DefaultTableModel(new String[]{"DATE","TIME", "BILLING ID", "VENDOR ID" ,"BILLING AMOUNT", "DUE" }, 0);
    
    private void setData(){
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from bill_list";
        String query2 = "select sum(paid_amount) as total_paid_amount from payment where ID = ?";
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            PreparedStatement pstmt = con.prepareStatement(query2);
            
            if(rs.next()){
                do{
                    String col1 = rs.getString("date");
                    String col2 = rs.getString("time");
                    String col3 = rs.getString("billing_ID");
                    String col4 = rs.getString("vendor_ID");
                    String col5 = Double.toString(rs.getDouble("total"));
                    String col6 = "0.0";
                    pstmt.setString(1,col3);
                    ResultSet rs2 = pstmt.executeQuery();
                    while(rs2.next()){
                        col6 = Double.toString(rs2.getDouble("total_paid_amount"));
                    }
                    Double total_due = (Double.parseDouble(col5)-Double.parseDouble(col6));
                    if( total_due < 0.0 )total_due = 0.0;
                    
                    data.addRow(new Object[]{col1, col2, col3, col4, col5,Double.toString(total_due)});
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
    private static BillingList ref;
    private JFrame caller;
    //end of custom variable
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGO;
    private javax.swing.JButton jButtonGetBills;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldSearchBills;
    private javax.swing.JTextField jTextFieldSearchBills1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblInvoiceList;
    private javax.swing.JScrollPane scrPaneTable2;
    // End of variables declaration//GEN-END:variables
   
    private void setIcon(){
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icons/Icon.png")).getImage());
    }

    @Override
    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            caller.setEnabled(true);
            dispose();
        }
    }
    
    
    public void setCaller(JFrame frame){
        this.caller = frame;
    }
    
    public static BillingList getRef(){
        if(ref==null)
            ref = new BillingList();
        return ref;
    }
}
