
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Dbclass {
    public static final String URL  = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER = "system";
    public static final String PASS = "tannu";
    Connection con;
    Statement st;
    ResultSet rs ;
    public Dbclass(){
        try {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tannu");
            st = con.createStatement();
            rs = st.executeQuery("select * from customers");
            while(rs.next()){
                System.out.println(rs.getString("city"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
