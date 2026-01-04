/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objekwisata.app.setting;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class koneksi {
    //membuat variabel yang mengarah ke database objekwisata_app
   private static String DB = "jdbc:mysql://localhost/objekwisata_app";
   
   //function untuk konek ke database
   public static Connection getKoneksi(){
       Connection conn = null;
       MysqlDataSource data = new MysqlDataSource();
       data.setUser("root");
       data.setPassword("");
       data.setURL(DB);
       try {
           conn = data.getConnection();
       } catch (SQLException ex) {
           Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
       
   }
    
}
