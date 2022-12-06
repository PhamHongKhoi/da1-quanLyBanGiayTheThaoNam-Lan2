/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.ThongKe;
import Repository.Iplm.ThongKeRespository;
import Services.IThongKeService;
import ViewModels.QuanLyThongKe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ThongKeService implements IThongKeService {

    ThongKeRespository tkr = new ThongKeRespository();

    @Override
    public List<QuanLyThongKe> getAll() {
        List<ThongKe> lstThongKe = tkr.getAll();
        List<QuanLyThongKe> lstQlThongKe = new ArrayList<>();
        for (ThongKe tk : lstThongKe) {
            QuanLyThongKe qlTk = new QuanLyThongKe(tk.getTen(), tk.getSoLuong(), tk.getDonGia(), tk.getNgayTao(), tk.getTongTien());
            lstQlThongKe.add(qlTk);
        }
        return lstQlThongKe;
    }

    @Override
    public List<QuanLyThongKe> getHangHuy() {
        List<ThongKe> lstThongKe = tkr.getHangHuy();
        List<QuanLyThongKe> lstQlThongKe = new ArrayList<>();
        for (ThongKe tk : lstThongKe) {
            QuanLyThongKe qlTk = new QuanLyThongKe(tk.getTen(), tk.getSoLuong(), tk.getDonGia(), tk.getNgayTao(), tk.getTrangThai());
            lstQlThongKe.add(qlTk);
        }
        return lstQlThongKe;
    }

    @Override
    public List<QuanLyThongKe> getTongTien() {
        List<ThongKe> lstThongKe = tkr.getTongTien();
        List<QuanLyThongKe> lstQlTk = new ArrayList<>();
        for (ThongKe tk : lstThongKe) {
            QuanLyThongKe qlTk = new QuanLyThongKe(tk.getTongTien());
            lstQlTk.add(qlTk);
        }
        return lstQlTk;
    }

}
