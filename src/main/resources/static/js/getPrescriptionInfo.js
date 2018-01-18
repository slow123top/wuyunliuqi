/**
 * Created by Hu_2015 on 2016/4/11.
 */
define(['jquery','zrenderPaint'],function($,zrenderPaint){
    $("#wuyunliuqi").on("click", function () {
        var flag = false;
        var prescriptionbtSitian = $("#sitiannum").text();
        var prescriptionbtKeqi = $("#keqinum").text();
        var prescriptionbtZhongyun = $("#zhongyunnum").text();
        var prescriptionbtZhuqi = $("#zhuqinum").text();
        var prescriptionbtZaiquan = $("#zaiquannum").text();
        $("#prescription-date").hide();
        $("#riqi,#lifa,#lifa-year,#lifa-month,#lifa-day,#lifa-hour,#lifa-minute,#lifa-hourlink").hide();
        $("#main-right-up").show();
        $("#main-right-down").show();
        $("#date-container2").show();
        zrenderPaint.drawShiXiangTu(prescriptionbtSitian,prescriptionbtKeqi,prescriptionbtZhongyun,
            prescriptionbtZhuqi,prescriptionbtZaiquan,flag);
    });
    $("#chufang").on("click", function () {
        var flag = true;
        $("#medicine-select").show();
        $(".coolscrollbar").show();
        $("#date-container2").hide();
        $("#prescription-date").show();
        var prescriptionCalendar = $("#calendar-type2").val();
        var prescriptionYear = $("#year2").find("option:selected").text();
        var prescriptionMonth = $("#month2").find("option:selected").text();
        var prescriptionDay = $("#day2").find("option:selected").text();
        var prescriptionHour = $("#hour2").find("option:selected").text();
        var prescriptionMinute = $("#minute2").find("option:selected").text();
        var prescriptionHourlink = $("#lunarhourlink2").text();
        var prescriptionbtSitian = $("#sitiannum").text();
        var prescriptionbtKeqi = $("#keqinum").text();
        var prescriptionbtZhongyun = $("#zhongyunnum").text();
        var prescriptionbtZhuqi = $("#zhuqinum").text();
        var prescriptionbtZaiquan = $("#zaiquannum").text();
        if (prescriptionCalendar == "公历") {
            $("#prescription-date").text("日期：" + prescriptionCalendar + prescriptionYear
                + prescriptionMonth + prescriptionDay + prescriptionHour + prescriptionMinute);

        } else {
            $("#prescription-date").text("日期：" + prescriptionCalendar + prescriptionYear
                + prescriptionMonth + prescriptionDay + prescriptionHour + prescriptionHourlink);
        }
        zrenderPaint.drawShiXiangTu(prescriptionbtSitian,prescriptionbtKeqi,prescriptionbtZhongyun,
            prescriptionbtZhuqi,prescriptionbtZaiquan,flag);
        $("#main-right-up").hide();
    });
});