
package CHKB.UI;

import CHKB.DAO.CHKB_KhuyenMaiManipulation;
import CHKB.DAO.CHKB_NhaXuatBanManipulation;
import CHKB.DAO.CHKB_SachManipulation;
import CHKB.DAO.CHKB_TheLoaiManipulation;
import CHKB.DAO.ConnectionToDatabase;
import CHKB.MODAL.KhuyenMai;
import CHKB.MODAL.NhaXuatBan;
import CHKB.MODAL.Sach;
import CHKB.MODAL.TheLoai;
import CHKB_DESIGN.MessageDialog;
import CHKB_DESIGN.ThongBao;
import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author caoho
 */
public class frmCapNhatSanPham extends javax.swing.JFrame {

    String duongDanAnh = "";
    Sach sach;

    public frmCapNhatSanPham(Sach thongTinSach) throws SQLException {
        initComponents();
        loadAllCombobox();
        sach = thongTinSach;
        loadAllCombobox();
        anhXaDuLieu();
        this.setDefaultCloseOperation(frmCapNhatSanPham.DISPOSE_ON_CLOSE);
    }
    
    public void anhXaDuLieu()
    {
        hinhSP.setIcon(new ImageIcon(new ImageIcon(sach.getHinh()).getImage().getScaledInstance(hinhSP.getWidth(), hinhSP.getHeight(), Image.SCALE_SMOOTH)));
        txt_tenSach.setText(sach.getTenSach());
        txt_giaBan.setText(sach.getGiaBan());
        txt_soLuong.setText(sach.getSoLuong());
        txt_tap.setText(sach.getTap());
//        if (sach.getTrangThai().equals("1")) {
//            ckb_hienThi.setSelected(true);
//        } else {
//            ckb_hienThi.setSelected(false);
//        }
         if(sach.getTrangThai().equalsIgnoreCase("Có bán"))
        {
            ckb_hienThi.setSelected(true);
        }
        txt_tacGia.setText(sach.getTacGia());
        txt_viTri.setText(sach.getViTri());
        cbb_theLoai.setSelectedItem(sach.getMaTheLoai());
        cbb_nhaXuatBan.setSelectedItem(sach.getMaNhaXuatBan());
        if (sach.getMaKhuyenMai()== null) {
            cbb_khuyenMai.setSelectedIndex(0);
        } else {
            for (KhuyenMai km : lstKhuyenMai) {
                if (km.getMaKhuyenMai().equalsIgnoreCase(sach.getMaKhuyenMai())) { //mã không trùng
                    cbb_khuyenMai.setSelectedItem(km.getTenChuongTrinh());
                    break;
                }
            }
        }
    }

    private frmCapNhatSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void loadAllCombobox() throws SQLException
    {
        loadTableNhaXuatBan();
        loadTableTheLoai();
        loadTableKhuyenMai();
    }
    
    public boolean kiemTraSo(String chuoi)
    {
        boolean kq = false;
        try
        {
            int so = Integer.parseInt(chuoi);
            if(so > 0)
                kq = true;
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }
    
    List<KhuyenMai> lstKhuyenMai;
    public void loadTableKhuyenMai() throws SQLException
    {
        lstKhuyenMai = new ArrayList<>();
        CHKB_KhuyenMaiManipulation getData = new CHKB_KhuyenMaiManipulation();
        lstKhuyenMai = getData.getAllData();
        for(KhuyenMai data : lstKhuyenMai)
        {
            cbb_khuyenMai.addItem(data.getTenChuongTrinh());
        }
    } 

    List<NhaXuatBan> lstNhaXuatBan;
   public void loadTableNhaXuatBan() throws SQLException
    {
        lstNhaXuatBan = new ArrayList<>();
        CHKB_NhaXuatBanManipulation getData = new CHKB_NhaXuatBanManipulation();
        lstNhaXuatBan = getData.getAllData();
        for(NhaXuatBan data : lstNhaXuatBan)
        {
            cbb_nhaXuatBan.addItem(data.getTenNhaXuatBan());
        }
    }
   
   List<TheLoai> lstTheLoai;
   public void loadTableTheLoai() throws SQLException
    {
        lstTheLoai = new ArrayList<>();
        CHKB_TheLoaiManipulation getData = new CHKB_TheLoaiManipulation();
        lstTheLoai = getData.getAllData();
        for(TheLoai data : lstTheLoai)
        {
            cbb_theLoai.addItem(data.getTenTheLoai());
        }
    }
   
   public void chonAnh()
    {
        JFileChooser jfileChooser = new JFileChooser();
        jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(jfileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            duongDanAnh = jfileChooser.getSelectedFile().getAbsolutePath();
            hinhSP.setIcon(new ImageIcon(new ImageIcon(duongDanAnh).getImage().getScaledInstance(hinhSP.getWidth(), hinhSP.getHeight(), Image.SCALE_SMOOTH)));
        }
    }
   
   public boolean kiemTraRong()
    {
        String tenSach = txt_tenSach.getText().trim();
        String giaBan = txt_giaBan.getText().trim();
        String soLuong = txt_soLuong.getText().trim();
        String tap = txt_tap.getText().trim();
        String trangThai = ckb_hienThi.getText().trim();
        String tacGia = txt_tacGia.getText().trim();
         String viTri = txt_viTri.getText().trim();
        int theLoai = cbb_theLoai.getSelectedIndex();
        int nhaXuatBan = cbb_nhaXuatBan.getSelectedIndex();
        boolean kq = true;
        if(tenSach.length()<1 || giaBan.length() < 1 || soLuong.length() < 1 || tap.length() < 1 || tacGia.length() < 1 || viTri.length() < 1 || theLoai < 0 || nhaXuatBan < 0 )//|| khuyenMai < 0
        {
            kq = false;
        }
        if (kiemTraSo(soLuong) == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Số lượng phải là số và lớn hơn 0");
            kq = false;
        }
        if (kiemTraSo(giaBan) == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Giá bán phải là số và lớn hơn 0");
            kq = false;
        }
        return kq;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoundGradient2 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient1 = new CHKB_DESIGN.PanelRoundGradient();
        jLabel1 = new javax.swing.JLabel();
        btn_themAnh = new CHKB_DESIGN.ButtonGradientRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hinhSP = new javax.swing.JLabel();
        txt_tenSach = new CHKB_DESIGN.TextField();
        txt_giaBan = new CHKB_DESIGN.TextField();
        txt_soLuong = new CHKB_DESIGN.TextField();
        txt_tap = new CHKB_DESIGN.TextField();
        ckb_hienThi = new CHKB_DESIGN.JCheckBoxCustom();
        txt_tacGia = new CHKB_DESIGN.TextField();
        txt_viTri = new CHKB_DESIGN.TextField();
        cbb_theLoai = new CHKB_DESIGN.ComboBoxSuggestion();
        cbb_nhaXuatBan = new CHKB_DESIGN.ComboBoxSuggestion();
        cbb_khuyenMai = new CHKB_DESIGN.ComboBoxSuggestion();
        btn_them = new CHKB_DESIGN.ButtonGradientRound();
        btn_huyBo = new CHKB_DESIGN.ButtonGradientRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhật sản phẩm");

        panelRoundGradient2.setColorEnd(new java.awt.Color(254, 254, 254));
        panelRoundGradient2.setColorStart(new java.awt.Color(254, 254, 254));
        panelRoundGradient2.setRoundBottomLeft(0);
        panelRoundGradient2.setRoundBottomRight(0);
        panelRoundGradient2.setRoundTopLeft(0);
        panelRoundGradient2.setRoundTopRight(0);

        panelRoundGradient1.setColorEnd(new java.awt.Color(153, 0, 204));
        panelRoundGradient1.setColorStart(new java.awt.Color(51, 255, 255));
        panelRoundGradient1.setRoundBottomLeft(10);
        panelRoundGradient1.setRoundBottomRight(10);
        panelRoundGradient1.setRoundTopLeft(10);
        panelRoundGradient1.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cập nhật sản phẩm");

        javax.swing.GroupLayout panelRoundGradient1Layout = new javax.swing.GroupLayout(panelRoundGradient1);
        panelRoundGradient1.setLayout(panelRoundGradient1Layout);
        panelRoundGradient1Layout.setHorizontalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRoundGradient1Layout.setVerticalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_themAnh.setText("Thêm ảnh sản phẩm");
        btn_themAnh.setColor1(new java.awt.Color(51, 255, 255));
        btn_themAnh.setColor2(new java.awt.Color(0, 255, 153));
        btn_themAnh.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_themAnh.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_themAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themAnhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên sách");

        jLabel3.setText("Giá bán");

        jLabel4.setText("Số lượng");

        jLabel5.setText("Tập");

        jLabel6.setText("Vị trí");

        jLabel7.setText("Trạng thái");

        jLabel8.setText("Tác giả");

        jLabel9.setText("Khuyến mãi");

        jLabel10.setText("Thể loại");

        jLabel11.setText("Nhà xuất bản");

        hinhSP.setBackground(new java.awt.Color(255, 255, 255));
        hinhSP.setIcon(new javax.swing.ImageIcon("D:\\mahaCode\\CongNgheJava\\QuanLyBanSach_DoAnJava_CHKB\\QuanLyBanSach_DoAnJava_CHKB\\src\\CHKB_IMAGE\\kinhTruongBo.jpg")); // NOI18N
        hinhSP.setToolTipText("");

        txt_tenSach.setForeground(new java.awt.Color(51, 51, 51));
        txt_tenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSachActionPerformed(evt);
            }
        });

        txt_giaBan.setForeground(new java.awt.Color(51, 51, 51));
        txt_giaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaBanActionPerformed(evt);
            }
        });

        txt_soLuong.setForeground(new java.awt.Color(51, 51, 51));
        txt_soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        txt_tap.setForeground(new java.awt.Color(51, 51, 51));
        txt_tap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tapActionPerformed(evt);
            }
        });

        ckb_hienThi.setText("Hiển thị");
        ckb_hienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_hienThiActionPerformed(evt);
            }
        });

        txt_tacGia.setForeground(new java.awt.Color(51, 51, 51));
        txt_tacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tacGiaActionPerformed(evt);
            }
        });

        txt_viTri.setForeground(new java.awt.Color(51, 51, 51));
        txt_viTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_viTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_viTriActionPerformed(evt);
            }
        });

        cbb_theLoai.setToolTipText("");

        cbb_nhaXuatBan.setToolTipText("");

        cbb_khuyenMai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Không có" }));
        cbb_khuyenMai.setToolTipText("");

        btn_them.setText("Cập nhật sản phẩm");
        btn_them.setColor1(new java.awt.Color(51, 255, 255));
        btn_them.setColor2(new java.awt.Color(0, 255, 153));
        btn_them.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_them.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_huyBo.setText("Hủy bỏ");
        btn_huyBo.setColor1(new java.awt.Color(255, 0, 153));
        btn_huyBo.setColor2(new java.awt.Color(204, 0, 51));
        btn_huyBo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_huyBo.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))
                                .addGap(10, 10, 10)
                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_tap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_giaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ckb_hienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_tacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_viTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbb_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbb_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ckb_hienThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_viTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cbb_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themAnhActionPerformed
        chonAnh();
    }//GEN-LAST:event_btn_themAnhActionPerformed

    private void txt_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSachActionPerformed

    private void txt_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaBanActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_tapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tapActionPerformed

    private void ckb_hienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_hienThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckb_hienThiActionPerformed

    private void txt_tacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tacGiaActionPerformed

    private void txt_viTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_viTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_viTriActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if(kiemTraRong() == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng nhập đúng và đầy đủ nội dung để thêm!");
        } else {
            String tenSach = txt_tenSach.getText().trim();
            String giaBan = txt_giaBan.getText().trim();
            String soLuong = txt_soLuong.getText().trim();
            String tap = txt_tap.getText().trim();

            String trangThai = "0";
            if(ckb_hienThi.isSelected())
            {
                trangThai = "1";
            }
            String tacGia = txt_tacGia.getText().trim();
            String viTri = txt_viTri.getText().trim();
            String theLoai = lstTheLoai.get(cbb_theLoai.getSelectedIndex()).getMaTheLoai();
            String nhaXuatBan = lstNhaXuatBan.get(cbb_nhaXuatBan.getSelectedIndex()).getMaNhaXuatBan();

            String khuyenMai = "null";
            if(cbb_khuyenMai.getSelectedIndex() > 0) {
                for(KhuyenMai km : lstKhuyenMai)
                {
                    if(cbb_khuyenMai.getSelectedItem().equals(km.getTenChuongTrinh()))
                    {
                        khuyenMai = km.getMaKhuyenMai();
                        break;
                    }
                }
            }

            if (kiemTraSo(soLuong) && kiemTraSo(giaBan)) {

                String sql = "{call updateSach(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)}";
                ConnectionToDatabase con = new ConnectionToDatabase();
                try {
                    CHKB_SachManipulation tt = new CHKB_SachManipulation();
                    int kq = 0;
//                    JOptionPane.showConfirmDialog(null, duongDanAnh);
                    if(duongDanAnh.isEmpty())
                    {
                        duongDanAnh = sach.getHinh();
                    }
                    kq = tt.Update(sql, tenSach, giaBan, soLuong, tap, duongDanAnh, viTri, trangThai, tacGia, khuyenMai, theLoai, nhaXuatBan, sach.getMaSach());
                    if (kq > 0) {
                        MessageDialog lc = new MessageDialog(this);
                        lc.showMessage("Thông báo", "Cập nhật thành công!\nChọn tiếp tục để tiếp tục cập nhật hoặc thoát để đóng", "Tiếp tục", "Thoát");
                        if(lc.getMessageType()== MessageDialog.MessageType.CANCEL)
                        {
                            this.dispose();
                        }
                    }
                } catch (SQLException ex) {
//                    Logger.getLogger(frmThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed
        MessageDialog luaChon = new MessageDialog(this);
        luaChon.showMessage("Thông báo", "Bạn có chắc chắn muốn hủy!");
        if(luaChon.getMessageType()== MessageDialog.MessageType.OK)
        {
            //            frmLogin f = new frmLogin();
            this.dispose();
            //            f.setVisible(true);
        }
    }//GEN-LAST:event_btn_huyBoActionPerformed

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
            java.util.logging.Logger.getLogger(frmCapNhatSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCapNhatSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_huyBo;
    private CHKB_DESIGN.ButtonGradientRound btn_them;
    private CHKB_DESIGN.ButtonGradientRound btn_themAnh;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_khuyenMai;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_nhaXuatBan;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_theLoai;
    private CHKB_DESIGN.JCheckBoxCustom ckb_hienThi;
    private javax.swing.JLabel hinhSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.TextField txt_giaBan;
    private CHKB_DESIGN.TextField txt_soLuong;
    private CHKB_DESIGN.TextField txt_tacGia;
    private CHKB_DESIGN.TextField txt_tap;
    private CHKB_DESIGN.TextField txt_tenSach;
    private CHKB_DESIGN.TextField txt_viTri;
    // End of variables declaration//GEN-END:variables
}
