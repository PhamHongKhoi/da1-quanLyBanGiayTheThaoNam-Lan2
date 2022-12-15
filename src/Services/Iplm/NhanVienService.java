/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.NhanVien;
import Repository.Iplm.NhanVienRespository;
import Services.INhanVienService;
import ViewModels.QuanLyNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVienService implements INhanVienService {

    NhanVienRespository nvr = new NhanVienRespository();

    @Override
    public List<QuanLyNhanVien> getAll() {
        List<NhanVien> nv = nvr.getAll();
        List<QuanLyNhanVien> lstQlNv = new ArrayList<>();
        for (NhanVien ql : nv) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien(ql.getId(), ql.getMa(), ql.getTen(), ql.getGioiTinh(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(), ql.getChucVu(), ql.getTrangThai(), ql.getTenTaiKhoan(), ql.getMatKhau(), ql.getHinhAnh());
            lstQlNv.add(qlnv);
        }
        return lstQlNv;
    }

    @Override
    public String add(QuanLyNhanVien qlnv) {

        NhanVien nv = new NhanVien(null, qlnv.getMa(), qlnv.getTen(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSoDienThoai(), qlnv.getChucVu(), qlnv.getTrangThai(), qlnv.getTenTaiKhoan(), qlnv.getMatKhau(), qlnv.getHinhAnh());
        boolean add = nvr.add(nv);
        if (add == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String update(QuanLyNhanVien qlnv, String id) {

        NhanVien nv = new NhanVien(null, qlnv.getMa(), qlnv.getTen(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSoDienThoai(), qlnv.getChucVu(), qlnv.getTrangThai(), qlnv.getTenTaiKhoan(), qlnv.getMatKhau(), qlnv.getHinhAnh());
        QuanLyNhanVien qlKhachhang = new QuanLyNhanVien();
        qlKhachhang = new NhanVienService().getManv(qlnv.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {
            boolean update = nvr.update(nv, id);
            if (update == true) {
                return "Sửa thành công";
            } else {
                return "Sửa thất bại";
            }
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = nvr.delete(id);
        if (delete == true) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<QuanLyNhanVien> getbyTrangThainv(int trangThai) {
        List<NhanVien> nv = nvr.getbyTrangThainv(trangThai);
        List<QuanLyNhanVien> lstQlNv = new ArrayList<>();
        for (NhanVien ql : nv) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien(ql.getId(), ql.getMa(), ql.getTen(), ql.getGioiTinh(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(), ql.getChucVu(), ql.getTrangThai(), ql.getTenTaiKhoan(), ql.getMatKhau(), ql.getHinhAnh());
            lstQlNv.add(qlnv);
        }
        return lstQlNv;
    }

    @Override
    public List<QuanLyNhanVien> getbyChucVunv(int chucVu) {
        List<NhanVien> nv = nvr.getbyChucVunv(chucVu);
        List<QuanLyNhanVien> lstQlNv = new ArrayList<>();
        for (NhanVien ql : nv) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien(ql.getId(), ql.getMa(), ql.getTen(), ql.getGioiTinh(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(), ql.getChucVu(), ql.getTrangThai(), ql.getTenTaiKhoan(), ql.getMatKhau(), ql.getHinhAnh());
            lstQlNv.add(qlnv);
        }
        return lstQlNv;
    }

    @Override
    public List<QuanLyNhanVien> getbyTennv(String ten) {
        List<NhanVien> nv = nvr.getbyTennv(ten);
        List<QuanLyNhanVien> lstQlNv = new ArrayList<>();
        for (NhanVien ql : nv) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien(ql.getId(), ql.getMa(), ql.getTen(), ql.getGioiTinh(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(), ql.getChucVu(), ql.getTrangThai(), ql.getTenTaiKhoan(), ql.getMatKhau(), ql.getHinhAnh());
            lstQlNv.add(qlnv);
        }
        return lstQlNv;
    }

    @Override
    public List<QuanLyNhanVien> getbyGioiTinh(int gioiTinh) {
        List<NhanVien> nv = nvr.getbyGioiTinh(gioiTinh);
        List<QuanLyNhanVien> lstQlNv = new ArrayList<>();
        for (NhanVien ql : nv) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien(ql.getId(), ql.getMa(), ql.getTen(), ql.getGioiTinh(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(), ql.getChucVu(), ql.getTrangThai(), ql.getTenTaiKhoan(), ql.getMatKhau(), ql.getHinhAnh());
            lstQlNv.add(qlnv);
        }
        return lstQlNv;
    }

    @Override
    public QuanLyNhanVien getManv(String manv) {
        NhanVien cv = nvr.getMaNV(manv);
        if (cv != null) {
            QuanLyNhanVien ql = new QuanLyNhanVien();
            ql.setId(cv.getId());
            ql.setMa(cv.getMa());
            ql.setTen(cv.getTen());
            ql.setGioiTinh(cv.getGioiTinh());
            ql.setNgaySinh(cv.getNgaySinh());
            ql.setDiaChi(cv.getDiaChi());
            ql.setSoDienThoai(cv.getSoDienThoai());
            ql.setTrangThai(cv.getTrangThai());
            ql.setHinhAnh(cv.getHinhAnh());
            ql.setTenTaiKhoan(cv.getTenTaiKhoan());
            ql.setChucVu(cv.getChucVu());
            ql.setMatKhau(cv.getMatKhau());

            return ql;
        } else {
            return null;
        }

    }
}
