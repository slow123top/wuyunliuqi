$(function () {

    function changeCaptchaSrc(img){
        $(img).attr('src', '/captcha?' + Math.random());
    }

    /*
     验证码
     */
    $('.captcha-img').on('click', function () {
        changeCaptchaSrc(this);
    });

    $('#login-modal').on('open.modal.amui', function(){
        changeCaptchaSrc($(this).find('.captcha-img'));
    });

    /*
     登录
     */
    $('#login-btn').on('click', function () {
        var username = $('#login-username').val();
        var password = $('#login-password').val();
        var captcha = $('#login-captcha').val();
        $.ajax({
            url: '/api/login',
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