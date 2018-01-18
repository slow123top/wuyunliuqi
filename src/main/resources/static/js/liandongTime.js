/**
 * Created by Hu_2015 on 2016/4/11.
 */

define(['jquery'],function ($) {
    var liandongTime = {};
    liandongTime.lunarInfo = [
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
//======================================= 返回农历 y年的闰月的天数
    liandongTime.leapDays = function (y) {
        if (liandongTime.leapMonth(y)) {
            return ((liandongTime.lunarInfo[y - 1900] & 0x10000) ? 30 : 29)
        } else {
            return (0)
        }
    };

//======================================= 返回农历 y年闰哪个月 1-12，没闰返回 0
    liandongTime.leapMonth = function (y) {
        return parseInt(liandongTime.lunarInfo[y - 1900] & 0xf)
    };

//======================================= 返回农历 y年m月的总天数
    liandongTime.monthDays = function (y, m) {
        return ( (liandongTime.lunarInfo[y - 1900] & (0x10000 >> m)) ? 30 : 29 )
    };

//公历获得某年某月的天数
    liandongTime.getDaysOfYearMonth = function (year, month) {
        var isLeapYear = function (year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        };
        var daysOfMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        daysOfMonth[1] = isLeapYear(year) ? 29 : 28;
        return daysOfMonth[month - 1];
    };
    /*
     农历月份
     */
    liandongTime.lunarmonth = ["正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月",
        "", "闰二月", "闰三月", "闰四月", "闰五月", "闰六月", "闰七月", "闰八月", "闰九月", "闰十月"];

    /*
     农历日期
     */
    liandongTime.lunarday = [
        "初一",
        "初二",
        "初三",
        "初四",
        "初五",
        "初六",
        "初七",
        "初八",
        "初九",
        "初十",
        "十一",
        "十二",
        "十三",
        "十四",
        "十五",
        "十六",
        "十七",
        "十八",
        "十九",
        "廿十",
        "廿一",
        "廿二",
        "廿三",
        "廿四",
        "廿五",
        "廿六",
        "廿七",
        "廿八",
        "廿九",
        "卅十"];
    /*
     农历时辰及其对应关系
     */
    liandongTime.lunarhourandlink = [
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
    liandongTime.tiangan = [
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
    liandongTime.dizhi = [
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
    liandongTime.addgreyear = function (year) {
        for (var i = 1900; i <= 2100; i++) {
            year.append("<option value='" + i + "'>" + i + "年</option>");
        }
    };
    liandongTime.addgremonth = function (month) {
        for (var i = 1; i <= 12; i++) {
            month.append("<option value='" + i + "'>" + i + "月</option>");
        }
    };
    liandongTime.addgreday = function (day, daysOfgreM) {
        for (var i = 1; i <= daysOfgreM; i++) {
            day.append("<option value='" + i + "'>" + i + "日</option>");
        }
    };
    liandongTime.addgrehour = function (hour) {
        for (var i = 0; i <= 23; i++) {
            hour.append("<option value='" + i + "'>" + i + "时</option>");
        }
    };
    liandongTime.addgreminute = function (minute) {
        for (var i = 0; i <= 59; i++) {
            minute.append("<option value='" + i + "'>" + i + "分</option>");
        }
    };
    liandongTime.addlunaryear = function (year) {
        var i = 1900, j = 6, k = 0;
        for (i, j, k; i <= 2100; i++, j++, k++) {
            j = j % 10;
            k = k % 12;
            year.append("<option value='" + i + "'>" + liandongTime.tiangan[j] + "" + liandongTime.dizhi[k] + "（" + i + "）年</option>");
        }
    };
    liandongTime.addlunarmonth = function ($month, leapMonth) {
        var months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        if (leapMonth != 0) {
            var firstPart = months.slice(0, leapMonth);
            var leapPart = [leapMonth + 12];
            var lastPart = months.slice(leapMonth, 12);
            months = firstPart.concat(leapPart).concat(lastPart);
        }
        months.forEach(function (month) {
            $month.append("<option value='" + month + "'>" + liandongTime.lunarmonth[month - 1] + "</option>")
        });
    };
    liandongTime.addlunarday = function (year, month, $day) {
        var daysoflunarMonth;
        if (month > 12) {
            //闰月
            daysoflunarMonth = liandongTime.leapDays(year);
        } else {
            daysoflunarMonth = liandongTime.monthDays(year, month);
        }
        for (var i = 1; i <= daysoflunarMonth; i++) {
            $("<option></option>").text(liandongTime.lunarday[i - 1]).val(i).appendTo($day);
            //$day.append("<option value='" + i + "'>" + lunarday[i - 1] + "</option>");
        }
    };
    liandongTime.addlunarhour = function (hour) {
        for (var i = 0; i < 12; i++) {
            hour.append("<option value='" + i + "'>" + liandongTime.lunarhourandlink[i][0] + "</option>");
        }
    };
    $(".year,.month,.day,.hour,.minute").empty();
    liandongTime.$year = $(".year");
    liandongTime.$month = $(".month");
    liandongTime.$day = $(".day");
    liandongTime.$hour = $(".hour");
    liandongTime.$minute = $(".minute");
    liandongTime.now = new Date();
    liandongTime.year = liandongTime.now.getFullYear();
    liandongTime.month = liandongTime.now.getMonth() + 1;
    liandongTime.day = liandongTime.now.getDate();
    liandongTime.hour = liandongTime.now.getHours();
    liandongTime.minute = liandongTime.now.getMinutes();
    liandongTime.days = liandongTime.getDaysOfYearMonth(year, month);
    $(".calendar-type").val("公历");
    liandongTime.addgreyear($(".year"));
    liandongTime.addgremonth($(".month"));
    liandongTime.addgreday($(".day"), liandongTime.getDaysOfYearMonth(liandongTime.year,liandongTime.month));
    liandongTime.addgrehour($(".hour"));
    liandongTime.addgreminute($(".minute"));
    liandongTime.$year.val(liandongTime.year);
    liandongTime.$month.val(liandongTime.month);
    liandongTime.$day.val(liandongTime.day);
    liandongTime.$hour.val(liandongTime.hour);
    liandongTime.$minute.val(liandongTime.minute);
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
                $lunarhourlink.text(liandongTime.lunarhourandlink[0][1]);
                var leapmonth = liandongTime.leapMonth(year);
                $minute.hide();
                liandongTime.addlunaryear($year);
                liandongTime.addlunarmonth($month, leapmonth);
                liandongTime.addlunarday(year, month, $day);
                liandongTime.addlunarhour($hour);
            } else {
                $lunarhourlink.hide();
                var days = liandongTime.getDaysOfYearMonth(year, month);
                $minute.show();
                liandongTime.addgreyear($year);
                liandongTime.addgremonth($month);
                liandongTime.addgreday($day, days);
                liandongTime.addgrehour($hour);
                liandongTime.addgreminute($minute);
            }
        });
        $form.on("change", ".year", function () {
            /*
             如果年份变化，尤其是农历年的时候，可能会有闰月，加以判断
             */
            var calendartype = $calendarType.val();
            var year = $year.val();
            var month = $month.val();
            var leapmonth = liandongTime.leapMonth(year);

            $form.find(".month, .day").empty();
            if (calendartype == "农历") {
                $lunarhourlink.show();
                $lunarhourlink.text(liandongTime.lunarhourandlink[0][1]);
                liandongTime.addlunarmonth($month, leapmonth);
                liandongTime.addlunarday(year, month, $day);
            } else {
                $lunarhourlink.hide();
                var daysofgre = liandongTime.getDaysOfYearMonth(year, month);
                liandongTime.addgremonth($month);
                liandongTime.addgreday($day, daysofgre);

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
                $lunarhourlink.text(liandongTime.lunarhourandlink[0][1]);
                liandongTime.addlunarday(year, month, $day);
            } else {
                $lunarhourlink.hide();
                var daysofgre = liandongTime.getDaysOfYearMonth(year, month);
                liandongTime.addgreday($day, daysofgre);
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
                $lunarhourlink.text(liandongTime.lunarhourandlink[hourlink][1]);

            }else{
                $lunarhourlink.hide();
            }
        });
    });
    return liandongTime;
});