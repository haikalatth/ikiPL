/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera_rent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Cancel {
    DefaultTableModel model1;
    DefaultTableModel model;
    int total;
    public int batal(JTable tb_keranjang, JTable tb_kamera, int b) {
        String jml = tb_keranjang.getValueAt(b,3).toString();
        int jumlah = Integer.parseInt(jml);
        String tot = tb_keranjang.getValueAt(b,4).toString();
        total = Integer.parseInt(tot);
        model1 = (DefaultTableModel)tb_keranjang.getModel();
        for(int i=0;i<tb_kamera.getRowCount();i++){
            if(tb_kamera.getValueAt(i, 0).equals(tb_keranjang.getValueAt(b, 0))){
                String strstok = tb_kamera.getValueAt(i, 3).toString();
                int stok = Integer.parseInt(strstok)+jumlah;
                tb_kamera.setValueAt(Integer.toString(stok), i, 3);
            }
        }
        model1.removeRow(b);
        return(total);
    }
}
