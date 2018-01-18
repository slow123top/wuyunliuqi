/**
 * Created by Hu_2015 on 2016/4/12.
 */
$(function(){
    var sitian      = sessionStorage.getItem("sitian");
    var keqi        = sessionStorage.getItem("keqi");
    var zhongyun    = sessionStorage.getItem("zhongyun");
    var zhuqi       = sessionStorage.getItem("zhuqi");
    var zaiquan     = sessionStorage.getItem("zaiquan");
    var sitiannum   = sessionStorage.getItem("sitiannum");
    var keqinum     = sessionStorage.getItem("keqinum");
    var zhongyunnum = sessionStorage.getItem("zhongyunnum");
    var zhuqinum    = sessionStorage.getItem("zhuqinum");
    var zaiquannum  = sessionStorage.getItem("zaiquannum");

    $(".sitian-text").text(sitian);
    $(".keqi-text").text(keqi);
    $(".zhongyun-text").text(zhongyun);
    $(".zhuqi-text").text(zhuqi);
    $(".zaiquan-text").text(zaiquan);
    $(".sitian-num").text(sitiannum);
    $(".keqi-num").text(keqinum);
    $(".zhongyun-num").text(zhongyunnum);
    $(".zhuqi-num").text(zhuqinum);
    $(".zaiquan-num").text(zaiquannum);
});