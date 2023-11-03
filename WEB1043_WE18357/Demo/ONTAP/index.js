function send() {
    var tendn = document.getElementById('tendn').value;
    var mk1 = document.getElementById('mk1').value;
    var mk2 = document.getElementById('mk2').value;
    var ten1 = document.getElementById('ten1').value;
    var ten2 = document.getElementById('ten2').value;
    var ngay = document.getElementById('ngay').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var emailRegex = /^\S+@\S+\.\S+$/;
    if (tendn=="") {
        document.getElementById('tendnloi').innerHTML="Chưa nhập tên đăng nhập";
        return false;
    }
    if (tendn!="") {
        document.getElementById('tendnloi').innerHTML="";
    }
    if (mk1=="") {
        document.getElementById('mk1loi').innerHTML="Chưa nhập mật khẩu";
        return false;
    }
    if (mk1!="") {
        document.getElementById('mk1loi').innerHTML="";
    }
    if (mk2=="") {
        document.getElementById('mk2loi').innerHTML="Chưa nhập lại mật khẩu";
        return false;
    }
    if (mk2!=mk1) {
        document.getElementById('mk2loi').innerHTML="Mật khẩu không khớp";
        return false;
    }
    if (mk2!="") {
        document.getElementById('mk2loi').innerHTML="";
    }
    if (ten1=="") {
        document.getElementById('ten1loi').innerHTML="Chưa nhập họ và tên lót";
        return false;
    }
    if (ten1!="") {
        document.getElementById('ten1loi').innerHTML="";
    }
    if (ten2=="") {
        document.getElementById('ten2loi').innerHTML="Chưa nhập tên ";
        return false;
    }
    if (ten2!="") {
        document.getElementById('ten2loi').innerHTML="";
    }
    if (ngay=="") {
        document.getElementById('ngayloi').innerHTML="Chưa nhập ngày sinh";
        return false;
    }
    if (ngay!="") {
        document.getElementById('ngayloi').innerHTML="";
    }
    if (email=="") {
        document.getElementById('emailloi').innerHTML="Chưa nhập email";
        return false;
    }
    if (!emailRegex.test(email)) {
        document.getElementById("emailloi").innerHTML = "Vui lòng nhập địa chỉ email hợp lệ!";
        return false;
      }
      if (email!="") {
        document.getElementById('emailloi').innerHTML="";
    }
    if (phone=="") {
        document.getElementById('phoneloi').innerHTML="Chưa nhập số điện thoại";
        return false;
    }    
    if (isNaN(phone)) {
        document.getElementById('phoneloi').innerHTML="Số điện thoại phải là số";
        return false;
    }
    if (phone!="") {
        document.getElementById('phoneloi').innerHTML=""
    }
    alert("Xác nhận thông tin thành công\n"+tendn+'\n'+mk1+'\n'+mk2+'\n'+ten1+'\n'+ten2+'\n'+ngay+'\n'+email+'\n'+phone);
    return true;
}