require.config({
    paths: {
        'jquery': '/assets/js/jquery.min',
        'zrender': '/assets/js/zrender',
        'zrender/shape/Circle': '/assets/js/zrender',
        'zrender/shape/Sector': '/assets/js/zrender',
        'zrender/shape/Ring': '/assets/js/zrender',
        'zrender/shape/Ellipse': '/assets/js/zrender',
        'zrender/shape/Heart': '/assets/js/zrender',
        'zrender/shape/Droplet': '/assets/js/zrender',
        'zrender/shape/Polyline': '/assets/js/zrender',
        'zrender/shape/Line': '/assets/js/zrender',
        'zrender/shape/BezierCurve': '/assets/js/zrender',
        'zrender/shape/Text': '/assets/js/zrender',
        'zrender/shape/Image': '/assets/js/zrender',
        'zrender/shape/Path': '/assets/js/zrender',
        'zrender/shape/Trochoid': '/assets/js/zrender',
        'zrender/shape/Rose': '/assets/js/zrender',
        'zrender/shape/Star': '/assets/js/zrender',
        'zrender/shape/Isogon': '/assets/js/zrender',
        'zrender/tool/color': '/assets/js/zrender',
        'zrender/ZRender' :'/assets/js/zrender'


}
});

define(['jquery', 'zrender', 'zrender/shape/Circle', 'zrender/tool/color', 'zrender/shape/Line', 'zrender/shape/Text', 'zrender/shape/Path'], function ($, zrender, CircleShape, color, LineShape, TextShape, Path) {
    var zrenderPaint = {};
    //画一个小型的漏斗形状
    zrenderPaint.paintPath = function (zr, pathx, pathy) {
        zr.addShape(new Path({
            style: {
                path: 'L20,27, L40,49, L20,49, L40,27 z',
                x: pathx,
                y: pathy,
                lineWidth: 1,
            },
            hoverable: false,
        }));
    };
    //画圆函数
    zrenderPaint.paintArc = function (zr, arcx, arcy, arcr, linelen, flag) {
        zrenderPaint.iconflag = true;
        zr.addShape(new CircleShape({
            style: {
                x: arcx,
                y: arcy,
                r: arcr,
                brushType: 'both',
                color: 'rgba(220, 20, 60, 0)',
                lineWidth: linelen
            },
            hoverable: flag,
            clickable: flag,
            onclick: function (params) {
                var pathx = params.event.offsetX;
                var pathy = params.event.offsetY;
                    //console.log(params);
                    zrenderPaint.paintPath(zr, pathx - 30, pathy - 35);
                    zrenderPaint.iconflag = false;

                //}
            }
        }));
    }
    //画直线函数
    zrenderPaint.paintLine = function (zr, startlinex, startliney, endlinex, endliney) {
        zr.addShape(new LineShape({
            style: {
                xStart: startlinex,
                yStart: startliney,
                xEnd: endlinex,
                yEnd: endliney,
                lineWidth: 2,

            }
        }));

    }
    //添加文字函数
    zrenderPaint.paintText = function (zr, text, textx, texty) {
        zr.addShape(new TextShape({
            style: {
                text: text,
                x: textx,
                y: texty,
                color: 'blue',
            },
            hoverable: false,
        }));
    }
    //大圆里面画小圆函数
    zrenderPaint.sonArc = function (zr, property, count, flag) {
        var x, y;
        var r = [9, 6, 12, 3, 15];
        if (count != 0) {
            for (var i = 0; i < count; i++) {
                switch (property) {
                    //木
                    case 1:
                        x = 15 + r[i];
                        y = 140;
                        break;
                    //金
                    case 2:
                        x = 235 - r[i];
                        y = 140
                        break;
                    //土
                    case 3:
                        x = 125;
                        y = 140;
                        break;
                    //火
                    case 4:
                        x = 125;
                        y = 30 + r[i];
                        break;
                    //水
                    case 5:
                        x = 125;
                        y = 250 - r[i];
                        break;
                }
                if (i > 2) {
                    zrenderPaint.paintArc(zr, x, y, r[i], 1, flag);
                } else {
                    zrenderPaint.paintArc(zr, x, y, r[i], 1, flag);
                }
            }
        }
    }
    //根据时相画出时相图函数
    zrenderPaint.paintSonarc = function (zr, sinum, kenum, zhongnum, zhunum, zainum, flag) {
        var jcount = 0;
        var mcount = 0;
        var scount = 0;
        var hcount = 0;
        var tcount = 0;
        var wylqnum = [sinum, kenum, zhongnum, zhunum, zainum];
        for (var i = 0; i < 5; i++) {
            if (wylqnum[i] == 28 || wylqnum[i] == "28▲" || wylqnum[i] == "28▼") {//金
                jcount++;
                switch (jcount) {
                    case 1:
                        zrenderPaint.sonArc(zr, 2, 1, flag);
                        break;
                    case 2:
                        zrenderPaint.sonArc(zr, 2, 2, flag);
                        break;
                    case 3:
                        zrenderPaint.sonArc(zr, 2, 3, flag);
                        break;
                    case 4:
                        zrenderPaint.sonArc(zr, 2, 4, flag);
                        break;
                    case 5:
                        zrenderPaint.sonArc(zr, 2, 5, flag);
                        break;
                }
            } else if (wylqnum[i] == 410 || wylqnum[i] == "410▲" || wylqnum[i] == "410▼") {//木
                mcount++;
                switch (mcount) {
                    case 1:
                        zrenderPaint.sonArc(zr, 1, 1, flag);
                        break;
                    case 2:
                        zrenderPaint.sonArc(zr, 1, 2, flag);
                        break;
                    case 3:
                        zrenderPaint.sonArc(zr, 1, 3, flag);
                        break;
                    case 4:
                        zrenderPaint.sonArc(zr, 1, 4, flag);
                        break;
                    case 5:
                        zrenderPaint.sonArc(zr, 1, 5, flag);
                        break;
                }
            } else if (wylqnum[i] == 39 || wylqnum[i] == "39▲" || wylqnum[i] == "39▼") {//水
                scount++;
                switch (scount) {
                    case 1:
                        zrenderPaint.sonArc(zr, 5, 1, flag);
                        break;
                    case 2:
                        zrenderPaint.sonArc(zr, 5, 2, flag);
                        break;
                    case 3:
                        zrenderPaint.sonArc(zr, 5, 3, flag);
                        break;
                    case 4:
                        zrenderPaint.sonArc(zr, 5, 4, flag);
                        break;
                    case 5:
                        zrenderPaint.sonArc(zr, 5, 5, flag);
                        break;
                }
            } else if (wylqnum[i] == 115 || wylqnum[i] == 17 || wylqnum[i] == "115▲" || wylqnum[i] == "115▼" || wylqnum[i] == "17▲" || wylqnum[i] == "17▼") {//火
                hcount++;
                switch (hcount) {
                    case 1:
                        zrenderPaint.sonArc(zr, 4, 1, flag);
                        break;
                    case 2:
                        zrenderPaint.sonArc(zr, 4, 2, flag);
                        break;
                    case 3:
                        zrenderPaint.sonArc(zr, 4, 3, flag);
                        break;
                    case 4:
                        zrenderPaint.sonArc(zr, 4, 4, flag);
                        break;
                    case 5:
                        zrenderPaint.sonArc(zr, 4, 5, flag);
                        break;
                }
            } else if (wylqnum[i] == 126 || wylqnum[i] == "126▲" || wylqnum[i] == "126▼") {//土
                tcount++;
                switch (tcount) {
                    case 1:
                        zrenderPaint.sonArc(zr, 3, 1, flag);
                        break;
                    case 2:
                        zrenderPaint.sonArc(zr, 3, 2, flag);
                        break;
                    case 3:
                        zrenderPaint.sonArc(zr, 3, 3, flag);
                        break;
                    case 4:
                        zrenderPaint.sonArc(zr, 3, 4, flag);
                        break;
                    case 5:
                        zrenderPaint.sonArc(zr, 3, 5, flag);
                        break;
                }
            }
        }
    }
    //执行以上函数  画出时相图
    zrenderPaint.drawShiXiangTu = function (sinum, kenum, zhongnum, zhunum, zainum, flag) {
        zrenderPaint.zr = zrender.init(document.getElementById('bt-zrender'));
        zrenderPaint.colorIdx = 0;
        zrenderPaint.zr.clear();
        //画出金木水火土的大圈
        //金
        zrenderPaint.paintArc(zrenderPaint.zr, 210, 140, 25, 3, flag);
        //木
        zrenderPaint.paintArc(zrenderPaint.zr, 40, 140, 25, 3, flag);
        //水zrenderPaint.zr
        zrenderPaint.paintArc(zrenderPaint.zr, 125, 225, 25, 3, flag);
        //火zrenderPaint.zr
        zrenderPaint.paintArc(zrenderPaint.zr, 125, 55, 25, 3, flag);
        //土zrenderPaint.zr
        zrenderPaint.paintArc(zrenderPaint.zr, 125, 140, 25, 3, flag);
        //添加文本
        zrenderPaint.paintText(zrenderPaint.zr, "金", 210, 105);
        zrenderPaint.paintText(zrenderPaint.zr, "木", 40, 105);
        zrenderPaint.paintText(zrenderPaint.zr, "水", 85, 225);
        zrenderPaint.paintText(zrenderPaint.zr, "火", 85, 55);
        zrenderPaint.paintText(zrenderPaint.zr, "土", 150, 110);
        ////画出对应的线段
        zrenderPaint.paintLine(zrenderPaint.zr, 65, 140, 100, 140);
        zrenderPaint.paintLine(zrenderPaint.zr, 150, 140, 185, 140);
        zrenderPaint.paintLine(zrenderPaint.zr, 125, 80, 125, 115);
        zrenderPaint.paintLine(zrenderPaint.zr, 125, 165, 125, 200);
        //画出时相图
        zrenderPaint.paintSonarc(zrenderPaint.zr, sinum, kenum, zhongnum, zhunum, zainum, flag);
        zrenderPaint.zr.render();
    };
    return zrenderPaint;
});
