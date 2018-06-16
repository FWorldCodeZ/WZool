function register() {
    var passWord = $('#userPassword').val();
    var rePassWord = $("#repassword").val();
    if (rePassWord !== passWord) {
        $('#userPassWord').val("");
        $("#repassword").val("");
        layer.msg("两次密码不一致，请重新输入1");
        return;
    }
    var data = JSON.stringify({});
    var option = {
        url: getPath() + "/user/register",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        type: "post",
        success: function (data) {
            if (data.status = "200") {
                layer.msg(data.msg);
            }
        }
    }

    $("#form").ajaxSubmit(option);
}