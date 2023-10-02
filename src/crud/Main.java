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
public class Main {
    public static void main (String[]args){
        try {
            //form merupakan objek baru dari class FormProduk
            FormProduk form = new FormProduk();
            //menampilkan form
            form.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
