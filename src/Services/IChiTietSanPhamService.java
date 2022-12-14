/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QuanLyChiTietSanPham;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IChiTietSanPhamService {

    List<QuanLyChiTietSanPham> getAll();

    String add(QuanLyChiTietSanPham qlCtSp);

    String update(QuanLyChiTietSanPham qlCtSp, String id);

    String delete(String id);

    List<QuanLyChiTietSanPham> getThuongHieu(String ten);

    List<QuanLyChiTietSanPham> getKichCo(String ten);

    List<QuanLyChiTietSanPham> getGiaSanPham(String giaThapNhat, String giaCaoNhat);

    List<QuanLyChiTietSanPham> getSanPham(String ten);
}
