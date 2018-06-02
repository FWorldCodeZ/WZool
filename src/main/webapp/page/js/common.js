// $(load());
// function load() {
//     $("#top").load("top.html");
//     $("#foot").load("foot.html");
// }

//公共路径
function getPath() {
    var pathTop = document.location.pathname;
    var index = pathTop.substr(1).indexOf("/");
    var result = pathTop.substr(0, index + 1);
    return result;
}