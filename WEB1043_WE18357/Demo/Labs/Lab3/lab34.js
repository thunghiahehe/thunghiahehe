var toanHang1 = 0;
var toanHang2 = 0;
var toanTu;
var trangThai = 0;
var ketQuaPhepToan = 0;
//nếu trạng thái = 0, đang chờ nhập toán hạng 1
//nếu trạng thái = 1, đang chờ nhập toán hạng 2

function phimSo (so) {
    if (trangThai == 0) {
        toanHang1 = toanHang1 * 10 + so;
        console.log(toanHang1);
    }  else {
        toanHang2 = toanHang2 * 10 + so;
        console.log(toanHang2);
    }
        
}

function phepToan (pt) {
    if (trangThai == 0) {
        trangThai = 1;
        toanTu = pt;
    }
}

function tinhToan() {
    if (trangThai = 1) {
        //tính đi
        switch (toanTu) {
            case '+':
                ketQuaPhepToan = toanHang1+toanHang2;
                break;
            case '-':
                ketQuaPhepToan = toanHang1-toanHang2;
                break;
            case 'x':
                ketQuaPhepToan = toanHang1*toanHang2;
                break;
            case ':':
                if (toanHang2 = 0) {
                    ketQuaPhepToan = 'Null'
                } else {
                    ketQuaPhepToan = toanHang1/toanHang2;
                }     
                break;
        }
        document.getElementById("ketqua").innerHTML = 'Ket qua = ' + ketQuaPhepToan;
    }
}

function phimC() {
    if (trangThai == 0)
        toanHang1 = 0;
    else
        toanHang2 = 0;
}

