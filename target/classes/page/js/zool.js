var app =new Vue({
    el: "#app",
    data() {
        return {
            zoolsData: '',
            zoolsPage: {
                pageNow: 1, //第几页
                pageNumber: 12, //每页展示数
                total: Number, //总页数
                selectPageNumber: 1 //选中的页数
            },
            cardInfo:[],//卡片信息

        }
    },
    mounted() {
        // this.setTime();
       setTimeout(this.dataLoad(), 500);

    },
    methods: {
        dataLoad: function () {
            this.zools();
        },
        zools: function () {
            var _this = this.zoolsPage;
            var _that=this.cardInfo;
            var data = JSON.stringify({
                pageNow: _this.pageNow,
                pageNumber: _this.pageNumber
            })
            var option = {
                url: getPath() + "/zools/selectByCondition",
                data: data,
                type: "post",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                 //
                    if (data.status == "200") {
                        _that=data.item.map;
                     //   layer.msg("加载成功")
                        console.log(_that.obj)
                        page_tool(_that.pageNow,_that.obj.length, _that.count, _that.obj);
                    }
                }

            };
            $.ajax(option);
        },
        //下一页
        next:function () {
            page_next();
        },
        //上一页
        prev:function () {
            page_pre();
        },
        //点击跳转到指定页
        pageInto:function () {
            page_tool(page_now, page_number, info_total);
        }
    }
})