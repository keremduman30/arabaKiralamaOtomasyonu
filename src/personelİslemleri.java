
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class personelİslemleri {
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    public void ekle(String marka,String model,String fiyat){
    String sorgu="INSERT into personel(marka,model,fiyat) VALUES(?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, marka);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, fiyat);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(personelİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public void güncelle(int id,String marka,String model,String fiyat){
        String sorgu="Update personel set marka=? , model=? , fiyat=? where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, marka);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, fiyat);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personelİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
    public void sil(int id){
        String sorgu="Delete From personel where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(personelİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    public ArrayList<personel> arabaları_getir(){
    String sorgu="Select * From personel";
    ArrayList<personel> cıktı=new ArrayList<personel>();
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
            int id=rs.getInt("id");
            String marka=rs.getString("marka");
            String model=rs.getString("model");
            String fiyat=rs.getString("fiyat");
            cıktı.add(new personel(id, marka, model, fiyat));
            }
            return cıktı;

        } catch (SQLException ex) {
            Logger.getLogger(personelİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
        
    
    }
    public boolean personel_girisi(String ad,String parola){
   String sorgu="Select * From personelgiris where ad=? and parola=?";
        try {
           preparedStatement=con.prepareStatement(sorgu);
           preparedStatement.setString(1, ad);
           preparedStatement.setString(2, parola);
            ResultSet rs=preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(personelİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
 
   
        
    }
   
    public personelİslemleri() {
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
        personelİslemleri islemler=new personelİslemleri();
    }
    
    
}
