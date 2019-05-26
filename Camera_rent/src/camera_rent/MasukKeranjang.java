/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera_rent;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class MasukKeranjang {
    DefaultTableModel model;
    int total;
    public int tambahKeranjang(JTable tb_kamera, JTable tb_keranjang, int a, JLabel total_harga) {
        try{
            String jml = JOptionPane.showInputDialog(null, "Jumlah :");
            int jumlah = Integer.parseInt(jml);
            model = (DefaultTableModel)tb_kamera.getModel();
            String kb = model.getValueAt(a,0).toString();
            String nb = model.getValueAt(a, 1).toString();
            String hb = model.getValueAt(a, 2).toString();
            int hrg = Integer.parseInt(hb);
            total = total+(hrg*jumlah);
            //kurangi stok
            String strstok = model.getValueAt(a,3).toString();
            int stok = Integer.parseInt(strstok)-jumlah;
            if(stok<0){
                JOptionPane.showMessageDialog(null,"Stok Kurang!");
            }else{
                model.setValueAt(Integer.toString(stok),a,3);
                List data = new ArrayList<>();
                data.add(kb);
                data.add(nb);
                data.add(hb);     
                data.add(jml);
                data.add(total);
                //masuk keranjang
                DefaultTableModel mdl = (DefaultTableModel)tb_keranjang.getModel();
                mdl.addRow(data.toArray());
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }            
        return(total);
    }
}
