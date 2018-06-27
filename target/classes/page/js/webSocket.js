var webSocket = null;
var flag = false;
if ('webSocket' in window) {
    var path = "ws://localhost:8082/wzool/ws";
    webSocket = new WebSocket(path);
} else {
    alert('当前浏览器不支持 webSocket')
}
//连接发生错误时
webSocket.onerror = function () {

}
//连接成功时回调
webSocket.onopen = function () {
    console.log("连接成功！")
}
//接收到的消息
webSocket.onmessage = function (msg) {
    //console.log(msg.data);
    var data = '';
    if (flag) {
        data = JSON.parse(msg.data);
        pushInfo(data);
    } else {
        flag = true;
    }


}

//连接关闭回调的方法
webSocket.onclose = function () {

}
//监听窗口关闭事件，当窗口关闭时，主动去掉webSocket连接，防止端口还没有断开就关闭窗口，server端会抛出异常
window.onbeforeunload = function () {
    closeWebSocket();
}

//关闭WebSocket连接
function closeWebSocket() {
    webSocket.close();
}

//发送消息
function send() {
    webSocket.send("");
}

function pushInfo(data) {

    //  var list = JSON.parse(data);
    $(".layui-timeline").empty();
    //console.log(data.length)
    var html = '';
    for (var i = 0; i < data.length; i++) {
        html += '                  <li class="layui-timeline-item">';
        if (i == 0) {
            html += '              <i class="layui-icon layui-timeline-axis"></i>';
        } else {
            html += '              <i class="layui-icon layui-timeline-axis"></i>';
        }
        html += '                    <div class="layui-timeline-content layui-text">\n' +
            '                        <div class="layui-timeline-title">' +
            '<span class="time-show">' + data[i].startTime;
        if (data[i].endTime != undefined) {
            html += '<span> &nbsp;至 &nbsp;' + data[i].endTime + '</span>';
        }
        html += '</span>，' + data[i].cardTitle + '</div>\n' +
            '                        </div>\n' +
            '                        </li>';
    }
    html += ' <li class="layui-timeline-item">\n' +
        '                    <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>\n' +
        '                    <div class="layui-timeline-content layui-text">' +
        '                        <div class="layui-timeline-title">更久前，请点击查看</div>\n' +
        '                    </div>\n' +
        '                </li>';
    $('.layui-timeline').append(html);
}


