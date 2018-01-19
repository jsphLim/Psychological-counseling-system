
function search(){
    var book_name = document.getElementById("searchTxt");
    data={};
    data["bookName"]=book_name.value;
    $.ajax({
        url: "search",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        success: function(response) {
            console.log(response);
            $("#postTable").html("<tr style=\"font-weight: bold\"><td>书名</td><td>作者</td><td>出版社</td><td>借阅状态</td><td>一键借阅</td></tr>");
            $.each(response, function(i, item) {
                var isrent;
                if(item.isrent==0) {
                    isrent = "在架上";
                    $("#postTable").append(
                        '<tr><td>'+item.bookName+'</td><td>'+item.bookWriter+'</td><td>'+item.Publisher+'</td><td>'+isrent+'</td><td><a class="btn btn-primary btn-xs" href="#"  role="button" id="'+item.book_id+'" onclick="borrowBook(this)">借阅</a></td></tr>');
                }
                else {
                    isrent = "已借出";
                    $("#postTable").append(
                        '<tr><td>' + item.bookName + '</td><td>' + item.bookWriter + '</td><td>' + item.Publisher + '</td><td>' + isrent + '</td><td><a class="btn btn-primary btn-xs" href="#" disabled="true" role="button" id="'+item.book_id+'">借阅</a></td></tr>'
                    );
                }
            });

        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}


function borrowBook(obj){
    var data={};
    data["id"]=obj.id.toString();
    if(confirm("请确定是否借阅这本书？")){
        $.ajax({
           url:"borrowBook",
            type: "POST",
           data:data,
            dataType:"JSON",
            success: function (response) {
               if(response === true)
                setTimeout('window.location.href="Mybook.html"');
            },
            error: function(xhr, msg, e) {
                console.log(e);
            }

        });


        alert("成功借阅！即日送达！")
    }

}