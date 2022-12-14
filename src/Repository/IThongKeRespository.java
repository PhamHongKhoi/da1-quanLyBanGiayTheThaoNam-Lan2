/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.ThongKe;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IThongKeRespository {

    List<ThongKe> getAll();

    List<ThongKe> getHangHuy();

    List<ThongKe> getTongTien();

    List<ThongKe> getDanhMucHangHoa(String ten);

    List<ThongKe> getNgayTaoHoaDon(String ngayBatDau, String ngayKetThuc);
}
