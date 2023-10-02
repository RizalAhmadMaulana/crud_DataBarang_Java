  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

/**
 *
 * @author ASUS
 */
//Memanggil library Connection untuk menghubungkan ke database
import java.sql.Connection;
// Memanggil library Driver karena nantinya diperlukan
import java.sql.DriverManager;
// Memanggil library untuk mengawasi SQL (cirinya ada try dan catch)
import java.sql.SQLException;

// Membuat class KoneksiMysql 
public class KoneksiMysql {
    // Suatu class Connection pada variable connect
    private Connection connect;
    // Membuat variable driverName (dari Services, database, driverName) dengan tipe data String
    private final String driverName = "com.mysql.jdbc.Driver";
    // Membuat variable untuk API bernama jdbc dengan tipe data String
    private final String jdbc = "jdbc:mysql://";
    private final String host = "localhost:";
    private final String port = "3306/";
    // Membuat variable database untuk memanggil database anda
    private final String database = "penjualan";
    // Membuat variable url untuk menyambungkan jadi satu API jdbc, host, port,database
    private final String url = jdbc + host + port + database;
    // Membuat variable username dan password untuk memanggil username dan password anda dalam phpmyadmin 
    private final String username = "root";
    private final String password = "";
    
    // Membuat method getKoneksi dari class Connection kemudian throw(dilempar) SQLException
    public Connection getKoneksi() throws SQLException{
        // Membuat fungsi Logika
        // Jika variacle connect sama dengan null maka mencari library DriverManager
        if (connect == null) {
            //Coba
            try {
                // buat mendeklarasi class driver Name
                Class.forName(driverName);
                System.out.println("Class driver berhasil ditemukan");
                try {
                    //Memanggil variable connect mengambil DriverManafer mengerjakan method getConnection kemudian memanggil url, username, password
                    connect = DriverManager.getConnection(url, username, password);
                    // Jika ada tampilkan teks
                    System.out.println("Koneksi database berhasil");
                // Jika tidak, Memanggil libraryy SQLException.(se itu nama, jd boleh bebas
                } catch (SQLException se) {
                    System.out.println("Koneksi database gagal" + se);
                    System.exit(0);
                }
            //Kemudian jika class tidak ada (cnfe itu nama, boleh bebas)
            } catch (ClassNotFoundException cnfe) {
                // Maka Tampilkan teks kemudian kasih + nama(cnfe)
                System.out.println("Class driver tidak ditemukan, terjadi kesalahan pada : " + cnfe);
                System.exit(0);
            }
        }
        //Mengembalikan variabel connect
        return connect;
    }
}