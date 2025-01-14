/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.phong;
import service.PhongSV;

/**
 *
 * @author Admin
 */
public class QuanLyPhong extends javax.swing.JFrame {

    //maphong, tenphong, loaiphong, giaphong, trangthai, ghichu
    PhongSV pser = new PhongSV();
    String[] colums = {
        "Mã Phòng", "Tên Phòng", "Loại Phòng", "Giá Phòng", "Trạng thái", "Ghi chú"
    };
    DefaultTableModel model = new DefaultTableModel(colums, 0);

    /**
     * Creates new form QuanLyPhong
     */
    public QuanLyPhong() {
        initComponents();
        tablephong.setModel(model);
        rdcon.setSelected(true);

        btnluu.setEnabled(false);
        btnsua.setEnabled(false);
        btnxoa.setEnabled(false);

        filltable(pser.getAllph());
        this.setLocationRelativeTo(null);
    }
    private int index = -1;

    void filltable(List<phong> list) {
        model.setRowCount(0);
        for (phong ph : list) {
            model.addRow(ph.torow());
        }
        index = -1;
    }

    void loadform(int inde) {
        txtma.setText(tablephong.getValueAt(inde, 0).toString());
        txtten.setText(tablephong.getValueAt(inde, 1).toString());
        cbphong.setSelectedItem(tablephong.getValueAt(inde, 2).toString());
        txtgia.setText(tablephong.getValueAt(inde, 3).toString());
        switch ((int) tablephong.getValueAt(inde, 4)) {
            case 1 ->
                rdhetphong.setSelected(true);
            case 0 ->
                rdcon.setSelected(true);
            default ->
                throw new AssertionError();
        }
        txtghichu.setText(tablephong.getValueAt(inde, 5).toString());
    }

    void loadform1(phong ph) {
        txtma.setText(ph.getMaPhong());
        txtten.setText(ph.getTenPhong());
        cbphong.setSelectedItem(ph.getLoaiPhong());
        txtgia.setText(String.valueOf(ph.getGiaPhong()));
        switch (ph.getTrangThai()) {
            case 1 ->
                rdhetphong.setSelected(true);
            case 0 ->
                rdcon.setSelected(true);
            default ->
                throw new AssertionError();
        }
        txtghichu.setText(ph.getGhiChu());
    }

    void loadtrue() {
        txtghichu.setEnabled(true);
        txtgia.setEnabled(true);
        txtma.setEnabled(true);
        txtten.setEnabled(true);
        rdcon.setEnabled(true);
        rdhetphong.setEnabled(true);
        cbphong.setEnabled(true);
    }

    void loadfalse() {
        txtghichu.setEnabled(false);
        txtgia.setEnabled(false);
        txtma.setEnabled(false);
        txtten.setEnabled(false);
        rdcon.setEnabled(false);
        rdhetphong.setEnabled(false);
        cbphong.setEnabled(false);
    }

    phong getform() {
        //maphong, tenphong, loaiphong, giaphong, trangthai, ghichu
        String ma = txtma.getText();
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã !", "Lỗi thiếu thông tin !", 3);
            return null;
        }
        String ten = txtten.getText();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên phòng !", "Lỗi thiếu thông tin !", 3);
            return null;
        }
        String loaiPhong = (String) cbphong.getSelectedItem();
        if (cbphong.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Chọn loại phòng !", "Lỗi thiếu thông tin !", 3);
            return null;
        }
        int giaPhong = -1;
        try {
            giaPhong = Integer.parseInt(txtgia.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào 1 số !", "Lỗi thiếu thông tin !", 3);
            return null;
        }
        if (txtgia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập giá !", "Lỗi thiếu thông tin !", 3);
            return null;
        } else if (giaPhong <= 0) {
            JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0!", "Lỗi thiếu Sai Định dạng!", 3);
            return null;
        }
        int tt = 0;
        if (rdcon.isSelected()) {
            tt = 0;
        } else {
            tt = 1;
        }
        String ghichu = txtghichu.getText();
        return new phong(ma, ten, loaiPhong, giaPhong, tt, ghichu);

    }

    void resetForm() {
        loadtrue();
        txtghichu.setText("");
        txtgia.setText("");
        txtma.setText("");
        txtten.setText("");
        cbphong.setSelectedIndex(0);
        rdcon.setSelected(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        cbphong = new javax.swing.JComboBox<>();
        txtgia = new javax.swing.JTextField();
        txtghichu = new javax.swing.JTextField();
        btnnew = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        rdcon = new javax.swing.JRadioButton();
        rdhetphong = new javax.swing.JRadioButton();
        btnsua = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablephong = new javax.swing.JTable();
        btnthoat = new javax.swing.JButton();
        btntimkiem = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Mã Phòng:");

        jLabel2.setText("Tên Phòng:");

        jLabel3.setText("Loại Phòng:");

        jLabel4.setText("Trạng thái:");

        jLabel5.setText("Ghi Chú:");

        jLabel6.setText("Giá Phòng:");

        cbphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Loại Phòng", "Phòng Đơn", "Phòng Đôi", "Phòng Ba", "Phòng Massage", "Phòng Thường", "Phòng Vip" }));

        btnnew.setText("New");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnluu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save as.png"))); // NOI18N
        btnluu.setText("Lưu");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdcon);
        rdcon.setText("Trống");

        buttonGroup1.add(rdhetphong);
        rdhetphong.setText("Đã có người ở");

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtgia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtghichu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdhetphong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbphong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnluu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(160, 160, 160)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnxoa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(rdcon)
                                    .addComponent(rdhetphong)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnsua)
                                        .addGap(18, 18, 18)))
                                .addComponent(btnluu)
                                .addGap(3, 3, 3)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quản Lý Phòng");

        tablephong.setModel(new javax.swing.table.DefaultTableModel(
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
        tablephong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablephongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablephongMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablephong);

        btnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Log out.png"))); // NOI18N
        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthoat)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntimkiem)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntimkiem)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthoat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablephongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablephongMouseClicked
        index = tablephong.getSelectedRow();
        if (index >= 0) {
            loadform(index);
            btnsua.setEnabled(true);
            btnxoa.setEnabled(true);

            loadfalse();
            txtma.setEnabled(false);
        }
    }//GEN-LAST:event_tablephongMouseClicked

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        txtma.setEditable(true);
        resetForm();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        index = tablephong.getSelectedRow();
        phong kh = getform();
        if (kh != null) {
            if (index >= 0) {
                int h = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Sửa Phòng này không ?", "Hỏi !", JOptionPane.YES_NO_CANCEL_OPTION, 3);
                if (h == 0) {
                    String ma = tablephong.getValueAt(index, 0).toString();
                    int x = pser.updatePH(ma, kh);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(this, "Sửa Thất bại !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa Thành công !");
                        filltable(pser.getAllph());
                        btnluu.setEnabled(false);
                        btnsua.setEnabled(false);
                        btnxoa.setEnabled(false);
                        loadtrue();
                        resetForm();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy sửa!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn Dòng muốn sửa !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất bại !");
        }
    }//GEN-LAST:event_btnluuActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        phong kh = getform();
        if (kh != null) {
            List<phong> lit = pser.kiemtraPH(kh.getMaPhong());
            if (lit != null && !lit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã đã được sử dụng vui lòng chọn mã khác !", "Trùng lặp dữ liệu", 2);
            } else {
                int h = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không ?", "Thoát !", JOptionPane.YES_NO_CANCEL_OPTION, 3);
                if (h == 0) {
                    int x = pser.insertPH(kh);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(this, "Thêm Thất bại !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm Thành công !");
                        filltable(pser.getAllph());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất bại !");
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        index = tablephong.getSelectedRow();
        if (index >= 0) {
            String ma = tablephong.getValueAt(index, 0).toString();
            int h = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phòng này\n và duổi toàn bộ Người trong phòng này ra không ?");
            if (h == 0) {
                int te = pser.deletehd(ma);
                int x = pser.deletePH(ma);
                if (x == 0) {
                    JOptionPane.showMessageDialog(this, "Xoa Thất bại !");
                } else {
                    JOptionPane.showMessageDialog(this, "Đã xóa thành công Khách hàng này và " + te + " hóa đơn của vị khách này !");
                    filltable(pser.getAllph());
                    btnluu.setEnabled(false);
                    btnsua.setEnabled(false);
                    btnxoa.setEnabled(false);
                    resetForm();
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn Dòng muốn xoa");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String ma = JOptionPane.showInputDialog(this, "Nhập mã cần tìm ", "Tìm kiếm theo mã .", 3);
        if (ma != null && ma.length() > 0) {
            List<phong> list = pser.kiemtraPH(ma);
            filltable(list);
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy Phòng ");
            } else {
                loadform1(list.get(0));
            }
        }

    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        int h = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không ?", "Thoát !", JOptionPane.YES_NO_CANCEL_OPTION, 3);
        viewQuanLy kh = new viewQuanLy();
        kh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        loadtrue();
        txtma.setEnabled(false);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tablephongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablephongMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablephongMouseEntered

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
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbphong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdcon;
    private javax.swing.JRadioButton rdhetphong;
    private javax.swing.JTable tablephong;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
