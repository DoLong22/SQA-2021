async function submit() {
    const masoKh = $('#masokh').val();
    const hoTen = $('#hoten').val();
    const quocTich = $('#quoctich').val();
    const ngaySinh = $('#ngaysinh').val();
    const email = $('#email').val();
    const soCmt = $('#socmt').val();
    const ngayCap = $('#ngaycap').val();
    const noiCap = $('#noicap').val();
    const diaChi = $('#diachi').val();
    const soDt = $('#sodienthoai').val();
    const congViec = $('#congviec').val();
    const thuNhap = $('#thunhap').val();
    const ttHonnhan = $('input[type=radio][name=ttHonnhan]:checked').val();
    const gioiTinh = $('input[type=radio][name=gioiTinh]:checked').val()
    const camKet = $('#camket').val();
    const data = {
        id:5,
        hoTen,
        quocTich,
        ngaySinh,
        gioiTinh,
        email,
        soCmt,
        ngayCap,
        noiCap,
        diaChi,
        soDt,
        ttHonnhan,
        congViec,
        thuNhap,
        camKet,
    }
    console.log(data);
    try {
        const response = await axios({
            method: "put",
            url: "http://localhost:8080/customers",
            data
        })
        console.log(response);
        return response;
    } catch (error) {
        console.log(error);
        return error;
    }
}

async function login(){
        
}