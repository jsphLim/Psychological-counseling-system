
function search(){
    var tname = document.getElementById("searchTxt");
    data={};
    data["tname"]=tname.value;
    $.ajax({
        url: "searchTname",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        success: function(response) {
            console.log(response);
            $("#postTable").html("<tr style=\"font-weight: bold\"><td>工号</td><td>姓名</td><td>地点</td><td>值班日</td><td>人数</td></tr>\n");
            $.each(response, function(i, item) {
                $("#postTable").append(
                    '<tr><td>'+item.tno+'</td><td>'+item.tname+'</td><td>'+item.location+'</td><td>'+item.dutytime+'</td><td>'+item.currentnumber+'/'+item.totalnumber+'</td>'+'<td><a class="btn btn-primary btn-xs" role="button" href="#" id="'+item.tno+'" onclick="reserve_tno(this)" >预约</a></td></tr>');
            });

        },
        error: function(xhr, msg, e) {
            alert("网络异常:"+msg);
        }
    });
}


function reserve_tno(obj) {
    var data={};
    console.log(obj.id);

    data["tno"]=obj.id.toString();
    console.log(data["tno"]);
    if(confirm("请您确认预约信息？")){
        $.ajax({
            url:"createAppointment",
            type: "POST",
            data:data,
            dataType:"JSON",
            success: function (response) {
                if(response.error_code === 1) {
                    setTimeout('window.location.href="reservation.html"');
                    alert(response.error_message);
                }
                else{
                    setTimeout('window.location.href="home.html"');
                    alert(response.error_message);
                }
            },
            error: function(xhr, msg, e) {
                alert("网络异常:"+msg);
            }

        });



    }
}