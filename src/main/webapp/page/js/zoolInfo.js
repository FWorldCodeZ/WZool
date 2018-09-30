var app = new Vue({
    el: "#app",
    data() {
        return {
            zoolsData: '',
            Page: {
                pageNow: 1, //第几页
                pageNumber: 12, //每页展示数
                total: Number, //总页数
                selectPageNumber: 1 //选中的页数
            },
            zoolInfo: [],//动物园信息

        }
    },
    mounted() {
        // this.setTime();
        setTimeout(this.dataLoad(), 500);

    },
    methods: {
        dataLoad: function () {
            this.zoolsInfo();//初始化请求
        },
        zoolsInfo: function () {
            var path = "zools/zoolInfo";
            var data = {
                otherId: zoolId,
            };
            var type = "post"
            commonAjax(obj, path, data, type, this.show);
        },
        show: function (obj, data) {
            //数据展示处理
        },
    }
})