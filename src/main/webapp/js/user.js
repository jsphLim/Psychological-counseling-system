
function c_o_li_data() {
    var user = document.getElementById('username');
    var password = document.getElementById('password');
    var data = {};
    data["username"] = user.value;
    data["password"] = password.value;
    console.log("sadascsa"+data);
    return data;
}
function c_o_li_submit() {
        var data = c_o_li_data();

        $.ajax({
            url: "login",
            type: "POST",
            //contex: ,
            async:false,
            data: data,
            dataType: "JSON",
            success: function(response) {
                if (response.error_code === 1) {
                    window.location.href="home.html";

                } else {
                    alert(response.error_message);
                }
                // setTimeout('window.location.href="index.html"', 1000);
            },
            error: function(xhr, msg, e) {
                alert("error");
            }
        });
}

function  register_data() {

   return data;
}

function register_submit() {



    var data = {};
    var username = document.getElementById("user");
    var pass=document.getElementById("pass");
    var passconfirm=document.getElementById("passconfirm");
    var deptno=document.getElementById("deptno");
    var name=document.getElementById("name");
    if(pass.value!==passconfirm.value) {alert("两次输入密码不一样！"); return ;}
    var email=document.getElementById("email");
    if(username.value==="" || pass.value==="" || passconfirm.value==="" || deptno.value==="" || name.value==="" || email.value===""){
        alert("用户信息填充不完整!请重试");
        return ;
    }
    else if(pass.length<6){
        alert("密码长度必须大于6位");
    }
    else if(pass.value!==passconfirm.value){
        alert("两次输入密码不一致！");
        return ;
    }
    data["username"] = username.value;
    data["password"] = pass.value;
    data["email"] = email.value;
    data["deptno"] = deptno.value;
    data["name"] = name.value;
    $.ajax({
        url: "register",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        success: function(response) {
            if (response.error_code === 1) {
                location.reload();
                setTimeout('window.location.href="index.html"', 1000);
                alert(response.error_message)


            } else {
                alert(response.error_message);
                setTimeout('window.location.href="index.html"', 1000);

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
