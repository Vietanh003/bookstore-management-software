/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CHKB.UI;

import CHKB.DAO.ConnectionToDatabase;
import CHKB.DAO.ManipulationNhanVien;
import CHKB.MODAL.NhanVien;
import CHKB_DESIGN.MessageDialog;
import CHKB_DESIGN.ThongBao;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author caoho
 */
public class frmThemNhanVien extends javax.swing.JFrame {
    ConnectionToDatabase con;
    String duongDanAnh;
    /**
     * Creates new form frmThemNhanVien
     */
    public frmThemNhanVien() {
        initComponents();
        con = new ConnectionToDatabase();
        this.setDefaultCloseOperation(frmThemNhanVien.DISPOSE_ON_CLOSE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
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
        jLabel10 = new javax.swing.JLabel();
        hinhSP = new javax.swing.JLabel();
        txt_hoTen = new CHKB_DESIGN.TextField();
        txt_sdt = new CHKB_DESIGN.TextField();
        txt_cccd = new CHKB_DESIGN.TextField();
        txt_email = new CHKB_DESIGN.TextField();
        ckb_trangThai = new CHKB_DESIGN.JCheckBoxCustom();
        txt_namSinh = new CHKB_DESIGN.TextField();
        btn_them = new CHKB_DESIGN.ButtonGradientRound();
        btn_huyBo = new CHKB_DESIGN.ButtonGradientRound();
        txt_diaChi = new CHKB_DESIGN.TextField();
        cbb_gioiTinh = new CHKB_DESIGN.ComboBoxSuggestion();

        dateChooser1.setForeground(new java.awt.Color(153, 0, 204));
        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(txt_namSinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm mới nhân viên");

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
        jLabel1.setText("Thêm Nhân viên mới");

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

        btn_themAnh.setText("Thêm ảnh nhân viên");
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
        jLabel2.setText("Họ và tên");

        jLabel3.setText("Số điện thoại");

        jLabel4.setText("Số CCCD");

        jLabel5.setText("Email");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Trạng thái");

        jLabel8.setText("Năm sinh");

        jLabel10.setText("Địa chỉ");

        hinhSP.setBackground(new java.awt.Color(255, 255, 255));
        hinhSP.setIcon(new javax.swing.ImageIcon("D:\\mahaCode\\CongNgheJava\\QuanLyBanSach_DoAnJava_CHKB\\QuanLyBanSach_DoAnJava_CHKB\\src\\CHKB_IMAGE\\kinhTruongBo.jpg")); // NOI18N
        hinhSP.setToolTipText("");

        txt_hoTen.setForeground(new java.awt.Color(51, 51, 51));
        txt_hoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoTenActionPerformed(evt);
            }
        });

        txt_sdt.setForeground(new java.awt.Color(51, 51, 51));
        txt_sdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_cccd.setForeground(new java.awt.Color(51, 51, 51));
        txt_cccd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cccdActionPerformed(evt);
            }
        });

        txt_email.setForeground(new java.awt.Color(51, 51, 51));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        ckb_trangThai.setSelected(true);
        ckb_trangThai.setText("Còn làm");
        ckb_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_trangThaiActionPerformed(evt);
            }
        });

        txt_namSinh.setForeground(new java.awt.Color(51, 51, 51));
        txt_namSinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_namSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namSinhActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
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

        txt_diaChi.setForeground(new java.awt.Color(51, 51, 51));
        txt_diaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_diaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diaChiActionPerformed(evt);
            }
        });

        cbb_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ", " " }));
        cbb_gioiTinh.setToolTipText("");
        cbb_gioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_gioiTinhActionPerformed(evt);
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
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_themAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                            .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(23, 23, 23))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_hoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                        .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_namSinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_diaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ckb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))))
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
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_namSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 42, Short.MAX_VALUE))
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
        duongDanAnh = con.chonAnh(this);
        hinhSP.setIcon(new ImageIcon(new ImageIcon(duongDanAnh).getImage().getScaledInstance(hinhSP.getWidth(), hinhSP.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_btn_themAnhActionPerformed

    private void txt_hoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoTenActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void ckb_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckb_trangThaiActionPerformed

    private void txt_namSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namSinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namSinhActionPerformed

    
    public boolean ktEmail(String email)
    {
       return Pattern.compile("^(.+)@(\\S+)$")
      .matcher(email)
      .matches();
    }
    
    public int hopLe(String email, String dienThoai, String soCCCD, String namSinh)
    {
        int loi = 0;
           if(con.ktEmail(email) == false)
           {
               ThongBao t = new ThongBao(this);
               t.showMessage("Thông báo", "Email của bạn không hợp lệ. Vui lòng nhập lại email!");
               loi++;
           }
           if(con.kiemTraSo(dienThoai) == false)
           {
               ThongBao t = new ThongBao(this);
               t.showMessage("Thông báo", "Số điện thoại của bạn không hợp lệ. Vui lòng nhập lại!");
               loi++;
           }
           if(con.kiemTraSo(soCCCD) == false)
           {
               ThongBao t = new ThongBao(this);
               t.showMessage("Thông báo", "Số CCCD của bạn không hợp lệ. Vui lòng nhập lại!");
               loi++;
           }
           if(con.ktNgay(namSinh) == false)
           {
               ThongBao t = new ThongBao(this);
               t.showMessage("Thông báo", "Ngày sinh của bạn không hợp lệ. Vui lòng nhập lại!");
               loi++;
           }
           return loi;
    }
    
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
//       LocalDateTime myDateObj = LocalDateTime.now();
//       DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //String ngayVaoLam = myFormatObj;
       String hoTen = txt_hoTen.getText().trim();
       String dienThoai = txt_sdt.getText().trim();
       String soCCCD = txt_cccd.getText().trim();
       String email = txt_email.getText().trim();
       String namSinh = txt_namSinh.getText().trim();
       String gioiTinh = cbb_gioiTinh.getSelectedItem().toString().trim();
       String diaChi = txt_diaChi.getText().trim();
       String trangThai = "0";
       if(ckb_trangThai.isSelected())
       {
           trangThai = "1";
       }
       String vaiTro = "Nhân viên";
       //Mật khẩu mặc định là số điện thoại tên đăng nhập là họ tên
       
       if(hoTen.length()< 1 || dienThoai.length() < 1 || soCCCD.length() < 1 || email.length() < 1 || namSinh.length() < 1 || gioiTinh.length() < 1 || diaChi.length() < 1)
       {
           ThongBao t = new ThongBao(this);
           t.showMessage("Thông báo", "Vui lòng nhập đầy đủ các trường để thêm!");
       } else {
           if (hopLe(email, dienThoai, soCCCD, namSinh) == 0) {
               ManipulationNhanVien tnv;
               try {
                   tnv = new ManipulationNhanVien();
                   String sql = "{call insertNhanVien(?,?,?,?,?,?,?,?,?,?,?,?)}";
                   NhanVien nv = new NhanVien(hoTen, dienThoai, email, soCCCD, namSinh, gioiTinh, vaiTro, diaChi, dienThoai, duongDanAnh, trangThai, hoTen);
                   if (tnv.Insert(sql, nv) > 0) {
                        MessageDialog lc = new MessageDialog(this);
                        lc.showMessage("Thông báo", "Thêm nhân viên thành công!\nChọn tiếp tục để tiếp tục thêm hoặc thoát để đóng", "Tiếp tục", "Thoát");
                        if(lc.getMessageType()== MessageDialog.MessageType.CANCEL)
                        {
                            this.dispose();
                        }
                        else
                        {
                            xoaTrong();
                        }
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(frmThemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ParseException ex) {
                   Logger.getLogger(frmThemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
    }//GEN-LAST:event_btn_themActionPerformed

        public void xoaTrong()
    {
        txt_hoTen.setText("");
        txt_sdt.setText("");
        txt_cccd.setText("");
        txt_email.setText("");
        txt_namSinh.setText("");
        cbb_gioiTinh.setSelectedIndex(0);
        txt_diaChi.setText("");
        ckb_trangThai.setSelected(true);
    }
    
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

    private void txt_cccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cccdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cccdActionPerformed

    private void txt_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diaChiActionPerformed

    private void cbb_gioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_gioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_gioiTinhActionPerformed

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
            java.util.logging.Logger.getLogger(frmThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThemNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_huyBo;
    private CHKB_DESIGN.ButtonGradientRound btn_them;
    private CHKB_DESIGN.ButtonGradientRound btn_themAnh;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_gioiTinh;
    private CHKB_DESIGN.JCheckBoxCustom ckb_trangThai;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel hinhSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.TextField txt_cccd;
    private CHKB_DESIGN.TextField txt_diaChi;
    private CHKB_DESIGN.TextField txt_email;
    private CHKB_DESIGN.TextField txt_hoTen;
    private CHKB_DESIGN.TextField txt_namSinh;
    private CHKB_DESIGN.TextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
