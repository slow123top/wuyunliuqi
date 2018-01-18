/**
 * Created by Hu_2015 on 2016/4/12.
 */
$(function() {

    $("#query-btbtn").on("click", function () {

        sessionStorage.setItem("sitian", $("#sitian").text());
        sessionStorage.setItem("keqi", $("#keqi").text());
        sessionStorage.setItem("zhongyun", $("#zhongyun").text());
        sessionStorage.setItem("zhuqi", $("#zhuqi").text());
        sessionStorage.setItem("zaiquan", $("#zaiquan").text());
        sessionStorage.setItem("sitiannum", $("#sitiannum").text());
        sessionStorage.setItem("keqinum", $("#keqinum").text());
        sessionStorage.setItem("zhongyunnum", $("#zhongyunnum").text());
        sessionStorage.setItem("zhuqinum", $("#zhuqinum").text());
        sessionStorage.setItem("zaiquannum", $("#zaiquannum").text());

        //$("#query-btbtn").click(setSessionstorage);
    });
});