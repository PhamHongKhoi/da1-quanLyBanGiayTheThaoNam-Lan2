/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.ChiTietHoaDon;
import Repository.Iplm.ChiTietHoaDonRepository;
import Services.IChiTietHoaDonService;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonService implements IChiTietHoaDonService {

    private ChiTietHoaDonRepository chiTietHoaDonRepository = new ChiTietHoaDonRepository();

    @Override
    public ArrayList<ChiTietHoaDon> getDataByID(String id) {
        return chiTietHoaDonRepository.getDataByID(id);
    }

    @Override
    public String saveHoaDonCT(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDonRepository.saveHoaDonCT(chiTietHoaDon)) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    @Override
    public String delete(String idHD, String idCTSP) {
        if (chiTietHoaDonRepository.delete(idHD, idCTSP)) {
            return "Xoá thành công sản phẩm trong đơn hàng";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String updateSoLuongHoaDonCT(ChiTietHoaDon chiTietHoaDon, String idHD, String idCTSP) {
        if (chiTietHoaDonRepository.updateSoLuongHoaDonCT(chiTietHoaDon, idHD, idCTSP)) {
            return "Update thành công sản phẩm trong đơn hàng";
        } else {
            return "Update so luong sp gh thất bại";
        }
    }

    @Override
    public ArrayList<ChiTietHoaDon> getSoLuongByID(String idHD, String idCTSP) {
        return chiTietHoaDonRepository.getSoLuongByID(idHD, idCTSP);
              
    }
}
