package spring.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class DeclareInformation {
    private String hoTen;

    private String cardNumber;

    private Date ngaySinh;

    private String email;

    private String soNha;

    private String phuongXa;

    private String quanHuyen;

    private String tinhThanhpho;
}
