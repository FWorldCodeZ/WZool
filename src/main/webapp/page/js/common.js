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

var page_count = 0;//总页数
var page_now = 0;//当前页数
var page_number = 100;//当前页记录大小
var info_total = 0;//总记录条数
function page_tool(page_now, page_number, info_total, cardInfos) {
    this.page_now = page_now;
    this.page_number = page_number;
    this.info_total = info_total;
    this.cardInfos = cardInfos;
    var page_size = 0;//当前页当前条数
    page_count = info_total / page_number;
    if (info_total % page_number > 0) {
        page_count++
    }

    //page_size = (page_now * page_number <= info_total) ? (page_number - (page_now * page_number - info_total)) : page_number;
    var html=null;
    console.log("cardInfos:" + cardInfos)
    console.log("page_size:" + page_size)
    console.log("page_number:" + page_number)
    for (var i = 0; i < page_number; i++) {
        //一行四列
        if (i % 4 == 0) {
            console.log(i);

            if (i != 0) {
                html += '</div>';
            }
            html += '<div class="row_style">\n' + '';
            // console.log(html);
        }
        html += '                <!--卡片-->\n' +
            '                <div class="card_show">\n' +
            '                    <div class="card_show_img">\n' +
            '                        <img class="card_show_img_content" src="../image/'+cardInfos[i].zoolPhotosList[0].photos+'"/>\n' +
            '                    </div>\n' +
            '                    <div class="card_show_content">\n' +
            '                        <div class="icon_line">\n' +
            '                            <div class="layui-icon layui-icon-location icon_style" title="去那里"></div>\n' +
            '                            <div class="layui-icon icon-ticket icon_style" title="门票"></div>\n' +
            '                            <span class="icon_badge">9折</span>\n' +
            '                            <div class="layui-icon layui-icon-star icon_style" title="收藏"></div>\n' +
            '                            <!--layui-icon-star-fill-->\n' +
            '                            <div class="layui-icon layui-icon-share icon_style" title="分享"></div>\n' +
            '                            <div class="layui-icon layui-icon-more-vertical icon_style" title="详情"></div>\n' +
            '                        </div>\n' +
            '                        <fieldset class="show_line">\n' +
            '                            <legend>'+cardInfos[i].zoolName+'</legend>\n' +
            '                            <div class="font_box">'+ cardInfos[i].zoolDescription+ '</div>\n' +
            '                        </fieldset>\n' +
            '                    </div>\n' +
            '                </div>\n' + '';

    }
    html += '</div>';

    $(".zool_content_show").append(html);
}


function page_show(page_now, page_count) {
    var page_html;//页码
    page_html = '<div class="page_btn"><button class="page_pre">上一页</button>';
    // for (var i = 1; i < page_count; i++) {
    //     if (page_count > 6) {
    //         if (page_count == i) {
    //             page_html += '<button class="btn_into">i</button>';
    //         } else if (i = 6) {
    //             page_html += '<button class="btn_into">...</button>';
    //         } else if (i < 6) {
    //             page_html += '<button class="btn_into">i</button>';
    //         }
    //     } else {
    //         page_html += '<button class="btn_into">i</button>';
    //     }
    // }
    if (page_count <= 6) {
        page_html += '<button class="btn_into">page_count</button>';
    } else {
        for (var i = 1; i < 7; i++) {
            if (i < 6) {
                page_html += '<button class="btn_into">i</button>';
            } else if (i = 6) {
                page_html += '<button class="btn_into">...</button>';
            }
        }
    }
    page_html += '<button class="btn_into">page_count</button><button class="page_next">下一页</button>';
    page_html += '</div>';
}

//上一页
function page_pre() {
    if (page_now > 0) {
        page_now--;
        page_tool(page_now, page_number, info_total);
        return null;
    }
    return "已经是第一页了！";

}

//下一页
function page_next() {
    if (page_now <= page_count) {
        page_now++;
        page_tool(page_now, page_number, info_total);
        return null;
    }
    return "已经是最后一页了！";

}
