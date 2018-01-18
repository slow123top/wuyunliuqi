require.config({
                   paths: {
                       'jquery': '/assets/js/jquery.min',
                       'amui': '/assets/js/amazeui.min'
                   },
                   shim: {
                       'amui': ['jquery']
                   }
               });
require(['jquery','amui'],function($) {
    $(function () {

        function changeCaptchaSrc(img) {
            $(img).attr('src', '/captcha?' + Math.random());
        }

        /*
         验证码
         */
        $('.captcha-img').on('click', function () {
            changeCaptchaSrc(this);
        });

        $('#login-modal').on('open.modal.amui', function () {
            changeCaptchaSrc($(this).find('.captcha-img'));
        });

        /*
         登录
         */
        //按钮id是login-btn    on()，是一个函数，第一个参数是事件类型，这里是点击就用click，第二个参数是回调函数  用于处理你的controller返回的响应
        $('#login-btn').on('click', function () {
            //这里的username password captcha就好比你的两个时间参数
            var username = $('#login-username').val();
            var password = $('#login-password').val();
            var captcha = $('#login-captcha').val();
            //ajax是jQuery封装好的专门用于胡后端进行交互的一个函数  以后你如果用这个，就按照这种格式来写就行
            //里面的url就是你后端的接口  type是指明get或者post方法，data是一个js对象，也可以是一个json,用于存储你要传递的参数，
            // 里面的内容是键值对形式，后端获取的时候就是获取这里面的参数名
            //success是说与后端连接成功之后要处理的方法，其实就是函数，你返回的表格数据就在这个函数里面处理
            $.ajax({
                url: '/login',
                type: 'POST',
                data: {username: username, password: password, captcha: captcha},
                success: function (data) {
                    if (data['status'] == 'SUCCESS') {
                        location.href = data['data']['jumpUrl'];
                    } else {
                        $('#login-error-messaage').text(data['message']);
                    }
                }
            });
            return false;
        });
        /*
         注册
         */
        $('#register-btn').on('click', function () {
            var username = $('#register-username').val();
            var password = $('#register-password').val();
            var displayName = $('#register-displayName').val();
            var captcha = $('#register-captcha').val();
            $.ajax({
                url: '/register',
                type: 'POST',
                data: {username: username, displayName: displayName, password: password, captcha: captcha},
                success: function (data) {
                    $('#register-error-messaage').text(data['message']);
                }
            });
            return false;
        });
    });
});