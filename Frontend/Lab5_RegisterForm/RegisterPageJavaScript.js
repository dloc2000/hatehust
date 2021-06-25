function returnPageRegister() {
    window.open("Register.html")
    console.log("OK")
}

function resetForm(){
    document.getElementById('fullname').value ='';
    document.getElementById('email').value ='';
    document.getElementById('pwd').value ='';
    document.getElementById('conf-pwd').value ='';
}

function creatNewUser() {
    var v_fullname = document.getElementById('fullname').value;
    var v_email = document.getElementById('email').value;
    var v_pwd = document.getElementById('pwd').value;
    var v_conf_pwd = document.getElementById('conf-pwd').value;
    var v_birthday = document.getElementById('birthday').value;

    if(v_conf_pwd != v_pwd){
        alert('Mat khau ko trung khop')
    }
    var user = {
        fullname: v_fullname,
        email: v_email,
        password: v_pwd,
        birthday: v_birthday,
    }

    window.open('login.html', '_self')
    var json = JSON.stringify(user)
    localStorage.setItem('user' , json)
}

function loginSuccess() {
    var v_email_login = document.getElementById('email').value
    var v_password_login = document.getElementById('pwd').value
    var user = JSON.parse(localStorage.getItem('user'))

    if((user.email == v_email_login) && (user.password == v_password_login)){
        alert('Dang nhap thanh cong')
        window.open('home.html', '_self')
    }
    else {
        alert('Kiem tra lai thong tin !!!')
    }
}