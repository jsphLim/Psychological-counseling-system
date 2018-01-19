
function c_o_li_data() {
    var user = document.getElementById('username');
    var password = document.getElementById('password');
    var checkor = document.getElementById("check");
    var data = {};
    data["username"] = user.value;
    data["password"] = password.value;
    if(!checkor.checked){
        user.text("");
        password.text("");
    }
    return data;
}
function c_o_li_submit() {
        var data = c_o_li_data();

        $.ajax({
            url: "login",
            type: "POST",
            //contex: ,
            data: data,
            dataType: "JSON",
            success: function(response) {
                if (response === true) {
                    setTimeout('window.location.href="indexpage.html"',1000);


                } else {
                    alert("账号或密码错误");
                }
                // setTimeout('window.location.href="index.html"', 1000);
            },
            error: function(xhr, msg, e) {
               alert("error!");
            }
        });
}

function  register_data() {
    var username = document.getElementById("user");
    var pass=document.getElementById("pass");
    var passconfirm=document.getElementById("passconfirm");
    if(pass.value!=passconfirm.value) {alert("两次密码不一样！"); return ;}
    var email=document.getElementById("email");

    var data = {};
    data["username"] = user.value;
    data["password"] = pass.value;
    data["email"] = email.value;
   return data;
}

function register_submit() {
    var data = register_data();
    $.ajax({
        url: "register",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        success: function(response) {
            if (response === true) {
                alert("注册成功！")
            } else {
                alert("账号已存在");
            }
            // setTimeout('window.location.href="index.html"', 3000);
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}

function logout() {
    $.ajax({
        url: "logout",
        type: "GET",
        dataType: "JSON",
        success: function(response) {
            if (response === true) {
                setTimeout('window.location.href="index.html"', 1000);
            } else {
                alert("登出失败!");
            }
            // setTimeout('window.location.href="index.html"', 3000);
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}

function online() {
    $.ajax({
        url: "online",
        type: "GET",
        success: function(response) {
                if(response!=null) {
                    $("#UserID").innerHTML(response.toString()
                                             + '<b class="caret"></b>');
                }
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}
function updatePass() {
    var pass1 = document.getElementById("pass1");
    var pass2 = document.getElementById("pass2");
    if (pass1.value !== pass2.value) {
        alert("两次密码输入不一致!")
        pass1.text("");
        pass2.text("");
    }
    else {
        var data = {};
        data["password"] = pass2.value;
        $.ajax({
            url: "updatepass",
            type: "POST",
            data: data,
            dataType: "JSON",
            success: function (response) {
                if (response === true) {
                    alert("密码修改成功!");
                    setTimeout('window.location.href="index.html"');
                }
            }
        });
    }
}
