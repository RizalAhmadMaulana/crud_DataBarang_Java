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
//memanggil library yg dibutuhkan
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aksi {
    //Membuat atau deklarasi variabel 
    private String IDProduk, KodeProduk, NamaProduk, Satuan, Harga, Stok;
    private Connection aksiConnect;
    private PreparedStatement aksiPsmt;
    private Statement aksiStat;
    private ResultSet aksiResult;
    private String aksiQuery;
    //membuat method Aksi
    public Aksi(){
        try {
            //membuat object connect dari kelas KoneksiMysql
            KoneksiMysql connect = new KoneksiMysql();
            //Mengisi varible aksiConnect dari kelas KoneksiMysq dengan method getKoneksi
            aksiConnect = connect.getKoneksi();
        } catch (SQLException se) {
            System.out.println(se);
        }
    }

    //Setter & Getter untuk mengirim variable antar class(alt+fn+insert)
    public String getIDProduk() {
        return IDProduk;
    }

    public void setIDProduk(String IDProduk) {
        this.IDProduk = IDProduk;
    }

    public String getKodeProduk() {
        return KodeProduk;
    }

    public void setKodeProduk(String KodeProduk) {
        this.KodeProduk = KodeProduk;
    }

    public String getNamaProduk() {
        return NamaProduk;
    }

    public void setNamaProduk(String NamaProduk) {
        this.NamaProduk = NamaProduk;
    }

    public String getSatuan() {
        return Satuan;
    }

    public void setSatuan(String Satuan) {
        this.Satuan = Satuan;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String Stok) {
        this.Stok = Stok;
    }
    
    //Membuat method tampilData dari type method ResultSet
    public ResultSet tampilData(){
        //mendeklarasi variable aksiQuery untuk menampilkan data pada tabel produk
        aksiQuery = "select * from produk";
        try {
            //mengisi aksiStat dari variabel aksiConnect kemudian membuat pernyataan
            aksiStat = aksiConnect.createStatement();
            //mengisi aksiResult dari pernyataan yg sudah dibuat dari aksiStat, kemudian jalan query 
            aksiResult = aksiStat.executeQuery(aksiQuery);
        } catch (Exception e) {
        }
        //Mengembalikan nilai method tersebut(dari ResultSet)
        return aksiResult;
    }
    
    // Membuat method simpanData dari type void, kemudian membuat parameter untuk data yg dibutuhkan
    public void simpanData(String KodeProduk, String NamaProduk, String Satuan, String Harga, String Stok){
        //mendeklarasi variable aksiQuery untuk menambahkan data pada tabel produk
        aksiQuery = "insert into produk values (?,?,?,?,?,?)";
        try {
            //mengisi variabel aksiPsmt dengan aksiConnect kemudian mempersiapkan data
            aksiPsmt = aksiConnect.prepareStatement(aksiQuery);
            //mengisi request data dari preparestatement dengan data dari parameter diatas
            aksiPsmt.setString(1, IDProduk);
            aksiPsmt.setString(2, KodeProduk);
            aksiPsmt.setString(3, NamaProduk);
            aksiPsmt.setString(4, Satuan);
            aksiPsmt.setString(5, Harga);
            aksiPsmt.setString(6, Stok);
            //menjalankan query dari variable aksiPsmt
            aksiPsmt.executeUpdate();
            //menutup query
            aksiPsmt.close();
        } catch (Exception e) {
        }
    }
    
    // Membuat method ubahData dari type void, kemudian membuat parameter untuk data yg dibutuhkan
    public void ubahData(String KodeProduk, String NamaProduk, String Satuan, String Harga, String Stok){
        //mendeklarasi variable aksiQuery untuk menambahkan data pada tabel produk
        aksiQuery = "update produk set NamaProduk=?, Satuan=?, Harga=?, Stok=? where KodeProduk=?";
        try {
            //mengisi variabel aksiPsmt dengan aksiConnect kemudian mempersiapkan data
            aksiPsmt = aksiConnect.prepareStatement(aksiQuery);
            //mengisi request data dari preparestatement dengan data dari parameter diatas
            aksiPsmt.setString(1, NamaProduk);
            aksiPsmt.setString(2, Satuan);
            aksiPsmt.setString(3, Harga);
            aksiPsmt.setString(4, Stok);
            aksiPsmt.setString(5, KodeProduk);
            //menjalankan query dari variable aksiPsmt
            aksiPsmt.executeUpdate();
            //menutup query
            aksiPsmt.close();
        } catch (Exception e) {
        }
    }
    
    // Membuat method hapusData dari type void, kemudian membuat parameter yg ditetepkan sebagai kunci
    public void hapusData(String KodeProduk){
        //mendeklarasi variable aksiQuery untuk menghapus data pada tabel produk
        aksiQuery = "Delete from produk where KodeProduk=?";
        try {
            //mengisi variabel aksiPsmt dengan aksiConnect kemudian mempersiapkan data
            aksiPsmt = aksiConnect.prepareStatement(aksiQuery);
            //mengisi request data dari preparestatement dengan data dari parameter sebagai kunci
            aksiPsmt.setString(1, KodeProduk);
            //menjalankan query dari variable aksiPsmt
            aksiPsmt.executeUpdate();
            //menutup query
            aksiPsmt.close();
        } catch (Exception e) {
        }
    }
}
