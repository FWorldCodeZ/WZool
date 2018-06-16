// function load() {
//     $(".top").load("top.html");
//     $(".foot").load("foot.html");
// }

//公共路径
function getPath() {
    var pathTop = document.location.pathname;
    var index = pathTop.substr(1).indexOf("/");
    var result = pathTop.substr(0, index + 1);
    return result;
}

var contenshow={
    template:
        `<div class="zool_content_show">

       

            </div>`


}

var page_count = 0;//总页数
var page_now = 0;//当前页数
var page_number = 100;//当前页记录大小
var info_total = 0;//总记录条数

function page_tool(page_now, page_number, info_total, cardInfos) {
    $(".zool_content_show").empty();
    var page_size = 0;//当前页当前条数
    var cardInfos=cardInfos;
    page_count = parseInt(info_total / page_number);
    if (info_total % page_number > 0) {
        page_count++
    }
   page_size =cardInfos.length ;
    var html = '';
    for (var i = 0; i < page_size; i++) {
        //一行四列
        if (i % 4 == 0) {
            //   console.log(i);

            if (i != 0) {
                html += '</div>';
            }
            html += '<div class="row_style">\n' + '';

        }
        html += '                <!--卡片-->\n' +
            '                <div class="card_show">\n' +
            '                    <div class="card_show_img">\n' +
            '                        <img class="card_show_img_content" src="../image/' + cardInfos[i].zoolPhotosList[0].photos + '"/>\n' +
            '                    </div>\n' +
            '                    <div class="card_show_content">\n' +
            '                        <div class="icon_line">\n' +
            '                            <div class="layui-icon layui-icon-location icon_style" title="去那里"></div>\n' +
            '                            <div class="layui-icon icon-ticket icon_style" title="门票"></div>\n' +
            '                            <span class="icon_badge">9折</span>\n' +
            '                            <div class="layui-icon layui-icon-star icon_style" title="收藏"></div>\n' +
            '                            <!--layui-icon-star-fill-->\n' +
            '                            <div class="layui-icon layui-icon-share icon_style" title="分享"></div>\n' +
            '                            <div class="layui-icon layui-icon-more-vertical icon_style" title="详情" onclick="test"></div>\n' +
            '                        </div>\n' +
            '                        <fieldset class="show_line">\n' +
            '                            <legend>' + cardInfos[i].zoolName + '</legend>\n' +
            '                            <div class="font_box">' + cardInfos[i].zoolDescription + '</div>\n' +
            '                        </fieldset>\n' +
            '                    </div>\n' +
            '                </div>\n' + '';

    }
    html += '</div>';

    $(".zool_content_show").append(html);
    page_show(page_now,page_count);
}


function page_show(page_now,page_count) {
    $(".page_tool").empty();
    var page_html;//页码
    page_html = '<button type="button" class="page_pre"  onclick="prevTo()">上一页</button>';

    if (page_count <= 6) {
        for (var i = 1; i <= page_count; i++) {
            if (i == page_now) {
                page_html += '<button type="button" class="btn_into page_now">' + i + '</button>';
            } else {
                page_html += '<button type="button" class="btn_into"  onclick="pageInto('+i+')">' + i + '</button>';
            }

        }
    } else {
        for (var i = 1; i < 7; i++) {
            if (i < 6) {
                page_html += '<button type="button" class="btn_into"  onclick="pageInto('+i+')">' + i + '</button>';
            } else if (i = 6) {
                page_html += '<button type="button" class="btn_into">...</button>';
            }
        }
        page_html += '<button class="btn_into" onclick="pageInto('+page_count+')">' + page_count + '</button>';
    }
    page_html += '<button type="button" class="page_next"  onclick="nextTo()" >下一页</button>';
    $(".page_tool").append(page_html);
    // return page_html;
}

//上一页
function page_pre(page_now) {
    if (page_now > 1) {
        page_now--;
        return page_now;
    }
    layer.msg('玩命提示中');
    layer.msg("已经是第一页了！");
    return page_now;
}


//下一页
function page_next(page_now) {
    console.log("page_count"+page_count)
    console.log("page_now"+page_now)
    if (page_now <page_count) {
        page_now++;
        return page_now;
    }
    layer.msg("已经是最后一页了！")
    return page_now;

}
