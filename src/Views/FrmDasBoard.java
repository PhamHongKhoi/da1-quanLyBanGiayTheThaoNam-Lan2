/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModel.ChiTietHoaDon;
import DomainModel.HoaDon;
import DomainModel.LoaiHinhTanhToan;
import Services.IChiTietHoaDonService;
import Services.IDanhSAchSanPhamService;
import Services.IDongSPRService;
import Services.IHoaDonService;
import Services.IKhachHangRService;
import Services.IKichCoRService;
import Services.ILoaiHinhThanhToanService;
import Services.IThuongHieuRService;
import Services.Iplm.ChatLieuService;
import Services.Iplm.ChiTietHoaDonService;
import Services.Iplm.ChiTietSanPhamServiceIplm;
import Services.Iplm.DanhSachSanPhamService;
import Services.Iplm.DongSPRService;
import Services.Iplm.DongSanPhamImpl;
import Services.Iplm.HoaDonService;
import Services.Iplm.KhachHangRService;
import Services.Iplm.KhachHangService;
import Services.Iplm.KhuyenMaiService;
import Services.Iplm.KichCoRService;
import Services.Iplm.KichCoServiceImpl;
import Services.Iplm.KieuDangImpl;
import Services.Iplm.LoaiHinhThanhToanService;
import Services.Iplm.MauSacServiceIplm;
import Services.Iplm.NhaSanXuatImpl;
import Services.Iplm.NhanVienService;
import Services.Iplm.SanPhamServiceIplm;
import Services.Iplm.ThongKeService;
import Services.Iplm.ThuongHieuRService;
import Services.Iplm.ThuongHieuServiceImpl;
import ViewModels.DanhSachSanPhamResponse;
import ViewModels.DongSPRResponse;
import ViewModels.HoaDonResponse;
import ViewModels.KhachHangResponse;
import ViewModels.KichCoRResponse;
import ViewModels.QuanLyChatLieu;
import ViewModels.QuanLyChiTietSanPham;
import ViewModels.QuanLyDongSanPham;
import ViewModels.QuanLyKhachHang;
import ViewModels.QuanLyKhuyenMai;
import ViewModels.QuanLyKichco;
import ViewModels.QuanLyKieuDang;
import ViewModels.QuanLyMauSac;
import ViewModels.QuanLyNhaSanXuat;
import ViewModels.QuanLyNhanVien;
import ViewModels.QuanLySanPham;
import ViewModels.QuanLySanPhamGiamGia;
import ViewModels.QuanLyThongKe;
import ViewModels.QuanLyThuongHieu;
import ViewModels.ThuongHieuRResponse;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class FrmDasBoard extends javax.swing.JFrame {

    /**
     * Creates new form FrmDasBoard
     */
    ImageIcon icon = new ImageIcon("img/shoe.png");
    ImageIcon exit = new ImageIcon("img/exit.png");
    ImageIcon thongKe = new ImageIcon("img/thongke.png");
    ImageIcon khachHang = new ImageIcon("img/khachhang.png");
    ImageIcon nhanVien = new ImageIcon("img/nhanvien.png");
    ImageIcon khuyenMai = new ImageIcon("img/sale.png");
    ImageIcon hoaDon = new ImageIcon("img/hoadon.png");
    ImageIcon banHang = new ImageIcon("img/banhang.png");
    ImageIcon sanPham = new ImageIcon("img/sanpham.png");
    ImageIcon anhDaiDien = new ImageIcon("img/anhdaidien.png");
    ImageIcon themNhanhSanPham = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhKichCo = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhThuongHieu = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhMauSac = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhDongSp = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhChatLieu = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhKieuDang = new ImageIcon("img/themnhanh.png");
    ImageIcon themNhanhNhaSanXuat = new ImageIcon("img/themnhanh.png");
    ImageIcon manHinhChinh = new ImageIcon("img/anhNen.jpg");
    CardLayout cardLayout = new CardLayout();

    private ArrayList<DanhSachSanPhamResponse> listDssp = new ArrayList<>();
    private ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<>();
    private ArrayList<HoaDonResponse> listHD = new ArrayList<>();
    private ArrayList<ThuongHieuRResponse> listThuongHieuResponses = new ArrayList<>();
    private ArrayList<KichCoRResponse> listKichCoRResponses = new ArrayList<>();
    private ArrayList<DongSPRResponse> listDongSPRResponses = new ArrayList<>();
    private ArrayList<LoaiHinhTanhToan> listLoaiHinhTanhToans = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private DefaultTableModel dtmDSSP = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultComboBoxModel dcbmTH = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmKC = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmDSP = new DefaultComboBoxModel();
    private IDanhSAchSanPhamService danhSAchSanPhamService = new DanhSachSanPhamService();
    private IHoaDonService hoaDonService = new HoaDonService();
    private IChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonService();
    private IThuongHieuRService thuongHieuRService = new ThuongHieuRService();
    private IKichCoRService kichCoRService = new KichCoRService();
    private IDongSPRService dongSPRService = new DongSPRService();
    private ILoaiHinhThanhToanService loaiHinhThanhToanService = new LoaiHinhThanhToanService();
    private IKhachHangRService khachHangRService = new KhachHangRService();

    //ls hoa don
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private List<QuanLySanPham> lstQLSp = new ArrayList<>();
    private SanPhamServiceIplm spsi = new SanPhamServiceIplm();
    private DefaultComboBoxModel dcbbTrangThai = new DefaultComboBoxModel();
    private List<String> lstTrangThaiSp = new ArrayList<>();
    private DefaultComboBoxModel dcbbMaSanPham = new DefaultComboBoxModel();
    private DefaultTableModel dtmThuocTinh = new DefaultTableModel();
    private DefaultComboBoxModel dcbbThuocTinh = new DefaultComboBoxModel();
    private List<String> lstThuocTinh = new ArrayList<>();
    private DongSanPhamImpl dspi = new DongSanPhamImpl();
    private List<QuanLyDongSanPham> lstDongSanPham = new ArrayList<>();
    private KichCoServiceImpl kcsi = new KichCoServiceImpl();
    private List<QuanLyKichco> lstKichCo = new ArrayList<>();
    private KieuDangImpl kdi = new KieuDangImpl();
    private List<QuanLyKieuDang> lstKieuDang = new ArrayList<>();
    private ThuongHieuServiceImpl thsi = new ThuongHieuServiceImpl();
    List<QuanLyThuongHieu> lstThuongHieu = new ArrayList<>();
    NhaSanXuatImpl nsxi = new NhaSanXuatImpl();
    List<QuanLyNhaSanXuat> lstNhaSanXuat = new ArrayList<>();
    MauSacServiceIplm msi = new MauSacServiceIplm();
    List<QuanLyMauSac> lstMauSac = new ArrayList<>();
    ChatLieuService cls = new ChatLieuService();
    List<QuanLyChatLieu> lstChatLieu = new ArrayList<>();
    NhanVienService nvs = new NhanVienService();
    List<QuanLyNhanVien> lstQlNhanVien = new ArrayList<>();
    String strHinhAnh = null;
    DefaultTableModel dtmNhanVien = new DefaultTableModel();
    DefaultComboBoxModel dcbbChucVuNhanVien = new DefaultComboBoxModel();
    List<String> lstCvNhanVien = new ArrayList<>();
    DefaultComboBoxModel dcbbTrangThaiNhanVien = new DefaultComboBoxModel();
    List<String> lstTrangThaiNhanVien = new ArrayList<>();
    String strHinhAnhChiTietSanPham = null;
    List<QuanLyChiTietSanPham> lstCtSp = new ArrayList<>();
    ChiTietSanPhamServiceIplm ctspI = new ChiTietSanPhamServiceIplm();
    DefaultTableModel dtmChiTietSp = new DefaultTableModel();

    DefaultComboBoxModel dcbbCtspNSX = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbCtspKieuDang = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbSanPham = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbKichCo = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbThuongHieu = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbMauSac = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbChatLieu = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbbDongSp = new DefaultComboBoxModel<>();

    private DefaultTableModel dtmKhachHang = new DefaultTableModel();
    private List<QuanLyKhachHang> lstKh = new ArrayList<>();
    private KhachHangService khs = new KhachHangService();
    private DefaultComboBoxModel dcbbTrangThaiKhachHang = new DefaultComboBoxModel();
    private List<String> lstTrangThaiKhachHang = new ArrayList<>();

    private DefaultTableModel dtmThongKeDoanhThu = new DefaultTableModel();
    List<QuanLyThongKe> lstThongKe = new ArrayList<>();
    ThongKeService tks = new ThongKeService();

    private DefaultTableModel dtmHangHuy = new DefaultTableModel();
    List<QuanLyThongKe> lstHangHuy = new ArrayList<>();

    private DefaultTableModel dtmKhuyenMai = new DefaultTableModel();
    List<QuanLyKhuyenMai> lstKm = new ArrayList<>();
    KhuyenMaiService kms = new KhuyenMaiService();
    private List<String> lstTrangThaiKm = new ArrayList<>();
    private DefaultComboBoxModel dcbbTrangThaiKm = new DefaultComboBoxModel();

    private DefaultTableModel dtmSanPhamKhuyenMai = new DefaultTableModel();
    List<QuanLySanPhamGiamGia> lstSpGiamGia = new ArrayList<>();

    private List<String> lstLoaiKhuyenMai = new ArrayList<>();
    private DefaultComboBoxModel dcbbLoaiKhuyenMai = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbbKhuyenMaiSanPhamKhuyenMai = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbbTenSanPhamKhuyenMai = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbbTrangThaiSanPhamKhuyenMai = new DefaultComboBoxModel();
    private List<String> lstTrangThaiSanPhamKhuyenMai = new ArrayList<>();

    private DefaultComboBoxModel dcbbLocCtspThuongHieu = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbbLocCtspKichCo = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbbLocDanhMucHangHoa = new DefaultComboBoxModel();

    public FrmDasBoard() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý bán giày thể thao nam");
        setIconImage(icon.getImage());
        btThoat.setIcon(exit);
        btThongKe.setIcon(thongKe);
        btKhachHang.setIcon(khachHang);
        btNhanVien.setIcon(nhanVien);
        btKhuyenMai.setIcon(khuyenMai);
        btHoaDon.setIcon(hoaDon);
        btBanHang.setIcon(banHang);
        btSanPham.setIcon(sanPham);
        btAnhDaiDien.setIcon(anhDaiDien);
        btThemNhanhSanPham.setIcon(themNhanhSanPham);
        btThemNhanhKichCo.setIcon(themNhanhKichCo);
        btThemNhanhThuongHieu.setIcon(themNhanhThuongHieu);
        btThemNhanhMauSac.setIcon(themNhanhMauSac);
        btThemNhanhDongSp.setIcon(themNhanhDongSp);
        btThemNhanhChatLieu.setIcon(themNhanhChatLieu);
        btThemNhanhKieuDang.setIcon(themNhanhKieuDang);
        btThemNhanhNhaSanXuat.setIcon(themNhanhNhaSanXuat);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        tbQlSanPham.setModel(dtmSP);
        cbbTrangThaiSp.setModel(dcbbTrangThai);
        jlbManHinhChinh.setIcon(manHinhChinh);
//        cbbMaSanPham.setModel(dcbbMaSanPham);

        String[] sp = {"Id", "Mã sản phẩm", "Tên sản phẩm", "Trạng thái"};
        dtmSP.setColumnIdentifiers(sp);
        lstQLSp = spsi.getAll();
        showTableSanPham(lstQLSp);
        showComBoxTrangThaiSp();
        showComBoxMaSp();
        cbbThuocTinhSanPham.setModel(dcbbThuocTinh);
        showComBoxThuocTinh();

        listDssp = danhSAchSanPhamService.getAll();
        showDataTableDSSP(listDssp);
        listHD = hoaDonService.getAll();
        showDataTableHD(listHD);

        listThuongHieuResponses = thuongHieuRService.getAll();
        listKichCoRResponses = kichCoRService.getAll();
        listDongSPRResponses = dongSPRService.getAll();
        cbbThuongHieu.setModel(dcbmTH);
        cbbKichCo.setModel(dcbmKC);
        cbbDongSP.setModel(dcbmDSP);
        for (ThuongHieuRResponse listTH : listThuongHieuResponses) {
            dcbmTH.addElement(listTH.getTenThuongHieu());
        }
        for (KichCoRResponse listKC : listKichCoRResponses) {
            dcbmKC.addElement(listKC.getTenKichCo());
        }
        for (DongSPRResponse listDSP : listDongSPRResponses) {
            dcbmDSP.addElement(listDSP.getTenDongSP());
        }

        TBHoaDon.removeColumn(TBHoaDon.getColumnModel().getColumn(1));
        TBGioHang.removeColumn(TBGioHang.getColumnModel().getColumn(1));
        TBSanPham.removeColumn(TBSanPham.getColumnModel().getColumn(9));
        TBSanPham.removeColumn(TBSanPham.getColumnModel().getColumn(1));
        TBSanPham.getColumnModel().getColumn(2).setPreferredWidth(150);
        TBGioHang.getColumnModel().getColumn(2).setPreferredWidth(150);
        btnRefresh.doClick();

        cbbPTTT.setSelectedIndex(0);
        txtNgayShip.setEditable(false);
        txtNgayShip.setEnabled(false);
        txtNgayThanhToan.setEnabled(false);
        txtNgayNhan.setEnabled(false);
        btnNgayHenKhach.setEnabled(true);
        btnGuiHang.setEnabled(false);
        btnThanhToan1.setEnabled(false);

        showChoThanhToan();
        TBGioHang.setDefaultEditor(Object.class, null);
        TBSanPham.setDefaultEditor(Object.class, null);

        //ls hd
        listHD = hoaDonService.getAll();
        showDataTableHDLS(listHD);

        TBGioHangLS.getColumnModel().getColumn(3).setPreferredWidth(170);
        TBHoaDonLS.removeColumn(TBHoaDonLS.getColumnModel().getColumn(1));
        TBGioHangLS.removeColumn(TBGioHangLS.getColumnModel().getColumn(1));

        tbQuanLyNhanVien.setModel(dtmNhanVien);
        cbbChucVuNhanVien.setModel(dcbbChucVuNhanVien);
        cbbTrangThaiNhanVien.setModel(dcbbTrangThaiNhanVien);
        String[] nv = {"Id", "Mã", "Tên", "Giới tính", "Ngày sinh", "Dịa chỉ", "SDT", "Chức vụ", "Trạng thái", "Tên tk", "Mật khẩu", "Hình ảnh"};
        dtmNhanVien.setColumnIdentifiers(nv);

        lstQlNhanVien = nvs.getAll();
        showTableNhanVien(lstQlNhanVien);

        showComBoxCvNhanVien();
        showComBoxTrangThaiNhanVien();

        tbChiTietSanPham.setModel(dtmChiTietSp);
        String[] ctsp = {"Id", "Mô tả", "Số lượng tồn", "Giá nhập", "Giá bán", "Năm bán hàng", "Hình ảnh", "Dòng sản phẩm", "Nhà sản xuất", "Kiểu dáng", "Kích cỡ", "Chất liệu", "Màu sắc", "Sản phẩm", "Thương hiệu"};
        dtmChiTietSp.setColumnIdentifiers(ctsp);

        lstCtSp = ctspI.getAll();
        showTableChiTietSp(lstCtSp);

        cbbCtspNhaSanXuat.setModel(dcbbCtspNSX);
        lstNhaSanXuat = nsxi.getAll();
        showComBoxCtspNsx(lstNhaSanXuat);

        cbbCtspKieuDang.setModel(dcbbCtspKieuDang);
        lstKieuDang = kdi.getAll();
        showComBoxCtspKieuDang(lstKieuDang);

        cbbCtspSanPham.setModel(dcbbSanPham);
        lstQLSp = spsi.getAll();
        showComBoxCtspSanPham(lstQLSp);

        cbbCtspKichCo.setModel(dcbbKichCo);
        lstKichCo = kcsi.getAll();
        showComBoxCtspKichCo(lstKichCo);

        cbbCtspThuongHieu.setModel(dcbbThuongHieu);
        lstThuongHieu = thsi.getAll();
        showComBoxCtspThuongHieu(lstThuongHieu);

        cbbCtspMauSac.setModel(dcbbMauSac);
        lstMauSac = msi.getAll();
        showComBoxCtspMauSac(lstMauSac);

        cbbCtspDongSanPham.setModel(dcbbDongSp);
        lstDongSanPham = dspi.getAll();
        showComBoxCtspDongSp(lstDongSanPham);

        cbbCtspChatLieu.setModel(dcbbChatLieu);
        lstChatLieu = cls.getAll();
        showComBoxCtspChatLieu(lstChatLieu);

        tbKhachHang.setModel(dtmKhachHang);
        cbbKhachHang.setModel(dcbbTrangThaiKhachHang);
        String[] kh = {"Id", "Mã", "Tên", "Giới tính", "Ngày sinh", "Sdt", "Địa chỉ", "Trạng thái"};
        dtmKhachHang.setColumnIdentifiers(kh);
        lstKh = khs.getAll();
        showTableKhachHang(lstKh);
        showComBoxKH();

        tbDoanhThuThongKe.setModel(dtmThongKeDoanhThu);
        String[] thongKe = {"Tên Sản Phẩm", "Số lượng", "Đơn giá", "Ngày tạo", "Tổng tiền"};
        dtmThongKeDoanhThu.setColumnIdentifiers(thongKe);
        lstThongKe = tks.getAll();
        showTableThongKe(lstThongKe);

        tbHangHoaHuy.setModel(dtmHangHuy);
        String[] hangHuy = {"Tên Sản Phẩm", "Số lượng", "Đơn giá", "Ngày tạo", "Trạng thái", "Tổng tiền"};
        dtmHangHuy.setColumnIdentifiers(hangHuy);

        lstHangHuy = tks.getHangHuy();
        showTableHangHuy(lstHangHuy);

//        int soHoaDon = 0;
//        for (int i = 0; i < tbDoanhThuThongKe.getRowCount(); i++) {
//            soHoaDon = ++i;
//        }
//        jlbSoHoaDon.setText(String.valueOf(soHoaDon));
//        int soHangHuy = 0;
//        for (int i = 1; i < tbHangHoaHuy.getRowCount(); i++) {
//            soHangHuy = ++i;
//        }
//        jlbSoHangHuy.setText(String.valueOf(soHangHuy));
        tbKhuyenMai.setModel(dtmKhuyenMai);
        String[] km = {"Id", "Tên khuyến mại", "Loại khuyến mại", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"};
        dtmKhuyenMai.setColumnIdentifiers(km);
        lstKm = kms.getAll();
        showTableKhuyenMai(lstKm);
        cbbTrangThaiKhuyenMai.setModel(dcbbTrangThaiKm);
        showComBoxTrangThaiKm();

        tbSanPhamKhuyenMai.setModel(dtmSanPhamKhuyenMai);
        String[] sanPhamKm = {"Id", "Tên khuyến mại", "Tên sản phẩm", "Đơn giá", "Trạng thái", "Số tiền còn lại"};
        dtmSanPhamKhuyenMai.setColumnIdentifiers(sanPhamKm);
        lstSpGiamGia = kms.getAllSanPhamGiamGia();
        showTableSanPhamKhuyenMai(lstSpGiamGia);

        cbbLoaiKhuyenMai.setModel(dcbbLoaiKhuyenMai);
        showComBoxloaiKhuyenmai();

        cbbTenKhuyenMaiSanPhamKhuyenMai.setModel(dcbbKhuyenMaiSanPhamKhuyenMai);
        lstKm = kms.getAll();
        showComBoxKhuyenMaiSanPham(lstKm);

        cbbTenSanPhamSanPhamKhuyenMai.setModel(dcbbTenSanPhamKhuyenMai);
        lstCtSp = ctspI.getAll();
        showComBoxTenSanPhamKhuyenMai(lstCtSp);

        cbbTrangThaiSanPhamKhuyenMai.setModel(dcbbTrangThaiSanPhamKhuyenMai);
        showComBoxTrangThaiSanPhamKhuyenMai();

//        int sum = 0;
//        for (int i = 0; i < tbDoanhThuThongKe.getRowCount(); i++) {
//            sum = sum + Integer.valueOf(tbDoanhThuThongKe.getModel().getValueAt(i, 4).toString());
//        }
//        System.out.println(String.valueOf(sum));
//        jlbDoanhThu.setText(String.valueOf(sum));
        if (rdbtTatCaDoanhThuThongKe.isSelected()) {
            txtNgaybatDauTaoHoaDon.setEnabled(false);
            txtNgayKetThucTaoHoaDon.setEnabled(false);
            btTimKiemNgayThongKe.setEnabled(false);
        }

        cbbLocCtspThuongHieu.setModel(dcbbLocCtspThuongHieu);
        showComBoxLocThuongHieu(lstThuongHieu);

        cbbLocCtspKichCo.setModel(dcbbLocCtspKichCo);
        showComBoxLocKichCo(lstKichCo);

        cbbDanhMucHangHoaThongKe.setModel(dcbbLocDanhMucHangHoa);
        showComBoxDanhMucHangHoa(lstQLSp);

        showHoaDonDaThanhToan();
        showHoaDonHuy();
        showTongTienHoaDon();
    }

    private void showTongTienHoaDon() {
        int sum = 0;
        for (int i = 0; i < tbDoanhThuThongKe.getRowCount(); i++) {
            sum = sum + Integer.valueOf(tbDoanhThuThongKe.getModel().getValueAt(i, 4).toString());
        }
        System.out.println(String.valueOf(sum));
        jlbDoanhThu.setText(String.valueOf(sum));
    }

    private void showHoaDonHuy() {
        int soHangHuy = 1;
        for (int i = 2; i < tbHangHoaHuy.getRowCount(); i++) {
            soHangHuy = ++i;
        }
        jlbSoHangHuy.setText(String.valueOf(soHangHuy));
    }

    private void showHoaDonDaThanhToan() {
        int soHoaDon = 1;
        for (int i = 1; i < tbDoanhThuThongKe.getRowCount(); i++) {
            soHoaDon = ++i;
        }
        jlbSoHoaDon.setText(String.valueOf(soHoaDon));
    }

    private void showComBoxDanhMucHangHoa(List<QuanLySanPham> lstSp) {
        for (QuanLySanPham ql : lstSp) {
            dcbbLocDanhMucHangHoa.addElement(ql.getTen());
        }
    }

    private void showComBoxLocKichCo(List<QuanLyKichco> lstKc) {
        for (QuanLyKichco ql : lstKc) {
            dcbbLocCtspKichCo.addElement(ql.getTen());
        }
    }

    private void showComBoxLocThuongHieu(List<QuanLyThuongHieu> lstTh) {
        for (QuanLyThuongHieu ql : lstTh) {
            dcbbLocCtspThuongHieu.addElement(ql.getTen());
        }
    }

    private void showComBoxTrangThaiSanPhamKhuyenMai() {
        for (int i = 0; i < 2; i++) {
            lstTrangThaiSanPhamKhuyenMai.add(String.valueOf(i));
        }

        for (String s : lstTrangThaiSanPhamKhuyenMai) {
            dcbbTrangThaiSanPhamKhuyenMai.addElement(s);
        }
    }

    private void showComBoxTenSanPhamKhuyenMai(List<QuanLyChiTietSanPham> qlCtSp) {
        for (QuanLyChiTietSanPham ql : qlCtSp) {
            dcbbTenSanPhamKhuyenMai.addElement(ql.getIdSanPham());
        }
    }

    private void showComBoxKhuyenMaiSanPham(List<QuanLyKhuyenMai> lstKm) {
        for (QuanLyKhuyenMai ql : lstKm) {
            dcbbKhuyenMaiSanPhamKhuyenMai.addElement(ql.getTenKhuyenMai());
        }
    }

    private void showComBoxloaiKhuyenmai() {
        for (int i = 0; i <= 100; i++) {
            lstLoaiKhuyenMai.add(String.valueOf(i) + "%");
        }

        for (String s : lstLoaiKhuyenMai) {
            dcbbLoaiKhuyenMai.addElement(s);
        }
    }

    private void showTableSanPhamKhuyenMai(List<QuanLySanPhamGiamGia> lstSpGG) {
        dtmSanPhamKhuyenMai.setRowCount(0);
        for (QuanLySanPhamGiamGia ql : lstSpGG) {
            dtmSanPhamKhuyenMai.addRow(ql.arriveSanPhamGiamGia());
        }
    }

    private void showComBoxTrangThaiKm() {
        for (int i = 0; i < 2; i++) {
            lstTrangThaiKm.add(String.valueOf(i));
        }

        for (String s : lstTrangThaiKm) {
            dcbbTrangThaiKm.addElement(s);
        }
    }

    private void showTableKhuyenMai(List<QuanLyKhuyenMai> lstKhuyenMai) {
        dtmKhuyenMai.setRowCount(0);
        for (QuanLyKhuyenMai ql : lstKhuyenMai) {
            dtmKhuyenMai.addRow(ql.arriveKhuyenMai());
        }
    }

    private void showTableHangHuy(List<QuanLyThongKe> lstThongKe) {
        dtmHangHuy.setRowCount(0);
        for (QuanLyThongKe ql : lstThongKe) {
            dtmHangHuy.addRow(ql.arriveHangHoaHuy());
        }
    }

    private void showTableThongKe(List<QuanLyThongKe> lstThongKe) {
        dtmThongKeDoanhThu.setRowCount(0);
        for (QuanLyThongKe ql : lstThongKe) {
            dtmThongKeDoanhThu.addRow(ql.arriveThongke());
        }
    }

    private void fillKhachHang(int row) {
        QuanLyKhachHang qlkh = lstKh.get(row);
        jlbIdKhachHang.setText(qlkh.getId());
        txtMaKhachHang.setText(qlkh.getMa());
        txtTenKhachHang.setText(qlkh.getTen());
        jdcNgaySinhKhachHang.setDate(qlkh.getNgaySinh());
        int gender = qlkh.getGioiTinh();
        if (gender == 0) {
            rdbtNamKhachHang.setSelected(true);
        } else {
            rdbtNuKhachHang.setSelected(true);
        }
        txtSoDienThoaiKhachHang.setText(qlkh.getSoDienThoai());
        txtDiaChiKhachHang.setText(qlkh.getDiaChi());
        cbbKhachHang.setSelectedIndex(qlkh.getTrangThai());
    }

    private QuanLyKhachHang getKhachHang() {

        String ma = txtMaKhachHang.getText();
        String ten = txtTenKhachHang.getText();
        Date ngaySinh = jdcNgaySinhKhachHang.getDate();
        boolean gioiTinh = rdbtNamKhachHang.isSelected();
        int gender;
        if (gioiTinh == true) {
            gender = 0;
        } else {
            gender = 1;
        }
        String sdt = txtSoDienThoaiKhachHang.getText();
        String diaChi = txtDiaChiKhachHang.getText();
        int trangThai = cbbKhachHang.getSelectedIndex();

        QuanLyKhachHang qlkh = new QuanLyKhachHang("", ma, ten, gender, ngaySinh, sdt, diaChi, trangThai);

        return qlkh;
    }

    private void showTableKhachHang(List<QuanLyKhachHang> lst) {
        dtmKhachHang.setRowCount(0);
        for (QuanLyKhachHang ql : lst) {
            dtmKhachHang.addRow(ql.ArriveKhachHang());
        }
    }

    private void showComBoxKH() {
        for (int i = 0; i < 2; i++) {
            lstTrangThaiKhachHang.add(String.valueOf(i));
        }

        for (String s : lstTrangThaiKhachHang) {
            dcbbTrangThaiKhachHang.addElement(s);
        }
    }

    private void fillCtSp(int row) {
        QuanLyChiTietSanPham qlCtSp = lstCtSp.get(row);
        jlbCtspId.setText(qlCtSp.getIdCtsp());
        jtpCtspMoTa.setText(qlCtSp.getMoTa());
        txtCtspSoLuongTon.setText(String.valueOf(qlCtSp.getSoLuongTon()));
        txtCtspGiaNhap.setText(String.valueOf(qlCtSp.getGiaNhap()));
        txtCtspGiaBan.setText(String.valueOf(qlCtSp.getGiaban()));
        txtCtspNamBh.setText(String.valueOf(qlCtSp.getNamBanHang()));
        // fill ảnh
        if (qlCtSp.getHinhAnh().equalsIgnoreCase("No avt")) {
            jlbCtspHinhAnh.setText("NO AVT");
            jlbCtspHinhAnh.setText(null);

        } else {
            jlbCtspHinhAnh.setText("");
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + qlCtSp.getHinhAnh()));
            Image img = imageIcon.getImage();
            img.getScaledInstance(jlbCtspHinhAnh.getWidth(), jlbCtspHinhAnh.getY(), 0);
            jlbCtspHinhAnh.setIcon(imageIcon);
        }

        cbbCtspDongSanPham.setSelectedItem(qlCtSp.getIdDongSp());
        cbbCtspNhaSanXuat.setSelectedItem(qlCtSp.getIdNSX());
        cbbCtspKieuDang.setSelectedItem(qlCtSp.getIdKieuDang());
        cbbCtspKichCo.setSelectedItem(qlCtSp.getIdKichCo());
        cbbCtspChatLieu.setSelectedItem(qlCtSp.getIdChatLieu());
        cbbCtspMauSac.setSelectedItem(qlCtSp.getIdMauSac());
        cbbCtspSanPham.setSelectedItem(qlCtSp.getIdSanPham());
        cbbCtspThuongHieu.setSelectedItem(qlCtSp.getIdThuongHieu());

    }

    private QuanLyChiTietSanPham getQlChiTietSp() {
        String moTa = jtpCtspMoTa.getText();
        String soLuongTon = txtCtspSoLuongTon.getText();
        String giaNhap = txtCtspGiaNhap.getText();
        String giaBan = txtCtspGiaBan.getText();
        int namBh = Integer.valueOf(txtCtspNamBh.getText());
        String hinhAnh = strHinhAnhChiTietSanPham;
        int indexDongSp = cbbCtspDongSanPham.getSelectedIndex();
        QuanLyDongSanPham dongSp = lstDongSanPham.get(indexDongSp);
        int indexNhaSanXuat = cbbCtspNhaSanXuat.getSelectedIndex();
        QuanLyNhaSanXuat nsx = lstNhaSanXuat.get(indexNhaSanXuat);
        int indexKieuDang = cbbCtspKieuDang.getSelectedIndex();
        QuanLyKieuDang kd = lstKieuDang.get(indexKieuDang);
//        qlChiTietSp.setIdKichCo(String.valueOf(cbbCtspKichCo.getSelectedItem()));
        int indexKichCo = cbbCtspKichCo.getSelectedIndex();
        QuanLyKichco kc = lstKichCo.get(indexKichCo);
//        qlChiTietSp.setIdChatLieu(String.valueOf(cbbCtspChatLieu.getSelectedItem()));
        int indexChatLieu = cbbCtspChatLieu.getSelectedIndex();
        QuanLyChatLieu cl = lstChatLieu.get(indexChatLieu);
//        qlChiTietSp.setIdMauSac(String.valueOf(cbbCtspMauSac.getSelectedItem()));
        int indexMauSac = cbbCtspMauSac.getSelectedIndex();
        QuanLyMauSac ms = lstMauSac.get(indexMauSac);
//        qlChiTietSp.setIdSanPham(String.valueOf(cbbCtspSanPham.getSelectedItem()));
        int indexSanPham = cbbCtspSanPham.getSelectedIndex();
        QuanLySanPham sp = lstQLSp.get(indexSanPham);
//        qlChiTietSp.setIdThuongHieu(String.valueOf(cbbCtspThuongHieu.getSelectedItem()));
        int indexThuongHieu = cbbCtspThuongHieu.getSelectedIndex();
        QuanLyThuongHieu th = lstThuongHieu.get(indexThuongHieu);
//        qlChiTietSp.setQrCode(null);
        QuanLyChiTietSanPham qlChiTietSp = new QuanLyChiTietSanPham(null, moTa, Integer.valueOf(soLuongTon), Double.valueOf(giaNhap), Double.valueOf(giaBan), namBh, hinhAnh, null, dongSp.getId(), nsx.getId(), kd.getId(), kc.getId(), cl.getId(), ms.getId(), sp.getId(), th.getId(), null);
        return qlChiTietSp;
    }

    private void showComBoxCtspKieuDang(List<QuanLyKieuDang> lstKieuDang) {
        for (QuanLyKieuDang ql : lstKieuDang) {
            dcbbCtspKieuDang.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspSanPham(List<QuanLySanPham> lstSanPham) {
        for (QuanLySanPham ql : lstSanPham) {
            dcbbSanPham.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspKichCo(List<QuanLyKichco> lstKichCo) {
        for (QuanLyKichco ql : lstKichCo) {
            dcbbKichCo.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspThuongHieu(List<QuanLyThuongHieu> lstThuongHieu) {
        for (QuanLyThuongHieu ql : lstThuongHieu) {
            dcbbThuongHieu.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspMauSac(List<QuanLyMauSac> lstMauSac) {
        for (QuanLyMauSac ql : lstMauSac) {
            dcbbMauSac.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspChatLieu(List<QuanLyChatLieu> lstChatLieu) {
        for (QuanLyChatLieu ql : lstChatLieu) {
            dcbbChatLieu.addElement(ql.getDaChinh());
        }
    }

    private void showComBoxCtspDongSp(List<QuanLyDongSanPham> lstDongSp) {
        for (QuanLyDongSanPham ql : lstDongSp) {
            dcbbDongSp.addElement(ql.getTen());
        }
    }

    private void showComBoxCtspNsx(List<QuanLyNhaSanXuat> lstNhaSanXuat) {
        for (QuanLyNhaSanXuat ql : lstNhaSanXuat) {
            dcbbCtspNSX.addElement(ql.getTen());
        }
    }

    private void showTableChiTietSp(List<QuanLyChiTietSanPham> lstQlCtSp) {
        dtmChiTietSp.setRowCount(0);
        for (QuanLyChiTietSanPham ql : lstQlCtSp) {
            dtmChiTietSp.addRow(ql.arriveChiTietSp());
        }
    }

    private void showComBoxThuocTinh() {
        for (int i = 0; i < 2; i++) {
            lstThuocTinh.add(String.valueOf(i));
        }

        for (String s : lstThuocTinh) {
            dcbbThuocTinh.addElement(s);
        }
    }

    private void showComBoxMaSp() {
        for (QuanLySanPham ql : lstQLSp) {
            dcbbMaSanPham.addElement(ql.getMa());
        }
    }

    private void showComBoxTrangThaiSp() {
        for (int i = 0; i < 2; i++) {
            lstTrangThaiSp.add(String.valueOf(i));
        }

        for (String s : lstTrangThaiSp) {
            dcbbTrangThai.addElement(s);
        }
    }

    private void showTableSanPham(List<QuanLySanPham> lstQlSp) {
        dtmSP.setRowCount(0);
        for (QuanLySanPham ql : lstQlSp) {
            dtmSP.addRow(ql.arriveData());
        }
    }

    private void showDataTableDSSP(ArrayList<DanhSachSanPhamResponse> lists) {
        dtmDSSP = (DefaultTableModel) TBSanPham.getModel();
        int i = 1;
        dtmDSSP.setRowCount(0);
        for (DanhSachSanPhamResponse list : lists) {
            dtmDSSP.addRow(new Object[]{
                i++, list.getId(), list.getMaSp(), list.getTenSp(), list.getNamBH(), list.getKichCo(), list.getSoLuong(), list.getGiaNhap(), list.getGiaBan(), list.getHinhAnh()
            });
        }
    }

    private void showDataTableCTHD(ArrayList<ChiTietHoaDon> lists) {
        dtmGH = (DefaultTableModel) TBGioHang.getModel();
        int i = 1;
        dtmGH.setRowCount(0);
        for (ChiTietHoaDon list : lists) {
            dtmGH.addRow(new Object[]{
                i++, list.getIdCTSP(), list.getMaSP(), list.getTenSP(), list.getSoLuong(), list.getDonGia(), Integer.valueOf(list.getSoLuong()) * Integer.valueOf((int) list.getDonGia())
            });
        }
    }

    private void showTongTien() {
        int sum = 0;
        int tienShiptt = Integer.valueOf(txtTienShip.getText());
        if (txtTienShip.getText().isEmpty()) {
            tienShiptt = 0;
        }
        for (int i = 0; i < TBGioHang.getRowCount(); i++) {
            sum = sum + Integer.parseInt(TBGioHang.getModel().getValueAt(i, 6).toString());
        }
        System.out.println(sum);
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        jTongTien.setText(format.format(sum));
        jTongTienGiaoHang.setText(format.format(sum + tienShiptt));

    }

    private void showDataTableHD(ArrayList<HoaDonResponse> lists) {
        dtmHD = (DefaultTableModel) TBHoaDon.getModel();
        int i = 1;
        String maNV = "NV1";
        dtmHD.setRowCount(0);
        for (HoaDonResponse list : lists) {
            dtmHD.addRow(new Object[]{
                i++, list.getId(), list.getMaHD(), list.getNgayTao(), maNV, list.tenTrangThai()
            });
        }
    }

    private void checkTTKH() {
        if (txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap dia chi");
            return;
        }
        if (txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua SDT");
            return;
        }
        if (txtTenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap tenKH");
            return;
        }
    }

    private void checkTTKHGiaoHang() {
        if (txtDiaChiGiaoHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap dia chi");
            return;
        }
        if (txtSDTGiaoHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua SDT");
            return;
        }
        if (txtTenKHGiaoHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap tenKH");
            return;
        }
        if (txtTienShip.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap tien ship");
            return;
        }
    }

    private void capNhapSoLuongTonKho() {
        int rowGH = TBGioHang.getSelectedRow();
        String idSelected = (String) TBGioHang.getModel().getValueAt(rowGH, 1);
        int soLuongThemLai = (int) TBGioHang.getModel().getValueAt(rowGH, 4);
        ArrayList<DanhSachSanPhamResponse> listSL = danhSAchSanPhamService.getSoLuongById(idSelected);
        int soLuongTon = 0;
        for (DanhSachSanPhamResponse danhSachSanPhamResponse : listSL) {
            soLuongTon = danhSachSanPhamResponse.getSoLuong();
        }
        System.out.println(soLuongTon);
        System.out.println(soLuongThemLai);
        int soLuongSauXoa = soLuongTon + Integer.valueOf(soLuongThemLai);
        System.out.println(soLuongSauXoa);
        DanhSachSanPhamResponse dsspr = new DanhSachSanPhamResponse(soLuongSauXoa);
        JOptionPane.showMessageDialog(this, danhSAchSanPhamService.updateSoLuongSP(dsspr, idSelected));
        listDssp = danhSAchSanPhamService.getAll();
        showDataTableDSSP(listDssp);
    }

    private void showChoThanhToan() {
        rdoChoThanhToan.setSelected(true);
        if (rdoChoThanhToan.isSelected() == true) {
            int trangThai = 0;
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }

    private void showDaThanhToan() {
        rdoDaThanhToan.setSelected(true);
        if (rdoDaThanhToan.isSelected() == true) {
            int trangThai = 1;
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }

    private void dangGiaoHang() {
        rdoDangGiaoHang.setSelected(true);
        if (rdoDangGiaoHang.isSelected() == true) {
            int trangThai = 3;
            TBHoaDon.clearSelection();
            btnThanhToan1.setEnabled(true);
            btnHuyHoaDonGH.setEnabled(true);
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }

    // ls hd
    private void showDataTableCTHDLS(ArrayList<ChiTietHoaDon> lists) {
        dtmGH = (DefaultTableModel) TBGioHangLS.getModel();
        int i = 1;
        dtmGH.setRowCount(0);
        for (ChiTietHoaDon list : lists) {
            dtmGH.addRow(new Object[]{
                i++, list.getIdCTSP(), list.getMaSP(), list.getTenSP(), list.getSoLuong(), list.getDonGia(), Integer.valueOf(list.getSoLuong()) * Integer.valueOf((int) list.getDonGia())
            });
        }
    }

    private void showTongTienLS() {
        int sum = 0;
        int tienShiptt = Integer.valueOf(txtTienShipLS.getText());
        if (txtTienShipLS.getText().isEmpty()) {
            tienShiptt = 0;
        }
        for (int i = 0; i < TBGioHangLS.getRowCount(); i++) {
            sum = sum + Integer.parseInt(TBGioHangLS.getModel().getValueAt(i, 6).toString());
        }
        System.out.println(sum);
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
//        jTongTien.setText(format.format(sum));
        jTongTienGiaoHangLS.setText(format.format(sum + tienShiptt));

    }

    private void showDataTableHDLS(ArrayList<HoaDonResponse> lists) {
        dtmHD = (DefaultTableModel) TBHoaDonLS.getModel();
        JTable table = new JTable(dtmHD);
        int i = 1;
        String maNV = "NV1";
        dtmHD.setRowCount(0);
        for (HoaDonResponse list : lists) {
            dtmHD.insertRow(0, new Object[]{
                i++, list.getId(), list.getMaHD(), list.getNgayTao(), maNV, list.tenTrangThai()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btBanHang = new javax.swing.JButton();
        btSanPham = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();
        btKhuyenMai = new javax.swing.JButton();
        btNhanVien = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btThongKe = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        btAnhDaiDien = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        pnlCards = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jlbManHinhChinh = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        pnlCard1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BtnXoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBSanPham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        rdoTatCa = new javax.swing.JRadioButton();
        lblHinhAnhBH = new javax.swing.JLabel();
        cbbKichCo = new javax.swing.JComboBox<>();
        cbbDongSP = new javax.swing.JComboBox<>();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        palHD = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        jTienThua = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jTongTien = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        txtNgayThanhToan = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        cbbPTTT = new javax.swing.JComboBox<>();
        jLabel155 = new javax.swing.JLabel();
        txtTienChuyenKhoan = new javax.swing.JTextField();
        palGH = new javax.swing.JPanel();
        btnThanhToan1 = new javax.swing.JButton();
        btnHuyHoaDonGH = new javax.swing.JButton();
        jLabel156 = new javax.swing.JLabel();
        jTienThuaGiaoHang = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        txtTienKhachDuaGiaoHang = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jTongTienGiaoHang = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        txtDiaChiGiaoHang = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        txtSDTGiaoHang = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        txtTenKHGiaoHang = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        txtMaNVGiaoHang = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        txtNgayTaoGiaoHang = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        txtMaHDGiaoHang = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        txtTienShip = new javax.swing.JTextField();
        btnGuiHang = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jdcNgayHenKhach = new com.toedter.calendar.JDateChooser();
        btnNgayHenKhach = new javax.swing.JButton();
        jLabel167 = new javax.swing.JLabel();
        txtNgayNhan = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        txtNgayShip = new javax.swing.JTextField();
        btnApDungTienShip = new javax.swing.JButton();
        txtSoLuongTon = new javax.swing.JTextField();
        txtSoLuongGh = new javax.swing.JTextField();
        rdoDangGiaoHang = new javax.swing.JRadioButton();
        pnlCard2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btLamMoi = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jlbId = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        cbbTrangThaiSp = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbQlSanPham = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtTimKiemSp = new javax.swing.JTextField();
        btTimKiemSp = new javax.swing.JButton();
        btAllSanPham = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        cbbTimKiemTrangThaiSp = new javax.swing.JComboBox<>();
        jTimKiemTrangThaiSp = new javax.swing.JLabel();
        btTimKiemMAsp = new javax.swing.JButton();
        txtTimKiemMaSp = new javax.swing.JTextField();
        jpbSanPhamChiTiet = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cbbCtspSanPham = new javax.swing.JComboBox<>();
        cbbCtspKichCo = new javax.swing.JComboBox<>();
        txtCtspGiaNhap = new javax.swing.JTextField();
        txtCtspGiaBan = new javax.swing.JTextField();
        cbbCtspThuongHieu = new javax.swing.JComboBox<>();
        cbbCtspMauSac = new javax.swing.JComboBox<>();
        txtCtspSoLuongTon = new javax.swing.JTextField();
        cbbCtspDongSanPham = new javax.swing.JComboBox<>();
        cbbCtspChatLieu = new javax.swing.JComboBox<>();
        cbbCtspKieuDang = new javax.swing.JComboBox<>();
        cbbCtspNhaSanXuat = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtpCtspMoTa = new javax.swing.JTextPane();
        jLabel31 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jlbCtspHinhAnh = new javax.swing.JLabel();
        txtCtspNamBh = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jlbCtspId = new javax.swing.JLabel();
        btThemNhanhKichCo = new javax.swing.JButton();
        btThemNhanhDongSp = new javax.swing.JButton();
        btThemNhanhSanPham = new javax.swing.JButton();
        btThemNhanhThuongHieu = new javax.swing.JButton();
        btThemNhanhMauSac = new javax.swing.JButton();
        btThemNhanhKieuDang = new javax.swing.JButton();
        btThemNhanhChatLieu = new javax.swing.JButton();
        btThemNhanhNhaSanXuat = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbChiTietSanPham = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbbLocCtspThuongHieu = new javax.swing.JComboBox<>();
        cbbLocCtspKichCo = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        txtTimKiemTenSanPham = new javax.swing.JTextField();
        btTimTheoTenSanPham = new javax.swing.JButton();
        txtTimKiemGiaThapCtsp = new javax.swing.JTextField();
        txtTimKiemGiaCaoCtsp = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        btTimTheoGiaSanPham = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        rdbtKieuDang = new javax.swing.JRadioButton();
        rdbtMauSac = new javax.swing.JRadioButton();
        rdbtChatLieu = new javax.swing.JRadioButton();
        rdbtDongSanPham = new javax.swing.JRadioButton();
        rdbtThuongHieu = new javax.swing.JRadioButton();
        rdbtKichCo = new javax.swing.JRadioButton();
        rdbtNhaSanXuat = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        cbbThuocTinhSanPham = new javax.swing.JComboBox<>();
        txtMaThuocTinh = new javax.swing.JTextField();
        txtLopLotTrong = new javax.swing.JTextField();
        txtDeNgoai = new javax.swing.JTextField();
        txtDaPhu = new javax.swing.JTextField();
        txtDaChinh = new javax.swing.JTextField();
        btThemThuocTinh = new javax.swing.JButton();
        btSuaThuocTinh = new javax.swing.JButton();
        btXoaThuocTinh = new javax.swing.JButton();
        btLamMoiThuocTinh = new javax.swing.JButton();
        txtJd = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbThuocTinh = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        pnlCard3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        btnTimKiemHD = new javax.swing.JButton();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        cbbTenKieuBanHang = new javax.swing.JComboBox<>();
        txtTKSDT = new javax.swing.JTextField();
        btnTKSDT = new javax.swing.JButton();
        cbbTrangThaiHDLS = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TBHoaDonLS = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TBGioHangLS = new javax.swing.JTable();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        txtTenKHLS = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtSDTLS = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtDiaChiLS = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        cbbPTTTLS = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        txtTienChuyenKhoanLS = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtTienShipLS = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jTongTienGiaoHangLS = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jdcNgayHenKhachLS = new com.toedter.calendar.JDateChooser();
        jLabel137 = new javax.swing.JLabel();
        txtNgayShipLS = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txtNgayNhanLS = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        txtNgayThanhToanLS = new javax.swing.JTextField();
        txtTienKhachDuaGiaoHangLS = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        pnlCard4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cbbLoaiKhuyenMai = new javax.swing.JComboBox<>();
        txtTenKhuyenMai = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        cbbTrangThaiKhuyenMai = new javax.swing.JComboBox<>();
        btThemKhuyenMai = new javax.swing.JButton();
        btHuyKhuyenMai = new javax.swing.JButton();
        jlbTrangThaiKhuyenMai = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jdcNgayBatDauKm = new com.toedter.calendar.JDateChooser();
        jdcNgayKetThucKm = new com.toedter.calendar.JDateChooser();
        jlbIdKhuyenMai = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        jLabel100 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbSanPhamKhuyenMai = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        cbbTenKhuyenMaiSanPhamKhuyenMai = new javax.swing.JComboBox<>();
        jLabel142 = new javax.swing.JLabel();
        cbbTenSanPhamSanPhamKhuyenMai = new javax.swing.JComboBox<>();
        jLabel143 = new javax.swing.JLabel();
        cbbTrangThaiSanPhamKhuyenMai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jlbTrangThaiSanPhamKhuyenmai = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pnlCard5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        btThemNhanVien = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jlbIdNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        jdcNgaySinhNhanVien = new com.toedter.calendar.JDateChooser();
        rdbtNamNhanVien = new javax.swing.JRadioButton();
        rdbtNuNhanVien = new javax.swing.JRadioButton();
        txtDiaChiNhanVien = new javax.swing.JTextField();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();
        cbbChucVuNhanVien = new javax.swing.JComboBox<>();
        cbbTrangThaiNhanVien = new javax.swing.JComboBox<>();
        txtTenTk = new javax.swing.JTextField();
        jpfMatKhau = new javax.swing.JPasswordField();
        jlbAnhNhanVien = new javax.swing.JLabel();
        jlbChucVuNhanVien = new javax.swing.JLabel();
        jlbTrangThaiNhanVIen = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        cbbTimKiemChucVuNV = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        cbbTimKiemTrangThaiNV = new javax.swing.JComboBox<>();
        txtTimKiemTenNV = new javax.swing.JTextField();
        btTimKiemTenNV = new javax.swing.JButton();
        btAllNv = new javax.swing.JButton();
        cbbTimKiemGioiTinhNV = new javax.swing.JComboBox<>();
        jTimKiemChucVuNV = new javax.swing.JLabel();
        jTimKiemGioiTinhNV = new javax.swing.JLabel();
        jTimKiemTrangThaiNV = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbQuanLyNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        pnlCard6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jlbIdKhachHang = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        jdcNgaySinhKhachHang = new com.toedter.calendar.JDateChooser();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        txtDiaChiKhachHang = new javax.swing.JTextField();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jPanel30 = new javax.swing.JPanel();
        btThemKhachHang = new javax.swing.JButton();
        btSuaKhachHang = new javax.swing.JButton();
        btXoaKhachHang = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        rdbtNamKhachHang = new javax.swing.JRadioButton();
        rdbtNuKhachHang = new javax.swing.JRadioButton();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        cbbTimKiemTrangThaiKH = new javax.swing.JComboBox<>();
        jTimKiemTrangThaiKH = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cbbTimKiemGioiTinhKH = new javax.swing.JComboBox<>();
        jTimKiemGioiTinhKhachHang = new javax.swing.JLabel();
        btTimKiemTenKH = new javax.swing.JButton();
        txtTimKiemTenKH = new javax.swing.JTextField();
        cbbAllKH = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        pnlCard7 = new javax.swing.JPanel();
        jpnThongKe = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jlbDoanhThu = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jlbSoHoaDon = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jlbSoHangHuy = new javax.swing.JLabel();
        rdbtTatCaDoanhThuThongKe = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbDoanhThuThongKe = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        cbbDanhMucHangHoaThongKe = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbHangHoaHuy = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        btTimKiemNgayThongKe = new javax.swing.JButton();
        txtNgaybatDauTaoHoaDon = new javax.swing.JTextField();
        txtNgayKetThucTaoHoaDon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerSize(0);

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        btBanHang.setBackground(new java.awt.Color(51, 255, 0));
        btBanHang.setText("Bán Hàng");
        btBanHang.setBorder(null);
        btBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanHangActionPerformed(evt);
            }
        });

        btSanPham.setBackground(new java.awt.Color(0, 255, 51));
        btSanPham.setText("Sản Phẩm");
        btSanPham.setBorder(null);
        btSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSanPhamActionPerformed(evt);
            }
        });

        btHoaDon.setBackground(new java.awt.Color(0, 255, 51));
        btHoaDon.setText("Lịch Sử");
        btHoaDon.setBorder(null);
        btHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHoaDonActionPerformed(evt);
            }
        });

        btKhuyenMai.setBackground(new java.awt.Color(0, 255, 51));
        btKhuyenMai.setText("Khuyến Mại");
        btKhuyenMai.setBorder(null);
        btKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhuyenMaiActionPerformed(evt);
            }
        });

        btNhanVien.setBackground(new java.awt.Color(0, 255, 51));
        btNhanVien.setText("Nhân viên");
        btNhanVien.setBorder(null);
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btKhachHang.setBackground(new java.awt.Color(0, 255, 51));
        btKhachHang.setText("Khách hàng");
        btKhachHang.setBorder(null);
        btKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangActionPerformed(evt);
            }
        });

        btThongKe.setBackground(new java.awt.Color(0, 255, 51));
        btThongKe.setText("Thống kê");
        btThongKe.setBorder(null);
        btThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThongKeActionPerformed(evt);
            }
        });

        btThoat.setBackground(new java.awt.Color(0, 255, 51));
        btThoat.setText("Thoát");
        btThoat.setBorder(null);
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        btAnhDaiDien.setBackground(new java.awt.Color(0, 255, 51));
        btAnhDaiDien.setBorder(null);
        btAnhDaiDien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnhDaiDienActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 255, 0));
        jButton16.setText("Màn hình chính");
        jButton16.setBorder(null);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btAnhDaiDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        pnlCards.setLayout(new java.awt.CardLayout());

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jlbManHinhChinh.setText(".");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jlbManHinhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 1757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 169, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jlbManHinhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 185, Short.MAX_VALUE))
        );

        pnlCards.add(jPanel26, "card14");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        pnlCard1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã HĐ", "Ngày Tạo", "Mã NV", "Trạng Thái"
            }
        ));
        TBHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        BtnXoa.setText("Xoa");
        BtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnXoaActionPerformed(evt);
            }
        });

        TBGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        TBGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBGioHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnXoa))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã SP", "Tên SP", "Năm BH", "Mô tả", "Số Lượng", "Giá Nhập", "Giá Bán", "Anh"
            }
        ));
        TBSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TBSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Hóa đơn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sản phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Quản Lý Bán Hàng");

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán ");
        rdoDaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaThanhToanMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chưa thanh toán");
        rdoChoThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChoThanhToanMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setText("Đã hủy");
        rdoDaHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaHuyMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatCaMouseClicked(evt);
            }
        });

        cbbKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKichCoActionPerformed(evt);
            }
        });

        cbbDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDongSPActionPerformed(evt);
            }
        });

        cbbThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThuongHieuActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setText("Tạo Hoá Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyHoaDon.setText("Huỷ Hoá Đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        jLabel144.setText("Tiền thừa");

        jTienThua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTienThua.setForeground(new java.awt.Color(255, 0, 51));
        jTienThua.setText("-");

        jLabel145.setText("Tiền khách đưa");

        txtTienKhachDua.setText("0");

        jLabel146.setText("Tổng Tiền");

        jTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTongTien.setForeground(new java.awt.Color(255, 0, 51));
        jTongTien.setText("-");

        jLabel147.setText("Dia Chi");

        jLabel148.setText("SDT");

        jLabel149.setText("Ten KH");

        jLabel150.setText("Ma NV");

        jLabel151.setText("Ngày Tạo");

        jLabel152.setText("Mã HĐ");

        jLabel153.setText("Ngày thanh toán");

        jLabel154.setText("Thanh Toán");

        cbbPTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", "Tiền Mặt + Chuyển Khoản" }));
        cbbPTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPTTTActionPerformed(evt);
            }
        });

        jLabel155.setText("Tiền chuyển khoản");

        txtTienChuyenKhoan.setText("0");

        javax.swing.GroupLayout palHDLayout = new javax.swing.GroupLayout(palHD);
        palHD.setLayout(palHDLayout);
        palHDLayout.setHorizontalGroup(
            palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(palHDLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(palHDLayout.createSequentialGroup()
                        .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, palHDLayout.createSequentialGroup()
                        .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, palHDLayout.createSequentialGroup()
                                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgayTao)
                                    .addComponent(txtMaHD)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, palHDLayout.createSequentialGroup()
                                .addComponent(jLabel154)
                                .addGap(23, 23, 23)
                                .addComponent(cbbPTTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))
                    .addGroup(palHDLayout.createSequentialGroup()
                        .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(palHDLayout.createSequentialGroup()
                                    .addComponent(jLabel155)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(palHDLayout.createSequentialGroup()
                                .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(palHDLayout.createSequentialGroup()
                        .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel146)
                            .addGroup(palHDLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(palHDLayout.createSequentialGroup()
                                .addComponent(jLabel145)
                                .addGap(18, 18, 18)
                                .addComponent(jTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        palHDLayout.setVerticalGroup(
            palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, palHDLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel152)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel147)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel154)
                    .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel146)
                    .addComponent(jTongTien))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155)
                    .addComponent(txtTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTienThua)
                    .addComponent(jLabel144))
                .addGap(18, 18, 18)
                .addGroup(palHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnHuyHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        tab.addTab("Hoa Don", palHD);

        btnThanhToan1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToan1.setText("Đã Nhận Hàng");
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });

        btnHuyHoaDonGH.setText("Huỷ Hoá Đơn");
        btnHuyHoaDonGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonGHActionPerformed(evt);
            }
        });

        jLabel156.setText("Tiền thừa");

        jTienThuaGiaoHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTienThuaGiaoHang.setForeground(new java.awt.Color(255, 0, 51));
        jTienThuaGiaoHang.setText("-");

        jLabel157.setText("Tiền khách đưa");

        txtTienKhachDuaGiaoHang.setText("0");

        jLabel158.setText("Tổng Tiền");

        jTongTienGiaoHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTongTienGiaoHang.setForeground(new java.awt.Color(255, 0, 51));
        jTongTienGiaoHang.setText("-");

        jLabel159.setText("Dia Chi");

        jLabel160.setText("SDT");

        jLabel161.setText("Ten KH");

        jLabel162.setText("Ma NV");

        jLabel163.setText("Ngày Tạo");

        jLabel164.setText("Mã HĐ");

        jLabel165.setText("TienShip");

        txtTienShip.setText("0");
        txtTienShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienShipMouseClicked(evt);
            }
        });

        btnGuiHang.setText("Xác Nhận Gửi Hàng");
        btnGuiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiHangActionPerformed(evt);
            }
        });

        jLabel166.setText("Ngày Hẹn Khách");

        btnNgayHenKhach.setText("Xác nhận ngày hẹn khách");
        btnNgayHenKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayHenKhachActionPerformed(evt);
            }
        });

        jLabel167.setText("Ngày khách nhận");

        jLabel168.setText("NgayShip");

        btnApDungTienShip.setText("Lưu");
        btnApDungTienShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungTienShipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout palGHLayout = new javax.swing.GroupLayout(palGH);
        palGH.setLayout(palGHLayout);
        palGHLayout.setHorizontalGroup(
            palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, palGHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNgayHenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addComponent(btnHuyHoaDonGH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuiHang)))
                .addGap(33, 33, 33))
            .addGroup(palGHLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txtNgayShip))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jTienThuaGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel166))
                        .addGap(31, 31, 31)
                        .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDTGiaoHang)
                            .addComponent(txtTenKHGiaoHang)
                            .addComponent(txtDiaChiGiaoHang)
                            .addComponent(txtMaNVGiaoHang)
                            .addComponent(txtNgayTaoGiaoHang)
                            .addComponent(txtMaHDGiaoHang)
                            .addComponent(jdcNgayHenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addComponent(jLabel167)
                        .addGap(29, 29, 29)
                        .addComponent(txtNgayNhan))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel158))
                        .addGap(66, 66, 66)
                        .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTongTienGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(palGHLayout.createSequentialGroup()
                                .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnApDungTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addComponent(jLabel157)
                        .addGap(39, 39, 39)
                        .addComponent(txtTienKhachDuaGiaoHang)))
                .addContainerGap())
        );
        palGHLayout.setVerticalGroup(
            palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, palGHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHDGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTaoGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(txtMaNVGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel161)
                    .addComponent(txtTenKHGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel160)
                    .addComponent(txtSDTGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(txtDiaChiGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel166)
                    .addComponent(jdcNgayHenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel165)
                    .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnApDungTienShip)))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTongTienGiaoHang)
                    .addComponent(jLabel158))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(txtTienKhachDuaGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel156)
                    .addComponent(jTienThuaGiaoHang))
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel168))
                    .addGroup(palGHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167)
                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnNgayHenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(palGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuiHang)
                    .addComponent(btnHuyHoaDonGH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        tab.addTab("Giao hang", palGH);

        buttonGroup1.add(rdoDangGiaoHang);
        rdoDangGiaoHang.setText("Đang giao hàng");
        rdoDangGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDangGiaoHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCard1Layout.createSequentialGroup()
                                        .addComponent(btnRefresh)
                                        .addGap(67, 67, 67)
                                        .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(rdoDaThanhToan)
                                .addGap(18, 18, 18)
                                .addComponent(rdoChoThanhToan)
                                .addGap(36, 36, 36)
                                .addComponent(rdoDaHuy)
                                .addGap(36, 36, 36)
                                .addComponent(rdoTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDangGiaoHang))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addGap(572, 572, 572)
                                .addComponent(jLabel6))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHoaDon)
                            .addComponent(lblHinhAnhBH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(pnlCard1Layout.createSequentialGroup()
                                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuongGh, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(435, 435, 435))
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDaThanhToan)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoDaHuy)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoDangGiaoHang))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongGh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addComponent(lblHinhAnhBH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(65, 65, 65))
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 111, Short.MAX_VALUE))
        );

        pnlCards.add(jPanel19, "card9");

        pnlCard2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Quản lý sản phẩm");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setText("Mã sản phẩm");

        jLabel14.setText("Tên sản phẩm");

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btLamMoi.setText("làm mới");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(btSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btSua)
                .addGap(18, 18, 18)
                .addComponent(btXoa)
                .addGap(18, 18, 18)
                .addComponent(btLamMoi)
                .addContainerGap())
        );

        jLabel22.setText("Id");

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));

        jlbId.setText(".");

        jLabel73.setText("Trạng thái");

        cbbTrangThaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jlbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbTrangThaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(649, 649, 649))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71)
                            .addComponent(jlbId)
                            .addComponent(jLabel73)
                            .addComponent(cbbTrangThaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Thông tin sản phẩm");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbQlSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbQlSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQlSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbQlSanPham);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Lọc sản phẩm");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btTimKiemSp.setText("Tìm kiếm");
        btTimKiemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemSpActionPerformed(evt);
            }
        });

        btAllSanPham.setText("tất cả sản phẩm");
        btAllSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllSanPhamActionPerformed(evt);
            }
        });

        jLabel46.setText("Trạng Thái");

        cbbTimKiemTrangThaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemTrangThaiSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemTrangThaiSpActionPerformed(evt);
            }
        });

        jTimKiemTrangThaiSp.setText(".");

        btTimKiemMAsp.setText("tìm kiếm mã");
        btTimKiemMAsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemMAspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btTimKiemMAsp)
                        .addGap(34, 34, 34)
                        .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTimKiemTrangThaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTimKiemTrangThaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(btTimKiemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(btAllSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemSp)
                    .addComponent(jLabel46)
                    .addComponent(cbbTimKiemTrangThaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimKiemTrangThaiSp)
                    .addComponent(btTimKiemMAsp)
                    .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btAllSanPham)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel24.setText("Sản phẩm");

        jLabel25.setText("Thương hiệu");

        jLabel28.setText("Kích cỡ");

        jLabel29.setText("Màu sắc");

        jLabel32.setText("Năm BH");

        jLabel33.setText("Giá nhập");

        jLabel34.setText("Giá bán");

        jLabel35.setText("Số lượng tồn");

        jLabel36.setText("Dòng Sp");

        jLabel38.setText("Nhà sản xuất");

        jLabel39.setText("Kiểu dáng");

        jLabel40.setText("Chất liệu");

        jLabel42.setText("Mô tả");

        cbbCtspSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspSanPhamMouseClicked(evt);
            }
        });

        cbbCtspKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspKichCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspKichCoMouseClicked(evt);
            }
        });

        cbbCtspThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspThuongHieuMouseClicked(evt);
            }
        });

        cbbCtspMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspMauSacMouseClicked(evt);
            }
        });

        cbbCtspDongSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspDongSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspDongSanPhamMouseClicked(evt);
            }
        });

        cbbCtspChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspChatLieuMouseClicked(evt);
            }
        });

        cbbCtspKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspKieuDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspKieuDangMouseClicked(evt);
            }
        });

        cbbCtspNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCtspNhaSanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCtspNhaSanXuatMouseClicked(evt);
            }
        });

        jScrollPane6.setViewportView(jtpCtspMoTa);

        jLabel31.setText("Hình ảnh");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sửa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Xóa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Làm mới");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addGap(37, 37, 37)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(38, 38, 38)
                .addComponent(jButton8)
                .addGap(30, 30, 30))
        );

        jlbCtspHinhAnh.setText("Hình ảnh");
        jlbCtspHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlbCtspHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCtspHinhAnhMouseClicked(evt);
            }
        });

        jLabel99.setText("Id");

        jlbCtspId.setText(".");

        btThemNhanhKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhKichCoActionPerformed(evt);
            }
        });

        btThemNhanhDongSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhDongSpActionPerformed(evt);
            }
        });

        btThemNhanhSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhSanPhamActionPerformed(evt);
            }
        });

        btThemNhanhThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhThuongHieuActionPerformed(evt);
            }
        });

        btThemNhanhMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhMauSacActionPerformed(evt);
            }
        });

        btThemNhanhKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhKieuDangActionPerformed(evt);
            }
        });

        btThemNhanhChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhChatLieuActionPerformed(evt);
            }
        });

        btThemNhanhNhaSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanhNhaSanXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtCtspGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbbCtspSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThemNhanhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCtspNamBh)
                            .addComponent(cbbCtspKichCo, 0, 174, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btThemNhanhKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel35))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlbCtspId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCtspGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCtspSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbbCtspThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThemNhanhThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(cbbCtspNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThemNhanhNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cbbCtspMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btThemNhanhMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cbbCtspChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btThemNhanhChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(167, 167, 167)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbbCtspDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btThemNhanhDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbbCtspKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btThemNhanhKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbCtspHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btThemNhanhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThemNhanhNhaSanXuat)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25)
                                .addComponent(cbbCtspSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbCtspThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38)
                                .addComponent(cbbCtspNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btThemNhanhThuongHieu)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(cbbCtspKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCtspMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42)
                                    .addComponent(btThemNhanhKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btThemNhanhMauSac))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(txtCtspSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(txtCtspNamBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(cbbCtspDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtCtspGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btThemNhanhDongSp))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(cbbCtspChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel34)
                                    .addComponent(txtCtspGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btThemNhanhChatLieu))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(cbbCtspKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel99)
                                    .addComponent(jlbCtspId)
                                    .addComponent(btThemNhanhKieuDang))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbCtspHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbChiTietSanPham);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(523, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel37.setText("Thuơng hiệu");

        jLabel41.setText("Kích Cỡ");

        cbbLocCtspThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocCtspThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocCtspThuongHieuActionPerformed(evt);
            }
        });

        cbbLocCtspKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocCtspKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocCtspKichCoActionPerformed(evt);
            }
        });

        jLabel44.setText("Tên sản phẩm");

        btTimTheoTenSanPham.setText("tìm kiếm");
        btTimTheoTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimTheoTenSanPhamActionPerformed(evt);
            }
        });

        jLabel43.setText("Giá cao");

        jLabel107.setText("Giá thấp");

        jLabel111.setText("Giá");

        btTimTheoGiaSanPham.setText("Tìm");
        btTimTheoGiaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimTheoGiaSanPhamActionPerformed(evt);
            }
        });

        jButton9.setText("Tất cả sản phẩm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(cbbLocCtspThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbLocCtspKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(78, 78, 78)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiemGiaThapCtsp, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtTimKiemGiaCaoCtsp))
                        .addGap(18, 18, 18)
                        .addComponent(btTimTheoGiaSanPham)))
                .addGap(47, 47, 47)
                .addComponent(jLabel44)
                .addGap(27, 27, 27)
                .addComponent(txtTimKiemTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTimTheoTenSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbLocCtspThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41)
                                .addComponent(cbbLocCtspKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTimTheoTenSanPham)
                                .addComponent(txtTimKiemTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44))
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemGiaCaoCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemGiaThapCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(btTimTheoGiaSanPham)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Chi Tiết sản phẩm");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Lọc sản phẩm");

        javax.swing.GroupLayout jpbSanPhamChiTietLayout = new javax.swing.GroupLayout(jpbSanPhamChiTiet);
        jpbSanPhamChiTiet.setLayout(jpbSanPhamChiTietLayout);
        jpbSanPhamChiTietLayout.setHorizontalGroup(
            jpbSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpbSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpbSanPhamChiTietLayout.createSequentialGroup()
                        .addGroup(jpbSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpbSanPhamChiTietLayout.setVerticalGroup(
            jpbSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbSanPhamChiTietLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm Chi Tiết", jpbSanPhamChiTiet);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup2.add(rdbtKieuDang);
        rdbtKieuDang.setText("Kiểu dáng");
        rdbtKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtKieuDangActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtMauSac);
        rdbtMauSac.setText("Màu sắc");
        rdbtMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtMauSacActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtChatLieu);
        rdbtChatLieu.setText("Chất liệu");
        rdbtChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtChatLieuActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtDongSanPham);
        rdbtDongSanPham.setText("Dòng sản phẩm");
        rdbtDongSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtDongSanPhamActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtThuongHieu);
        rdbtThuongHieu.setText("Thương hiệu");
        rdbtThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtThuongHieuActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtKichCo);
        rdbtKichCo.setText("Kích cỡ");
        rdbtKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtKichCoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbtNhaSanXuat);
        rdbtNhaSanXuat.setText(" Nhà sản xuất");
        rdbtNhaSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtNhaSanXuatActionPerformed(evt);
            }
        });

        jLabel18.setText("Id");

        jLabel19.setText("Mã");

        jLabel23.setText("Tên");

        jLabel52.setText("Trạng thái");

        jLabel54.setText("Da chính");

        jLabel55.setText("Da phụ");

        jLabel56.setText("Đế ngoài");

        jLabel57.setText("Lớp lót trong");

        cbbThuocTinhSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btThemThuocTinh.setText("Thêm");
        btThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemThuocTinhActionPerformed(evt);
            }
        });

        btSuaThuocTinh.setText("Sửa");
        btSuaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaThuocTinhActionPerformed(evt);
            }
        });

        btXoaThuocTinh.setText("Xóa");
        btXoaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaThuocTinhActionPerformed(evt);
            }
        });

        btLamMoiThuocTinh.setText("Làm mới");
        btLamMoiThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiThuocTinhActionPerformed(evt);
            }
        });

        txtJd.setText("id.");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(txtMaThuocTinh)
                        .addComponent(cbbThuocTinhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtJd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDaChinh)
                        .addComponent(txtDaPhu, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                    .addComponent(txtDeNgoai, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLopLotTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSuaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLamMoiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(213, 213, 213))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtDongSanPham)
                    .addComponent(jLabel18)
                    .addComponent(jLabel54)
                    .addComponent(txtDaChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemThuocTinh)
                    .addComponent(txtJd))
                .addGap(24, 24, 24)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtKichCo)
                    .addComponent(jLabel19)
                    .addComponent(jLabel55)
                    .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDaPhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtKieuDang)
                    .addComponent(jLabel23)
                    .addComponent(jLabel56)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeNgoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSuaThuocTinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtThuongHieu)
                    .addComponent(jLabel52)
                    .addComponent(jLabel57)
                    .addComponent(cbbThuocTinhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLopLotTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtNhaSanXuat)
                    .addComponent(btXoaThuocTinh))
                .addGap(18, 18, 18)
                .addComponent(rdbtMauSac)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtChatLieu)
                    .addComponent(btLamMoiThuocTinh))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Thông tin thuộc tính");

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbThuocTinh);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Thuộc tính");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 374, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel16);

        javax.swing.GroupLayout pnlCard2Layout = new javax.swing.GroupLayout(pnlCard2);
        pnlCard2.setLayout(pnlCard2Layout);
        pnlCard2Layout.setHorizontalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addGap(522, 522, 522)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        pnlCard2Layout.setVerticalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pnlCards.add(pnlCard2, "card3");

        pnlCard3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quản Lý Hóa Đơn");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnTimKiemHD.setText("Tìm Kiếm");
        btnTimKiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHDActionPerformed(evt);
            }
        });

        cbbTenKieuBanHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán hàng tại quầy", "Giao hàng" }));
        cbbTenKieuBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenKieuBanHangActionPerformed(evt);
            }
        });

        btnTKSDT.setText("Tìm kiếm");
        btnTKSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKSDTActionPerformed(evt);
            }
        });

        cbbTrangThaiHDLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả ", "Chờ Thanh Toán", "Đã Thanh Toán", "Đã Huỷ" }));
        cbbTrangThaiHDLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiHDLSActionPerformed(evt);
            }
        });

        jLabel20.setText("Từ");

        jLabel21.setText("Đến");

        jLabel48.setText("Tìm theo SDT");

        jLabel49.setText("Trạng Thái Hoá Đơn");

        jLabel50.setText("Hình Thức Bán Hàng");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbTrangThaiHDLS, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbTenKieuBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTKSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemHD)
                    .addComponent(btnTKSDT))
                .addGap(29, 29, 29))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiemHD)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTKSDT)
                                .addComponent(txtTKSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbTenKieuBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50))))
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTrangThaiHDLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBHoaDonLS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã HĐ", "Ngày Tạo", "Mã NV", "Trạng Thái"
            }
        ));
        TBHoaDonLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBHoaDonLSMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TBHoaDonLS);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBGioHangLS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        TBGioHangLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBGioHangLSMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TBGioHangLS);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel101.setText("Lọc hóa đơn");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel102.setText("Hóa đơn");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel103.setText("Hóa đơn chi tiết");

        jLabel63.setText("Ten KH");

        jLabel64.setText("SDT");

        jLabel65.setText("Dia Chi");

        jLabel66.setText("Thanh Toán");

        cbbPTTTLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", "Tiền Mặt + Chuyển Khoản", "COD" }));
        cbbPTTTLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPTTTLSActionPerformed(evt);
            }
        });

        jLabel67.setText("Tiền chuyển khoản");

        txtTienChuyenKhoanLS.setText("0");

        jLabel68.setText("Tiền mặt");

        jLabel69.setText("TienShip");

        txtTienShipLS.setText("0");
        txtTienShipLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienShipLSMouseClicked(evt);
            }
        });

        jLabel135.setText("Tổng Tiền");

        jTongTienGiaoHangLS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTongTienGiaoHangLS.setForeground(new java.awt.Color(255, 0, 51));
        jTongTienGiaoHangLS.setText("-");

        jLabel136.setText("Ngày Hẹn Khách");

        jLabel137.setText("NgayShip");

        jLabel138.setText("Ngày khách nhận");

        jLabel139.setText("Ngày thanh toán");

        txtTienKhachDuaGiaoHangLS.setText("0");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayNhanLS))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcNgayHenKhachLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgayShipLS))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel136)
                            .addComponent(jLabel135)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTongTienGiaoHangLS, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 111, Short.MAX_VALUE))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtTienShipLS))))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel66)
                                .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel68))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDuaGiaoHangLS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTienChuyenKhoanLS)
                            .addComponent(cbbPTTTLS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtDiaChiLS))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtTenKHLS))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtSDTLS))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayThanhToanLS)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtTenKHLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(23, 23, 23)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txtDiaChiLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(cbbPTTTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtTienKhachDuaGiaoHangLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(txtTienChuyenKhoanLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69)
                    .addComponent(txtTienShipLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel135)
                    .addComponent(jTongTienGiaoHangLS))
                .addGap(18, 18, 18)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel136)
                    .addComponent(jdcNgayHenKhachLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel137)
                    .addComponent(txtNgayShipLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayNhanLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138))
                .addGap(18, 18, 18)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(txtNgayThanhToanLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setText("Thông Tin Đơn Hàng");

        javax.swing.GroupLayout pnlCard3Layout = new javax.swing.GroupLayout(pnlCard3);
        pnlCard3.setLayout(pnlCard3Layout);
        pnlCard3Layout.setHorizontalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlCard3Layout.createSequentialGroup()
                            .addGap(488, 488, 488)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCard3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel101))
                        .addGroup(pnlCard3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCard3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCard3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(752, 752, 752))))
        );
        pnlCard3Layout.setVerticalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard3Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jLabel102)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(pnlCard3Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlCards.add(pnlCard3, "card4");

        pnlCard4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Quản Lý khuyến Mại");

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel59.setText("Tên khuyến mại");

        jLabel61.setText("Loại khuyến mại");

        cbbLoaiKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel106.setText("Trạng thái");

        cbbTrangThaiKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThaiKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiKhuyenMaiActionPerformed(evt);
            }
        });

        btThemKhuyenMai.setText("Thêm");
        btThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemKhuyenMaiActionPerformed(evt);
            }
        });

        btHuyKhuyenMai.setText("Sửa");
        btHuyKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyKhuyenMaiActionPerformed(evt);
            }
        });

        jlbTrangThaiKhuyenMai.setText("...");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangThaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbTrangThaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(btHuyKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(cbbTrangThaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTrangThaiKhuyenMai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(cbbLoaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemKhuyenMai)
                    .addComponent(btHuyKhuyenMai))
                .addGap(29, 29, 29))
        );

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel86.setText("Chưởng trình khuyến mại");

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel62.setText("Ngày bắt đầu");

        jLabel90.setText("Ngày kết thúc");

        jlbIdKhuyenMai.setText(".");

        jLabel141.setText("Id");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcNgayBatDauKm, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jdcNgayKetThucKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbIdKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62)
                    .addComponent(jdcNgayBatDauKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(jdcNgayKetThucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbIdKhuyenMai)
                    .addComponent(jLabel141))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbKhuyenMai);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel100.setText("Thời gian sử dụng");

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbSanPhamKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tbSanPhamKhuyenMai);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel140.setText("Tên khuyến mại");

        cbbTenKhuyenMaiSanPhamKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel142.setText("Tên sản phẩm");

        cbbTenSanPhamSanPhamKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel143.setText("Trạng thái");

        cbbTrangThaiSanPhamKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThaiSanPhamKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiSanPhamKhuyenMaiActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlbTrangThaiSanPhamKhuyenmai.setText(".");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel140)
                .addGap(18, 18, 18)
                .addComponent(cbbTenKhuyenMaiSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jLabel142)
                .addGap(18, 18, 18)
                .addComponent(cbbTenSanPhamSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(jLabel143)
                .addGap(18, 18, 18)
                .addComponent(cbbTrangThaiSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbTrangThaiSanPhamKhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(cbbTenKhuyenMaiSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142)
                    .addComponent(cbbTenSanPhamSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143)
                    .addComponent(cbbTrangThaiSanPhamKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jlbTrangThaiSanPhamKhuyenmai))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setText("Sản phẩm khuyến mại");

        javax.swing.GroupLayout pnlCard4Layout = new javax.swing.GroupLayout(pnlCard4);
        pnlCard4.setLayout(pnlCard4Layout);
        pnlCard4Layout.setHorizontalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlCard4Layout.createSequentialGroup()
                            .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel86))
                            .addGap(43, 43, 43)
                            .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel100)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel8)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        pnlCard4Layout.setVerticalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard4, "card5");

        pnlCard5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Quản Lý Nhân Viên");

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel72.setText("Id");

        jLabel74.setText("Mã");

        jLabel75.setText("Tên");

        jLabel76.setText("Ngày sinh");

        jLabel77.setText("Giới tính");

        jLabel78.setText("Địa chỉ");

        jLabel79.setText("Số điện thoại");

        jLabel80.setText("Chức vụ");

        jLabel81.setText("Trạng thái");

        jLabel82.setText("Tên tk");

        jLabel83.setText("Mật khẩu");

        jLabel84.setText("Hình ảnh");

        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btThemNhanVien.setText("Thêm");
        btThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanVienActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btThemNhanVien)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(22, 22, 22))
        );

        jlbIdNhanVien.setText(".");

        buttonGroup3.add(rdbtNamNhanVien);
        rdbtNamNhanVien.setText("Nam");

        buttonGroup3.add(rdbtNuNhanVien);
        rdbtNuNhanVien.setText("Nữ");

        cbbChucVuNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChucVuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuNhanVienActionPerformed(evt);
            }
        });

        cbbTrangThaiNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThaiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiNhanVienActionPerformed(evt);
            }
        });

        jlbAnhNhanVien.setText("Hình ảnh");
        jlbAnhNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlbAnhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbAnhNhanVienMouseClicked(evt);
            }
        });

        jlbChucVuNhanVien.setText(".");

        jlbTrangThaiNhanVIen.setText(".");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbIdNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaNhanVien)
                    .addComponent(txtTenNhanVien)
                    .addComponent(jdcNgaySinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(rdbtNamNhanVien)
                                .addGap(50, 50, 50)
                                .addComponent(rdbtNuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChiNhanVien)
                            .addComponent(txtSoDienThoaiNhanVien))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cbbChucVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbChucVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenTk, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addComponent(jpfMatKhau))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cbbTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTrangThaiNhanVIen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel84)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jlbAnhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel77)
                    .addComponent(jLabel81)
                    .addComponent(jLabel84)
                    .addComponent(jlbIdNhanVien)
                    .addComponent(rdbtNamNhanVien)
                    .addComponent(rdbtNuNhanVien)
                    .addComponent(cbbTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTrangThaiNhanVIen))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel78)
                            .addComponent(jLabel82)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79)
                            .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83)
                            .addComponent(jpfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel80)
                                .addComponent(cbbChucVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbChucVuNhanVien)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbAnhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel87.setText("Chức vụ");

        cbbTimKiemChucVuNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemChucVuNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemChucVuNVActionPerformed(evt);
            }
        });

        jLabel88.setText("Giới  tính");

        jLabel89.setText("Trạng thái");

        cbbTimKiemTrangThaiNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemTrangThaiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemTrangThaiNVActionPerformed(evt);
            }
        });

        btTimKiemTenNV.setText("Tìm kiếm Tên");
        btTimKiemTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemTenNVActionPerformed(evt);
            }
        });

        btAllNv.setText("Tất cả nhân viên");
        btAllNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllNvActionPerformed(evt);
            }
        });

        cbbTimKiemGioiTinhNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemGioiTinhNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemGioiTinhNVActionPerformed(evt);
            }
        });

        jTimKiemChucVuNV.setText("...");

        jTimKiemGioiTinhNV.setText("...");

        jTimKiemTrangThaiNV.setText("...");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAllNv))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTimKiemChucVuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTimKiemChucVuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTimKiemGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTimKiemGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel89)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTimKiemTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTimKiemTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btTimKiemTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtTimKiemTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(cbbTimKiemChucVuNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88)
                    .addComponent(jLabel89)
                    .addComponent(cbbTimKiemTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemTenNV)
                    .addComponent(cbbTimKiemGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimKiemChucVuNV)
                    .addComponent(jTimKiemGioiTinhNV)
                    .addComponent(txtTimKiemTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimKiemTrangThaiNV))
                .addGap(18, 18, 18)
                .addComponent(btAllNv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbQuanLyNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQuanLyNhanVienMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbQuanLyNhanVien);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Thông tin nhân viên");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel85.setText("Tìm kiếm nhân viên");

        javax.swing.GroupLayout pnlCard5Layout = new javax.swing.GroupLayout(pnlCard5);
        pnlCard5.setLayout(pnlCard5Layout);
        pnlCard5Layout.setHorizontalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel85))
                .addContainerGap(482, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(596, 596, 596))
        );
        pnlCard5Layout.setVerticalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard5, "card6");

        pnlCard6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Quản Lý Khách Hàng");

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel91.setText("Id");

        jLabel92.setText("Mã");

        jLabel93.setText("Tên");

        jLabel94.setText("Giới tính");

        jLabel95.setText("Ngày sinh");

        jLabel96.setText("Số điện thoại");

        jLabel97.setText("Địa chỉ");

        jLabel98.setText("Trạng thái");

        jlbIdKhachHang.setText(".");

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btThemKhachHang.setText("Thêm");
        btThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemKhachHangActionPerformed(evt);
            }
        });

        btSuaKhachHang.setText("Sửa");
        btSuaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaKhachHangActionPerformed(evt);
            }
        });

        btXoaKhachHang.setText("Xóa");
        btXoaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaKhachHangActionPerformed(evt);
            }
        });

        jButton14.setText("Làm mới");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btThemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSuaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXoaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(btThemKhachHang)
                .addGap(18, 18, 18)
                .addComponent(btSuaKhachHang)
                .addGap(18, 18, 18)
                .addComponent(btXoaKhachHang)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(15, 15, 15))
        );

        buttonGroup5.add(rdbtNamKhachHang);
        rdbtNamKhachHang.setSelected(true);
        rdbtNamKhachHang.setText("Nam");

        buttonGroup5.add(rdbtNuKhachHang);
        rdbtNuKhachHang.setText("Nữ");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKhachHang))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKhachHang))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbIdKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(rdbtNamKhachHang)
                                .addGap(36, 36, 36)
                                .addComponent(rdbtNuKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdcNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 241, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addGap(18, 18, 18)
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiaChiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(jLabel94)
                            .addComponent(jLabel97)
                            .addComponent(jlbIdKhachHang)
                            .addComponent(txtDiaChiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbtNamKhachHang)
                            .addComponent(rdbtNuKhachHang))
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel92)
                                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel95)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel98)
                        .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jLabel96)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbKhachHang);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Thông tin khách hàng");

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel45.setText("Trạng Thái");

        cbbTimKiemTrangThaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemTrangThaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemTrangThaiKHActionPerformed(evt);
            }
        });

        jTimKiemTrangThaiKH.setText("...");

        jLabel47.setText("Giới Tính");

        cbbTimKiemGioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTimKiemGioiTinhKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemGioiTinhKHActionPerformed(evt);
            }
        });

        jTimKiemGioiTinhKhachHang.setText("...");

        btTimKiemTenKH.setText("Tìm kiếm tên");
        btTimKiemTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemTenKHActionPerformed(evt);
            }
        });

        cbbAllKH.setText("tất cả khách hàng");
        cbbAllKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbAllKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTimKiemTrangThaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTimKiemTrangThaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTimKiemGioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTimKiemGioiTinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btTimKiemTenKH)
                .addGap(33, 33, 33)
                .addComponent(txtTimKiemTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(cbbAllKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(cbbTimKiemTrangThaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimKiemTrangThaiKH)
                    .addComponent(jLabel47)
                    .addComponent(cbbTimKiemGioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimKiemGioiTinhKhachHang)
                    .addComponent(btTimKiemTenKH)
                    .addComponent(txtTimKiemTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbAllKH))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setText("Tìm kiếm khách hàng");

        javax.swing.GroupLayout pnlCard6Layout = new javax.swing.GroupLayout(pnlCard6);
        pnlCard6.setLayout(pnlCard6Layout);
        pnlCard6Layout.setHorizontalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard6Layout.createSequentialGroup()
                .addGroup(pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel58))
                    .addGroup(pnlCard6Layout.createSequentialGroup()
                        .addGap(506, 506, 506)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCard6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard6Layout.createSequentialGroup()
                        .addGroup(pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard6Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1672, Short.MAX_VALUE))
                            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(122, 122, 122))
                    .addGroup(pnlCard6Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlCard6Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlCard6Layout.setVerticalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(15, 15, 15)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        pnlCards.add(pnlCard6, "card7");

        pnlCard7.setBackground(new java.awt.Color(255, 255, 255));

        jpnThongKe.setBackground(new java.awt.Color(255, 255, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Doanh Thu");

        jlbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbDoanhThu.setText("...");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel11)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 0));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel104.setText("Số Hóa Đơn");

        jlbSoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbSoHoaDon.setText("...");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel104)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 0));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel105.setText("Số Hàng Hủy");

        jlbSoHangHuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbSoHangHuy.setText("...");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel105)
                .addGap(48, 48, 48))
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSoHangHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbSoHangHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        buttonGroup6.add(rdbtTatCaDoanhThuThongKe);
        rdbtTatCaDoanhThuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbtTatCaDoanhThuThongKe.setSelected(true);
        rdbtTatCaDoanhThuThongKe.setText("Tất cả");
        rdbtTatCaDoanhThuThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtTatCaDoanhThuThongKeActionPerformed(evt);
            }
        });

        buttonGroup6.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("Theo tháng");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tbDoanhThuThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tbDoanhThuThongKe);

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbbDanhMucHangHoaThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDanhMucHangHoaThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucHangHoaThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbDanhMucHangHoaThongKe, 0, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbDanhMucHangHoaThongKe)
                .addContainerGap())
        );

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel108.setText("Danh Mục");

        jButton10.setText("Tất cả hóa đơn");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108)
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel108)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Hàng Hóa", jPanel36);

        tbHangHoaHuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(tbHangHoaHuy);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Hàng Hóa Hủy", jPanel37);

        jLabel60.setText("Ngày bắt đầu");

        jLabel110.setText("Ngày kết thúc");

        btTimKiemNgayThongKe.setText("Tìm");
        btTimKiemNgayThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemNgayThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard7Layout = new javax.swing.GroupLayout(pnlCard7);
        pnlCard7.setLayout(pnlCard7Layout);
        pnlCard7Layout.setHorizontalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtTatCaDoanhThuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCard7Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(86, 86, 86)
                        .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayKetThucTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtNgaybatDauTaoHoaDon))))
                .addGap(67, 67, 67)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemNgayThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 525, Short.MAX_VALUE))
        );
        pnlCard7Layout.setVerticalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbtTatCaDoanhThuThongKe)
                        .addComponent(jRadioButton2)
                        .addComponent(jLabel60)
                        .addComponent(txtNgaybatDauTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btTimKiemNgayThongKe, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(txtNgayKetThucTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard7, "card8");

        jSplitPane1.setRightComponent(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBanHangActionPerformed
        cardLayout.show(pnlCards, "card9");
    }//GEN-LAST:event_btBanHangActionPerformed

    private void btSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSanPhamActionPerformed
        cardLayout.show(pnlCards, "card3");
    }//GEN-LAST:event_btSanPhamActionPerformed

    private void btHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHoaDonActionPerformed
        cardLayout.show(pnlCards, "card4");
    }//GEN-LAST:event_btHoaDonActionPerformed

    private void btKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhuyenMaiActionPerformed
        cardLayout.show(pnlCards, "card5");
    }//GEN-LAST:event_btKhuyenMaiActionPerformed

    private void btNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhanVienActionPerformed
        cardLayout.show(pnlCards, "card6");
    }//GEN-LAST:event_btNhanVienActionPerformed

    private void btKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangActionPerformed
        cardLayout.show(pnlCards, "card7");
    }//GEN-LAST:event_btKhachHangActionPerformed

    private void btThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThongKeActionPerformed
        cardLayout.show(pnlCards, "card8");
    }//GEN-LAST:event_btThongKeActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btThoatActionPerformed

    private void btAnhDaiDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnhDaiDienActionPerformed
        FrmThongTinCaNhan ttcn = new FrmThongTinCaNhan();
        ttcn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAnhDaiDienActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        cardLayout.show(pnlCards, "card14");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void rdoDaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaThanhToanMouseClicked
        if (rdoDaThanhToan.isSelected() == true) {
            int trangThai = 1;
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }//GEN-LAST:event_rdoDaThanhToanMouseClicked

    private void rdoChoThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChoThanhToanMouseClicked
        if (rdoChoThanhToan.isSelected() == true) {
            int trangThai = 0;
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);

            btnThanhToan.setEnabled(true);
            btnHuyHoaDon.setEnabled(true);
            txtMaHD.setEnabled(true);
            txtMaNV.setEnabled(true);
            txtNgayTao.setEnabled(true);
            txtTienKhachDua.setEnabled(true);
            txtMaNV.setEnabled(true);
            txtSDT.setEnabled(true);
            txtTenKH.setEnabled(true);
            txtMaHDGiaoHang.setEnabled(true);
            txtMaNVGiaoHang.setEnabled(true);
            txtNgayTaoGiaoHang.setEnabled(true);
            txtTienKhachDuaGiaoHang.setEnabled(true);
            txtMaNVGiaoHang.setEnabled(true);
            txtSDTGiaoHang.setEnabled(true);
            txtTenKHGiaoHang.setEnabled(true);
            txtDiaChi.setEnabled(true);
            txtDiaChi.setEnabled(true);
            txtDiaChiGiaoHang.setEnabled(true);
            txtTienShip.setEnabled(true);
        }
    }//GEN-LAST:event_rdoChoThanhToanMouseClicked

    private void rdoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatCaMouseClicked
        if (rdoTatCa.isSelected() == true) {
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAll();
            showDataTableHD(listHD);
        }
    }//GEN-LAST:event_rdoTatCaMouseClicked

    private void rdoDaHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaHuyMouseClicked
        if (rdoDaHuy.isSelected() == true) {
            int trangThai = 2;
            TBHoaDon.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }//GEN-LAST:event_rdoDaHuyMouseClicked

    private void btAllSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllSanPhamActionPerformed
        lstQLSp = spsi.getAll();
        showTableSanPham(lstQLSp);
    }//GEN-LAST:event_btAllSanPhamActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        QuanLySanPham qlsp = getSanPham();
        if (txtMaSanPham.getText().isEmpty() || txtTenSanPham.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không được để trống !");
        } else {

            String add = spsi.add(qlsp);
            JOptionPane.showMessageDialog(this, add);
            lstQLSp = spsi.getAll();
            showTableSanPham(lstQLSp);
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        QuanLySanPham qlsp = getSanPham();
        String id = jlbId.getText();
        String update = spsi.update(qlsp, id);
        JOptionPane.showMessageDialog(this, update);
        lstQLSp = spsi.getAll();
        showTableSanPham(lstQLSp);
    }//GEN-LAST:event_btSuaActionPerformed

    private void tbQlSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQlSanPhamMouseClicked
        int row = tbQlSanPham.getSelectedRow();
        fillTableSanPham(row);
    }//GEN-LAST:event_tbQlSanPhamMouseClicked

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String id = jlbId.getText();
        String delete = spsi.delete(id);
        JOptionPane.showMessageDialog(this, delete);
        lstQLSp = spsi.getAll();
        showTableSanPham(lstQLSp);
    }//GEN-LAST:event_btXoaActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        jlbId.setText("");
        txtTenSanPham.setText("");
        txtMaSanPham.setText("");
        cbbTrangThaiSp.setSelectedIndex(0);
    }//GEN-LAST:event_btLamMoiActionPerformed

    private void btTimKiemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemSpActionPerformed
        if (txtTimKiemSp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "mời nhập tên !");
        } else {

            String ten = txtTimKiemSp.getText();
            lstQLSp = spsi.getTenSp(ten);
            showTableSanPham(lstQLSp);
        }
    }//GEN-LAST:event_btTimKiemSpActionPerformed

    private void rdbtKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtKichCoActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstKichCo = kcsi.getAll();
        showtableKichCo(lstKichCo);
    }//GEN-LAST:event_rdbtKichCoActionPerformed
    private void showtableKichCo(List<QuanLyKichco> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyKichco ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }
    private void rdbtChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtChatLieuActionPerformed
        txtTenThuocTinh.setEnabled(false);
        txtDaChinh.setEnabled(true);
        txtDaPhu.setEnabled(true);
        txtDeNgoai.setEnabled(true);
        txtLopLotTrong.setEnabled(true);

        tbThuocTinh.setModel(dtmThuocTinh);
        String[] chatLieu = {"Id", "Mã", "Da chính", "Da phụ", "Đế ngoài", "Lớp lót trong", "Trạng thái"};
        dtmThuocTinh.setColumnIdentifiers(chatLieu);

        lstChatLieu = cls.getAll();
        showTableChatLieu(lstChatLieu);
    }//GEN-LAST:event_rdbtChatLieuActionPerformed
    private void showTableChatLieu(List<QuanLyChatLieu> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyChatLieu ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }


    private void rdbtDongSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtDongSanPhamActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstDongSanPham = dspi.getAll();
        showtableDongSanPham(lstDongSanPham);
    }//GEN-LAST:event_rdbtDongSanPhamActionPerformed
    private void showtableDongSanPham(List<QuanLyDongSanPham> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyDongSanPham ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }
    private void rdbtKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtKieuDangActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstKieuDang = kdi.getAll();
        showtableKieuDang(lstKieuDang);
    }//GEN-LAST:event_rdbtKieuDangActionPerformed
    private void showtableKieuDang(List<QuanLyKieuDang> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyKieuDang ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }
    private void rdbtThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtThuongHieuActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstThuongHieu = thsi.getAll();
        showtableThuongHieu(lstThuongHieu);
    }//GEN-LAST:event_rdbtThuongHieuActionPerformed
    private void showtableThuongHieu(List<QuanLyThuongHieu> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyThuongHieu ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }
    private void rdbtNhaSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtNhaSanXuatActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstNhaSanXuat = nsxi.getAll();
        showTableNhaSanXuat(lstNhaSanXuat);
    }//GEN-LAST:event_rdbtNhaSanXuatActionPerformed
    private void showTableNhaSanXuat(List<QuanLyNhaSanXuat> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyNhaSanXuat ql : lst) {
            dtmThuocTinh.addRow(ql.todata());
        }
    }
    private void rdbtMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtMauSacActionPerformed
        txtDaChinh.setEnabled(false);
        txtDaPhu.setEnabled(false);
        txtDeNgoai.setEnabled(false);
        txtLopLotTrong.setEnabled(false);
        txtTenThuocTinh.setEnabled(true);
        tbThuocTinh.setModel(dtmThuocTinh);
        String[] ms = {"Id", "Mã", "Tên", "Trang thái"};
        dtmThuocTinh.setColumnIdentifiers(ms);

        lstMauSac = msi.getAll();
        showTableMauSac(lstMauSac);

    }//GEN-LAST:event_rdbtMauSacActionPerformed

    private void btThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemThuocTinhActionPerformed
        if (rdbtDongSanPham.isSelected() == true) {
            QuanLyDongSanPham ql = getDongSanPham();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addDongSp = dspi.add(ql);
                JOptionPane.showMessageDialog(this, addDongSp);
                lstDongSanPham = dspi.getAll();
                showtableDongSanPham(lstDongSanPham);
            }

        } else if (rdbtKichCo.isSelected() == true) {

            QuanLyKichco qlKichCo = getKichCo();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {

                String addKichCo = kcsi.add(qlKichCo);
                JOptionPane.showMessageDialog(this, addKichCo);
                lstKichCo = kcsi.getAll();
                showtableKichCo(lstKichCo);
            }
        } else if (rdbtKieuDang.isSelected() == true) {
            QuanLyKieuDang qlKieuDang = getKieuDang();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addKieuDang = kdi.add(qlKieuDang);
                JOptionPane.showMessageDialog(this, addKieuDang);
                lstKieuDang = kdi.getAll();
                showtableKieuDang(lstKieuDang);
            }
        } else if (rdbtThuongHieu.isSelected() == true) {
            QuanLyThuongHieu qlThuongHieu = getThuongHieu();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addThuongHieu = thsi.add(qlThuongHieu);
                JOptionPane.showMessageDialog(this, addThuongHieu);
                lstThuongHieu = thsi.getAll();
                showtableThuongHieu(lstThuongHieu);
            }
        } else if (rdbtNhaSanXuat.isSelected() == true) {
            QuanLyNhaSanXuat qlNhaSanXuat = getNhaSanXuat();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addNhaSanXuat = nsxi.add(qlNhaSanXuat);
                JOptionPane.showMessageDialog(this, addNhaSanXuat);
                lstNhaSanXuat = nsxi.getAll();
                showTableNhaSanXuat(lstNhaSanXuat);
            }
        } else if (rdbtMauSac.isSelected() == true) {
            QuanLyMauSac qlMauSac = getMauSac();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addMauSac = msi.add(qlMauSac);
                JOptionPane.showMessageDialog(this, addMauSac);
                lstMauSac = msi.getAll();
                showTableMauSac(lstMauSac);
            }
        } else if (rdbtChatLieu.isSelected() == true) {
            QuanLyChatLieu qlChatLieu = getChatLieu();
            if (txtMaThuocTinh.getText().isEmpty() || txtTenThuocTinh.getText().isEmpty() || txtDaChinh.getText().isEmpty() || txtDaPhu.getText().isEmpty() || txtLopLotTrong.getText().isEmpty() || txtDeNgoai.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else {
                String addChatLieu = cls.add(qlChatLieu);
                JOptionPane.showMessageDialog(this, addChatLieu);
                lstChatLieu = cls.getAll();
                showTableChatLieu(lstChatLieu);
            }
        }
    }//GEN-LAST:event_btThemThuocTinhActionPerformed
    private void fillDongSp(int row) {
        QuanLyDongSanPham qlDongSp = lstDongSanPham.get(row);
        txtJd.setText(qlDongSp.getId());
        txtMaThuocTinh.setText(qlDongSp.getMa());
        txtTenThuocTinh.setText(qlDongSp.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlDongSp.getTrangThai());
    }

    private void fillKichCo(int row) {
        QuanLyKichco qlk = lstKichCo.get(row);
        txtJd.setText(qlk.getId());
        txtMaThuocTinh.setText(qlk.getMa());
        txtTenThuocTinh.setText(qlk.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlk.getTrangThai());
    }

    private void fillKieuDang(int row) {
        QuanLyKieuDang qlkd = lstKieuDang.get(row);
        txtJd.setText(qlkd.getId());
        txtMaThuocTinh.setText(qlkd.getMa());
        txtTenThuocTinh.setText(qlkd.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlkd.getTrangThai());
    }

    private void fillThuongHieu(int row) {
        QuanLyThuongHieu qlth = lstThuongHieu.get(row);
        txtJd.setText(qlth.getId());
        txtMaThuocTinh.setText(qlth.getMa());
        txtTenThuocTinh.setText(qlth.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlth.getTrangThai());
    }

    private void fillNhaSX(int row) {
        QuanLyNhaSanXuat qlnsx = lstNhaSanXuat.get(row);
        txtJd.setText(qlnsx.getId());
        txtMaThuocTinh.setText(qlnsx.getMa());
        txtTenThuocTinh.setText(qlnsx.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlnsx.getTrangThai());
    }

    private void fillMauSac(int row) {
        QuanLyMauSac qlms = lstMauSac.get(row);
        txtJd.setText(qlms.getId());
        txtMaThuocTinh.setText(qlms.getMa());
        txtTenThuocTinh.setText(qlms.getTen());
        cbbThuocTinhSanPham.setSelectedIndex(qlms.getTrangThai());
    }

    private void fillChatLieu(int row) {
        QuanLyChatLieu qlcl = lstChatLieu.get(row);
        txtJd.setText(qlcl.getId());
        txtMaThuocTinh.setText(qlcl.getMa());
        cbbThuocTinhSanPham.setSelectedIndex(qlcl.getTrangThai());
        txtDaChinh.setText(qlcl.getDaChinh());
        txtDaPhu.setText(qlcl.getDaPhu());
        txtDeNgoai.setText(qlcl.getDeNgoai());
        txtLopLotTrong.setText(qlcl.getLopLotTrong());
    }
    private void tbThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThuocTinhMouseClicked
        int row = tbThuocTinh.getSelectedRow();
        if (rdbtDongSanPham.isSelected() == true) {
            fillDongSp(row);
        } else if (rdbtKichCo.isSelected() == true) {
            fillKichCo(row);
        } else if (rdbtKieuDang.isSelected() == true) {
            fillKieuDang(row);
        } else if (rdbtThuongHieu.isSelected() == true) {
            fillThuongHieu(row);
        } else if (rdbtNhaSanXuat.isSelected() == true) {
            fillNhaSX(row);
        } else if (rdbtMauSac.isSelected() == true) {
            fillMauSac(row);
        } else if (rdbtChatLieu.isSelected() == true) {
            fillChatLieu(row);
        }
    }//GEN-LAST:event_tbThuocTinhMouseClicked

    private void btLamMoiThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiThuocTinhActionPerformed
        txtJd.setText("");
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        cbbThuocTinhSanPham.setSelectedIndex(0);
        txtDaChinh.setText("");
        txtDaPhu.setText("");
        txtDeNgoai.setText("");
        txtLopLotTrong.setText("");
    }//GEN-LAST:event_btLamMoiThuocTinhActionPerformed

    private void btXoaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaThuocTinhActionPerformed
        if (rdbtDongSanPham.isSelected() == true) {
            String idDongSp = txtJd.getText();
            String addDongSp = dspi.delete(idDongSp);
            JOptionPane.showMessageDialog(this, addDongSp);
            lstDongSanPham = dspi.getAll();
            showtableDongSanPham(lstDongSanPham);
        } else if (rdbtKichCo.isSelected() == true) {
            String idKichCo = txtJd.getText();
            String addKichCo = kcsi.delete(idKichCo);
            JOptionPane.showMessageDialog(this, addKichCo);
            lstKichCo = kcsi.getAll();
            showtableKichCo(lstKichCo);
        } else if (rdbtKieuDang.isSelected() == true) {
            String idKieuDang = txtJd.getText();
            String addKieuDang = kdi.delete(idKieuDang);
            JOptionPane.showMessageDialog(this, addKieuDang);
            lstKieuDang = kdi.getAll();
            showtableKieuDang(lstKieuDang);
        } else if (rdbtThuongHieu.isSelected() == true) {
            String idThuongHieu = txtJd.getText();
            String addThuongHieu = thsi.delete(idThuongHieu);
            JOptionPane.showMessageDialog(this, addThuongHieu);
            lstThuongHieu = thsi.getAll();
            showtableThuongHieu(lstThuongHieu);
        } else if (rdbtNhaSanXuat.isSelected() == true) {
            String idNSX = txtJd.getText();
            String addNhaSanXuat = nsxi.delete(idNSX);
            JOptionPane.showMessageDialog(this, addNhaSanXuat);
            lstNhaSanXuat = nsxi.getAll();
            showTableNhaSanXuat(lstNhaSanXuat);
        } else if (rdbtMauSac.isSelected() == true) {
            String idMauSac = txtJd.getText();
            String addMauSac = msi.delete(idMauSac);
            JOptionPane.showMessageDialog(this, addMauSac);
            lstMauSac = msi.getAll();
            showTableMauSac(lstMauSac);
        } else if (rdbtChatLieu.isSelected() == true) {
            String idChatLieu = txtJd.getText();
            String addChatLieu = cls.delete(idChatLieu);
            JOptionPane.showMessageDialog(this, addChatLieu);
            lstChatLieu = cls.getAll();
            showTableChatLieu(lstChatLieu);
        }
    }//GEN-LAST:event_btXoaThuocTinhActionPerformed

    private void btSuaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaThuocTinhActionPerformed
        if (rdbtDongSanPham.isSelected() == true) {
            QuanLyDongSanPham qldsp = getDongSanPham();
            String idDongSp = txtJd.getText();
            String addDongSp = dspi.update(qldsp, idDongSp);
            JOptionPane.showMessageDialog(this, addDongSp);
            lstDongSanPham = dspi.getAll();
            showtableDongSanPham(lstDongSanPham);
        } else if (rdbtKichCo.isSelected() == true) {
            QuanLyKichco qlk = getKichCo();
            String idKichCo = txtJd.getText();
            String addKichCo = kcsi.update(qlk, idKichCo);
            JOptionPane.showMessageDialog(this, addKichCo);
            lstKichCo = kcsi.getAll();
            showtableKichCo(lstKichCo);
        } else if (rdbtKieuDang.isSelected() == true) {
            QuanLyKieuDang qlkd = getKieuDang();
            String idKieuDang = txtJd.getText();
            String addKieuDang = kdi.update(qlkd, idKieuDang);
            JOptionPane.showMessageDialog(this, addKieuDang);
            lstKieuDang = kdi.getAll();
            showtableKieuDang(lstKieuDang);
        } else if (rdbtThuongHieu.isSelected() == true) {
            QuanLyThuongHieu qlth = getThuongHieu();
            String idThuongHieu = txtJd.getText();
            String addThuongHieu = thsi.update(qlth, idThuongHieu);
            JOptionPane.showMessageDialog(this, addThuongHieu);
            lstThuongHieu = thsi.getAll();
            showtableThuongHieu(lstThuongHieu);
        } else if (rdbtNhaSanXuat.isSelected() == true) {
            QuanLyNhaSanXuat qlnsx = getNhaSanXuat();
            String idNSX = txtJd.getText();
            String addNhaSanXuat = nsxi.update(qlnsx, idNSX);
            JOptionPane.showMessageDialog(this, addNhaSanXuat);
            lstNhaSanXuat = nsxi.getAll();
            showTableNhaSanXuat(lstNhaSanXuat);
        } else if (rdbtMauSac.isSelected() == true) {
            QuanLyMauSac qlms = getMauSac();
            String idMauSac = txtJd.getText();
            String addMauSac = msi.update(qlms, idMauSac);
            JOptionPane.showMessageDialog(this, addMauSac);
            lstMauSac = msi.getAll();
            showTableMauSac(lstMauSac);
        } else if (rdbtChatLieu.isSelected() == true) {
            QuanLyChatLieu qlcl = getChatLieu();
            String idChatLieu = txtJd.getText();
            String addChatLieu = cls.update(qlcl, idChatLieu);
            JOptionPane.showMessageDialog(this, addChatLieu);
            lstChatLieu = cls.getAll();
            showTableChatLieu(lstChatLieu);
        }
    }//GEN-LAST:event_btSuaThuocTinhActionPerformed

    private void cbbKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKichCoActionPerformed
        String thSelected = (String) cbbThuongHieu.getSelectedItem();
        String kcSelected = (String) cbbKichCo.getSelectedItem();
        String dspSelected = (String) cbbDongSP.getSelectedItem();
        listDssp = danhSAchSanPhamService.getAllByTheLoai(thSelected, kcSelected, dspSelected);
        showDataTableDSSP(listDssp);
    }//GEN-LAST:event_cbbKichCoActionPerformed

    private void cbbDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDongSPActionPerformed
        String thSelected = (String) cbbThuongHieu.getSelectedItem();
        String kcSelected = (String) cbbKichCo.getSelectedItem();
        String dspSelected = (String) cbbDongSP.getSelectedItem();
        listDssp = danhSAchSanPhamService.getAllByTheLoai(thSelected, kcSelected, dspSelected);
        showDataTableDSSP(listDssp);
    }//GEN-LAST:event_cbbDongSPActionPerformed

    private void cbbThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThuongHieuActionPerformed
        String thSelected = (String) cbbThuongHieu.getSelectedItem();
        String kcSelected = (String) cbbKichCo.getSelectedItem();
        String dspSelected = (String) cbbDongSP.getSelectedItem();
        listDssp = danhSAchSanPhamService.getAllByTheLoai(thSelected, kcSelected, dspSelected);
        showDataTableDSSP(listDssp);
    }//GEN-LAST:event_cbbThuongHieuActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        listDssp = danhSAchSanPhamService.getAll();
        showDataTableDSSP(listDssp);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jlbAnhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbAnhNhanVienMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("D:\\java\\DuAn1-main-git\\da1-quanLyBanGiayTheThaoNam-Lan2\\src\\image");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strHinhAnh = file.getName();
            jlbAnhNhanVien.setText("");
            int with = jlbAnhNhanVien.getWidth();
            int height = jlbAnhNhanVien.getHeight();
            jlbAnhNhanVien.setIcon(new ImageIcon(img.getScaledInstance(with, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }//GEN-LAST:event_jlbAnhNhanVienMouseClicked

    private void btThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanVienActionPerformed
        QuanLyNhanVien qlnv = getNhanVien();
        if (txtMaNhanVien.getText().isEmpty() || txtTenNhanVien.getText().isEmpty() || txtDiaChiNhanVien.getText().isEmpty() || txtSoDienThoaiNhanVien.getText().isEmpty() || txtTenTk.getText().isEmpty() || jpfMatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không được để trống !");
        } else if (!txtTenNhanVien.getText().matches("[a-z A-Z]+") == false) {
            JOptionPane.showMessageDialog(this, "tên không đúng định dạng !");
        } else if (txtSoDienThoaiNhanVien.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$") == false) {
            JOptionPane.showMessageDialog(this, " số điện thoại sai định dạng !");
        } else {
            String add = nvs.add(qlnv);
            JOptionPane.showMessageDialog(this, add);
            lstQlNhanVien = nvs.getAll();
            showTableNhanVien(lstQlNhanVien);
        }
    }//GEN-LAST:event_btThemNhanVienActionPerformed

    private void tbQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQuanLyNhanVienMouseClicked
        int row = tbQuanLyNhanVien.getSelectedRow();
        fillDataNhanVien(row);
    }//GEN-LAST:event_tbQuanLyNhanVienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        QuanLyNhanVien qlnv = getNhanVien();
        String id = jlbIdNhanVien.getText();
        String add = nvs.update(qlnv, id);
        JOptionPane.showMessageDialog(this, add);
        lstQlNhanVien = nvs.getAll();
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String id = jlbIdNhanVien.getText();
        String delete = nvs.delete(id);
        JOptionPane.showMessageDialog(this, delete);
        lstQlNhanVien = nvs.getAll();
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jlbIdNhanVien.setText("");
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        jdcNgaySinhNhanVien.setDate(null);
        txtDiaChiNhanVien.setText("");
        txtSoDienThoaiNhanVien.setText("");
        cbbChucVuNhanVien.setSelectedIndex(0);
        cbbTrangThaiNhanVien.setSelectedIndex(0);
        buttonGroup3.clearSelection();
        txtTenTk.setText("");
        jpfMatKhau.setText("");
        jlbAnhNhanVien.setIcon(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietSanPhamMouseClicked
        int row = tbChiTietSanPham.getSelectedRow();
        fillCtSp(row);
    }//GEN-LAST:event_tbChiTietSanPhamMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        QuanLyChiTietSanPham qlChiTietSp = getQlChiTietSp();
        String moTa = jtpCtspMoTa.getText();
        String soLuongTon = txtCtspSoLuongTon.getText();
        String giaNhap = txtCtspGiaNhap.getText();
        String giaBan = txtCtspGiaBan.getText();
        String namBh = txtCtspNamBh.getText();
        String hinhAnh = strHinhAnhChiTietSanPham;
        int indexDongSp = cbbCtspDongSanPham.getSelectedIndex();
        QuanLyDongSanPham dongSp = lstDongSanPham.get(indexDongSp);
        int indexNhaSanXuat = cbbCtspNhaSanXuat.getSelectedIndex();
        QuanLyNhaSanXuat nsx = lstNhaSanXuat.get(indexNhaSanXuat);
        int indexKieuDang = cbbCtspKieuDang.getSelectedIndex();
        QuanLyKieuDang kd = lstKieuDang.get(indexKieuDang);
//        qlChiTietSp.setIdKichCo(String.valueOf(cbbCtspKichCo.getSelectedItem()));
        int indexKichCo = cbbCtspKichCo.getSelectedIndex();
        QuanLyKichco kc = lstKichCo.get(indexKichCo);
//        qlChiTietSp.setIdChatLieu(String.valueOf(cbbCtspChatLieu.getSelectedItem()));
        int indexChatLieu = cbbCtspChatLieu.getSelectedIndex();
        QuanLyChatLieu cl = lstChatLieu.get(indexChatLieu);
//        qlChiTietSp.setIdMauSac(String.valueOf(cbbCtspMauSac.getSelectedItem()));
        int indexMauSac = cbbCtspMauSac.getSelectedIndex();
        QuanLyMauSac ms = lstMauSac.get(indexMauSac);
//        qlChiTietSp.setIdSanPham(String.valueOf(cbbCtspSanPham.getSelectedItem()));
        int indexSanPham = cbbCtspSanPham.getSelectedIndex();
        QuanLySanPham sp = lstQLSp.get(indexSanPham);
//        qlChiTietSp.setIdThuongHieu(String.valueOf(cbbCtspThuongHieu.getSelectedItem()));
        int indexThuongHieu = cbbCtspThuongHieu.getSelectedIndex();
        QuanLyThuongHieu th = lstThuongHieu.get(indexThuongHieu);
        if (txtCtspGiaBan.getText().isEmpty() || txtCtspGiaNhap.getText().isEmpty() || txtCtspNamBh.getText().isEmpty() || txtCtspSoLuongTon.getText().isEmpty() || jtpCtspMoTa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không được để trống !");
        } else if (giaBan.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số nguyên dương  !");
        } else if (Double.parseDouble(giaBan) <= 0) {
            JOptionPane.showMessageDialog(this, "giá bán phải là số nguyên dương  !");
        } else if (giaNhap.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "giá nhập  phải là số nguyên dương !");
        } else if (Double.parseDouble(giaNhap) <= 0) {
            JOptionPane.showMessageDialog(this, "giá nhập phải là số nguyên dương !");
        } else if (soLuongTon.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "số lượng tồn phải là số nguyên dương !");
        } else if (Double.parseDouble(giaNhap) <= 0) {
            JOptionPane.showMessageDialog(this, "số lượng tồn phải là số nguyên dương !");
        } else if (namBh.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "năm bảo hành phải là số nguyên dương !");
        } else if (Integer.parseInt(namBh) <= 0) {
            JOptionPane.showMessageDialog(this, "năm bảo hành phải là số nguyên dương !");
        } else {
            QuanLyChiTietSanPham qlChiTietSp = new QuanLyChiTietSanPham(null, moTa, Integer.valueOf(soLuongTon), Double.valueOf(giaNhap), Double.valueOf(giaBan), Integer.valueOf(namBh), hinhAnh, null, dongSp.getId(), nsx.getId(), kd.getId(), kc.getId(), cl.getId(), ms.getId(), sp.getId(), th.getId(), null);
            String add = ctspI.add(qlChiTietSp);
            JOptionPane.showMessageDialog(this, add);
            lstCtSp = ctspI.getAll();
            showTableChiTietSp(lstCtSp);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jlbCtspHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCtspHinhAnhMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("D:\\java\\DuAn1-main-git\\da1-quanLyBanGiayTheThaoNam-Lan2\\src\\image");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strHinhAnhChiTietSanPham = file.getName();
            jlbCtspHinhAnh.setText("");
            int with = jlbCtspHinhAnh.getWidth();
            int height = jlbCtspHinhAnh.getHeight();
            jlbCtspHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(with, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }//GEN-LAST:event_jlbCtspHinhAnhMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        QuanLyChiTietSanPham qlChiTietSp = getQlChiTietSp();
        String id = jlbCtspId.getText();
        String update = ctspI.update(qlChiTietSp, id);
        JOptionPane.showMessageDialog(this, update);
        lstCtSp = ctspI.getAll();
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String id = jlbCtspId.getText();
        String delete = ctspI.delete(id);
        JOptionPane.showMessageDialog(this, delete);
        lstCtSp = ctspI.getAll();
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int row = tbKhachHang.getSelectedRow();
        fillKhachHang(row);
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemKhachHangActionPerformed
        int them = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm ?", "thên", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (them == JOptionPane.YES_OPTION) {
//            QuanLyKhachHang qlkh = getKhachHang();

            String ma = txtMaKhachHang.getText();
            String ten = txtTenKhachHang.getText();
            Date ngaySinh = jdcNgaySinhKhachHang.getDate();
            boolean gioiTinh = rdbtNamKhachHang.isSelected();
            int gender;
            if (gioiTinh == true) {
                gender = 0;
            } else {
                gender = 1;
            }
            String sdt = txtSoDienThoaiKhachHang.getText();
            String diaChi = txtDiaChiKhachHang.getText();
            int trangThai = cbbKhachHang.getSelectedIndex();

            if (txtMaKhachHang.getText().isEmpty() || txtTenKhachHang.getText().isEmpty() || txtDiaChiKhachHang.getText().isEmpty() || txtSoDienThoaiKhachHang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "không được để trống !");
            } else if (txtTenKhachHang.getText().matches("[a-z A-Z]+") == false) {
                JOptionPane.showMessageDialog(this, "tên không đúng định dạng !");
            } else if (txtSoDienThoaiKhachHang.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$") == false) {
                JOptionPane.showMessageDialog(this, " số điện thoại sai định dạng !");
            } else {
                QuanLyKhachHang qlkh = new QuanLyKhachHang("", ma, ten, gender, ngaySinh, sdt, diaChi, trangThai);
                String add = khs.add(qlkh);
                JOptionPane.showMessageDialog(this, add);
                lstKh = khs.getAll();
                showTableKhachHang(lstKh);
            }
        } else if (them == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thêm");
        }
    }//GEN-LAST:event_btThemKhachHangActionPerformed

    private void btSuaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaKhachHangActionPerformed
        int sua = JOptionPane.showConfirmDialog(this, "Bạn có muốn Sửa ?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (sua == JOptionPane.YES_OPTION) {
            QuanLyKhachHang qlkh = getKhachHang();
            String id = jlbIdKhachHang.getText();
            String update = khs.update(qlkh, id);
            JOptionPane.showMessageDialog(this, update);
            lstKh = khs.getAll();
            showTableKhachHang(lstKh);
        } else if (sua == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy sửa");
        }
    }//GEN-LAST:event_btSuaKhachHangActionPerformed

    private void btXoaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaKhachHangActionPerformed
        int xoa = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa ?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (xoa == JOptionPane.YES_OPTION) {
            String id = jlbIdKhachHang.getText();
            String delete = khs.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            lstKh = khs.getAll();
            showTableKhachHang(lstKh);
        } else if (xoa == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy xóa");
        }
    }//GEN-LAST:event_btXoaKhachHangActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jlbIdKhachHang.setText("");
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        buttonGroup5.clearSelection();
        jdcNgaySinhKhachHang.setDate(null);
        txtSoDienThoaiKhachHang.setText("");
        txtDiaChiKhachHang.setText("");
        cbbKhachHang.setSelectedIndex(0);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cbbCtspSanPham.setSelectedIndex(0);
        cbbCtspKichCo.setSelectedIndex(0);
        txtCtspNamBh.setText("");
        txtCtspGiaNhap.setText("");
        txtCtspGiaBan.setText("");
        jlbCtspId.setText("");
        cbbCtspThuongHieu.setSelectedIndex(0);
        cbbCtspMauSac.setSelectedIndex(0);
        txtCtspSoLuongTon.setText("");
        cbbCtspDongSanPham.setSelectedIndex(0);
        cbbCtspChatLieu.setSelectedIndex(0);
        cbbCtspKieuDang.setSelectedIndex(0);
        cbbCtspNhaSanXuat.setSelectedIndex(0);
        jtpCtspMoTa.setText("");
        jlbCtspHinhAnh.setIcon(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cbbChucVuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVuNhanVienActionPerformed
        int chucVuNhanVien = cbbChucVuNhanVien.getSelectedIndex();
        if (chucVuNhanVien == 0) {
            jlbChucVuNhanVien.setText("Quản Lý");
        } else {
            jlbChucVuNhanVien.setText("Nhân Viên");
        }
    }//GEN-LAST:event_cbbChucVuNhanVienActionPerformed

    private void cbbTrangThaiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiNhanVienActionPerformed
        int trangThaiNv = cbbTrangThaiNhanVien.getSelectedIndex();
        if (trangThaiNv == 0) {
            jlbTrangThaiNhanVIen.setText("Đã nghi");
        } else {
            jlbTrangThaiNhanVIen.setText("Đang hoạt động");
        }
    }//GEN-LAST:event_cbbTrangThaiNhanVienActionPerformed

    private void btThemNhanhNhaSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhNhaSanXuatActionPerformed
        FrmThemNhanhNhaSanXuat tmNsx = new FrmThemNhanhNhaSanXuat();
        tmNsx.setVisible(true);
    }//GEN-LAST:event_btThemNhanhNhaSanXuatActionPerformed

    private void cbbCtspNhaSanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspNhaSanXuatMouseClicked
        int itemcount = cbbCtspNhaSanXuat.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspNhaSanXuat.removeItemAt(0);
        }

        lstNhaSanXuat = nsxi.getAll();
        showComBoxCtspNsx(lstNhaSanXuat);
    }//GEN-LAST:event_cbbCtspNhaSanXuatMouseClicked

    private void btThemNhanhKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhKieuDangActionPerformed
        FrmThemNhanhKieuDang tmKd = new FrmThemNhanhKieuDang();
        tmKd.setVisible(true);
    }//GEN-LAST:event_btThemNhanhKieuDangActionPerformed

    private void cbbCtspKieuDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspKieuDangMouseClicked
        int itemcount = cbbCtspKieuDang.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspKieuDang.removeItemAt(0);
        }

        lstKieuDang = kdi.getAll();
        showComBoxCtspKieuDang(lstKieuDang);
    }//GEN-LAST:event_cbbCtspKieuDangMouseClicked

    private void cbbCtspChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspChatLieuMouseClicked
        int itemcount = cbbCtspChatLieu.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspChatLieu.removeItemAt(0);
        }
        lstChatLieu = cls.getAll();
        showComBoxCtspChatLieu(lstChatLieu);
    }//GEN-LAST:event_cbbCtspChatLieuMouseClicked

    private void btThemNhanhChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhChatLieuActionPerformed
        FrmThemNhanhChatLieu cl = new FrmThemNhanhChatLieu();
        cl.setVisible(true);
    }//GEN-LAST:event_btThemNhanhChatLieuActionPerformed

    private void btThemNhanhDongSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhDongSpActionPerformed
        FrmThemNhanhDongSp FtmDsp = new FrmThemNhanhDongSp();
        FtmDsp.setVisible(true);
    }//GEN-LAST:event_btThemNhanhDongSpActionPerformed

    private void cbbCtspDongSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspDongSanPhamMouseClicked
        int itemcount = cbbCtspDongSanPham.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspDongSanPham.removeItemAt(0);
        }

        lstDongSanPham = dspi.getAll();
        showComBoxCtspDongSp(lstDongSanPham);
    }//GEN-LAST:event_cbbCtspDongSanPhamMouseClicked

    private void btThemNhanhMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhMauSacActionPerformed
        FrmThemNhanhMauSac ms = new FrmThemNhanhMauSac();
        ms.setVisible(true);
    }//GEN-LAST:event_btThemNhanhMauSacActionPerformed

    private void cbbCtspMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspMauSacMouseClicked
        int itemcount = cbbCtspMauSac.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspMauSac.removeItemAt(0);
        }

        lstMauSac = msi.getAll();
        showComBoxCtspMauSac(lstMauSac);
    }//GEN-LAST:event_cbbCtspMauSacMouseClicked

    private void btThemNhanhThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhThuongHieuActionPerformed
        FrmThemNhanhThuongHieu th = new FrmThemNhanhThuongHieu();
        th.setVisible(true);
    }//GEN-LAST:event_btThemNhanhThuongHieuActionPerformed

    private void cbbCtspThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspThuongHieuMouseClicked
        int itemcount = cbbCtspThuongHieu.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspThuongHieu.removeItemAt(0);
        }

        lstThuongHieu = thsi.getAll();
        showComBoxCtspThuongHieu(lstThuongHieu);
    }//GEN-LAST:event_cbbCtspThuongHieuMouseClicked

    private void btThemNhanhKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhKichCoActionPerformed
        FrmThemNhanhKichCo kc = new FrmThemNhanhKichCo();
        kc.setVisible(true);
    }//GEN-LAST:event_btThemNhanhKichCoActionPerformed

    private void cbbCtspKichCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspKichCoMouseClicked
        int itemcount = cbbCtspKichCo.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspKichCo.removeItemAt(0);
        }

        lstKichCo = kcsi.getAll();
        showComBoxCtspKichCo(lstKichCo);
    }//GEN-LAST:event_cbbCtspKichCoMouseClicked

    private void btThemNhanhSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNhanhSanPhamActionPerformed
        FrmThemNhanhSanPham sp = new FrmThemNhanhSanPham();
        sp.setVisible(true);
    }//GEN-LAST:event_btThemNhanhSanPhamActionPerformed

    private void cbbCtspSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCtspSanPhamMouseClicked
        int itemcount = cbbCtspSanPham.getItemCount();

        for (int i = 0; i < itemcount; i++) {
            cbbCtspSanPham.removeItemAt(0);
        }

        lstQLSp = spsi.getAll();
        showComBoxCtspSanPham(lstQLSp);
    }//GEN-LAST:event_cbbCtspSanPhamMouseClicked

    private void TBHoaDonLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBHoaDonLSMouseClicked
        //        txtTienKhachDua.setText("0");
        txtTienChuyenKhoanLS.setText("0");
        txtTienKhachDuaGiaoHangLS.setText("0");
        int row = TBHoaDonLS.getSelectedRow();
        //        txtMaNV.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
        //        txtNgayTao.setText((String) TBHoaDon.getModel().getValueAt(row, 3));
        //tb Giao Hang
        //        txtMaNVGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
        //        txtNgayTaoGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 3));
        String id = (String) TBHoaDonLS.getModel().getValueAt(row, 1);
        System.out.println(id);
        // lay thong tin khach hang
        ArrayList<HoaDonResponse> listTTKH = hoaDonService.getTTKhByID(id);
        String tenKH;
        String sdt;
        String diaChi;
        String ngayThanhToan;
        for (HoaDonResponse hoaDonResponse : listTTKH) {
            tenKH = hoaDonResponse.getTenNguoiNhan();
            sdt = hoaDonResponse.getSdt();
            diaChi = hoaDonResponse.getDiaChi();
            ngayThanhToan = hoaDonResponse.getNgayThanhToan();
            txtDiaChiLS.setText(diaChi);
            txtTenKHLS.setText(tenKH);
            txtSDTLS.setText(sdt);
            //            txtDiaChiGiaoHang.setText(diaChi);
            //            txtTenKHGiaoHang.setText(tenKH);
            //            txtSDTGiaoHang.setText(sdt);
            txtNgayThanhToanLS.setText(ngayThanhToan);
        }
        ArrayList<LoaiHinhTanhToan> listLoaiHinhTT = loaiHinhThanhToanService.getTTThanhToanByID(id);
        String tenPttt;
        float tienMat;
        float tienCK;
        for (LoaiHinhTanhToan loaiHinhTanhToan : listLoaiHinhTT) {
            tenPttt = loaiHinhTanhToan.getTenPTTT();
            tienMat = loaiHinhTanhToan.getTienMat();
            tienCK = loaiHinhTanhToan.getTienChuyenKhoan();
            cbbPTTTLS.setSelectedItem(tenPttt);
            //            txtTienKhachDua.setText(Integer.valueOf((int) tienMat) + "");
            txtTienChuyenKhoanLS.setText(Integer.valueOf((int) tienCK) + "");
            txtTienKhachDuaGiaoHangLS.setText(Integer.valueOf((int) tienMat) + "");
        }

        ArrayList<HoaDonResponse> listTTKHGiaoHang = hoaDonService.getTTKhGiaoHangByID(id);
        String tenKHGH;
        String sdtGH;
        String diaChiGH;
        float tienShip;
        String ngayShip;
        String ngayNhan;
        Date ngayHenKhach;
        for (HoaDonResponse hoaDonResponseGH : listTTKHGiaoHang) {
            tenKHGH = hoaDonResponseGH.getTenNguoiNhan();
            sdtGH = hoaDonResponseGH.getSdt();
            diaChiGH = hoaDonResponseGH.getDiaChi();
            tienShip = hoaDonResponseGH.getTienShip();
            ngayShip = hoaDonResponseGH.getNgayShip();
            ngayNhan = hoaDonResponseGH.getNgayNhan();
            ngayHenKhach = hoaDonResponseGH.getNgayHenKhach();
            //            txtDiaChiGiaoHang.setText(diaChiGH);
            //            txtTenKHGiaoHang.setText(tenKHGH);
            //            txtSDTGiaoHang.setText(sdtGH);
            txtTienShipLS.setText(Integer.valueOf((int) tienShip) + "");
            txtNgayNhanLS.setText(ngayNhan);
            txtNgayShipLS.setText(ngayShip);
            jdcNgayHenKhachLS.setDate(ngayHenKhach);

        }

        //show len tbhoadon
        listCTHD = chiTietHoaDonService.getDataByID(id);
        showDataTableCTHDLS(listCTHD);
        showTongTienLS();

        //        jTienThua.setText("-");
        //
        //        jTienThuaGiaoHang.setText("-");
    }//GEN-LAST:event_TBHoaDonLSMouseClicked

    private void TBGioHangLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBGioHangLSMouseClicked

    }//GEN-LAST:event_TBGioHangLSMouseClicked

    private void cbbPTTTLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPTTTLSActionPerformed
        if (cbbPTTTLS.getSelectedIndex() == 0) {
            txtTienChuyenKhoanLS.setEnabled(false);
            //            txtTienKhachDua.setEnabled(true);
        }
        if (cbbPTTTLS.getSelectedIndex() == 1) {
            txtTienChuyenKhoanLS.setEnabled(true);
            //            txtTienKhachDua.setEnabled(false);
        }
        if (cbbPTTTLS.getSelectedIndex() == 2) {
            txtTienChuyenKhoanLS.setEnabled(true);
            //            txtTienKhachDua.setEnabled(true);
        }
    }//GEN-LAST:event_cbbPTTTLSActionPerformed

    private void txtTienShipLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienShipLSMouseClicked
        showTongTienLS();
    }//GEN-LAST:event_txtTienShipLSMouseClicked

    private void btnTimKiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHDActionPerformed
        Date ngayBatDau = txtNgayBatDau.getDate();
        Date ngayKetThuc = txtNgayKetThuc.getDate();
        listHD = hoaDonService.getAllByNgayBatDauNgayKetThuc(ngayBatDau, ngayKetThuc);
        showDataTableHDLS(listHD);
    }//GEN-LAST:event_btnTimKiemHDActionPerformed

    private void cbbTimKiemTrangThaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemTrangThaiKHActionPerformed
        // TODO add your handling code here:
        int trangThaiNv = cbbTimKiemTrangThaiKH.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemTrangThaiKH.setText("Đang Hoạt động");
        } else {
            jTimKiemTrangThaiKH.setText("Đã nghỉ");
        }
        lstKh.clear();
        lstKh = khs.getbyTrangThai(cbbTimKiemTrangThaiKH.getSelectedIndex());
        showTableKhachHang(lstKh);
    }//GEN-LAST:event_cbbTimKiemTrangThaiKHActionPerformed

    private void cbbTimKiemGioiTinhKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemGioiTinhKHActionPerformed
        // TODO add your handling code here:
        int trangThaiNv = cbbTimKiemGioiTinhKH.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemGioiTinhKhachHang.setText("Nam");
        } else {
            jTimKiemGioiTinhKhachHang.setText("Nữ");
        }
        lstKh.clear();
        lstKh = khs.getbyGioiTinh(cbbTimKiemGioiTinhKH.getSelectedIndex());
        showTableKhachHang(lstKh);
    }//GEN-LAST:event_cbbTimKiemGioiTinhKHActionPerformed

    private void btTimKiemTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemTenKHActionPerformed
        // TODO add your handling code here:
        if (txtTimKiemTenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "mời nhập tên tìm kiếm !");
        } else {
            lstKh.clear();
            lstKh = khs.getbyTen(txtTimKiemTenKH.getText());
            showTableKhachHang(lstKh);
        }
    }//GEN-LAST:event_btTimKiemTenKHActionPerformed

    private void cbbAllKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbAllKHActionPerformed
        // TODO add your handling code here:
        lstKh = khs.getAll();
        showTableKhachHang(lstKh);
    }//GEN-LAST:event_cbbAllKHActionPerformed

    private void cbbTimKiemChucVuNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemChucVuNVActionPerformed
        // TODO add your handling code here:
        int trangThaiNv = cbbTimKiemChucVuNV.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemChucVuNV.setText("Quản Lý");
        } else {
            jTimKiemChucVuNV.setText("Nhân Viên ");
        }

        lstQlNhanVien.clear();
        lstQlNhanVien = nvs.getbyChucVunv(cbbTimKiemChucVuNV.getSelectedIndex());
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_cbbTimKiemChucVuNVActionPerformed

    private void cbbTimKiemGioiTinhNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemGioiTinhNVActionPerformed
        // TODO add your handling code here:
        cbbTimKiemChucVuNV.setSelectedIndex(0);
        jTimKiemChucVuNV.setText("");
        cbbTimKiemTrangThaiNV.setSelectedIndex(0);
        jTimKiemTrangThaiNV.setText("");
        int trangThaiNv = cbbTimKiemGioiTinhNV.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemGioiTinhNV.setText("Nam");
        } else {
            jTimKiemGioiTinhNV.setText("Nữ ");
        }

        lstQlNhanVien.clear();
        lstQlNhanVien = nvs.getbyGioiTinh(cbbTimKiemGioiTinhNV.getSelectedIndex());
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_cbbTimKiemGioiTinhNVActionPerformed

    private void cbbTimKiemTrangThaiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemTrangThaiNVActionPerformed
        // TODO add your handling code here:
        int trangThaiNv = cbbTimKiemTrangThaiNV.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemTrangThaiNV.setText("Đã Nghỉ");
        } else {
            jTimKiemTrangThaiNV.setText("Đang Hoạt Động");
        }

        lstQlNhanVien.clear();
        lstQlNhanVien = nvs.getbyTrangThainv(cbbTimKiemTrangThaiNV.getSelectedIndex());
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_cbbTimKiemTrangThaiNVActionPerformed

    private void btTimKiemTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemTenNVActionPerformed
        // TODO add your handling code here:
        if (txtTimKiemTenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "mời nhập tên !");
        } else {
            lstQlNhanVien.clear();
            lstQlNhanVien = nvs.getbyTennv(txtTimKiemTenNV.getText());
            showTableNhanVien(lstQlNhanVien);
        }
    }//GEN-LAST:event_btTimKiemTenNVActionPerformed

    private void btAllNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllNvActionPerformed
        // TODO add your handling code here:
        lstQlNhanVien = nvs.getAll();
        showTableNhanVien(lstQlNhanVien);
    }//GEN-LAST:event_btAllNvActionPerformed

    private void cbbTenKieuBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenKieuBanHangActionPerformed
        if (cbbTenKieuBanHang.getSelectedIndex() == 0) {
            String ck = "Chuyển Khoản";
            String tm = "Tiền Mặt";
            String cktm = "Tiền Mặt + Chuyển Khoản";
            listHD = hoaDonService.getAllByBanHangTaiQuay(ck, tm, cktm);
            showDataTableHDLS(listHD);
            txtNgayShipLS.setEnabled(false);
            txtNgayNhanLS.setEnabled(false);
            txtNgayThanhToanLS.setEnabled(true);
        } else {
            String cod = "COD";
            listHD = hoaDonService.getAllByGiaoHang(cod);
            showDataTableHDLS(listHD);
            txtNgayShipLS.setEnabled(true);
            txtNgayNhanLS.setEnabled(true);
            txtNgayThanhToanLS.setEnabled(false);
        }
    }//GEN-LAST:event_cbbTenKieuBanHangActionPerformed

    private void btnTKSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKSDTActionPerformed
        String tkSDT = txtTKSDT.getText();
        listHD = hoaDonService.getAllBySDT(tkSDT);
        showDataTableHDLS(listHD);
    }//GEN-LAST:event_btnTKSDTActionPerformed

    private void cbbTrangThaiHDLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiHDLSActionPerformed
        if (cbbTrangThaiHDLS.getSelectedIndex() == 0) {
            TBHoaDonLS.clearSelection();
            listHD = hoaDonService.getAll();
            showDataTableHDLS(listHD);
        } else if (cbbTrangThaiHDLS.getSelectedIndex() == 1) {
            int trangThai = 0;
            TBHoaDonLS.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHDLS(listHD);
        } else if (cbbTrangThaiHDLS.getSelectedIndex() == 2) {
            int trangThai = 1;
            TBHoaDonLS.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHDLS(listHD);
        } else {
            int trangThai = 2;
            TBHoaDonLS.clearSelection();
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHDLS(listHD);
        }
    }//GEN-LAST:event_cbbTrangThaiHDLSActionPerformed

    private void cbbTimKiemTrangThaiSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemTrangThaiSpActionPerformed
        // TODO add your handling code here:
        int trangThaiNv = cbbTimKiemTrangThaiSp.getSelectedIndex();
        if (trangThaiNv == 0) {
            jTimKiemTrangThaiSp.setText("hết hàng");
        } else {
            jTimKiemTrangThaiSp.setText("còn hàng");
        }

        lstQLSp.clear();
        lstQLSp = spsi.getTrangThai(cbbTimKiemTrangThaiSp.getSelectedIndex());
        showTableSanPham(lstQLSp);
    }//GEN-LAST:event_cbbTimKiemTrangThaiSpActionPerformed

    private void btTimKiemMAspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemMAspActionPerformed
        // TODO add your handling code here:
        if (txtTimKiemMaSp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "mời nhập mã cần tìm !");
        } else {
            lstQLSp = spsi.getMaSp(txtTimKiemMaSp.getText());
            showTableSanPham(lstQLSp);
        }
    }//GEN-LAST:event_btTimKiemMAspActionPerformed

    private void btThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemKhuyenMaiActionPerformed

        int themNsx = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (themNsx == JOptionPane.YES_OPTION) {
            QuanLyKhuyenMai ql = getKhuyenMai();
            String add = kms.add(ql);
            JOptionPane.showMessageDialog(this, add);
            lstKm = kms.getAll();
            showTableKhuyenMai(lstKm);
        } else if (themNsx == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thêm");
        }
    }//GEN-LAST:event_btThemKhuyenMaiActionPerformed

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
        int row = tbKhuyenMai.getSelectedRow();
        fillKhuyenMai(row);
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

    private void cbbTrangThaiKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiKhuyenMaiActionPerformed
        int trangThai = cbbTrangThaiKhuyenMai.getSelectedIndex();
        if (trangThai == 0) {
            jlbTrangThaiKhuyenMai.setText("Hết hạn");
        } else {
            jlbTrangThaiKhuyenMai.setText("Đang khuyến mại");
        }
    }//GEN-LAST:event_cbbTrangThaiKhuyenMaiActionPerformed

    private void btHuyKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyKhuyenMaiActionPerformed

        int themNsx = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (themNsx == JOptionPane.YES_OPTION) {
            QuanLyKhuyenMai ql = getKhuyenMai();
            String id = jlbIdKhuyenMai.getText();
            String update = kms.updateKhuyenMai(ql, id);
            JOptionPane.showMessageDialog(this, update);
            lstKm = kms.getAll();
            showTableKhuyenMai(lstKm);
        } else if (themNsx == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thêm");
        }
    }//GEN-LAST:event_btHuyKhuyenMaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        QuanLySanPhamGiamGia qlSpGG = getSanPhamGiamGia();
        String add = kms.addSanPhamGiamGia(qlSpGG);
        JOptionPane.showMessageDialog(this, add);
        lstSpGiamGia = kms.getAllSanPhamGiamGia();
        showTableSanPhamKhuyenMai(lstSpGiamGia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbTrangThaiSanPhamKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiSanPhamKhuyenMaiActionPerformed
        int trangThai = cbbTrangThaiSanPhamKhuyenMai.getSelectedIndex();
        if (trangThai == 0) {
            jlbTrangThaiSanPhamKhuyenmai.setText("Hết hạn");
        } else {
            jlbTrangThaiSanPhamKhuyenmai.setText("Đang khuyến mại");
        }
    }//GEN-LAST:event_cbbTrangThaiSanPhamKhuyenMaiActionPerformed

    private void TBHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBHoaDonMouseClicked
        txtTienKhachDua.setText("0");
        txtTienChuyenKhoan.setText("0");
        txtTienKhachDuaGiaoHang.setText("0");
        int row = TBHoaDon.getSelectedRow();
        txtMaHD.setText((String) TBHoaDon.getModel().getValueAt(row, 2));
        txtMaNV.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
        txtNgayTao.setText((String) TBHoaDon.getModel().getValueAt(row, 3));
        //tb Giao Hang
        txtMaHDGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 2));
        txtMaNVGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
        txtNgayTaoGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 3));
        String id = (String) TBHoaDon.getModel().getValueAt(row, 1);
        System.out.println(id);
        // lay thong tin khach hang
        ArrayList<HoaDonResponse> listTTKH = hoaDonService.getTTKhByID(id);
        String tenKH;
        String sdt;
        String diaChi;
        String ngayThanhToan;
        for (HoaDonResponse hoaDonResponse : listTTKH) {
            tenKH = hoaDonResponse.getTenNguoiNhan();
            sdt = hoaDonResponse.getSdt();
            diaChi = hoaDonResponse.getDiaChi();
            ngayThanhToan = hoaDonResponse.getNgayThanhToan();
            txtDiaChi.setText(diaChi);
            txtTenKH.setText(tenKH);
            txtSDT.setText(sdt);
            txtDiaChiGiaoHang.setText(diaChi);
            txtTenKHGiaoHang.setText(tenKH);
            txtSDTGiaoHang.setText(sdt);
            txtNgayThanhToan.setText(ngayThanhToan);
        }
        ArrayList<LoaiHinhTanhToan> listLoaiHinhTT = loaiHinhThanhToanService.getTTThanhToanByID(id);
        String tenPttt;
        float tienMat;
        float tienCK;
        for (LoaiHinhTanhToan loaiHinhTanhToan : listLoaiHinhTT) {
            tenPttt = loaiHinhTanhToan.getTenPTTT();
            tienMat = loaiHinhTanhToan.getTienMat();
            tienCK = loaiHinhTanhToan.getTienChuyenKhoan();
            cbbPTTT.setSelectedItem(tenPttt);
            txtTienKhachDua.setText(Integer.valueOf((int) tienMat) + "");
            txtTienChuyenKhoan.setText(Integer.valueOf((int) tienCK) + "");
            txtTienKhachDuaGiaoHang.setText(Integer.valueOf((int) tienMat) + "");
        }

        ArrayList<HoaDonResponse> listTTKHGiaoHang = hoaDonService.getTTKhGiaoHangByID(id);
        String tenKHGH;
        String sdtGH;
        String diaChiGH;
        float tienShip;
        String ngayShip;
        String ngayNhan;
        Date ngayHenKhach;
        for (HoaDonResponse hoaDonResponseGH : listTTKHGiaoHang) {
            tenKHGH = hoaDonResponseGH.getTenNguoiNhan();
            sdtGH = hoaDonResponseGH.getSdt();
            diaChiGH = hoaDonResponseGH.getDiaChi();
            tienShip = hoaDonResponseGH.getTienShip();
            ngayShip = hoaDonResponseGH.getNgayShip();
            ngayNhan = hoaDonResponseGH.getNgayNhan();
            ngayHenKhach = hoaDonResponseGH.getNgayHenKhach();
            txtDiaChiGiaoHang.setText(diaChiGH);
            txtTenKHGiaoHang.setText(tenKHGH);
            txtSDTGiaoHang.setText(sdtGH);
            txtTienShip.setText(Integer.valueOf((int) tienShip) + "");
            txtNgayNhan.setText(ngayNhan);
            txtNgayShip.setText(ngayShip);
            jdcNgayHenKhach.setDate(ngayHenKhach);

        }

        //show len tbhoadon
        listCTHD = chiTietHoaDonService.getDataByID(id);
        showDataTableCTHD(listCTHD);
        showTongTien();
        if (TBHoaDon.getModel().getValueAt(row, 5).toString() == "Đã huỷ") {
            btnThanhToan.setEnabled(false);
            btnHuyHoaDon.setEnabled(false);
            txtMaHD.setEditable(false);
            txtMaNV.setEditable(false);
            txtNgayTao.setEditable(false);
            txtTienKhachDua.setEditable(false);
            txtMaNV.setEditable(false);
            txtSDT.setEditable(false);
            txtTenKH.setEditable(false);
            txtMaHDGiaoHang.setEditable(false);
            txtMaNVGiaoHang.setEditable(false);
            txtNgayTaoGiaoHang.setEditable(false);
            txtTienKhachDuaGiaoHang.setEditable(false);
            txtMaNVGiaoHang.setEditable(false);
            txtSDTGiaoHang.setEditable(false);
            txtTenKHGiaoHang.setEditable(false);
            txtDiaChi.setEditable(false);
            txtDiaChiGiaoHang.setEditable(false);
            txtTienShip.setEditable(false);

            BtnXoa.setEnabled(false);
            TBSanPham.setEnabled(false);
            TBGioHang.setEnabled(false);
        } else if (TBHoaDon.getModel().getValueAt(row, 5).toString() == "Đang chờ thanh toán") {
            btnThanhToan.setEnabled(true);
            btnHuyHoaDon.setEnabled(true);
            txtMaHD.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtTienKhachDua.setEnabled(true);
            txtMaNV.setEnabled(false);
            txtSDT.setEnabled(true);
            txtTenKH.setEnabled(true);
            txtMaHDGiaoHang.setEnabled(false);
            txtMaNVGiaoHang.setEnabled(false);
            txtNgayTaoGiaoHang.setEnabled(false);
            txtTienKhachDuaGiaoHang.setEnabled(true);
            txtMaNVGiaoHang.setEnabled(false);
            txtSDTGiaoHang.setEnabled(true);
            txtTenKHGiaoHang.setEnabled(true);
            txtDiaChi.setEnabled(true);
            txtDiaChiGiaoHang.setEnabled(true);
            txtTienShip.setEnabled(true);
            jdcNgayHenKhach.setEnabled(true);
            btnApDungTienShip.setEnabled(true);
            btnNgayHenKhach.setEnabled(true);
            btnHuyHoaDonGH.setEnabled(true);

            btnNgayHenKhach.setEnabled(true);
            btnGuiHang.setEnabled(false);
            btnThanhToan1.setEnabled(false);
            btnApDungTienShip.setEnabled(false);
            BtnXoa.setEnabled(true);
            TBSanPham.setEnabled(true);
            TBGioHang.setEnabled(true);
        } else if (TBHoaDon.getModel().getValueAt(row, 5).toString() == "Đang giao hàng") {
            btnThanhToan.setEnabled(false);
            btnHuyHoaDon.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtSDT.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtMaHDGiaoHang.setEnabled(false);
            txtMaNVGiaoHang.setEnabled(false);
            txtNgayTaoGiaoHang.setEnabled(false);
            txtTienKhachDuaGiaoHang.setEnabled(true);
            txtMaNVGiaoHang.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChi.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);

            jdcNgayHenKhach.setEnabled(false);
            btnApDungTienShip.setEnabled(false);
            btnNgayHenKhach.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            btnThanhToan1.setEnabled(true);
            btnHuyHoaDonGH.setEnabled(true);
            BtnXoa.setEnabled(false);
            TBSanPham.setEnabled(false);
            TBGioHang.setEnabled(false);

            int sum = 0;
            int tienShiptt = Integer.valueOf(txtTienShip.getText());
            if (txtTienShip.getText().isEmpty()) {
                tienShiptt = 0;
            }
            for (int i = 0; i < TBGioHang.getRowCount(); i++) {
                sum = sum + Integer.parseInt(TBGioHang.getModel().getValueAt(i, 6).toString());
            }
            System.out.println(sum);
            Locale locale = new Locale("vi", "VN");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            jTongTien.setText(format.format(sum));
            jTongTienGiaoHang.setText(format.format(sum + tienShiptt));
            txtTienKhachDuaGiaoHang.setText(String.valueOf(sum + tienShiptt));
        } else {
            btnThanhToan.setEnabled(false);
            btnHuyHoaDon.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtSDT.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtMaHDGiaoHang.setEnabled(false);
            txtMaNVGiaoHang.setEnabled(false);
            txtNgayTaoGiaoHang.setEnabled(false);
            txtTienKhachDuaGiaoHang.setEnabled(false);
            txtMaNVGiaoHang.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChi.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);

            jdcNgayHenKhach.setEnabled(false);
            btnApDungTienShip.setEnabled(false);
            btnNgayHenKhach.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            BtnXoa.setEnabled(false);
            TBSanPham.setEnabled(false);
            TBGioHang.setEnabled(false);
        }

        jTienThua.setText("-");

        jTienThuaGiaoHang.setText("-");
    }//GEN-LAST:event_TBHoaDonMouseClicked

    private void TBGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBGioHangMouseClicked
//        int rowGH = TBGioHang.getSelectedRow();
//        String idsp = TBGioHang.getModel().getValueAt(rowGH, 1).toString();
//        System.out.println(idSelected);
        TBGioHang.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                //lấy row được click double
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.isRowSelected(row)) {

                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();

                    int rowHD = TBHoaDon.getSelectedRow();
                    int rowSP = TBSanPham.getSelectedRow();
                    int rowGH = TBGioHang.getSelectedRow();

                    String masp = TBGioHang.getModel().getValueAt(row, 2).toString();
                    String tensp = TBGioHang.getModel().getValueAt(row, 3).toString();
                    int soLuongBD = Integer.valueOf(TBGioHang.getModel().getValueAt(row, 4).toString());
//                    String idSPSelected = TBGioHang.getModel().getValueAt(row, 1).toString();
//                    String idHDS = TBHoaDon.getModel().getValueAt(row, 1).toString();

                    String inputXoa = JOptionPane.showInputDialog("Mời bạn nhập số lượng " + masp + " - " + tensp + " :");
                    if (inputXoa == null) {
                        JOptionPane.showMessageDialog(rootPane, "Ko co thay doi");
                        listDssp = danhSAchSanPhamService.getAll();
                        showDataTableDSSP(listDssp);
                        showTongTien();
                    } else if (!(inputXoa.matches("\\d*"))) {
                        JOptionPane.showMessageDialog(rootPane, "Bạn nhập sai định dạng");
                        listDssp = danhSAchSanPhamService.getAll();
                        showDataTableDSSP(listDssp);
                        showTongTien();
                    } else if (inputXoa.equals("0")) {
                        BtnXoa.doClick();
                    } else {
                        String idSPSelected = TBGioHang.getModel().getValueAt(row, 1).toString();
                        String idHDS = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
                        listDssp = danhSAchSanPhamService.getSoLuongById(idSPSelected);
                        int soLuongTon;
                        for (DanhSachSanPhamResponse danhSachSanPhamResponse : listDssp) {
                            soLuongTon = danhSachSanPhamResponse.getSoLuong();
                            txtSoLuongTon.setText(String.valueOf(soLuongTon));
                        }
                        int soLuongSauKhiThayDoi = soLuongBD + Integer.valueOf(txtSoLuongTon.getText());
                        int soLuongSauUpdate = Integer.valueOf(inputXoa);
                        int soLuongSauKhiThayDoiL2 = soLuongSauKhiThayDoi - soLuongSauUpdate;
                        if (soLuongSauKhiThayDoiL2 < 0) {
                            JOptionPane.showMessageDialog(rootPane, "Số lượng tồn không đủ");
                        } else {

                            DanhSachSanPhamResponse dsspr = new DanhSachSanPhamResponse(soLuongSauKhiThayDoi);
                            JOptionPane.showMessageDialog(rootPane, danhSAchSanPhamService.updateSoLuongSP(dsspr, idSPSelected));
                            listDssp = danhSAchSanPhamService.getAll();
                            showDataTableDSSP(listDssp);
                            showTongTien();

                            System.out.println(soLuongSauUpdate);
                            ChiTietHoaDon chiTietHoaDonTDSL = new ChiTietHoaDon(soLuongSauUpdate);
                            chiTietHoaDonService.updateSoLuongHoaDonCT(chiTietHoaDonTDSL, idHDS, idSPSelected);
                            listCTHD = chiTietHoaDonService.getDataByID(idHDS);
                            showDataTableCTHD(listCTHD);

                            listDssp = danhSAchSanPhamService.getAll();
                            showDataTableDSSP(listDssp);
                            showTongTien();

                            DanhSachSanPhamResponse dssprl2 = new DanhSachSanPhamResponse(soLuongSauKhiThayDoiL2);
                            JOptionPane.showMessageDialog(rootPane, danhSAchSanPhamService.updateSoLuongSP(dssprl2, idSPSelected));
                            listDssp = danhSAchSanPhamService.getAll();
                            showDataTableDSSP(listDssp);
                        }

                    }

                }

            }

        });
    }//GEN-LAST:event_TBGioHangMouseClicked

    private void BtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXoaActionPerformed
        int btnXoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá Sp ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (btnXoa == JOptionPane.YES_OPTION) {
            int rowGH = TBGioHang.getSelectedRow();
            int rowHD = TBHoaDon.getSelectedRow();
            String idHD = (String) TBHoaDon.getModel().getValueAt(rowHD, 1);
            String idCTSP = (String) TBGioHang.getModel().getValueAt(rowGH, 1);
            capNhapSoLuongTonKho();
            chiTietHoaDonService.delete(idHD, idCTSP);
            listCTHD = chiTietHoaDonService.getDataByID(idHD);
            showDataTableCTHD(listCTHD);
            showTongTien();
        } else if (btnXoa == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy Xoá");
        }
    }//GEN-LAST:event_BtnXoaActionPerformed

    private void TBSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBSanPhamMouseClicked
        int rowSP = TBSanPham.getSelectedRow();
        String idHDSelected = (String) TBSanPham.getModel().getValueAt(rowSP, 1);
        System.out.println(idHDSelected);
        TBSanPham.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                //lấy row được click double
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.isRowSelected(row)) {

                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();

                    int rowHD = TBHoaDon.getSelectedRow();
                    int rowSP = TBSanPham.getSelectedRow();
                    int rowGH = TBGioHang.getSelectedRow();
                    if (TBHoaDon.isRowSelected(rowHD) == false) {
                        btnTaoHoaDon.doClick();
                    } else {
                        try {
                            jTongTien.setText("-");
                            String idHDSelected = (String) TBHoaDon.getModel().getValueAt(rowHD, 1);
                            String hinhAnh = (String) TBSanPham.getModel().getValueAt(row, 9);
                            lblHinhAnhBH.setText("");
                            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/image/" + hinhAnh));
                            Image img = imgIcon.getImage();
                            img.getScaledInstance(lblHinhAnhBH.getWidth(), lblHinhAnhBH.getY(), 0);
                            lblHinhAnhBH.setIcon(imgIcon);

                            // them san pham vao hdct
                            String input = JOptionPane.showInputDialog("Mời nhập số lượng: ");
                            if (input == null) {
                                JOptionPane.showMessageDialog(rootPane, "Ko co san pham nao dc them");
                                listDssp = danhSAchSanPhamService.getAll();
                                showDataTableDSSP(listDssp);
                                showTongTien();
                            } else if (input.equals("0") || input.matches("[a-zA-Z]") || Integer.valueOf(input) < 0 || input.trim() == "") {
                                JOptionPane.showMessageDialog(rootPane, "Bạn nhập sai định dạng");
                                listDssp = danhSAchSanPhamService.getAll();
                                showDataTableDSSP(listDssp);
                                showTongTien();
                            } else if ((int) TBSanPham.getModel().getValueAt(row, 6) < Integer.valueOf(input)) {
                                JOptionPane.showMessageDialog(rootPane, "Số lượng hàng vượt quá lượng tồn kho");
                                listDssp = danhSAchSanPhamService.getAll();
                                showDataTableDSSP(listDssp);
                                showTongTien();
                            } else {

                                // check san pham trung trong gio hang
                                int soLuongHDCT;

                                int inputx = Integer.valueOf(input);
                                String idsp;
                                int soLuongGH;
                                int soLuongUpdate;
                                Object ob = null;
                                String s;
                                for (int i = 0; i < TBGioHang.getRowCount(); i++) {

                                    list.add((String) TBGioHang.getModel().getValueAt(i, 1));
                                    System.out.println(list);
                                    s = TBSanPham.getModel().getValueAt(rowSP, 1).toString();
                                    ob = s;

                                }
                                if (list.contains(ob)) {
                                    System.out.println("sp trung");
                                    idsp = ob.toString();

                                    ArrayList<ChiTietHoaDon> listCTHDSL = chiTietHoaDonService.getSoLuongByID(idHDSelected, idsp);
                                    int soLuongspgh;
                                    for (ChiTietHoaDon chiTietHoaDon1 : listCTHDSL) {
                                        soLuongspgh = chiTietHoaDon1.getSoLuong();
                                        txtSoLuongGh.setText(String.valueOf(soLuongspgh));
                                    }

                                    soLuongUpdate = inputx + Integer.valueOf(txtSoLuongGh.getText());
                                    System.out.println(soLuongUpdate);
                                    ChiTietHoaDon chiTietHoaDonUpdateSL = new ChiTietHoaDon(soLuongUpdate);
                                    chiTietHoaDonService.updateSoLuongHoaDonCT(chiTietHoaDonUpdateSL, idHDSelected, String.valueOf(ob));
                                    listCTHD = chiTietHoaDonService.getDataByID(idHDSelected);
                                    showDataTableCTHD(listCTHD);
                                } else {
                                    //add san pham chua co trong gio hang
                                    System.out.println("Ko trung");
                                    chiTietHoaDon.setIdCTSP((String) TBSanPham.getModel().getValueAt(row, 1));
                                    chiTietHoaDon.setMaSP((String) TBSanPham.getModel().getValueAt(row, 2));
                                    chiTietHoaDon.setTenSP((String) TBSanPham.getModel().getValueAt(row, 3));
                                    chiTietHoaDon.setSoLuong(Integer.valueOf(input));
                                    chiTietHoaDon.setDonGia((float) TBSanPham.getModel().getValueAt(row, 8));
                                    idHDSelected = (String) TBHoaDon.getModel().getValueAt(rowHD, 1);
                                    ChiTietHoaDon chiTietHoaDonAdd = new ChiTietHoaDon(idHDSelected, (String) TBSanPham.getModel().getValueAt(row, 1), Integer.valueOf(input), (float) TBSanPham.getModel().getValueAt(row, 8));

                                    chiTietHoaDonService.saveHoaDonCT(chiTietHoaDonAdd);
                                    listCTHD.add(chiTietHoaDon);
                                    showDataTableCTHD(listCTHD);
                                }

                                // cap nhap lai danh sach sp sau khi them vao gio
                                String idSelected = (String) TBSanPham.getModel().getValueAt(row, 1);
                                int soLuongSauKhiThem = (int) TBSanPham.getModel().getValueAt(rowSP, 6) - Integer.valueOf(input);
                                DanhSachSanPhamResponse dsspr = new DanhSachSanPhamResponse(soLuongSauKhiThem);
                                JOptionPane.showMessageDialog(rootPane, danhSAchSanPhamService.updateSoLuongSP(dsspr, idSelected));
                                listDssp = danhSAchSanPhamService.getAll();
                                showDataTableDSSP(listDssp);
                                showTongTien();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(rootPane, "Ban chua chon hoa don");

                        }
                    }

                    //show hinh anh
                } else {
                    String hinhAnh = (String) TBSanPham.getModel().getValueAt(row, 9);
                    lblHinhAnhBH.setText("");
                    ImageIcon imgIcon = new ImageIcon(getClass().getResource("/image/" + hinhAnh));
                    Image img = imgIcon.getImage();
                    img.getScaledInstance(lblHinhAnhBH.getWidth(), lblHinhAnhBH.getY(), 0);
                    lblHinhAnhBH.setIcon(imgIcon);

                }

            }

        });
    }//GEN-LAST:event_TBSanPhamMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        int taoHD = JOptionPane.showConfirmDialog(this, "Bạn có muốn tạo hoá đơn ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (taoHD == JOptionPane.YES_OPTION) {
            listHD = hoaDonService.getAll();
            showDataTableHD(listHD);

            ArrayList<HoaDonResponse> list = hoaDonService.getAll();
            int i = list.size() + 1;
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHD("HD" + i++);
            hoaDon.setNgayTao(new Date());
            hoaDon.setTrangThai(0);
            hoaDonService.saveHoaDon(hoaDon);
            listHD = hoaDonService.getAll();
            showDataTableHD(listHD);
            showChoThanhToan();
            dtmGH.setRowCount(0);
            TBHoaDon.setRowSelectionInterval(0, 0);

            //tb hoa don
            int row = TBHoaDon.getSelectedRow();
            txtMaHD.setText((String) TBHoaDon.getModel().getValueAt(row, 2));
            txtMaNV.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
            txtNgayTao.setText((String) TBHoaDon.getModel().getValueAt(row, 3));
            //tb Giao Hang
            txtMaHDGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 2));
            txtMaNVGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 4));
            txtNgayTaoGiaoHang.setText((String) TBHoaDon.getModel().getValueAt(row, 3));

            String id = (String) TBHoaDon.getModel().getValueAt(row, 1);
            System.out.println(id);
            // lay thong tin khach hang
            ArrayList<HoaDonResponse> listTTKH = hoaDonService.getTTKhByID(id);
            String tenKH;
            String sdt;
            String diaChi;
            String ngayThanhToan;
            for (HoaDonResponse hoaDonResponse : listTTKH) {
                tenKH = hoaDonResponse.getTenNguoiNhan();
                sdt = hoaDonResponse.getSdt();
                diaChi = hoaDonResponse.getDiaChi();
                ngayThanhToan = hoaDonResponse.getNgayThanhToan();
                txtDiaChi.setText(diaChi);
                txtTenKH.setText(tenKH);
                txtSDT.setText(sdt);
                txtDiaChiGiaoHang.setText(diaChi);
                txtTenKHGiaoHang.setText(tenKH);
                txtSDTGiaoHang.setText(sdt);
                txtNgayThanhToan.setText(ngayThanhToan);
            }
            ArrayList<LoaiHinhTanhToan> listLoaiHinhTT = loaiHinhThanhToanService.getTTThanhToanByID(id);
            String tenPttt;
            float tienMat;
            float tienCK;
            for (LoaiHinhTanhToan loaiHinhTanhToan : listLoaiHinhTT) {
                tenPttt = loaiHinhTanhToan.getTenPTTT();
                tienMat = loaiHinhTanhToan.getTienMat();
                tienCK = loaiHinhTanhToan.getTienChuyenKhoan();
                cbbPTTT.setSelectedItem(tenPttt);
                txtTienKhachDua.setText(Integer.valueOf((int) tienMat) + "");
                txtTienChuyenKhoan.setText(Integer.valueOf((int) tienCK) + "");
                txtTienKhachDuaGiaoHang.setText(Integer.valueOf((int) tienMat) + "");
            }

            ArrayList<HoaDonResponse> listTTKHGiaoHang = hoaDonService.getTTKhGiaoHangByID(id);
            String tenKHGH;
            String sdtGH;
            String diaChiGH;
            float tienShip;
            String ngayShip;
            String ngayNhan;
            Date ngayHenKhach;
            for (HoaDonResponse hoaDonResponseGH : listTTKHGiaoHang) {
                tenKHGH = hoaDonResponseGH.getTenNguoiNhan();
                sdtGH = hoaDonResponseGH.getSdt();
                diaChiGH = hoaDonResponseGH.getDiaChi();
                tienShip = hoaDonResponseGH.getTienShip();
                ngayShip = hoaDonResponseGH.getNgayShip();
                ngayNhan = hoaDonResponseGH.getNgayNhan();
                ngayHenKhach = hoaDonResponseGH.getNgayHenKhach();
                txtDiaChiGiaoHang.setText(diaChiGH);
                txtTenKHGiaoHang.setText(tenKHGH);
                txtSDTGiaoHang.setText(sdtGH);
                txtTienShip.setText(Integer.valueOf((int) tienShip) + "");
                txtNgayNhan.setText(ngayNhan);
                txtNgayShip.setText(ngayShip);
                jdcNgayHenKhach.setDate(ngayHenKhach);

            }

            //show len tbhoadon
            listCTHD = chiTietHoaDonService.getDataByID(id);
            showDataTableCTHD(listCTHD);
            showTongTien();
            txtTienKhachDua.setText("0");
            txtTienKhachDuaGiaoHang.setText("0");
            txtTienChuyenKhoan.setText("0");
            jTienThua.setText("-");
            jTienThuaGiaoHang.setText("-");
            btnThanhToan.setEnabled(true);
            btnHuyHoaDon.setEnabled(true);
            txtMaHD.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtMaHDGiaoHang.setEnabled(false);
            txtMaNVGiaoHang.setEnabled(false);
            txtNgayTaoGiaoHang.setEnabled(false);
            btnApDungTienShip.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(true);
            txtDiaChiGiaoHang.setEnabled(true);
            txtSDTGiaoHang.setEnabled(true);
            BtnXoa.setEnabled(true);
            TBSanPham.setEnabled(true);
            TBGioHang.setEnabled(true);
        } else if (taoHD == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thêm");
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int thanhToanTaiQuay = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (thanhToanTaiQuay == JOptionPane.YES_OPTION) {
            try {
                //them thong tin khach hang vao hoa don
                int rowHD = TBHoaDon.getSelectedRow();
                String idSelected = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
                String tenkh = txtTenKH.getText();
                String sdt = txtSDT.getText();
                String diaChi = txtDiaChi.getText();
                HoaDon hoaDonTTKH = new HoaDon(tenkh, diaChi, sdt);
                hoaDonService.updateTTKH(hoaDonTTKH, idSelected);
                //Tien thua
                int tienKhachDua = Integer.valueOf(txtTienKhachDua.getText());
                int tienChuyenKhoan = Integer.valueOf(txtTienChuyenKhoan.getText());
                int tongTienKhachDua = tienKhachDua + tienChuyenKhoan;
                int sum = 0;
                for (int i = 0; i < TBGioHang.getRowCount(); i++) {
                    sum = sum + Integer.parseInt(TBGioHang.getModel().getValueAt(i, 6).toString());
                }
                if (tongTienKhachDua < sum) {
                    JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ");
                    return;
                } else {
                    int tienThua = tongTienKhachDua - sum;
                    Locale locale = new Locale("vi", "VN");
                    NumberFormat format = NumberFormat.getCurrencyInstance(locale);
                    jTienThua.setText(format.format(tienThua));

                    //cap nhat trang thai 
                    String maSelected = TBHoaDon.getModel().getValueAt(rowHD, 2).toString();
                    int trangThai = 1;
                    HoaDon hoaDon = new HoaDon(trangThai);
                    TBHoaDon.clearSelection();
                    hoaDonService.updateThanhToan(hoaDon, maSelected);
                    listHD = hoaDonService.getAll();
                    showDataTableHD(listHD);

                    HoaDon hoaDonNgayThanhToan = new HoaDon();
                    hoaDonNgayThanhToan.setNgayThanhToan(new Date());
                    System.out.println(idSelected);
                    hoaDonService.updateNgayThanhToan(hoaDonNgayThanhToan, idSelected);

                    showChoThanhToan();
                    showDataTableCTHD(listCTHD);

                    // them loại hình thanh toán
                    String tenLHTT = String.valueOf(cbbPTTT.getSelectedItem());
                    float tienMat = Float.valueOf(txtTienKhachDua.getText());
                    float tienChuyen = Float.valueOf(txtTienChuyenKhoan.getText());
                    LoaiHinhTanhToan lhtt = new LoaiHinhTanhToan(idSelected, tenLHTT, tienMat, tienChuyen);
                    loaiHinhThanhToanService.saveLoaiHinhTT(lhtt);

                    if (!txtTenKH.getText().isEmpty()) {
                        String tenKh = txtTenKH.getText();
                        String sdtKh = txtSDT.getText();
                        String diaChiKh = txtTenKH.getText();
                        if (sdtKh.isEmpty() || !(sdtKh.matches("^[0-9]{10}$")) || diaChiKh.isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "Bạn nhập sai định dạng. khách hàng ko đc thêm");
                        } else {
                            KhachHangResponse khachHangResponse = new KhachHangResponse(tenKh, sdtKh, diaChiKh);
                            khachHangRService.saveKhachHang(khachHangResponse);
                        }

                    }
                    showDaThanhToan();
                    txtDiaChi.setEnabled(false);
                    txtTenKH.setEnabled(false);
                    txtSDT.setEnabled(false);
                    btnThanhToan.setEnabled(false);
                    btnHuyHoaDon.setEnabled(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn");
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập số tiền khách hàng thanh toán");
            }
        } else if (thanhToanTaiQuay == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thanh toán");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        int huyHD = JOptionPane.showConfirmDialog(this, "Bạn có muốn huỷ hoá đơn ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (huyHD == JOptionPane.YES_OPTION) {
            int rowHD = TBHoaDon.getSelectedRow();
            String maSelected = TBHoaDon.getModel().getValueAt(rowHD, 2).toString();
            int trangThai = 2;
            HoaDon hoaDon = new HoaDon(trangThai);
            JOptionPane.showMessageDialog(this, hoaDonService.updateThanhToan(hoaDon, maSelected));
            listHD = hoaDonService.getAll();
            showDataTableHD(listHD);
        } else if (huyHD == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy chức năng hoá đơn");
        }

    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void cbbPTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPTTTActionPerformed
        if (cbbPTTT.getSelectedIndex() == 0) {
            txtTienChuyenKhoan.setEnabled(false);
            txtTienKhachDua.setEnabled(true);
        }
        if (cbbPTTT.getSelectedIndex() == 1) {
            txtTienChuyenKhoan.setEnabled(true);
            txtTienKhachDua.setEnabled(false);
        }
        if (cbbPTTT.getSelectedIndex() == 2) {
            txtTienChuyenKhoan.setEnabled(true);
            txtTienKhachDua.setEnabled(true);
        }
    }//GEN-LAST:event_cbbPTTTActionPerformed

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        int thanhToanGh = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm xác nhận đơn hàng hoàn thành ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (thanhToanGh == JOptionPane.YES_OPTION) {
            try {
                //them thong tin khach hang vao hoa don
                int rowHD = TBHoaDon.getSelectedRow();
                String idSelected = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
                String tenkh = txtTenKHGiaoHang.getText();
                String sdt = txtSDTGiaoHang.getText();
                String diaChi = txtDiaChiGiaoHang.getText();
                float tienShip = Float.valueOf(txtTienShip.getText());
                checkTTKHGiaoHang();

                HoaDon hoaDonTTKHGH = new HoaDon(tienShip, tenkh, diaChi, sdt);
                JOptionPane.showMessageDialog(this, hoaDonService.updateTTKHGiaoHang(hoaDonTTKHGH, idSelected));

                KhachHangResponse khachHangResponse = new KhachHangResponse(tenkh, sdt, diaChi);
                khachHangRService.saveKhachHang(khachHangResponse);

                //Tien thua
                int tienKhachDua = Integer.valueOf(txtTienKhachDuaGiaoHang.getText());
                int sum = 0;
                int tienShiptt = Integer.valueOf(txtTienShip.getText());
                if (txtTienShip.getText().isEmpty()) {
                    tienShiptt = 0;
                }
                for (int i = 0; i < TBGioHang.getRowCount(); i++) {
                    sum = sum + Integer.parseInt(TBGioHang.getModel().getValueAt(i, 6).toString());
                }
                if (tienKhachDua < sum) {
                    JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ");
                    return;
                }
                int tienThua = tienKhachDua - (sum + tienShiptt);
                Locale locale = new Locale("vi", "VN");
                NumberFormat format = NumberFormat.getCurrencyInstance(locale);
                jTienThuaGiaoHang.setText(format.format(tienThua));

                //cap nhat trang thai 
                String maSelected = TBHoaDon.getModel().getValueAt(rowHD, 2).toString();
                int trangThai = 1;
                HoaDon hoaDon = new HoaDon(trangThai);
                JOptionPane.showMessageDialog(this, hoaDonService.updateThanhToan(hoaDon, maSelected));
                listHD = hoaDonService.getAll();
                showDataTableHD(listHD);

                // luu ngay nhan
                HoaDon hoaDonNgayKhachNhan = new HoaDon();
                hoaDonNgayKhachNhan.setNgayNhan(new Date());
                System.out.println(idSelected);
                hoaDonService.updateNgayKhachNhan(hoaDonNgayKhachNhan, idSelected);

                String tenLHTT = "COD";
                float tienMat = Float.valueOf(txtTienKhachDuaGiaoHang.getText());
                float tienChuyen = 0;
                LoaiHinhTanhToan lhtt = new LoaiHinhTanhToan(idSelected, tenLHTT, tienMat, tienChuyen);
                loaiHinhThanhToanService.saveLoaiHinhTT(lhtt);
                btnNgayHenKhach.setEnabled(true);
                btnGuiHang.setEnabled(false);
                btnThanhToan1.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn");
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập số tiền khách hàng thanh toán");
            }
        } else if (thanhToanGh == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy xác nhận đơn hàng hoàn thành");
        }
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    private void btnHuyHoaDonGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonGHActionPerformed
        int rowHD = TBHoaDon.getSelectedRow();
        String maSelected = TBHoaDon.getModel().getValueAt(rowHD, 2).toString();
        int trangThai = 2;
        HoaDon hoaDon = new HoaDon(trangThai);
        JOptionPane.showMessageDialog(this, hoaDonService.updateThanhToan(hoaDon, maSelected));
        listHD = hoaDonService.getAll();
        showDataTableHD(listHD);
    }//GEN-LAST:event_btnHuyHoaDonGHActionPerformed

    private void txtTienShipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienShipMouseClicked
        showTongTien();
    }//GEN-LAST:event_txtTienShipMouseClicked

    private void btnGuiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiHangActionPerformed
        int guiHang = JOptionPane.showConfirmDialog(this, "Bạn có muốn gửi hàng ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (guiHang == JOptionPane.YES_OPTION) {
            int rowHD = TBHoaDon.getSelectedRow();
            String idSelected = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
            String tenkh = txtTenKHGiaoHang.getText();
            String sdt = txtSDTGiaoHang.getText();
            String diaChi = txtDiaChiGiaoHang.getText();
            float tienShip = Float.valueOf(txtTienShip.getText());

            HoaDon hoaDonShip = new HoaDon();
            hoaDonShip.setNgayShip(new Date());
            System.out.println(idSelected);

            HoaDon hoaDonTTKHGH = new HoaDon(tienShip, tenkh, diaChi, sdt);
            JOptionPane.showMessageDialog(this, hoaDonService.updateTTKHGiaoHang(hoaDonTTKHGH, idSelected));

            if (txtDiaChiGiaoHang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua nhap dia chi");

            } else if (txtSDTGiaoHang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua SDT");
                return;
            } else if (txtTenKHGiaoHang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua nhap tenKH");
                return;
            } else if (txtTienShip.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua nhap tien ship");
                return;
            } else {
                JOptionPane.showMessageDialog(this, hoaDonService.updateNgayShip(hoaDonShip, idSelected));
//                KhachHangResponse khachHangResponse = new KhachHangResponse(tenkh, sdt, diaChi);
//                khachHangRService.saveKhachHang(khachHangResponse);
                btnThanhToan1.setEnabled(true);

                // Tính tông tiền
                int sum = 0;
                int tienShiptt = Integer.valueOf(txtTienShip.getText());
                if (txtTienShip.getText().isEmpty()) {
                    tienShiptt = 0;
                }
                for (int i = 0; i < TBGioHang.getRowCount(); i++) {
                    sum = sum + Integer.parseInt(TBGioHang.getModel().getValueAt(i, 6).toString());
                }
                System.out.println(sum);
                Locale locale = new Locale("vi", "VN");
                NumberFormat format = NumberFormat.getCurrencyInstance(locale);
                jTongTien.setText(format.format(sum));
                jTongTienGiaoHang.setText(format.format(sum + tienShiptt));

                txtDiaChiGiaoHang.setEnabled(false);
                txtTenKHGiaoHang.setEnabled(false);
                txtSDTGiaoHang.setEnabled(false);
                txtTienShip.setEnabled(false);
                btnApDungTienShip.setEnabled(false);
                jdcNgayHenKhach.setEnabled(false);

                //cap nhat trang thai 
                String maSelected = TBHoaDon.getModel().getValueAt(rowHD, 2).toString();
                int trangThai = 3;
                HoaDon hoaDon = new HoaDon(trangThai);
                JOptionPane.showMessageDialog(this, hoaDonService.updateThanhToan(hoaDon, maSelected));
                listHD = hoaDonService.getAll();
                showDataTableHD(listHD);

                txtTienKhachDuaGiaoHang.setText(String.valueOf(sum + tienShiptt));
                btnGuiHang.setEnabled(false);
                btnNgayHenKhach.setEnabled(false);
                dangGiaoHang();
            }
        } else if (guiHang == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy gửi hàng");
        }
    }//GEN-LAST:event_btnGuiHangActionPerformed

    private void btnNgayHenKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayHenKhachActionPerformed
        int henKhach = JOptionPane.showConfirmDialog(this, "Bạn có muốn đặt ngày hẹn khách ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (henKhach == JOptionPane.YES_OPTION) {
            System.out.println("Ngay hen khachh");
            int rowHD = TBHoaDon.getSelectedRow();
            String idSelected = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
            Date ngayHenKhach = jdcNgayHenKhach.getDate();

//        btnGuiHang.setEnabled(true);
//        int rowHD = TBHoaDon.getSelectedRow();
//        String idSelected = TBHoaDon.getModel().getValueAt(rowHD, 1).toString();
            String tenkh = txtTenKHGiaoHang.getText();
            String sdt = txtSDTGiaoHang.getText();
            String diaChi = txtDiaChiGiaoHang.getText();
            float tienShip = Float.valueOf(txtTienShip.getText());

            if (diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ban chua nhap dia chi");

            } else if (sdt.isEmpty() || sdt.matches("[a-zA-Z]")) {
                JOptionPane.showMessageDialog(rootPane, "Ban chua SDT");

            } else if (!(sdt.matches("^[0-9]{10}$"))) {
                JOptionPane.showMessageDialog(rootPane, "Ban nhập sai SĐT");

            } else if (tenkh.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ban chua nhap tenKH");

            } else if (txtTienShip.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ban chua nhap tien ship");

            } else if (txtTienShip.getText().matches("[a-zA-Z]")) {
                JOptionPane.showMessageDialog(rootPane, "Sai định dạng tiền ship");

            } else if (jdcNgayHenKhach.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Ban chua nhap ngay hen khach");

            } else {
                HoaDon hoaDonHenKH = new HoaDon(ngayHenKhach);
                JOptionPane.showMessageDialog(this, hoaDonService.updateNgayHenGiaoHang(hoaDonHenKH, idSelected));
                HoaDon hoaDonTTKHGH = new HoaDon(tienShip, tenkh, diaChi, sdt);
                JOptionPane.showMessageDialog(this, hoaDonService.updateTTKHGiaoHang(hoaDonTTKHGH, idSelected));
                btnApDungTienShip.setEnabled(true);
            }
        } else if (henKhach == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy đặt ngày hẹn khách");
        }
    }//GEN-LAST:event_btnNgayHenKhachActionPerformed

    private void btnApDungTienShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungTienShipActionPerformed
        int tienShip = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm tiền ship ?", "thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (tienShip == JOptionPane.YES_OPTION) {
            showTongTien();
            btnGuiHang.setEnabled(true);
        } else if (tienShip == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã hủy thêm tiền ship");
        }
    }//GEN-LAST:event_btnApDungTienShipActionPerformed

    private void rdbtTatCaDoanhThuThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtTatCaDoanhThuThongKeActionPerformed
        txtNgaybatDauTaoHoaDon.setEnabled(false);
        txtNgayKetThucTaoHoaDon.setEnabled(false);
        btTimKiemNgayThongKe.setEnabled(false);
        lstThongKe = tks.getAll();
        showTableThongKe(lstThongKe);
        showHoaDonDaThanhToan();
        showTongTienHoaDon();
    }//GEN-LAST:event_rdbtTatCaDoanhThuThongKeActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txtNgaybatDauTaoHoaDon.setEnabled(true);
        txtNgayKetThucTaoHoaDon.setEnabled(true);
        btTimKiemNgayThongKe.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void rdoDangGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDangGiaoHangMouseClicked
        if (rdoDangGiaoHang.isSelected() == true) {
            int trangThai = 3;
            TBHoaDon.clearSelection();
            btnThanhToan1.setEnabled(true);
            btnHuyHoaDonGH.setEnabled(true);
            listHD = hoaDonService.getAllByTrangThai(trangThai);
            showDataTableHD(listHD);
        }
    }//GEN-LAST:event_rdoDangGiaoHangMouseClicked

    private void cbbLocCtspThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocCtspThuongHieuActionPerformed
        String ten = (String) cbbLocCtspThuongHieu.getSelectedItem();
        lstCtSp = ctspI.getThuongHieu(ten);
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_cbbLocCtspThuongHieuActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        lstCtSp = ctspI.getAll();
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cbbLocCtspKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocCtspKichCoActionPerformed
        String ten = (String) cbbLocCtspKichCo.getSelectedItem();
        lstCtSp = ctspI.getKichCo(ten);
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_cbbLocCtspKichCoActionPerformed

    private void btTimTheoGiaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimTheoGiaSanPhamActionPerformed
        String giaThapNhat = txtTimKiemGiaThapCtsp.getText();
        String giaCaoNhat = txtTimKiemGiaCaoCtsp.getText();
        lstCtSp = ctspI.getGiaSanPham(giaThapNhat, giaCaoNhat);
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_btTimTheoGiaSanPhamActionPerformed

    private void btTimTheoTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimTheoTenSanPhamActionPerformed
        String ten = txtTimKiemTenSanPham.getText();
        lstCtSp = ctspI.getSanPham(ten);
        showTableChiTietSp(lstCtSp);
    }//GEN-LAST:event_btTimTheoTenSanPhamActionPerformed

    private void cbbDanhMucHangHoaThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucHangHoaThongKeActionPerformed
        String ten = (String) cbbDanhMucHangHoaThongKe.getSelectedItem();
        lstThongKe = tks.getDanhMuc(ten);
        showTableThongKe(lstThongKe);
        showHoaDonDaThanhToan();
        showTongTienHoaDon();
    }//GEN-LAST:event_cbbDanhMucHangHoaThongKeActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        lstThongKe = tks.getAll();
        showTableThongKe(lstThongKe);
        showHoaDonDaThanhToan();
        showTongTienHoaDon();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btTimKiemNgayThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemNgayThongKeActionPerformed
        String ngayBatDau = txtNgaybatDauTaoHoaDon.getText();
        String ngayKetThuc = txtNgayKetThucTaoHoaDon.getText();
        lstThongKe = tks.getNgayTaoHoaDon(ngayBatDau, ngayKetThuc);
        showTableThongKe(lstThongKe);
        showHoaDonDaThanhToan();
        showTongTienHoaDon();
    }//GEN-LAST:event_btTimKiemNgayThongKeActionPerformed
    private QuanLySanPhamGiamGia getSanPhamGiamGia() {
        int indexTenKhuyenMai = cbbTenKhuyenMaiSanPhamKhuyenMai.getSelectedIndex();
        QuanLyKhuyenMai km = lstKm.get(indexTenKhuyenMai);
        int indexTenSanPhamKhuyenMai = cbbTenSanPhamSanPhamKhuyenMai.getSelectedIndex();
        QuanLyChiTietSanPham ctsp = lstCtSp.get(indexTenSanPhamKhuyenMai);
        int trangThai = cbbTrangThaiSanPhamKhuyenMai.getSelectedIndex();

        QuanLySanPhamGiamGia qlSpGG = new QuanLySanPhamGiamGia(km.getId(), ctsp.getIdCtsp(), trangThai);

        return qlSpGG;
    }

    private void fillKhuyenMai(int row) {
        QuanLyKhuyenMai ql = lstKm.get(row);
        jlbIdKhuyenMai.setText(ql.getId());
        txtTenKhuyenMai.setText(ql.getTenKhuyenMai());
        cbbLoaiKhuyenMai.setSelectedIndex(ql.getLoaiKhuyenMai());
        cbbTrangThaiKhuyenMai.setSelectedIndex(ql.getTrangThai());
        jdcNgayBatDauKm.setDate(ql.getNgayBatDau());
        jdcNgayKetThucKm.setDate(ql.getNgatKetThuc());
    }

    private QuanLyKhuyenMai getKhuyenMai() {
        String tenKhuyenMai = txtTenKhuyenMai.getText();
        int loaiKhuyenMai = cbbLoaiKhuyenMai.getSelectedIndex();
        int trangThai = cbbTrangThaiKhuyenMai.getSelectedIndex();
        Date ngayBatDau = jdcNgayBatDauKm.getDate();
        Date ngayKetThuc = jdcNgayKetThucKm.getDate();

        QuanLyKhuyenMai ql = new QuanLyKhuyenMai(null, tenKhuyenMai, loaiKhuyenMai, ngayBatDau, ngayKetThuc, trangThai);

        return ql;
    }

    private QuanLyNhanVien getNhanVien() {
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        qlnv.setMa(txtMaNhanVien.getText());
        qlnv.setTen(txtTenNhanVien.getText());
        int gender = qlnv.getGioiTinh();
        if (rdbtNamNhanVien.isSelected()) {
            gender = 0;
        } else {
            gender = 1;
        }
        qlnv.setGioiTinh(gender);
        qlnv.setNgaySinh(jdcNgaySinhNhanVien.getDate());
        qlnv.setDiaChi(txtDiaChiNhanVien.getText());
        qlnv.setSoDienThoai(txtSoDienThoaiNhanVien.getText());
        qlnv.setChucVu(cbbChucVuNhanVien.getSelectedIndex());
        qlnv.setTrangThai(cbbTrangThaiNhanVien.getSelectedIndex());
        qlnv.setTenTaiKhoan(txtTenTk.getText());
        qlnv.setMatKhau(jpfMatKhau.getText());
        if (strHinhAnh == null) {
            qlnv.setHinhAnh("No avt");
        } else {
            qlnv.setHinhAnh(strHinhAnh);
        }
        return qlnv;
    }

    private void fillDataNhanVien(int row) {
        QuanLyNhanVien qlnv = lstQlNhanVien.get(row);
        jlbIdNhanVien.setText(qlnv.getId());
        txtMaNhanVien.setText(qlnv.getMa());
        txtTenNhanVien.setText(qlnv.getTen());
        int gender = qlnv.getGioiTinh();
        if (gender == 0) {
            rdbtNamNhanVien.setSelected(true);
        } else {
            rdbtNuNhanVien.setSelected(true);
        }
        jdcNgaySinhNhanVien.setDate(qlnv.getNgaySinh());
        txtDiaChiNhanVien.setText(qlnv.getDiaChi());
        txtSoDienThoaiNhanVien.setText(qlnv.getSoDienThoai());
        cbbChucVuNhanVien.setSelectedIndex(qlnv.getChucVu());
        cbbTrangThaiNhanVien.setSelectedIndex(qlnv.getTrangThai());
        txtTenTk.setText(qlnv.getTenTaiKhoan());
        jpfMatKhau.setText(qlnv.getMatKhau());
        //load anh
        if (qlnv.getHinhAnh().equalsIgnoreCase("No avt")) {
            jlbAnhNhanVien.setText("NO AVT");
            jlbAnhNhanVien.setText(null);

        } else {
            jlbAnhNhanVien.setText("");
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + qlnv.getHinhAnh()));
            Image img = imageIcon.getImage();
            img.getScaledInstance(jlbAnhNhanVien.getWidth(), jlbAnhNhanVien.getY(), 0);
            jlbAnhNhanVien.setIcon(imageIcon);
        }
    }

    private void showComBoxCvNhanVien() {
        for (int i = 0; i < 2; i++) {
            lstCvNhanVien.add(String.valueOf(i));
        }

        for (String s : lstCvNhanVien) {
            dcbbChucVuNhanVien.addElement(s);
        }
    }

    private void showComBoxTrangThaiNhanVien() {

        for (int i = 0; i < 2; i++) {
            lstTrangThaiNhanVien.add(String.valueOf(i));
        }

        for (String s : lstTrangThaiNhanVien) {
            dcbbTrangThaiNhanVien.addElement(s);
        }
    }

    private void showTableNhanVien(List<QuanLyNhanVien> lst) {
        dtmNhanVien.setRowCount(0);
        for (QuanLyNhanVien ql : lst) {
            dtmNhanVien.addRow(ql.arriveNhanVien());
        }
    }

    private QuanLyDongSanPham getDongSanPham() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyDongSanPham ql = new QuanLyDongSanPham(null, ma, ten, trangThai);

        return ql;
    }

    private QuanLyKichco getKichCo() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyKichco ql = new QuanLyKichco(null, ma, ten, trangThai);

        return ql;
    }

    private QuanLyKieuDang getKieuDang() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyKieuDang ql = new QuanLyKieuDang(null, ma, ten, trangThai);
        return ql;
    }

    private QuanLyThuongHieu getThuongHieu() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyThuongHieu ql = new QuanLyThuongHieu(null, ma, ten, trangThai);
        return ql;
    }

    private QuanLyNhaSanXuat getNhaSanXuat() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyNhaSanXuat ql = new QuanLyNhaSanXuat(null, ma, ten, trangThai);
        return ql;
    }

    private QuanLyMauSac getMauSac() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();

        QuanLyMauSac ql = new QuanLyMauSac(null, ma, ten, trangThai);

        return ql;
    }

    private QuanLyChatLieu getChatLieu() {
        String ma = txtMaThuocTinh.getText();
        int trangThai = cbbThuocTinhSanPham.getSelectedIndex();
        String daChinh = txtDaChinh.getText();
        String daPhu = txtDaPhu.getText();
        String deNgoai = txtDeNgoai.getText();
        String lopLotTrong = txtLopLotTrong.getText();

        QuanLyChatLieu ql = new QuanLyChatLieu(null, ma, daChinh, daPhu, deNgoai, lopLotTrong, trangThai);
        return ql;
    }

    private void showTableMauSac(List<QuanLyMauSac> lst) {
        dtmThuocTinh.setRowCount(0);
        for (QuanLyMauSac ql : lst) {
            dtmThuocTinh.addRow(ql.arriveData());
        }
    }

    private QuanLySanPham getSanPham() {
        String ma = txtMaSanPham.getText();
        String ten = txtTenSanPham.getText();
        int trangThai = cbbTrangThaiSp.getSelectedIndex();

        QuanLySanPham qlsp = new QuanLySanPham(null, ma, ten, trangThai);
        return qlsp;
    }

    private void fillTableSanPham(int row) {
        QuanLySanPham qlsp = lstQLSp.get(row);
        jlbId.setText(qlsp.getId());
        txtTenSanPham.setText(qlsp.getTen());
        txtMaSanPham.setText(qlsp.getMa());
        cbbTrangThaiSp.setSelectedIndex(qlsp.getTrangThai());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinCaNhan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinCaNhan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinCaNhan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinCaNhan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDasBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnXoa;
    private javax.swing.JTable TBGioHang;
    private javax.swing.JTable TBGioHangLS;
    private javax.swing.JTable TBHoaDon;
    private javax.swing.JTable TBHoaDonLS;
    private javax.swing.JTable TBSanPham;
    private javax.swing.JButton btAllNv;
    private javax.swing.JButton btAllSanPham;
    private javax.swing.JButton btAnhDaiDien;
    private javax.swing.JButton btBanHang;
    private javax.swing.JButton btHoaDon;
    private javax.swing.JButton btHuyKhuyenMai;
    private javax.swing.JButton btKhachHang;
    private javax.swing.JButton btKhuyenMai;
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btLamMoiThuocTinh;
    private javax.swing.JButton btNhanVien;
    private javax.swing.JButton btSanPham;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btSuaKhachHang;
    private javax.swing.JButton btSuaThuocTinh;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThemKhachHang;
    private javax.swing.JButton btThemKhuyenMai;
    private javax.swing.JButton btThemNhanVien;
    private javax.swing.JButton btThemNhanhChatLieu;
    private javax.swing.JButton btThemNhanhDongSp;
    private javax.swing.JButton btThemNhanhKichCo;
    private javax.swing.JButton btThemNhanhKieuDang;
    private javax.swing.JButton btThemNhanhMauSac;
    private javax.swing.JButton btThemNhanhNhaSanXuat;
    private javax.swing.JButton btThemNhanhSanPham;
    private javax.swing.JButton btThemNhanhThuongHieu;
    private javax.swing.JButton btThemThuocTinh;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btThongKe;
    private javax.swing.JButton btTimKiemMAsp;
    private javax.swing.JButton btTimKiemNgayThongKe;
    private javax.swing.JButton btTimKiemSp;
    private javax.swing.JButton btTimKiemTenKH;
    private javax.swing.JButton btTimKiemTenNV;
    private javax.swing.JButton btTimTheoGiaSanPham;
    private javax.swing.JButton btTimTheoTenSanPham;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaKhachHang;
    private javax.swing.JButton btXoaThuocTinh;
    private javax.swing.JButton btnApDungTienShip;
    private javax.swing.JButton btnGuiHang;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnHuyHoaDonGH;
    private javax.swing.JButton btnNgayHenKhach;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTKSDT;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToan1;
    private javax.swing.JButton btnTimKiemHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton cbbAllKH;
    private javax.swing.JComboBox<String> cbbChucVuNhanVien;
    private javax.swing.JComboBox<String> cbbCtspChatLieu;
    private javax.swing.JComboBox<String> cbbCtspDongSanPham;
    private javax.swing.JComboBox<String> cbbCtspKichCo;
    private javax.swing.JComboBox<String> cbbCtspKieuDang;
    private javax.swing.JComboBox<String> cbbCtspMauSac;
    private javax.swing.JComboBox<String> cbbCtspNhaSanXuat;
    private javax.swing.JComboBox<String> cbbCtspSanPham;
    private javax.swing.JComboBox<String> cbbCtspThuongHieu;
    private javax.swing.JComboBox<String> cbbDanhMucHangHoaThongKe;
    private javax.swing.JComboBox<String> cbbDongSP;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbKichCo;
    private javax.swing.JComboBox<String> cbbLoaiKhuyenMai;
    private javax.swing.JComboBox<String> cbbLocCtspKichCo;
    private javax.swing.JComboBox<String> cbbLocCtspThuongHieu;
    private javax.swing.JComboBox<String> cbbPTTT;
    private javax.swing.JComboBox<String> cbbPTTTLS;
    private javax.swing.JComboBox<String> cbbTenKhuyenMaiSanPhamKhuyenMai;
    private javax.swing.JComboBox<String> cbbTenKieuBanHang;
    private javax.swing.JComboBox<String> cbbTenSanPhamSanPhamKhuyenMai;
    private javax.swing.JComboBox<String> cbbThuocTinhSanPham;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JComboBox<String> cbbTimKiemChucVuNV;
    private javax.swing.JComboBox<String> cbbTimKiemGioiTinhKH;
    private javax.swing.JComboBox<String> cbbTimKiemGioiTinhNV;
    private javax.swing.JComboBox<String> cbbTimKiemTrangThaiKH;
    private javax.swing.JComboBox<String> cbbTimKiemTrangThaiNV;
    private javax.swing.JComboBox<String> cbbTimKiemTrangThaiSp;
    private javax.swing.JComboBox<String> cbbTrangThaiHDLS;
    private javax.swing.JComboBox<String> cbbTrangThaiKhuyenMai;
    private javax.swing.JComboBox<String> cbbTrangThaiNhanVien;
    private javax.swing.JComboBox<String> cbbTrangThaiSanPhamKhuyenMai;
    private javax.swing.JComboBox<String> cbbTrangThaiSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jTienThua;
    private javax.swing.JLabel jTienThuaGiaoHang;
    private javax.swing.JLabel jTimKiemChucVuNV;
    private javax.swing.JLabel jTimKiemGioiTinhKhachHang;
    private javax.swing.JLabel jTimKiemGioiTinhNV;
    private javax.swing.JLabel jTimKiemTrangThaiKH;
    private javax.swing.JLabel jTimKiemTrangThaiNV;
    private javax.swing.JLabel jTimKiemTrangThaiSp;
    private javax.swing.JLabel jTongTien;
    private javax.swing.JLabel jTongTienGiaoHang;
    private javax.swing.JLabel jTongTienGiaoHangLS;
    private com.toedter.calendar.JDateChooser jdcNgayBatDauKm;
    private com.toedter.calendar.JDateChooser jdcNgayHenKhach;
    private com.toedter.calendar.JDateChooser jdcNgayHenKhachLS;
    private com.toedter.calendar.JDateChooser jdcNgayKetThucKm;
    private com.toedter.calendar.JDateChooser jdcNgaySinhKhachHang;
    private com.toedter.calendar.JDateChooser jdcNgaySinhNhanVien;
    private javax.swing.JLabel jlbAnhNhanVien;
    private javax.swing.JLabel jlbChucVuNhanVien;
    private javax.swing.JLabel jlbCtspHinhAnh;
    private javax.swing.JLabel jlbCtspId;
    private javax.swing.JLabel jlbDoanhThu;
    private javax.swing.JLabel jlbId;
    private javax.swing.JLabel jlbIdKhachHang;
    private javax.swing.JLabel jlbIdKhuyenMai;
    private javax.swing.JLabel jlbIdNhanVien;
    private javax.swing.JLabel jlbManHinhChinh;
    private javax.swing.JLabel jlbSoHangHuy;
    private javax.swing.JLabel jlbSoHoaDon;
    private javax.swing.JLabel jlbTrangThaiKhuyenMai;
    private javax.swing.JLabel jlbTrangThaiNhanVIen;
    private javax.swing.JLabel jlbTrangThaiSanPhamKhuyenmai;
    private javax.swing.JPanel jpbSanPhamChiTiet;
    private javax.swing.JPasswordField jpfMatKhau;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JTextPane jtpCtspMoTa;
    private javax.swing.JLabel lblHinhAnhBH;
    private javax.swing.JPanel palGH;
    private javax.swing.JPanel palHD;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlCard5;
    private javax.swing.JPanel pnlCard6;
    private javax.swing.JPanel pnlCard7;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JRadioButton rdbtChatLieu;
    private javax.swing.JRadioButton rdbtDongSanPham;
    private javax.swing.JRadioButton rdbtKichCo;
    private javax.swing.JRadioButton rdbtKieuDang;
    private javax.swing.JRadioButton rdbtMauSac;
    private javax.swing.JRadioButton rdbtNamKhachHang;
    private javax.swing.JRadioButton rdbtNamNhanVien;
    private javax.swing.JRadioButton rdbtNhaSanXuat;
    private javax.swing.JRadioButton rdbtNuKhachHang;
    private javax.swing.JRadioButton rdbtNuNhanVien;
    private javax.swing.JRadioButton rdbtTatCaDoanhThuThongKe;
    private javax.swing.JRadioButton rdbtThuongHieu;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoDangGiaoHang;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbChiTietSanPham;
    private javax.swing.JTable tbDoanhThuThongKe;
    private javax.swing.JTable tbHangHoaHuy;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JTable tbQlSanPham;
    private javax.swing.JTable tbQuanLyNhanVien;
    private javax.swing.JTable tbSanPhamKhuyenMai;
    private javax.swing.JTable tbThuocTinh;
    private javax.swing.JTextField txtCtspGiaBan;
    private javax.swing.JTextField txtCtspGiaNhap;
    private javax.swing.JTextField txtCtspNamBh;
    private javax.swing.JTextField txtCtspSoLuongTon;
    private javax.swing.JTextField txtDaChinh;
    private javax.swing.JTextField txtDaPhu;
    private javax.swing.JTextField txtDeNgoai;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChiGiaoHang;
    private javax.swing.JTextField txtDiaChiKhachHang;
    private javax.swing.JTextField txtDiaChiLS;
    private javax.swing.JTextField txtDiaChiNhanVien;
    private javax.swing.JLabel txtJd;
    private javax.swing.JTextField txtLopLotTrong;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDGiaoHang;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVGiaoHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuocTinh;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtNgayKetThucTaoHoaDon;
    private javax.swing.JTextField txtNgayNhan;
    private javax.swing.JTextField txtNgayNhanLS;
    private javax.swing.JTextField txtNgayShip;
    private javax.swing.JTextField txtNgayShipLS;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayTaoGiaoHang;
    private javax.swing.JTextField txtNgayThanhToan;
    private javax.swing.JTextField txtNgayThanhToanLS;
    private javax.swing.JTextField txtNgaybatDauTaoHoaDon;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDTGiaoHang;
    private javax.swing.JTextField txtSDTLS;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    private javax.swing.JTextField txtSoLuongGh;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTKSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKHGiaoHang;
    private javax.swing.JTextField txtTenKHLS;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenKhuyenMai;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTenTk;
    private javax.swing.JTextField txtTienChuyenKhoan;
    private javax.swing.JTextField txtTienChuyenKhoanLS;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienKhachDuaGiaoHang;
    private javax.swing.JTextField txtTienKhachDuaGiaoHangLS;
    private javax.swing.JTextField txtTienShip;
    private javax.swing.JTextField txtTienShipLS;
    private javax.swing.JTextField txtTimKiemGiaCaoCtsp;
    private javax.swing.JTextField txtTimKiemGiaThapCtsp;
    private javax.swing.JTextField txtTimKiemMaSp;
    private javax.swing.JTextField txtTimKiemSp;
    private javax.swing.JTextField txtTimKiemTenKH;
    private javax.swing.JTextField txtTimKiemTenNV;
    private javax.swing.JTextField txtTimKiemTenSanPham;
    // End of variables declaration//GEN-END:variables
}
