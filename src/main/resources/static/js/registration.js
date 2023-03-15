function isVerificationCode() {
    let verificationCode = document.getElementById('verification-code').value;
    let pattern = /\d\d\d\d\d/;
    let result = pattern.test(verificationCode);
    if(verificationCode == '') {
        document.getElementById('vcSpan').innerHTML = '验证码为空！';
        return false;
    } else if(!result) {
        document.getElementById('vcSpan').innerHTML = '验证码错误！';
        return false;
    } else {
        document.getElementById('vcSpan').innerHTML = '';
        return true;
    }
}

function isPassword() {
    let password1 = document.getElementById('inputPassword1').value;
    let pattern = /\w{6,20}/;
    let result = pattern.test(password1);
    if (!result) {
        document.getElementById('pwd1Span').innerHTML = '密码必须为字母、数字或下划线，且不少于6位';
        return false;
    } else {
        document.getElementById('pwd1Span').innerHTML = '';
        return true;
    }
}

function reconfirmPassword() {
    let password1= document.getElementById("inputPassword1").value;
    let password2= document.getElementById("inputPassword2").value;
    if (password1 == password2) {
        document.getElementById("pwd2Span").innerHTML = "";
        return true;
    }else {
        document.getElementById("pwd2Span").innerHTML = "两次输入的密码不一致";
        return false;
    }
}

function inputEmail() {
    let email = document.getElementById('email').value;
    let inputEmail = document.getElementById('input-email');
    inputEmail.setAttribute('value', email);
}