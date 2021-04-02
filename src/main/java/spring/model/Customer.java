package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "khachhang")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
//    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password")
//    @Email(message = "Email should be valid")
    private String password;

    @Column(name = "masokh")
//    @NotNull(message = "Customer code is require")
    private String masoKh;

    @Column(name="hoten")
//    @NotBlank(message = "First name cannot be blank")
    private String hoTen;

    @Column(name = "ngaysinh")
//    @NotNull(message = "Date of birth is require")
    private Date ngaySinh;

        @Column(name="gioi_tinh")
//    @NotBlank(message = "Gender cannot be blank")
    private String gioiTinh;

    @Column(name="quoc_tich")
//    @NotBlank(message = "First name cannot be blank")
    private String quocTich;

    @Column(name = "socmt")
//    @NotNull(message = "Card number is require")
    private String soCmt;

    @Column(name = "ngaycap")
//    @NotNull(message = "Card number is require")
    private Date ngayCap;

    @Column(name = "noicap")
    private String noiCap;

    @Column(name="diachi")
//    @NotBlank(message = "Home number cannot be blank")
    private String diaChi;

    @Column(name = "sodienthoai")
    private String soDt;

    @Column(name = "tinh_trang_hon_nhan")
    private String ttHonnhan;

    @Column(name = "cong_viec")
    private String congViec;

    @Column(name = "thu_nhap")
    private float thuNhap;

    @Column(name="cam_ket")
    private boolean camKet;
}
