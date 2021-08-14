$(function(){
    
    });
function logOut(){
    localStorage.removeItem('userInfo');
    window.location.replace("http://127.0.0.1:5500/html/login.html");
}
function register(){
    // get data
    var email = document.getElementById("email-register").value;
    var userName = document.getElementById("username-register").value;
    var password = document.getElementById("password-register").value;
    var passwordConfirm = document.getElementById("password_confirm-register").value;
    var role = [];
    $('input[name="role-name"]:checked').each(function() {
        console.log(this.value);
        role.push(this.value);
     });
    
    if (userName === "") {
        $('#username-err-register').append(
            "userName không được trống. Hãy nhập userName")
        return;
    } else {
        $('#username-err-register').empty();
    }
    if (email === "") {
        $('#email-err-register').append(
            "Email không được trống. Hãy nhập email")
        return;
    } else {
        $('#email-err-register').empty();
    }
    if (!validateEmail(email)) {
        $('#email-err-register').append(
            "Email không đúng định dạng. Hãy nhập lại email")
        return;
    }
    if (password === "") {
        $('#password-err-register').append(
            "password không được trống. Hãy nhập password")
        return;
    } else {
        $('#password-err-register').empty();
    }
    if (passwordConfirm === "") {
        $('#passwordConfirm-err-register').append(
            "password confirm không được trống. Hãy nhập password confirm")
        return;
    } else {
        $('#passwordConfirm-err-register').empty();
    }
    if (passwordConfirm !== password) {
        $('#passwordConfirm-err-register').append(
            "password confirm không khớp, vui lòng nhập lại")
        return;
    } else {
        $('#passwordConfirm-err-register').empty();
    }
    var signUpRequest = {
        email: email,
        username: userName,
        password: password,
        role: role
    };
    $.ajax({
        url: 'http://localhost:8080/api/auth/signup',
        type: 'POST',
        // beforeSend: function (xhr) {
        //     xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        // },
        data: JSON.stringify(signUpRequest), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            if (data === "EMAIL") {
                $('#email-err-register').append(
                    "Email đã tồn tại. Hãy nhập email khác")
                return;
            }
            if (data === "USERNAME") {
                $('#username-err-register').append(
                    "username đã tồn tại. Hãy nhập username khác")
                return;
            }
            showSuccessAlertRegister();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}
function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
function showSuccessAlertRegister() {
    $("#success-alert-register").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert-register").slideUp(500);
    });
}