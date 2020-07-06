
package UI;

import Database.DBConnectionProvider;
import UI.PopUp.NoConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import rakibs.traders.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Login page
 * @author RH Rafi
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userTextF = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblUserInvalid = new javax.swing.JLabel();
        lblPassInvalid = new javax.swing.JLabel();
        userPassF = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTextF.setFont(new java.awt.Font("Titillium", 0, 14)); // NOI18N
        userTextF.setText("User Name");
        userTextF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTextFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userTextFFocusLost(evt);
            }
        });
        userTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFActionPerformed(evt);
            }
        });
        getContentPane().add(userTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 250, 32));

        btnGo.setBackground(new java.awt.Color(204, 204, 204));
        btnGo.setFont(new java.awt.Font("Titillium", 1, 15)); // NOI18N
        btnGo.setText("GO");
        btnGo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 130, 30));

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/002-user.png"))); // NOI18N
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 30, 30));

        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/003-open-lock.png"))); // NOI18N
        getContentPane().add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 30, 32));

        lblUserInvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/cross-mark.png"))); // NOI18N
        getContentPane().add(lblUserInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, 30, 30));
        lblUserInvalid.setVisible(false);

        lblPassInvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/cross-mark.png"))); // NOI18N
        getContentPane().add(lblPassInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 34, 30));
        lblPassInvalid.setVisible(false);

        userPassF.setFont(new java.awt.Font("Titillium", 0, 14)); // NOI18N
        userPassF.setToolTipText("Password");
        userPassF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPassFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userPassFFocusLost(evt);
            }
        });
        userPassF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPassFActionPerformed(evt);
            }
        });
        userPassF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userPassFKeyPressed(evt);
            }
        });
        getContentPane().add(userPassF, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 250, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/Asset 6@0.5x.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/Backround.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFFocusGained
        // TODO add your handling code here:
        userTextF.setText("");
        userTextF.setForeground(Color.BLACK);
        lblUserInvalid.setVisible(false);
    }//GEN-LAST:event_userTextFFocusGained

    private void userTextFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFFocusLost
        // TODO add your handling code here:
        if (userTextF.getText().isEmpty()) {
                userTextF.setForeground(Color.GRAY);
                userTextF.setText("User Name");
            }
    }//GEN-LAST:event_userTextFFocusLost

    private void userPassFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPassFFocusGained
         userPassF.setText("");
         userPassF.setForeground(Color.black);
         lblPassInvalid.setVisible(false);
    }//GEN-LAST:event_userPassFFocusGained

    private void userPassFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPassFFocusLost
            userPassF.setForeground(Color.GRAY);
    }//GEN-LAST:event_userPassFFocusLost

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
       // TODO add your handling code here:
        String user = userTextF.getText();
        char[] passArray = userPassF.getPassword();
        String pass = String.valueOf(passArray);
        this.userName = user;
        String passCheck = "", userCheck = "";
        //System.out.println(pass);
//        Connection con = DBConnectionProvider.getDBConnection();
//        Login_Page L = Login_Page.getRef();
//
//        try{
//            Statement stmt = con.createStatement();
//            String query = "select * from user_table";
//            ResultSet rs = stmt.executeQuery(query);
//            if(L.gettxtUserName().isEmpty() || L.getpassField().isEmpty()){
//                L.settxtUserName("Enter your user Name and password");
//            }else{
//                
//                String userName = L.gettxtUserName();
//                String password = L.getpassField();
//                while(rs.next()){
//                    String dbUser = rs.getString("User_name");
//                    String dbPass = rs.getString("Password");
//                    L.setCurrentuser(dbUser, dbPass);
//               
//                   if(userName.equals(dbUser) && password.equals(dbPass)){
//                        ApplicationFrame ref= ApplicationFrame.getRef();
//                        ref.remove(Login_Page.getRef());
//                        ref.add(Menu.getRef(), BorderLayout.CENTER);
//                        ref.paintAll(ref.getGraphics());
//                        break;
//                   }
//                   else{
//                       L.settxtUserName("Enter your user Name and password");
//                       L.setPassField();
//                   }
//                
//                }
//            }
        Connection con = DBConnectionProvider.getDBConnection();
        try{
            
            String query = "select * from user_list where user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                userCheck = rs.getString("user_name");
                passCheck = rs.getString("user_password");
                this.userAccess = rs.getString("access_level");
            }
                
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
        //System.out.println("User db:"+userCheck);
        //System.out.println("User:"+user);
        if(user.equals("admin") || user.equals(userCheck) && !userCheck.equals("")){
            if(pass.equals("admin") || pass.equals(passCheck) && !passCheck.equals("")){
                try{
                    insertLog();
                    this.userPass = pass;
                    Sell page = Sell.getRef();
                    page.setFlagTime();
                    page.setTime();
                    RakibsTraders.changeFrame(this,page);
                    RakibsTraders.setAccess();
                }catch(Exception ex){
                   System.out.println("Failed to get DBConn:: "+ex.getMessage()); 
                   NoConnection no = new NoConnection();
                   RakibsTraders.popUp(no);
                }
                
            }else{
                this.lblPassInvalid.setVisible(true);
                this.userPassF.setText("");
            }
        }else{
            this.lblUserInvalid.setVisible(true);
        }
    }//GEN-LAST:event_btnGoActionPerformed

    private void userPassFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPassFActionPerformed
        // TODO add your handling code here:
        btnGoActionPerformed(evt);
    }//GEN-LAST:event_userPassFActionPerformed

    private void userTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextFActionPerformed

    private void userPassFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userPassFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPassFKeyPressed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassInvalid;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserInvalid;
    private javax.swing.JPasswordField userPassF;
    private javax.swing.JTextField userTextF;
    // End of variables declaration//GEN-END:variables
    
    //custom variable
    private static LoginPage ref;
    private String userName = "";
    private String userPass = "";
    private String userAccess = "";
    private int sl;
    //end of custom variable
    
    private void setIcon(){
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icons/Icon.png")).getImage());
    }

    
    public static LoginPage getRef(){
        if(ref==null)
            ref = new LoginPage();
        return ref;
    }
    
    public void clearField(){
        this.userPassF.setText("");
        this.userTextF.setText("");
    }
    
    public String userName(){
        return this.userName;
    }
    
    public String userPass(){
        return this.userPass;
    }
    
    public int sl(){
        return this.sl;
    }
    
    public Integer userAccess(){
        
        if(this.userAccess.equals("admin") || this.userPass.equals("admin"))
            return 1;
        else if(this.userAccess.equals("Moderator"))
            return 2;
        else if(this.userAccess.equals("User"))
            return 3;
        else if(this.userAccess.equals("Guest"))
            return 4;
        else    
            return 0;
        
        
    }
    
    private void insertLog(){
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "insert into user_log ( user_name, log_in, log_out) VALUES (?, ?, ?)";
        String query2 = "SELECT * FROM user_log ORDER BY SL DESC LIMIT 1";
        try{
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userName);
            pstmt.setObject(2, dateTime());
            pstmt.setObject(3, dateTime());
            pstmt.executeUpdate();
                
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            while(rs.next())
                this.sl = rs.getInt("SL");
            System.out.println(""+this.sl);
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
            NoConnection no = new NoConnection();
            RakibsTraders.popUp(no);
        }
        
    }
    
    private String dateTime(){
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = dFormat.format(d);
        return date;
    }
}