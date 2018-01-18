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
        'zrender/config': '/assets/js/zrender'
    }
});

require(['jquery', 'zrender', 'zrender/shape/Circle', 'zrender/shape/Line', 'zrender/config','zrender/tool/color'], function ($, zrender, CircleShape, LineShape,config) {

    var icon = true;
    var zr = zrender.init(document.getElementById('demo'));
    var colorIdx = 0;
    var $demo = document.getElementById('demo');
    // 金
    zr.clear();
    zr.addShape(new CircleShape({
        style: {
            x: 210,
            y: 140,
            r: 25,
            brushType: 'both',
            color: 'rgba(0, 0, 60, 0)',          // rgba supported
            //strokeColor: color.getColor(colorIdx++),  // getColor from default palette
            lineWidth: 3,
        },
        clickable: true,   // default false

        // 可自带任何有效自定义属性
        //_name: 'Hello~',
        //onclick : function(event) {
        //    //var target = params.target;
        //    var x = event.clientX;
        //    console.log(x);
        //}
    }));
    //木
    zr.addShape(new CircleShape({
        style: {
            x: 40,
            y: 140,
            r: 25,
            brushType: 'both',
            color: 'rgba(220, 20, 60, 0)',          // rgba supported
            //strokeColor: color.getColor(colorIdx++),  // getColor from default palette
            lineWidth: 3,
            text: 'circle',
            textPosition: 'inside'
        },
        clickable: true,   // default false

        // 可自带任何有效自定义属性
        _name: 'Hello~',
        onclick: function () {
            $(".coolscrollbar").show();
        }
    }));
    //水
    zr.addShape(new CircleShape({
        style: {
            x: 125,
            y: 225,
            r: 25,
            brushType: 'both',
            color: 'rgba(220, 20, 60, 0)',          // rgba supported
            //strokeCol0or: color.getColor(colorIdx++),  // getColor from default palette
            lineWidth: 3,
            text: 'circle',
            textPosition: 'inside'
        },
        clickable: true,   // default false

        // 可自带任何有效自定义属性
        _name: 'Hello~',
        onclick: function () {
            $(".coolscrollbar").show();
        }
    }));
    //火
    zr.addShape(new CircleShape({
        style: {
            x: 125,
            y: 55,
            r: 25,
            brushType: 'both',
            color: 'rgba(220, 20, 60, 0)',          // rgba supported
            //strokeColor: color.getColor(colorIdx++),  // getColor from default palette
            lineWidth: 3,
            text: 'circle',
            textPosition: 'inside'
        },
        clickable: true,   // default false

        // 可自带任何有效自定义属性
        _name: 'Hello~',
        onclick: function () {
            $(".coolscrollbar").show();
        }
    }));
    //土
    zr.addShape(new CircleShape({
        style: {
            x: 125,
            y: 140,
            r: 25,
            brushType: 'both',
            color: 'rgba(220, 20, 60, 0)',          // rgba supported
            //strokeColor: color.getColor(colorIdx++),  // getColor from default palette
            lineWidth: 3,
            text: 'circle',
            textPosition: 'inside'
        },
        clickable: true,   // default false

        // 可自带任何有效自定义属性
        _name: 'Hello~',
        onclick: function () {
            $(".coolscrollbar").show();
        }
    }));

    //hoverable: true,   // default true
    //draggable: true,   // default false

    zr.render();
    zr.on(
        config.EVENT.CLICK,
        function(params) {
            if (params.target) {
                alert(params.target.style.offsetX);
            }
            else {
                alert('None shape, but i catch you!');
            }
        }
    );
});