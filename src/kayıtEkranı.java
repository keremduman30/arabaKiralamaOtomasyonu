
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerem
 */
public class kayıtEkranı extends javax.swing.JDialog {
   private  kayıt_islemleri kayıt_islemleri=new kayıt_islemleri();

    /**
     * Creates new form kayıtEkranı
     */
    public kayıtEkranı(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ad_alanı = new javax.swing.JTextField();
        kaydol = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        parola_alanı = new javax.swing.JPasswordField();
        mesaj_alanı = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("kayıt olma");
        setBackground(new java.awt.Color(36, 47, 65));
        setBounds(new java.awt.Rectangle(500, 150, 0, 0));

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setForeground(new java.awt.Color(36, 47, 65));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setEnabled(false);
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kullanıcı Adı : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("parola : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 60, -1));

        ad_alanı.setBackground(new java.awt.Color(36, 47, 65));
        ad_alanı.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ad_alanı.setForeground(new java.awt.Color(255, 255, 255));
        ad_alanı.setBorder(null);
        jPanel1.add(ad_alanı, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 190, -1));

        kaydol.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        kaydol.setForeground(new java.awt.Color(36, 47, 65));
        kaydol.setText("Kaydol");
        kaydol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydolActionPerformed(evt);
            }
        });
        jPanel1.add(kaydol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 131, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 200, 30));

        parola_alanı.setBackground(new java.awt.Color(36, 47, 65));
        parola_alanı.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        parola_alanı.setForeground(new java.awt.Color(255, 255, 255));
        parola_alanı.setBorder(null);
        jPanel1.add(parola_alanı, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 190, -1));

        mesaj_alanı.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(mesaj_alanı, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 360, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void kaydolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydolActionPerformed
       
        String ad=ad_alanı.getText();
           String parola=String.valueOf(parola_alanı.getPassword());
           if(ad.trim().equals("")&& parola.trim().equals("")){
           mesaj_alanı.setText("lütfen tüm boslukları doldurunuz");
           }
           else{
            kayıt_islemleri.kullanıcı_ekle(ad,parola);
           JOptionPane.showMessageDialog(this, "kayıt basarılı");
           setVisible(false);
           }
          
           
           
           
           
      
        
        
    }//GEN-LAST:event_kaydolActionPerformed

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
            java.util.logging.Logger.getLogger(kayıtEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kayıtEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kayıtEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kayıtEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                kayıtEkranı dialog = new kayıtEkranı(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_alanı;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton kaydol;
    private javax.swing.JLabel mesaj_alanı;
    private javax.swing.JPasswordField parola_alanı;
    // End of variables declaration//GEN-END:variables
}
