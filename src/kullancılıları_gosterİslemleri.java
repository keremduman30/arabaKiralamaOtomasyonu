
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class kullancılıları_gosterİslemleri {
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    public ArrayList<kullanıcı> kullanıcı_goster(){
    String sorgu="Select * From kullanıcı";
    ArrayList<kullanıcı> cıktı=new ArrayList<kullanıcı>();
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
            int id=rs.getInt("id");
            String ad=rs.getString("ad");
            String parola=rs.getString("parola");
            cıktı.add(new kullanıcı(id, ad, parola));
            }
            return cıktı;
            
        } catch (SQLException ex) {
            Logger.getLogger(kullancılıları_gosterİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    
    }
    public void sil(int id){
    String sorgu="Delete From kullanıcı where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kullancılıları_gosterİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public kullancılıları_gosterİslemleri() {
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
        kullancılıları_gosterİslemleri goster=new kullancılıları_gosterİslemleri();
    }
    
}
