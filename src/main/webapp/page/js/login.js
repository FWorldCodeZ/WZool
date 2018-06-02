function login() {
    var option = {
        url: getPath() + "/user/login",
        type: "post",
        beforeSend: function (request) {

        },
        success: function (data) {
            if (data.status == "200") {
                location.href = getPath() + "index.html"
            } else if (data.status == "500") {
                alert("登陆异常")
            }
            else{
                layer.alert(data.msg,{icon:3,time: 2000});
            }
        }
    }

    $("#form").ajaxSubmit(option);
}