<html>
<#include "head.ftl">
<body>
<div id="body-wrap">
<#include "body-header.ftl">
    <div id="main-content" class="am-cf">
    <#include "main-left.ftl">
        <div id="main-right">
            <div id="main-right-up">
                <div id="date-container">
                    <form name="form" action="" method="get" class="form" id="ming-form">
                        <label>出生日期：</label>

                        <select id="calendar-type" class="calendar-type" name="calendarType">
                            <option value="公历">公历</option>
                            <option value="农历">农历</option>
                        </select>
                        <select id="year" class="year" name="YYYY">

                            <option id="m-year" class="m-year"></option>

                        </select>
                        <select id="month" class="month" name="MM">

                            <option class="m-month"></option>

                        </select>
                        <select id="day" class="day" name="DD">

                            <option class="m-day"></option>

                        </select>
                        <select id="hour" class="hour" name="HH">

                            <option class="m-hour"></option>

                        </select>

                        <select id="minute" class="minute" name="mm">
                            <option class="m-minute"></option>
                        </select>
                        <span class="lunarhourlink"></span>
                        <input type="submit" value="查询" class="red-btn" id="query-mtbtn"/>
                    </form>
                    <div id="convertTime" style="align-content: flex-end" class="convertedDateTime"></div>
                </div>
                <div id="mingtu" class="am-cf shixiangtu">
                    <div id="wylq-table" class="am-fl am-cf wylq-table">
                        <div id="wylq-table-left" class="am-fl">
                            <table class="am-table am-table-bordered">
                                <tr>
                                    <td>
                                        <div>司天</div>
                                    </td>
                                    <td>
                                        <div class="sitian-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>客气</div>
                                    </td>
                                    <td>
                                        <div class="keqi-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>中运</div>
                                    </td>
                                    <td>
                                        <div class="zhongyun-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>主气</div>
                                    </td>
                                    <td>
                                        <div class="zhuqi-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>在泉</div>
                                    </td>
                                    <td>
                                        <div class="zaiquan-text"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="wylq-table-arrow" class="am-fl">
                            <img src='/img/arrow.png'/>
                        </div>
                        <div id="wylq-table-right" class="am-fl">
                            <table class="am-table am-table-bordered">
                                <tr>
                                    <td>
                                        <div id="sinum" class="sitian-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="kenum" class="keqi-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="zhongnum" class="zhongyun-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="zhunum" class="zhuqi-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="zainum" class="zaiquan-num"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div id="wylq-image" class="am-fr wylq-image">
                        <canvas id="wylq-canvas" class="wylq-canvas" width="400" height="400">你的浏览器不支持canvas
                        </canvas>
                        <div id="mt">命图</div>
                    </div>
                </div>
            </div>
            <div id="main-right-down">
                <div id="date-container2">
                    <form name="form" action="/wuyunliuqitu" method="get" class="form" id="bing-form">
                        <label>发病日期：</label>

                        <select id="calendar-type2" class="calendar-type" name="datetwo">
                            <option value="公历">公历</option>
                            <option value="农历">农历</option>
                        </select>

                        </select>
                        <select id="year2" class="year" name="YYYY">

                            <option class="b-year"></option>

                        </select>

                        <select id="month2" class="month" name="MM">

                            <option class="b-month"></option>

                        </select>

                        <select id="day2" class="day" name="DD">

                            <option class="b-day"></option>

                        </select>

                        <select id="hour2" class="hour" name="HH">

                            <option class="b-hour"></option>

                        </select>

                        <select id="minute2" class="minute" name="mm">
                            <option class="b-minute"></option>
                        </select>
                        <span id="lunarhourlink2" class="lunarhourlink"></span>
                        <input type="submit" value="查询" class="red-btn" id="query-btbtn"/>
                    </form>
                    <div id="convertTime2" style="align-content: flex-end" class="convertedDateTime"></div>
                </div>
                <div id="prescription-date" style="display: none">
                </div>
                <span id="riqi"></span>
                <span id="lifa"></span>
                <span id="lifa-year"></span>
                <span id="lifa-month"></span>
                <span id="lifa-day"></span>
                <span id="lifa-hour"></span>
                <span id="lifa-minute"></span>
                <span id="lifa-hourlink"></span>
                <div id="bingtu" class="am-cf shixiangtu">
                    <div id="wylq-table2" class="am-fl am-cf wylq-table">
                        <div id="wylq-table-left2" class="am-fl">
                            <table class="am-table am-table-bordered">
                                <tr>
                                    <td>
                                        <div>司天</div>
                                    </td>
                                    <td>
                                        <div id="sitian" class="sitian-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>客气</div>
                                    </td>
                                    <td>
                                        <div id="keqi" class="keqi-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>中运</div>
                                    </td>
                                    <td>
                                        <div id="zhongyun" class="zhongyun-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>主气</div>
                                    </td>
                                    <td>
                                        <div id="zhuqi" class="zhuqi-text"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>在泉</div>
                                    </td>
                                    <td>
                                        <div id="zaiquan" class="zaiquan-text"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="wylq-table-arrow2" class="am-fl">
                            <img src='/img/arrow.png'/>
                        </div>
                        <div id="wylq-table-right2" class="am-fl">
                            <table class="am-table am-table-bordered">
                                <tr>
                                    <td>
                                        <div id="sitiannum" class="sitian-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="keqinum" class="keqi-num"></div>
                                    </td>
                                </tr>
                                <tr>

                                    <td>
                                        <div id="zhongyunnum" class="zhongyun-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="zhuqinum" class="zhuqi-num"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="zaiquannum" class="zaiquan-num"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div id="wylq-bt" class="am-fr">
                        <div id="bt-zrender"></div>
                        <div id="bt">
                            病图
                        </div>
                    </div>
                </div>
            </div>
            <textarea class="coolscrollbar" style="display: none"></textarea>
            <div id="medicine-select" style="display: none">
                <label>中成药：</label>
                <select id="zhongchengyao" class="zhongchengyao" name="zcy">
                    <option>山楂丸</option>
                    <option>山楂丸</option>
                    <option>山楂丸</option>
                    <option>山楂丸</option>
                </select>
                <label>药方：</label>
                <select id="yaofang" class="yaofang" name="yf">
                    <option>药方</option>
                </select>
                <label>药材：</label>
                <select id="yaocai" class="yaocai" name="yc">
                    <option>清半夏</option>
                    <option>五味子</option>
                    <option>甘草</option>
                </select>
            </div>
        </div>
    </div>
<#include "body-footer.ftl">
</div>
<#include "common-js.ftl">
<script src="js/loginAndSignUp.js"></script>
<#--<script src="js/wuyunliuqituAjax.js"></script>-->
<#--<script src="js/require.js" data-main="js/convertedTimeDo.js" ></script>-->
<script src="js/require.js" data-main="js/query.js"></script>
<#--<script src="js/require.js" data-main="js/zrenderPaint.js"></script>-->

<#--<script src="js/getPrescriptionInfo.js"></script>-->

</body>

</html>
