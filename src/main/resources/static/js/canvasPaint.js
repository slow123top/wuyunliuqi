/**
 * Created by Hu_2015 on 2016/4/11.
 */
define(function() {
    var canvasPaint = {};
    canvasPaint.paintArc = function(ctx, x, y, r, length) {
        ctx.fillStyle = "#000000";
        ctx.beginPath();
        ctx.arc(x, y, r, 0, Math.PI * 2, true)
        ctx.closePath();
        ctx.lineWidth = length;
        ctx.stroke();
    };

    canvasPaint.paintLine = function(ctx, srcx, srcy, destx, desty) {
        ctx.fillStyle = "#000000";
        ctx.beginPath();
        ctx.moveTo(srcx, srcy);
        ctx.lineTo(destx, desty);
        ctx.lineWidth = 3;
        ctx.stroke();
    };

    canvasPaint.paintWord = function(ctx, canvas) {
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
    };

    canvasPaint.sonArc = function(ctx, property, count) {
        var x, y;
        var r = [12, 8, 16, 4, 20];
        var len = [2, 2, 2, 2, 2];
        if (count != 0) {
            for (var i = 0; i < count; i++) {
                switch (property) {
					//木
                    case 1:
                        x = 45 + r[i];
                        y = 180;
                        break;
						//金
                    case 2:
                        x = 355 - r[i];
                        y = 180;
                        break;
						//土
                    case 3:
                        x = 200;
                        y = 180;
                        break;
						//火
                    case 4:
                        x = 200;
                        y = 25 + r[i];
                        break;
						//水
                    case 5:
                        x = 200;
                        y = 335 - r[i];
                        break;
                }
                if (i > 2) {
                    canvasPaint.paintArc(ctx, x, y, r[i], len[i]);
                } else {
                    canvasPaint.paintArc(ctx, x, y, r[i], len[i]);
                }
            }
        }
    };

    canvasPaint.paintSonarc = function(ctx, sinum, kenum, zhongnum, zhunum, zainum) {
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
                        canvasPaint.sonArc(ctx, 2, 1);
                        break;
                    case 2:
                        canvasPaint.sonArc(ctx, 2, 2);
                        break;
                    case 3:
                        canvasPaint.sonArc(ctx, 2, 3);
                        break;
                    case 4:
                        canvasPaint.sonArc(ctx, 2, 4);
                        break;
                    case 5:
                        canvasPaint.sonArc(ctx, 2, 5);
                        break;
                }
            } else if (s[i] == 410 || s[i] == "410▲" || s[i] == "410▼") {//木
                mcount++;
                switch (mcount) {
                    case 1:
                        canvasPaint.sonArc(ctx, 1, 1);
                        break;
                    case 2:
                        canvasPaint.sonArc(ctx, 1, 2);
                        break;
                    case 3:
                        canvasPaint.sonArc(ctx, 1, 3);
                        break;
                    case 4:
                        canvasPaint.sonArc(ctx, 1, 4);
                        break;
                    case 5:
                        canvasPaint.sonArc(ctx, 1, 5);
                        break;
                }
            } else if (s[i] == 39 || s[i] == "39▲" || s[i] == "39▼") {//水
                scount++;
                switch (scount) {
                    case 1:
                        canvasPaint.sonArc(ctx, 5, 1);
                        break;
                    case 2:
                        canvasPaint.sonArc(ctx, 5, 2);
                        break;
                    case 3:
                        canvasPaint.sonArc(ctx, 5, 3);
                        break;
                    case 4:
                        canvasPaint.sonArc(ctx, 5, 4);
                        break;
                    case 5:
                        canvasPaint.sonArc(ctx, 5, 5);
                        break;
                }
            } else if (s[i] == 115 || s[i] == 17 || s[i] == "115▲" || s[i] == "115▼" || s[i] == "17▲" || s[i] == "17▼") {//火
                hcount++;
                switch (hcount) {
                    case 1:
                        canvasPaint.sonArc(ctx, 4, 1);
                        break;
                    case 2:
                        canvasPaint.sonArc(ctx, 4, 2);
                        break;
                    case 3:
                        canvasPaint.sonArc(ctx, 4, 3);
                        break;
                    case 4:
                        canvasPaint.sonArc(ctx, 4, 4);
                        break;
                    case 5:
                        canvasPaint.sonArc(ctx, 4, 5);
                        break;
                }
            } else if (s[i] == 126 || s[i] == "126▲" || s[i] == "126▼") {//土
                tcount++;
                switch (tcount) {
                    case 1:
                        canvasPaint.sonArc(ctx, 3, 1);
                        break;
                    case 2:
                        canvasPaint.sonArc(ctx, 3, 2);
                        break;
                    case 3:
                        canvasPaint.sonArc(ctx, 3, 3);
                        break;
                    case 4:
                        canvasPaint.sonArc(ctx, 3, 4);
                        break;
                    case 5:
                        canvasPaint.sonArc(ctx, 3, 5);
                        break;
                }
            }
        }

    }
    canvasPaint.drawShiXiangTu = function (elementId, sinum, kenum, zhongnum, zhunum, zainum) {
        var canvas = document.getElementById(elementId);
        var ctx;
        if (canvas) {
            ctx = canvas.getContext('2d');
            ctx.clearRect(0, 0, 400, 400);
            canvasPaint.paintArc(ctx, 80, 180, 35, 4);//木
            canvasPaint.paintArc(ctx, 200, 60, 35, 4);//火
            canvasPaint.paintArc(ctx, 320, 180, 35, 4);//金
            canvasPaint.paintArc(ctx, 200, 300, 35, 4);//水
            canvasPaint.paintArc(ctx, 200, 180, 35, 4);//土
            canvasPaint.paintLine(ctx, 200, 95, 200, 145);//上
            canvasPaint.paintLine(ctx, 200, 215, 200, 265);//下
            canvasPaint.paintLine(ctx, 115, 180, 165, 180);//左
            canvasPaint.paintLine(ctx, 235, 180, 285, 180);//右
            canvasPaint.paintWord(ctx, canvas);
            canvasPaint.paintSonarc(ctx, sinum, kenum, zhongnum, zhunum, zainum);
        }
    };
    return canvasPaint;
});