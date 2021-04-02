create table if not exists users(
                      id int auto_increment primary key,
                      email varchar(255),
                      password varchar(11),
                      masokh varchar(255),
                      hoten varchar(255),
                      ngaysinh date,
                      gioi_tinh varchar(50),
                      quoc_tich varchar(100),
                      socmt varchar(15),
                      ngaycap date,
                      noicap varchar(255),
                      diachi varchar(255),
                      sodienthoai varchar(12),
                      tinh_trang_hon_nhan varchar(50),
                      cong_viec varchar(100),
                      thu_nhap float,
                      cam_ket boolean
);