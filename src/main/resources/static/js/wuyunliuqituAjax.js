/*
 公历和农历相互转换
 */
/*
 1900年-2050年的农历年信息
 */
var lunarInfo = [
    0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260,
    0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
    0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255,
    0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
    0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40,
    0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
    0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0,
    0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
    0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4,
    0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
    0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0,
    0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
    0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570,
    0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
    0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4,
    0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
    0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a,
    0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
    0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50,
    0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
    0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552,
    0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
    0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9,
    0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,
    0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60,
    0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
    0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0,
    0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
    0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577,
    0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0];


//======================================= 返回农历 y年闰哪个月 1-12，没闰返回 0
function leapMonth(y) {
    return parseInt(lunarInfo[y - 1900] & 0xf)
}

//======================================= 返回农历 y年m月的总天数
function monthDays(y, m) {
    return ( (lunarInfo[y - 1900] & (0x10000 >> m)) ? 30 : 29 )
}
//======================================= 返回农历 y年的闰月的天数
function leapDays(y) {
    if (leapMonth(y)) {
        return ((lunarInfo[y - 1900] & 0x10000) ? 30 : 29)
    } else {
        return (0)
    }
}
/*
canvas画图
 */
//画圆
function paintArc(ctx, x, y, r, length) {
    ctx.fillStyle = "#000000";
    ctx.beginPath();
    ctx.arc(x, y, r, 0, Math.PI * 2, true)
    ctx.closePath();
    ctx.lineWidth = length;
    ctx.stroke();
}
//画直线
function paintLine(ctx, srcx, srcy, destx, desty) {
    ctx.fillStyle = "#000000";
    ctx.beginPath();
    ctx.moveTo(srcx, srcy);
    ctx.lineTo(destx, desty);
    ctx.lineWidth = 3;
    ctx.stroke();
}
//canvas添加text
function paintWord(ctx, canvas) {
    var gradient = ctx.createLinearGradient(0, 0, canvas.width, 0);
    gradient.addColorStop("0.5", "blue");
    ctx.fillStyle = gradient;
    ctx.font = "bold 20px Georgia";
    ctx.textAlign = "start";
    ctx.fillText("金", 335, 145);
    ctx.fillText("火", 140, 90);
    ctx.fillText("土", 225, 225);
    ctx.fillText("木", 50, 145);
    ctx.fillText("水", 145, 280);
    ctx.stroke();
}
//大圆里面画小圆
function sonArc(ctx, property, count) {
    var x, y;
    var r = [12, 8, 16, 4, 20];
    var len = [2, 2, 2, 2, 2];
    if (count != 0) {
        for (var i = 0; i < count; i++) {
            switch (property) {
                case 1:
                    x = 45 + r[i];
                    y = 180;
                    break;
                case 2:
                    x = 355 - r[i];
                    y = 180;
                    break;
                case 3:
                    x = 200;
                    y = 180;
                    break;
                case 4:
                    x = 200;
                    y = 25 + r[i];
                    break;
                case 5:
                    x = 200;
                    y = 335 - r[i];
                    break;
            }
            if (i > 2) {
                paintArc(ctx, x, y, r[i], len[i]);
            } else {
                paintArc(ctx, x, y, r[i], len[i]);
            }
        }
    }
}
//根据时相动态画出五运六气图
function paintSonarc(ctx, sinum, kenum, zhongnum, zhunum, zainum) {
    var jcount = 0;
    var mcount = 0;
    var scount = 0;
    var hcount = 0;
    var tcount = 0;
    var si = sinum;
    var ke = kenum;
    var zhong = zhongnum;
    var zhu = zhunum;
    var zai = zainum;
    var s = [];
    s[0] = si;
    s[1] = ke;
    s[2] = zhong;
    s[3] = zhu;
    s[4] = zai;
    for (var i = 0; i < 5; i++) {
        if (s[i] == 28 || s[i] == "28▲" || s[i] == "28▼") {//金
            jcount++;
            switch (jcount) {
                case 1:
                    sonArc(ctx, 2, 1);
                    break;
                case 2:
                    sonArc(ctx, 2, 2);
                    break;
                case 3:
                    sonArc(ctx, 2, 3);
                    break;
                case 4:
                    sonArc(ctx, 2, 4);
                    break;
                case 5:
                    sonArc(ctx, 2, 5);
                    break;
            }
        } else if (s[i] == 410 || s[i] == "410▲" || s[i] == "410▼") {//木
            mcount++;
            switch (mcount) {
                case 1:
                    sonArc(ctx, 1, 1);
                    break;
                case 2:
                    sonArc(ctx, 1, 2);
                    break;
                case 3:
                    sonArc(ctx, 1, 3);
                    break;
                case 4:
                    sonArc(ctx, 1, 4);
                    break;
                case 5:
                    sonArc(ctx, 1, 5);
                    break;
            }
        } else if (s[i] == 39 || s[i] == "39▲" || s[i] == "39▼") {//水
            scount++;
            switch (scount) {
                case 1:
                    sonArc(ctx, 5, 1);
                    break;
                case 2:
                    sonArc(ctx, 5, 2);
                    break;
                case 3:
                    sonArc(ctx, 5, 3);
                    break;
                case 4:
                    sonArc(ctx, 5, 4);
                    break;
                case 5:
                    sonArc(ctx, 5, 5);
                    break;
            }
        } else if (s[i] == 115 || s[i] == 17 || s[i] == "115▲" || s[i] == "115▼" || s[i] == "17▲" || s[i] == "17▼") {//火
            hcount++;
            switch (hcount) {
                case 1:
                    sonArc(ctx, 4, 1);
                    break;
                case 2:
                    sonArc(ctx, 4, 2);
                    break;
                case 3:
                    sonArc(ctx, 4, 3);
                    break;
                case 4:
                    sonArc(ctx, 4, 4);
                    break;
                case 5:
                    sonArc(ctx, 4, 5);
                    break;
            }
        } else if (s[i] == 126 || s[i] == "126▲" || s[i] == "126▼") {//土
            tcount++;
            switch (tcount) {
                case 1:
                    sonArc(ctx, 3, 1);
                    break;
                case 2:
                    sonArc(ctx, 3, 2);
                    break;
                case 3:
                    sonArc(ctx, 3, 3);
                    break;
                case 4:
                    sonArc(ctx, 3, 4);
                    break;
                case 5:
                    sonArc(ctx, 3, 5);
                    break;
            }
        }
    }

}
//公历获得某年某月的天数
var getDaysOfYearMonth = function (year, month) {
    var isLeapYear = function (year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    };
    var daysOfMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    daysOfMonth[1] = isLeapYear(year) ? 29 : 28;
    return daysOfMonth[month - 1];
};
//定义天干地支
var tiangan = [
"甲",
"乙",
"丙",
"丁",
"戊",
"己",
"庚",
"辛",
"壬",
"癸"];
var dizhi = [
"子",
"丑",
"寅",
"卯",
"辰",
"巳",
"午",
"未",
"申",
"酉",
"戌",
"亥"];
//分别变换公历和农历的年月日时分options
var addgreyear = function (year) {
    for (var i = 1900; i <= 2100; i++) {
        year.append("<option value='" + i + "'>" + i + "年</option>");
    }
}
var addgremonth = function (month) {
    for (var i = 1; i <= 12; i++) {
        month.append("<option value='" + i + "'>" + i + "月</option>");
    }
}
var addgreday = function (day, daysOfgreM) {
    for (var i = 1; i <= daysOfgreM; i++) {
        day.append("<option value='" + i + "'>" + i + "日</option>");
    }
}
var addgrehour = function (hour) {
    for (var i = 0; i <= 23; i++) {
        hour.append("<option value='" + i + "'>" + i + "时</option>");
    }
}
var addgreminute = function (minute) {
    for (var i = 0; i <= 59; i++) {
        minute.append("<option value='" + i + "'>" + i + "分</option>");
    }
}
var addlunaryear = function (year) {
    var i = 1900, j = 6, k = 0;
    for (i, j, k; i <= 2100; i++, j++, k++) {
        j = j % 10;
        k = k % 12;
        year.append("<option value='" + i + "'>" + tiangan[j] + "" + dizhi[k] + "(" + i + ")年</option>");
    }
}
var addlunarmonth = function ($month, leapMonth) {
    var months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
    if (leapMonth != 0) {
        var firstPart = months.slice(0, leapMonth);
        var leapPart = [leapMonth + 12];
        var lastPart = months.slice(leapMonth, 12);
        months = firstPart.concat(leapPart).concat(lastPart);
    }
    months.forEach(function (month) {
        $month.append("<option value='" + month + "'>" + lunarmonth[month - 1] + "</option>")
    });
};
var addlunarday = function (year, month, $day) {
    var daysoflunarMonth;
    if (month > 12) {
        //闰月
        daysoflunarMonth = leapDays(year);
    } else {
        daysoflunarMonth = monthDays(year, month);
    }
    for (var i = 1; i <= daysoflunarMonth; i++) {
        $("<option></option>").text(lunarday[i - 1]).val(i).appendTo($day);
        //$day.append("<option value='" + i + "'>" + lunarday[i - 1] + "</option>");
    }
}
var addlunarhour = function (hour) {
    for (var i = 0; i < 12; i++) {
        hour.append("<option value='" + i + "'>" + lunarhourandlink[i][0] + "</option>");
    }
}
/*
 农历月份
 */
var lunarmonth = ["正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月",
    "", "闰二月", "闰三月", "闰四月", "闰五月", "闰六月", "闰七月", "闰八月", "闰九月", "闰十月"];

/*
 农历日期
 */
var lunarday = [];
lunarday[0] = "初一";
lunarday[1] = "初二";
lunarday[2] = "初三";
lunarday[3] = "初四";
lunarday[4] = "初五";
lunarday[5] = "初六";
lunarday[6] = "初七";
lunarday[7] = "初八";
lunarday[8] = "初九";
lunarday[9] = "初十";
lunarday[10] = "十一";
lunarday[11] = "十二";
lunarday[12] = "十三";
lunarday[13] = "十四";
lunarday[14] = "十五";
lunarday[15] = "十六";
lunarday[16] = "十七";
lunarday[17] = "十八";
lunarday[18] = "十九";
lunarday[19] = "廿十";
lunarday[20] = "廿一";
lunarday[21] = "廿二";
lunarday[22] = "廿三";
lunarday[23] = "廿四";
lunarday[24] = "廿五";
lunarday[25] = "廿六";
lunarday[26] = "廿七";
lunarday[27] = "廿八";
lunarday[28] = "廿九";
lunarday[29] = "卅十";
/*
 农历时辰及其对应关系
 */
var lunarhourandlink = [
    ["子时", "（39）"],
    ["丑时", "（39）"],
    ["寅时", "（28）"],
    ["卯时", "（28）"],
    ["辰时", "（28）"],
    ["巳时", "（126）"],
    ["午时", "（126）"],
    ["未时", "（410、115、126）"],
    ["申时", "（17、410、115）"],
    ["酉时", "（17、410）"],
    ["戌时", "（17）"],
    ["亥时", "（39）"]];
//执行函数
$(function () {
    //执行画图
    var drawShiXiangTu = function (elementId, sinum, kenum, zhongnum, zhunum, zainum) {
        var canvas = document.getElementById(elementId);
        var ctx;
        if (canvas) {
            ctx = canvas.getContext('2d');
            ctx.clearRect(0, 0, 400, 400);
            paintArc(ctx, 80, 180, 35, 4);//木
            paintArc(ctx, 200, 60, 35, 4);//火
            paintArc(ctx, 320, 180, 35, 4);//金
            paintArc(ctx, 200, 300, 35, 4);//水
            paintArc(ctx, 200, 180, 35, 4);//土
            paintLine(ctx, 200, 95, 200, 145);//上
            paintLine(ctx, 200, 215, 200, 265);//下
            paintLine(ctx, 115, 180, 165, 180);//左
            paintLine(ctx, 235, 180, 285, 180);//右
            paintWord(ctx, canvas);
            paintSonarc(ctx, sinum, kenum, zhongnum, zhunum, zainum);
        }
    };
    //执行获取时相表和图信息
    var queryShiXiang = function (date, tableElement, tuElementId) {
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

                        drawShiXiangTu(tuElementId, sinum, kenum, zhongnum, zhunum, zainum);
                    }
                } else {
                    alert("空闲超时，为了安全请重新登录！");
                }
            }
        });
    };
    //绑定时相表获取信息的事件
    $(".wylq-table").on("queryShixiang", function () {
        var $this = $(this);
        var date = $this.data("date");
        queryShiXiang(date, $this, $this.parent().children().find(".wylq-canvas").attr("id"));
    });

    /*
     命图和病图搜索按钮触发函数
     */
    var mt = function () {
        var $this = $(this);
        var $form = $this.parents("form");
        var $convertedTime = $form.parent().children().filter(".convertedDateTime");
        var $wylqTable = $form.parent().parent().children().find(".wylq-table");

        var calendarConvertApiUrl = "/api/calendar-convert";

        var calendarType = $form.children(".calendar-type").val();
        var year = $form.children(".year").val();
        var month = $form.children(".month").val();
        var day = $form.children(".day").val();
        var hour = $form.children(".hour").val();
        var minute = $form.children(".minute").val();

        if (calendarType == "公历") {
            //公历

            var d = new Date();
            d.setFullYear(year);
            d.setMonth(month - 1);
            d.setDate(day);
            d.setHours(hour);
            d.setMinutes(minute);
            d.setSeconds(0);
            $wylqTable.data("date", d);
            $wylqTable.trigger("queryShixiang");
            $.ajax({
                url: calendarConvertApiUrl,
                type: "POST",
                data: {
                    date: year + "-" + month + "-" + day
                },
                success: function (data) {
                    if (data["status"] == "SUCCESS") {
                        var dateConverted = data["data"]["dateConverted"];
                        if (dateConverted) {
                            var ganzhi = dateConverted["干支年"]["名称"];
                            var month = dateConverted["month"];
                            var monthPrefix = "";
                            if (month < 0) {
                                month = -month;
                                monthPrefix = "闰";
                            }
                            var monthString = lunarmonth[month - 1];
                            var dayString = lunarday[dateConverted["day"] - 1];
                            var dateTimeConvertedString = "农历:" + ganzhi + "年" + monthPrefix + monthString + dayString
                                + lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][0]
                                + lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][1];
                            $convertedTime.text(dateTimeConvertedString);
                        }
                    }
                }
            });
        } else {
            //农历
            $.ajax({
                url: calendarConvertApiUrl,
                type: "POST",
                data: {
                    date: year + "-" + month + "-" + day,
                    ChineseToGregorian: true
                },
                success: function (data) {
                    if (data["status"] == "SUCCESS") {
                        var dateConverted = data["data"]["dateConverted"];
                        if (dateConverted) {
                            var year = dateConverted["year"];
                            var month = dateConverted["month"];
                            var day = dateConverted["day"];
                            var d = new Date();
                            d.setFullYear(year);
                            d.setMonth(month - 1);
                            d.setDate(day);
                            d.setHours(0);
                            d.setMinutes(0);
                            d.setSeconds(0);
                            $wylqTable.data("date", d);
                            $wylqTable.trigger("queryShixiang");
                            $convertedTime.text("公历:" + year + "年" + month + "月" + day + "日");
                        }
                    }
                }
            });
        }

        return false;
    };

    $("#query-mtbtn").click(mt);
    $("#query-btbtn").click(mt);
    /*
     选择不同的历法  出现不同的年月日时
     */


    $(".year,.month,.day,.hour,.minute").empty();
    var $year = $(".year");
    var $month = $(".month");
    var $day = $(".day");
    var $hour = $(".hour");
    var $minute = $(".minute");
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();
    var hour = now.getHours();
    var minute = now.getMinutes();
    var days = getDaysOfYearMonth(year, month);
    $(".calendar-type").val("公历");
    addgreyear($year);
    addgremonth($month);
    addgreday($day, days);
    addgrehour($hour);
    addgreminute($minute);
    $year.val(year);
    $month.val(month);
    $day.val(day);
    $hour.val(hour);
    $minute.val(minute);
    $("#query-mtbtn").click();
    $("#query-btbtn").click();




    $(".form").each(function () {
        var $form = $(this);
        var $calendarType = $form.find(".calendar-type");
        var $year = $form.find(".year");
        var $month = $form.find(".month");
        var $day = $form.find(".day");
        var $hour = $form.find(".hour");
        var $minute = $form.find(".minute");
        var $lunarhourlink = $form.find(".lunarhourlink");
        $form.on("change", ".calendar-type", function () {
            /*
             如果历法变化的话，先清空所有的options,然后根据不同的历法插入不同的年月日时分
             */
            var calendartype = $calendarType.val();
            var year = $year.val();
            var month = $month.val();
            var day = $day.val();
            $form.find(".year, .month, .day, .hour, .minute").empty();
            if (calendartype == "农历") {
                $lunarhourlink.show();
                $lunarhourlink.text(lunarhourandlink[0][1]);
                var leapmonth = leapMonth(year);
                $minute.hide();
                addlunaryear($year);
                addlunarmonth($month, leapmonth);
                addlunarday(year, month, $day);
                addlunarhour($hour);
            } else {
                $lunarhourlink.hide();
                var days = getDaysOfYearMonth(year, month);
                $minute.show();
                addgreyear($year);
                addgremonth($month);
                addgreday($day, days);
                addgrehour($hour);
                addgreminute($minute);
            }
        });
        $form.on("change", ".year", function () {
            /*
             如果年份变化，尤其是农历年的时候，可能会有闰月，加以判断
             */
            var calendartype = $calendarType.val();
            var year = $year.val();
            var month = $month.val();
            var leapmonth = leapMonth(year);

            $form.find(".month, .day").empty();
            if (calendartype == "农历") {
                $lunarhourlink.show();
                $lunarhourlink.text(lunarhourandlink[0][1]);
                addlunarmonth($month, leapmonth);
                addlunarday(year, month, $day);
            } else {
                $lunarhourlink.hide();
                var daysofgre = getDaysOfYearMonth(year, month);
                addgremonth($month);
                addgreday($day, daysofgre);

            }
            //$form.find("")
        });
        $form.on("change", ".month", function () {
            var calendartype = $calendarType.val();
            var year = $year.val();
            var month = $month.val();
            //var hour = $hour.val();
            $form.find(".day").empty();
            if (calendartype == "农历") {
                $lunarhourlink.show();
                $lunarhourlink.text(lunarhourandlink[0][1]);
                addlunarday(year, month, $day);
            } else {
                $lunarhourlink.hide();
                var daysofgre = getDaysOfYearMonth(year, month);
                addgreday($day, daysofgre);
            }
            /*
             如果是月变化
             */
        });
        $form.on("change", ".hour", function () {
            var calendartype = $calendarType.val();
            var hourlink = $hour.val();
            if (calendartype == "农历"){
                $lunarhourlink.show();
                $lunarhourlink.text(lunarhourandlink[hourlink][1]);

            }else{
                $lunarhourlink.hide();
            }
        });
    });
});