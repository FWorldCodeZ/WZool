// var app = new Vue({
//     el: "#app",
//     contentshow: {
//         'contenshow': contenshow
//     },
//     data() {
//         return {
//             zoolsData: '',
//             Page: {
//                 pageNow: 1, //第几页
//                 pageNumber: 12, //每页展示数
//                 total: Number, //总页数
//                 selectPageNumber: 1 //选中的页数
//             },
//             cardInfo: [],//卡片信息
//
//         }
//     },
//     mounted() {
//         // this.setTime();
//         setTimeout(this.dataLoad(), 500);
//
//     },
//     methods: {
//         dataLoad: function () {
//             this.zools();
//         },
//         zools: function () {
//             var _this = this.Page;
//             var _that = this.cardInfo;
//             var data = JSON.stringify({
//                 pageNow: _this.pageNow,
//                 pageNumber: _this.pageNumber
//             })
//             var option = {
//                 url: getPath() + "/zools/selectByCondition",
//                 data: data,
//                 type: "post",
//                 contentType: "application/json; charset=utf-8",
//                 success: function (data) {
//                     //
//                     if (data.status == "200") {
//                         _that = data.item.map;
//                         //   layer.msg("加载成功")
//                         // console.log(_that.obj)
//                         page_tool(_that.pageNow, _this.pageNumber, _that.count, _that.obj);
//
//                     }
//                 }
//
//             };
//             $.ajax(option);
//         },
//         //下一页
//         nextTo: function () {
//             app.Page.pageNow = page_next(app.Page.pageNow);
//             console.log(app.Page.pageNow);
//             this.zools();
//
//         },
//         //上一页
//         prevTo: function () {
//             app.Page.pageNow = page_pre(app.Page.pageNow);
//             console.log(app.Page.pageNow);
//             this.zools();
//
//         },
//         //点击跳转到指定页
//         pageInto: function (data) {
//             app.Page.pageNow = data;
//             console.log(app.Page.pageNow);
//             this.zools();
//         },
//     }
// })
$(
    zools(1)
)

var pageNow = 1;

function zools(pageNow) {
    var pageNow = pageNow;
    var pageNumber = 12;

    var _that;
    var data = JSON.stringify({
        'pageNow': pageNow,
        'pageNumber': pageNumber
    })
    //  console.log("zz" + pageNumber);
    var option = {
        url: getPath() + "/zools/selectByCondition",
        data: data,
        type: "post",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            if (data.status == "200") {
                _that = data.item.map;
                console.log(data.item)
                page_tool(_that.pageNow, pageNumber, _that.count, _that.obj);

            }
        }

    };
    $.ajax(option);
}

//下一页
function nextTo() {
    pageNow = page_next(pageNow);
    console.log(pageNow);
    this.zools(pageNow);

}

//上一页
function prevTo() {
    pageNow = page_pre(pageNow);
    this.zools(pageNow);

}

//点击跳转到指定页
function pageInto(data) {
    pageNow = data;
    this.zools(data);
}

//收藏点击
function collection(obj, zoolId) {
    var path = "collection/addCollection";
    var data = {
        otherId: zoolId,
        collType: 'zools'
    };
    var type = "post"
    commonAjax(obj, path, data, type, show);
}

function show(obj, data) {
    if (data.msg == "收藏成功！") {
        $(obj).removeClass("layui-icon-star");
        $(obj).addClass("layui-icon-star-fill");
        layer.msg(data.msg)
    } else {
        layer.msg(data.msg)
        $(obj).removeClass("layui-icon-star-fill");
        $(obj).addClass("layui-icon-star");
    }

    // function pushInfo(data) {
    //     alert(data);
    // }
}