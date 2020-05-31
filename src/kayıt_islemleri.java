
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class kayıt_islemleri {
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    public void kullanıcı_ekle(String ad,String parola){
        String sorgu="INSERT into kullanıcı(ad,parola) VALUES(?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, parola);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kayıt_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    public kayıt_islemleri(){
      String url="jdbc:mysql://" + database.host + ":" + database.port +"/" + database.database_ismi+"?useUnicode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("drive bulunamadı");        } 
            
        try {
            con=DriverManager.getConnection(url, database.kullanıcı_adı, database.parola);
            System.out.println("baglantı basarılı");
        } catch (SQLException ex) {
            System.out.println("baglantı basarısız");
            
        
    }
    }
    public static void main(String[] args) {
        kayıt_islemleri kayıt=new kayıt_islemleri();
        
    }
        
    }
    
    

