/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.KieuDang;
import Repository.Iplm.KieuDangRepository;
import ViewModels.QuanLyKieuDang;
import java.util.ArrayList;
import java.util.List;
import Services.IKieuDangService;

/**
 *
 * @author admin
 */
public class KieuDangImpl implements IKieuDangService {

    private KieuDangRepository rp = new KieuDangRepository();

    @Override
    public List<QuanLyKieuDang> getAll() {

        List<QuanLyKieuDang> ds = new ArrayList<>();
        List<KieuDang> list = rp.getAll();

        for (KieuDang cv : list) {
            QuanLyKieuDang vModel = new QuanLyKieuDang(cv.getId(), cv.getMa(), cv.getTen(), cv.getTrangThai());
            ds.add(vModel);
        }

        return ds;

    }

    @Override
    public String add(QuanLyKieuDang t) {
        QuanLyKieuDang qlKhachhang = new QuanLyKieuDang();
        qlKhachhang = new KieuDangImpl().getmakc(t.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {

            KieuDang thuongHieu = new KieuDang("", t.getMa(), t.getTen(), t.getTrangThai());
            boolean add = rp.add(thuongHieu);
            if (add == true) {
                return "thêm thành công";
            } else {
                return " thêm thất bại ";
            }
        }
    }

    @Override
    public String delete(String id) {
        boolean add = rp.delete(id);
        if (add == true) {
            return "xóa thành công";
        } else {
            return "xóa thất bại ";
        }
    }

    @Override
    public String update(QuanLyKieuDang cv, String id) {

        KieuDang thuongHieu = new KieuDang("", cv.getMa(), cv.getTen(), cv.getTrangThai());

        boolean add = rp.update(thuongHieu, id);
        if (add == true) {
            return "sửa thành công";
        } else {
            return " sửa thất bại ";
        }

    }

    @Override
    public String themNhanhKd(QuanLyKieuDang kd) {
        KieuDang tmKd = new KieuDang(kd.getTen());
        boolean themNhanh = rp.themNhanhKd(tmKd);
        if (themNhanh == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public QuanLyKieuDang getmakc(String ma) {
        KieuDang cv = rp.getmaKc(ma);
        if (cv != null) {
            QuanLyKieuDang ql = new QuanLyKieuDang();
            ql.setId(cv.getId());
            ql.setMa(cv.getMa());
            ql.setTen(cv.getTen());
            ql.setTrangThai(cv.getTrangThai());

            return ql;
        } else {
            return null;
        }
    }

}
