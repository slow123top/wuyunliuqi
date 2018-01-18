//执行获取时相表和图信息
define(['jquery','canvasPaint','zrenderPaint'],function($,canvasPaint,zrenderPaint) {
    var getShiXiang = {};
    getShiXiang.queryShiXiang = function (date, tableElement, tuElementId) {
        var $tu = $(tableElement);
        $.ajax({
            url: "/api/wuyunliuqitu",
            type: "POST",
            data: {
                date: date.format("yyyy-MM-dd.hh:mm:ss")
            }, success: function (data) {
                if (data["status"] == "SUCCESS") {
                    var shixiang = data["data"]["shixiang"];
                    if (shixiang) {
                        $tu.find(".sitian-text").text(shixiang["司天"]["名"]);
                        $tu.find(".keqi-text").text(shixiang["客气"]["名"]);
                        $tu.find(".zhongyun-text").text(shixiang["中运"]["名"]);
                        $tu.find(".zhuqi-text").text(shixiang["主气"]["名"]);
                        $tu.find(".zaiquan-text").text(shixiang["在泉"]["名"]);

                        var sinum = shixiang["司天"]["数"];
                        var kenum = shixiang["客气"]["数"];
                        var zhongnum = shixiang["中运"]["数"];
                        var zhunum = shixiang["主气"]["数"];
                        var zainum = shixiang["在泉"]["数"];

                        $tu.find(".sitian-num").text(sinum);
                        $tu.find(".keqi-num").text(kenum);
                        $tu.find(".zhongyun-num").text(zhongnum + shixiang["年天干阴阳标志"]);
                        $tu.find(".zhuqi-num").text(zhunum);
                        $tu.find(".zaiquan-num").text(zainum);

                        canvasPaint.drawShiXiangTu(tuElementId, sinum, kenum, zhongnum, zhunum, zainum);
                    }
                } else {
                    alert("空闲超时，为了安全请重新登录！");
                }
            }
        });
    };
    $(".wylq-table").on("queryShixiang", function () {
        var $this = $(this);
        var date = $this.data("date");
        getShiXiang.queryShiXiang(date, $this, $this.parent().children().find(".wylq-canvas").attr("id"));
    });














    getShiXiang.querybtShiXiang = function (date, tableElement) {
        var $tu = $(tableElement);
        $.ajax({
            url: "/api/wuyunliuqitu",
            type: "POST",
            data: {
                date: date.format("yyyy-MM-dd.hh:mm:ss")
            }, success: function (data) {
                if (data["status"] == "SUCCESS") {
                    var shixiang = data["data"]["shixiang"];
                    if (shixiang) {
                        $tu.find(".sitian-text").text(shixiang["司天"]["名"]);
                        $tu.find(".keqi-text").text(shixiang["客气"]["名"]);
                        $tu.find(".zhongyun-text").text(shixiang["中运"]["名"]);
                        $tu.find(".zhuqi-text").text(shixiang["主气"]["名"]);
                        $tu.find(".zaiquan-text").text(shixiang["在泉"]["名"]);

                        var sinum = shixiang["司天"]["数"];
                        var kenum = shixiang["客气"]["数"];
                        var zhongnum = shixiang["中运"]["数"];
                        var zhunum = shixiang["主气"]["数"];
                        var zainum = shixiang["在泉"]["数"];

                        $tu.find(".sitian-num").text(sinum);
                        $tu.find(".keqi-num").text(kenum);
                        $tu.find(".zhongyun-num").text(zhongnum + shixiang["年天干阴阳标志"]);
                        $tu.find(".zhuqi-num").text(zhunum);
                        $tu.find(".zaiquan-num").text(zainum);

                        zrenderPaint.drawShiXiangTu(sinum, kenum, zhongnum, zhunum, zainum);
                    }
                } else {
                    alert("空闲超时，为了安全请重新登录！");
                }
            }
        });
    };
    $("#wylq-table2").on("querybtShixiang", function () {
        var $this = $(this);
        var date = $this.data("date");
        getShiXiang.querybtShiXiang(date, $this);
    });
    return getShiXiang;
});