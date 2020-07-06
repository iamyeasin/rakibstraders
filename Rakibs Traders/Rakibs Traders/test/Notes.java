/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RH Rafi
 */

//table model
/*public class Notes {
 
    public void showDetails(String id){
        DefaultTableModel details = new DefaultTableModel(new String[]{"DOB","Age", "Sex", "Blood grp", "Nationality", "Maritial sts.", "Join Date", "Address"}, 0);
        try{
            st = conn.createStatement();
            String sql="SELECT * FROM emp_Details WHERE ID = '"+id+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                String col1 = rs.getString("DOB");
                String col2 = rs.getString("Age");
                String col3 = rs.getString("Sex");                
                String col4 = rs.getString("Blood_Grp");
                String col5 = rs.getString("Nationality");
                String col6 = rs.getString("Marit_Status");
                String col7 = rs.getString("Join_Date");
                String col8 = rs.getString("Address");
                details.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8});
            }
            jTableEmpDetails.setModel(details);
            rs.close();
    
}*/
