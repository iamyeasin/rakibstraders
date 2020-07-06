package UI.BigPopUp;

import Database.DBConnectionProvider;
import UI.PopUp.NoConnection;
import UI.Sell;
import com.placeholder.PlaceHolder;
import graph.SellsReportGraph;
import java.awt.List;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.LineChart;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rakibs.traders.RakibsTraders;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javax.swing.JFrame;
/**
 *
 * @author RH Rafi
 */
public class SellsReports extends javax.swing.JFrame {
    /**
     * Creates new form ProductsTable
     */
    
    PlaceHolder place;


    public SellsReports() {
        initComponents();
        initTable();
        setIcon();
        place = new PlaceHolder(jTextFieldSearchProduct,"Enter Product ID");
        if(!(jCheckBox1.isSelected())){
            jTextFieldSearchProduct.setEnabled(false);
            jButtonGO1.setEnabled(false);
        }
        
        if( !(jCheckBox2.isSelected()) ){
            jDateChooser2.setEnabled(false);
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

        scrPaneTable = new javax.swing.JScrollPane();
        lblExpenseHistory = new javax.swing.JLabel();
        jTextFieldSearchProduct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonGO = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButtonGO1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButtonRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonViewStock2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(scrPaneTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 1030, 270));

        lblExpenseHistory.setFont(new java.awt.Font("Titillium", 0, 22)); // NOI18N
        lblExpenseHistory.setForeground(new java.awt.Color(67, 196, 114));
        lblExpenseHistory.setText("Sells Report");
        getContentPane().add(lblExpenseHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 43));

        jTextFieldSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchProductActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 180, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Time Selected: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 200, 40));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("#Days");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 270, 40));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Total Sold Value:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 200, 40));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("#Sold Value");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 270, 40));

        jButtonGO.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGO.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGO.setText("GO");
        jButtonGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 60, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, 30));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("TO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 50, 30));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 220, 30));

        jButtonGO1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGO1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGO1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGO1.setText("GO");
        jButtonGO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGO1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 60, 30));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Sells Reports by:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 30));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("FROM:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 50, 30));

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Active Product");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 160, -1));

        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setFocusable(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 30, 30));

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 110, 30));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("#Item");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 270, 40));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Item found :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 190, 40));

        jButtonViewStock2.setBackground(new java.awt.Color(0, 51, 153));
        jButtonViewStock2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonViewStock2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonViewStock2.setText("STOCK");
        jButtonViewStock2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewStock2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonViewStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 120, 30));

        jButton1.setBackground(new java.awt.Color(220, 70, 9));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("GRAPH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 140, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -380, 2540, 1380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchProductActionPerformed
    public ArrayList<String> dates = new ArrayList<String>();
    public ArrayList<Double> values = new ArrayList<Double>();
    
    private void jButtonGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGOActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable.getViewport().add(table);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startingDate = dateFormat.format(jDateChooser1.getDate());
        
        if( !startingDate.equals("") && !( jCheckBox2.isSelected()) ){ // just working with starting date;

            Connection con = DBConnectionProvider.getDBConnection();
            String query = "select * from invoice_list where date = ? order by invoice_ID asc";
            int rownum = 0;
            
            try{
                PreparedStatement pstmt1 = con.prepareStatement(query);
                pstmt1.setString(1,startingDate); // It stored in database with a fucking extra space. fakfakfkakfkakfkakfkafkakfk
                ResultSet rs= pstmt1.executeQuery();
                BigDecimal totalValueOfSearch = BigDecimal.ZERO;
                dates.clear(); values.clear();
                
                if(rs.next()){
                    do{
                        rownum++;
                        String col1 = rs.getString("date");
                        
                        String col2 = rs.getString("time");
                        String col3 = rs.getString("invoice_ID");
                        String col4 = rs.getString("customer_ID");
                        Double col5 = rs.getDouble("total");
                        dates.add(col1);
                        values.add(col5);
                        String custName = getData(col4);
                        totalValueOfSearch = totalValueOfSearch.add(new BigDecimal(col5));

                        data.addRow(new Object[]{col1, col2, col3,custName, String.format("%.4f",col5)});
                        
                    }while(rs.next());
                    table.setModel(data);
                    rs.close();
                    jLabel9.setText(rownum + "");
                    jLabel5.setText(String.format("%.4f",totalValueOfSearch));
                }

                }catch(Exception ex){
                    System.out.println("No database connection"+ex);
                    NoConnection no = new NoConnection();
                    RakibsTraders.popUp(no);
                }
        }
        else{
//            select * from invoice_list where date between "yyyy-MM-dd" and " yyyy-MM-dd"
            String endingDate = dateFormat.format(jDateChooser2.getDate()); 
            Connection con = DBConnectionProvider.getDBConnection();
            String query = "select * from invoice_list where date between  ?  and  ? order by invoice_ID asc";
            int rownum = 0;
            
            try{
                PreparedStatement pstmt1 = con.prepareStatement(query);
                pstmt1.setString(1,startingDate);
                pstmt1.setString(2,endingDate); 
                ResultSet rs= pstmt1.executeQuery();
                BigDecimal totalValueOfSearch = BigDecimal.ZERO;
                dates.clear(); values.clear();
                
                if(rs.next()){
                    do{
                        rownum++;
                        String col1 = rs.getString("date");
                        String col2 = rs.getString("time");
                        String col3 = rs.getString("invoice_ID");
                        String col4 = rs.getString("customer_ID");
                        Double col5 = rs.getDouble("total");
                        String custName = getData(col4);
                        dates.add(col1);
                        values.add(col5);
                        totalValueOfSearch = totalValueOfSearch.add(new BigDecimal(col5));
                        
                        data.addRow(new Object[]{col1, col2, col3,custName, String.format("%.4f",col5)});
                        
                    }while(rs.next());
                    table.setModel(data);
                    rs.close();
                    Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startingDate);
                    Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
                    long diff = d2.getTime() - d1.getTime();
                    jLabel2.setText(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " Days");
                    jLabel9.setText(rownum + "");
                    jLabel5.setText(String.format("%.4f",totalValueOfSearch));
                }

                }catch(Exception ex){
                    System.out.println("No database connection"+ex);
                    NoConnection no = new NoConnection();
                    RakibsTraders.popUp(no);
                }
            
        }
        
        
    }//GEN-LAST:event_jButtonGOActionPerformed

    private void jButtonGO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGO1ActionPerformed
        // TODO add your handling code here:
        JTable table2 = new JTable();
        DefaultTableModel data2 = new DefaultTableModel(new String[]{"Date", "Customer Name", "Invoice ID", "Price" }, 0);
        
        data.getDataVector().removeAllElements();
        table2.setModel(data2);
        scrPaneTable.getViewport().add(table2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        if( !jCheckBox2.isSelected() && jTextFieldSearchProduct.getText().startsWith("#") ){
            // Working with only date
            String productID = jTextFieldSearchProduct.getText();
            String startingDate = dateFormat.format(jDateChooser1.getDate()); 
            Connection con = DBConnectionProvider.getDBConnection();
            
//            System.err.println(productID);
            
            String query = "SELECT price,invoice_list.customer_ID,invoice_products.invoice_ID,date FROM invoice_products INNER JOIN invoice_list ON invoice_products.invoice_ID = invoice_list.invoice_ID  and product_ID = ? and date = ? order by invoice_products.invoice_ID asc";
            String query2 = "Select customer_name from customer where customer_ID = ?";
            dates.clear(); values.clear();
            
            try {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString( 1, productID );
                pstmt.setString( 2,startingDate );
                ResultSet rs = pstmt.executeQuery();
//                System.err.println("Working2");
                Integer rowcount= 0;
                BigDecimal totalForSearch = BigDecimal.ZERO; // Ne sala , kha eibar koto error khaite paros
                
                while( rs.next() ){
                        rowcount++;
                        String col1 = rs.getString("date");
                        String col2 = rs.getString("customer_ID");
                        String col3 = rs.getString("invoice_ID");
                        Double col5 = rs.getDouble("price");
                        dates.add(col1);
                        values.add(col5);
                        totalForSearch = totalForSearch.add(new BigDecimal(col5));
//                        System.err.println(totalForSearch);
                        PreparedStatement pstmt2 = con.prepareStatement(query2);
                        pstmt2.setString(1, col2);
                        ResultSet rs2 = pstmt2.executeQuery();
                        String custName = "";
                        
                        if( rs2.next() ){
                            custName = rs2.getString("customer_name");
                        }
                        data2.addRow(new Object[]{col1, custName, col3,String.format("%.4f",col5)});
                }
                
                rs.close(); jLabel9.setText(rowcount + "");
                jLabel5.setText(String.format("%.4f",totalForSearch));
                
                
            } catch (SQLException ex) {
                Logger.getLogger(SellsReports.class.getName()).log(Level.SEVERE, null, ex);
                NoConnection page = new NoConnection();
                RakibsTraders.popUp(page);
            }
        }
        else{
            
            String productID = jTextFieldSearchProduct.getText();
            String startingDate = dateFormat.format(jDateChooser1.getDate()); 
            String endingDate = dateFormat.format(jDateChooser2.getDate()); 
            Connection con = DBConnectionProvider.getDBConnection();
            
            String query = "SELECT price,invoice_list.customer_ID,invoice_products.invoice_ID,date FROM invoice_products INNER JOIN invoice_list ON invoice_products.invoice_ID = invoice_list.invoice_ID  and product_ID = ? and date between ? and ? order by invoice_products.invoice_ID asc";
            String query2 = "Select customer_name from customer where customer_ID = ?";
            
            try {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString( 1, productID );
                pstmt.setString( 2, startingDate );
                pstmt.setString( 3, endingDate );
                ResultSet rs = pstmt.executeQuery();
//                System.err.println("Working2");
                Integer rowcount= 0;
                BigDecimal totalForSearch = BigDecimal.ZERO; // Ne sala , kha eibar koto error khaite paros
                dates.clear(); values.clear();
                
                while( rs.next() ){
                        rowcount++;
                        String col1 = rs.getString("date");
                        String col2 = rs.getString("customer_ID");
                        String col3 = rs.getString("invoice_ID");
                        Double col5 = rs.getDouble("price");
                        dates.add(col1);
                        values.add(col5);
                        totalForSearch = totalForSearch.add(new BigDecimal(col5));
//                        System.err.println(totalForSearch);

                        PreparedStatement pstmt2 = con.prepareStatement(query2);
                        pstmt2.setString(1, col2);
                        ResultSet rs2 = pstmt2.executeQuery();
                        String custName = "";
                        System.err.println(col2);
                        
                        if( rs2.next() ){
                            custName = rs2.getString("customer_name");
                        }
                        
                        data2.addRow(new Object[]{col1, custName, col3,String.format("%.4f",col5)});
                }
                
                rs.close(); 
                Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startingDate);
                Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
                long diff = d2.getTime() - d1.getTime();
                jLabel2.setText(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " Days");
                jLabel9.setText(rowcount + "");
                jLabel5.setText(String.format("%.4f",totalForSearch));
                
                
            } catch (SQLException ex) {
                Logger.getLogger(SellsReports.class.getName()).log(Level.SEVERE, null, ex);
                NoConnection page = new NoConnection();
                RakibsTraders.popUp(page);
            } catch (ParseException ex) {
                Logger.getLogger(SellsReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonGO1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
       if((jCheckBox1.isSelected()) ){
            jTextFieldSearchProduct.setEnabled(true);
            jButtonGO1.setEnabled(true);
       }
       else{
           jTextFieldSearchProduct.setEnabled(false);
           jButtonGO1.setEnabled(false);
       }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if( !(jCheckBox2.isSelected()) ){
            jDateChooser2.setEnabled(false);
        }
        else{
            jDateChooser2.setEnabled(true);
        }
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        data.getDataVector().removeAllElements();
        table.setModel(data);
        scrPaneTable.getViewport().add(table);
        setData();
        jLabel2.setText("#Days");
        jLabel9.setText("#Item");
        jLabel5.setText("#Sold Value");
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonViewStock2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewStock2ActionPerformed
        // TODO add your handling code here:
        ViewStock page = new ViewStock();
        page.setCaller(this);
        RakibsTraders.bigPopUp(page);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonViewStock2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SellsReportGraph page = new SellsReportGraph() {
            @Override
            public void start(Stage primaryStage) throws Exception {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        page.setData(dates,values);
        page.main();
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellsReports().setVisible(true);
            }
        });
    }

    private void initTable(){
        setData();
        scrPaneTable.getViewport().add(table);
    }
    
    private String getData( String custID){
        
        ResultSet rs;
        String name = "";
        Connection con = DBConnectionProvider.getDBConnection();
        String query2 = "select customer_name from customer where customer_ID = ?"; 
        PreparedStatement  pstmt;
        
        try {
            pstmt = con.prepareStatement(query2);
            pstmt.setString(1, custID);
            rs = pstmt.executeQuery();
            
            if( rs.next() ){
                name = rs.getString("customer_name");
            }
            rs.close();
        } catch (SQLException ex) {
            NoConnection page = new NoConnection();
            RakibsTraders.popUp(page);
            Logger.getLogger(SellsReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
        
    }
   
    DefaultTableModel data = new DefaultTableModel(new String[]{"Date", "Time", "Invoice ID", "Customer Name", "Total" }, 0);
    private void setData(){
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "select * from invoice_list";
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if(rs.next()){
                do{
                    String col1 = rs.getString("date");
                    String col2 = rs.getString("time");
                    String col3 = rs.getString("invoice_ID");
                    String col4 = rs.getString("customer_ID");
                    Double col5 = rs.getDouble("total");
                    String custName = getData(col4);//Returns Customer ID
                    
                    data.addRow(new Object[]{col1, col2, col3,custName, String.format("%.4f",col5)});
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGO;
    private javax.swing.JButton jButtonGO1;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonViewStock2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldSearchProduct;
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
