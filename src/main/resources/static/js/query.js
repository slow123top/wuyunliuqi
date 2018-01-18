/**
 * Created by Hu_2015 on 2016/4/12.
 */
/*
 命图和病图搜索按钮触发函数
 */
require.config({
    paths: {
        'jquery': '/assets/js/jquery.min',
    }
});
require(['jquery', 'liandongTime', 'getShiXiang','getPrescriptionInfo'], function ($, ct) {

    //绑定时相表获取信息的事件
    var bt = function () {
        var $this = $(this);
        var $form = $this.parents("form");
        var $convertedTime = $form.parent().children().filter(".convertedDateTime");
        var $wylqTable = $form.parent().parent().children().find("#wylq-table2");

        var calendarConvertApiUrl = "/api/calendar-convert";

        var calendarType = $form.children(".calendar-type").val();
        var year = $form.children(".year").val();
        var month = $form.children(".month").val();
        var day = $form.children(".day").val();
        var hour = $form.children(".hour").val();
        var minute = $form.children(".minute").val();


        //var sitian = $wylqTable.children().find("#sitian").text();
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
            $wylqTable.trigger("querybtShixiang");

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
                            var monthString = ct.lunarmonth[month - 1];
                            var dayString = ct.lunarday[dateConverted["day"] - 1];
                            var dateTimeConvertedString = "农历:" + ganzhi + "年" + monthPrefix + monthString + dayString
                                + ct.lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][0]
                                + ct.lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][1];
                            $convertedTime.text(dateTimeConvertedString);
                        }
                    }
                }
            });
            //se.setSessionstorage;
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
                            $wylqTable.trigger("querybtShixiang");
                            $convertedTime.text("公历:" + year + "年" + month + "月" + day + "日");
                        }
                    }
                }
            });
            //se.setSessionstorage;
        }

        return false;
    };
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
                            var monthString = ct.lunarmonth[month - 1];
                            var dayString = ct.lunarday[dateConverted["day"] - 1];
                            var dateTimeConvertedString = "农历:" + ganzhi + "年" + monthPrefix + monthString + dayString
                                + ct.lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][0]
                                + ct.lunarhourandlink[Math.floor((parseInt(hour) + 1) / 2) % 12][1];
                            $convertedTime.text(dateTimeConvertedString);
                        }
                    }
                }
            });
            //se.setSessionstorage;
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
            //se.setSessionstorage;
        }

        return false;
    };
    $("#query-mtbtn").click(mt);
    $("#query-btbtn").click(bt);
    $("#query-mtbtn").click();
    $("#query-btbtn").click();
});