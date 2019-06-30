/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket.barang;

import supermarket.anggota.*;
import supermarket.karyawan.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import supermarket.FormAnggota;
import supermarket.barang.FormBarang;
import supermarket.jamkerja.FormJamKerja;
import supermarket.suplier.FormSuplier;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class FormBuangBarang extends javax.swing.JFrame {

    Connection con;
    ResultSet RsKaryawan;
    Statement stm; 
    /** Creates new form FormKaryawan */
    public FormBuangBarang() {
        initComponents();
        open_db();
        setField();
    }
    private void open_db(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    private void setField(){
        //Menyiapkan id karyawan baru
        try{
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan order by id_karyawan DESC");
            if(RsKaryawan.next()){
                String id=Integer.toString(RsKaryawan.getInt("id_karyawan")+1);
                txtidkaryawan.setText(id);
                
            }else txtidkaryawan.setText("1");            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        //Mengkosongkan nama, alamat, kota, dan no telepon
        txtnama.setText("");
        txtalamat.setText("");
        txtkota.setText("");
        txtnotelp.setText("");
    }
    private boolean isEditField(){
        //Fungsi untuk mengembalikan nilai true jika ada perubahan data
        if(txtnama.getText().equals("")&&txtalamat.getText().equals("")
                &&txtkota.getText().equals("")&&txtnotelp.getText().equals("")) return false;
        else return true;
    }
    private boolean checkEmptyField(){
        //Fungsi untuk mengembalikan nilai true jika ada field karyawan baru yang kosong
        if(txtnama.getText().equals("")||txtalamat.getText().equals("")
                ||txtkota.getText().equals("")||txtnotelp.getText().equals("")) return true;
        else return false;
    }
    private void addNewEmployee(String nama, String alamat, String kota, String no_telp){
        //Prosedur untuk menambakan data karyawan baru ke database karyawan
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "karyawan(id_karyawan, nama_karyawan, almt_karyawan, kota_karyawan, notelp_karyawan) "
                    + "VALUES (NULL,'"+nama+"', '"+alamat+"', '"+kota+"', '"+no_telp+"')");    
            //Memberitahu jika penambahan karyawan baru berhasil
            JOptionPane.showConfirmDialog(null, "Karyawan baru berhasil ditambahkan!", "Informasi", JOptionPane.DEFAULT_OPTION);
            //Menyiapkan ulang textfield karyawan
            setField();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbnmSuplier = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        Psamping = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblSuplier = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblBarang = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblKaryawan = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblAnggota = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblLaporan = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblJamKerja = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTambKaryawan = new javax.swing.JLabel();
        lblidkaryawan = new javax.swing.JLabel();
        lblnmkaryawan = new javax.swing.JLabel();
        lblalamat = new javax.swing.JLabel();
        lblkota = new javax.swing.JLabel();
        btntambah = new javax.swing.JToggleButton();
        btnreset = new javax.swing.JToggleButton();
        lblkembali = new javax.swing.JLabel();
        cbnmKaryawan = new javax.swing.JComboBox<>();
        txtidbarang = new javax.swing.JTextField();
        txtidkaryawan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        datetglpesan = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtbuang = new javax.swing.JTextField();
        cbnamabarang = new javax.swing.JComboBox<>();
        txtjmlbuang = new javax.swing.JTextField();

        cbnmSuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnmSuplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Suplier" }));
        cbnmSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnmSuplierActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        Psamping.setBackground(new java.awt.Color(254, 151, 114));
        Psamping.setPreferredSize(new java.awt.Dimension(160, 650));

        jPanel5.setBackground(new java.awt.Color(254, 151, 114));

        lblSuplier.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSuplier.setForeground(new java.awt.Color(52, 17, 9));
        lblSuplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSuplier.setText("Suplier");
        lblSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuplierMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(52, 17, 9));

        lblBarang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblBarang.setForeground(new java.awt.Color(254, 151, 114));
        lblBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBarang.setText("Barang");
        lblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(254, 151, 114));

        lblKaryawan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKaryawan.setForeground(new java.awt.Color(52, 17, 9));
        lblKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKaryawan.setText("Karyawan");
        lblKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKaryawanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(254, 151, 114));

        lblAnggota.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnggota.setForeground(new java.awt.Color(52, 17, 9));
        lblAnggota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnggota.setText("Anggota");
        lblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnggotaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblAnggota)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblAnggota)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(254, 151, 114));

        lblLaporan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(52, 17, 9));
        lblLaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporan.setText("Laporan");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLaporan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLaporan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(254, 151, 114));

        lblJamKerja.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblJamKerja.setForeground(new java.awt.Color(52, 17, 9));
        lblJamKerja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJamKerja.setText("Jam Kerja");
        lblJamKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJamKerjaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJamKerja)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJamKerja)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PsampingLayout = new javax.swing.GroupLayout(Psamping);
        Psamping.setLayout(PsampingLayout);
        PsampingLayout.setHorizontalGroup(
            PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PsampingLayout.createSequentialGroup()
                .addGroup(PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PsampingLayout.setVerticalGroup(
            PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsampingLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 170, Short.MAX_VALUE))
        );

        jPanel1.add(Psamping);

        jPanel3.setBackground(new java.awt.Color(255, 229, 220));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 0));

        lblTambKaryawan.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTambKaryawan.setForeground(new java.awt.Color(253, 77, 12));
        lblTambKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTambKaryawan.setText("Pembuangan Barang");

        lblidkaryawan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblidkaryawan.setText("ID Pembuangan");

        lblnmkaryawan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnmkaryawan.setText("ID Barang");

        lblalamat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblalamat.setText("Nama Barang");

        lblkota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkota.setText("ID Karyawan");

        btntambah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btntambah.setText("Buang");
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });

        lblkembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblkembali.setText("< Kembali");
        lblkembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkembaliMouseClicked(evt);
            }
        });

        cbnmKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnmKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Karyawan" }));
        cbnmKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnmKaryawanActionPerformed(evt);
            }
        });

        txtidbarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidbarang.setEnabled(false);
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });

        txtidkaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidkaryawan.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 21, 9));
        jLabel3.setText("Nama Karyawan");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 21, 9));
        jLabel11.setText("Tgl Buang");

        datetglpesan.setDateFormatString("d MMM yyyy");
        datetglpesan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 21, 9));
        jLabel12.setText("Jumlah Jumlah Buang");

        txtbuang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbuang.setEnabled(false);

        cbnamabarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnamabarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtjmlbuang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTambKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblkembali))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblidkaryawan)
                            .addComponent(lblnmkaryawan)
                            .addComponent(lblalamat)
                            .addComponent(lblkota)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datetglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbuang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtjmlbuang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblkembali)
                .addGap(75, 75, 75)
                .addComponent(lblTambKaryawan)
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidkaryawan)
                    .addComponent(txtbuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnmkaryawan)
                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblalamat)
                    .addComponent(cbnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkota)
                    .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbnmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(datetglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtjmlbuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnreset))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
            setField(); //Menyiapkan ulangsemua textfield jika tombol reset diklik
    }//GEN-LAST:event_btnresetMouseClicked

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
        if(checkEmptyField()) JOptionPane.showMessageDialog(this, "Tolong lengkapi data karyawan baru"); //Mengecek data kosong pada data karyawan baru
        else{
            // Menambahkan karyawan baru ke database sesuai data yang diisikan
            addNewEmployee(txtnama.getText(), txtalamat.getText(), txtkota.getText(), txtnotelp.getText());            
        }        
    }//GEN-LAST:event_btntambahMouseClicked

    private void lblSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuplierMouseClicked
        this.setVisible(false);
        new FormSuplier().setVisible(true);
    }//GEN-LAST:event_lblSuplierMouseClicked

    private void lblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangMouseClicked
        this.setVisible(false);
        new FormBarang().setVisible(true);
    }//GEN-LAST:event_lblBarangMouseClicked

    private void lblKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaryawanMouseClicked
        this.setVisible(false);
        new FormKaryawan().setVisible(true);
    }//GEN-LAST:event_lblKaryawanMouseClicked

    private void lblJamKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJamKerjaMouseClicked
        this.setVisible(false);
        new FormJamKerja().setVisible(true);
    }//GEN-LAST:event_lblJamKerjaMouseClicked

    private void lblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnggotaMouseClicked
        this.setVisible(false);
        new FormAnggota().setVisible(true);
    }//GEN-LAST:event_lblAnggotaMouseClicked

    private void lblkembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkembaliMouseClicked
        // TODO add your handling code here:
        if(!isEditField()){        
            this.setVisible(false);
            new FormKaryawan().setVisible(true);
        }
        else{
            String[] pilihan= new String[2];
            pilihan[0]="Ya";
            pilihan[1]="Tidak";       
            int pilih=JOptionPane.showOptionDialog(this, "Apa Anda yakin ingin kembali?\nJika Anda mengklik \"Yes\" maka data yang Anda inputkan akan tidak ditambahkan.","Kembali", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,pilihan,null);
            if(JOptionPane.YES_OPTION==pilih){
                this.setVisible(false);
                new FormKaryawan().setVisible(true);
            }
        }
    }//GEN-LAST:event_lblkembaliMouseClicked

    private void cbnmKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnmKaryawanActionPerformed
        // TODO add your handling code here:
        setIdKaryawan();
    }//GEN-LAST:event_cbnmKaryawanActionPerformed

    private void cbnmSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnmSuplierActionPerformed
        // TODO add your handling code here:
        setIdSuplier();
    }//GEN-LAST:event_cbnmSuplierActionPerformed

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidbarangActionPerformed
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormBuangBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBuangBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBuangBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBuangBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBuangBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JToggleButton btnreset;
    private javax.swing.JToggleButton btntambah;
    private javax.swing.JComboBox<String> cbnamabarang;
    private javax.swing.JComboBox<String> cbnmKaryawan;
    private javax.swing.JComboBox<String> cbnmSuplier;
    private com.toedter.calendar.JDateChooser datetglpesan;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAnggota;
    private javax.swing.JLabel lblBarang;
    private javax.swing.JLabel lblJamKerja;
    private javax.swing.JLabel lblKaryawan;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblSuplier;
    private javax.swing.JLabel lblTambKaryawan;
    private javax.swing.JLabel lblalamat;
    private javax.swing.JLabel lblidkaryawan;
    private javax.swing.JLabel lblkembali;
    private javax.swing.JLabel lblkota;
    private javax.swing.JLabel lblnmkaryawan;
    private javax.swing.JTextField txtbuang;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtjmlbuang;
    // End of variables declaration//GEN-END:variables

}
