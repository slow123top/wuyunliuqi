<div id="header">
    <div id="login-area" class="am-fr">
        <button id="login" type="button" class="red-btn"
                data-am-modal="{target: '#login-modal', closeViaDimmer: 0}">
            登录
        </button>
        <button id="sig" type="button" class="red-btn"
                data-am-modal="{target: '#sig-modal', closeViaDimmer: 0}">
            注册
        </button>
        <button id="logout" type="button" class="red-btn">
            <a href="${contextPath!}/logout">注销</a>
        </button>
    </div>
    <div class="am-modal am-modal-no-btn modal-with-captcha" tabindex="-1" id="login-modal">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">登录
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <div class="am-modal-bd">
                <form class="am-form am-form-horizontal" action="/login" method="post">
                    <div class="am-form-group">
                        <label for="login-username" class="am-u-sm-2 am-form-label">用户名</label>
                        <div class="am-u-sm-10">
                            <input name="username" type="text" id="login-username" placeholder="请输入您的用户名">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="login-password" class="am-u-sm-2 am-form-label">密码</label>
                        <div class="am-u-sm-10">
                            <input name="password" type="password" id="login-password"
                                   placeholder="请输入您的密码">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="login-captcha" class="am-u-sm-2 am-form-label">验证码</label>
                        <div class="am-u-sm-6">
                            <input name="captcha" type="text" id="login-captcha" placeholder="请输入验证码">
                        </div>
                        <div class="am-u-sm-4">
                            <img src="#/captcha" data-src="/captcha" class="captcha-img">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-10 am-u-sm-offset-1">
                            <span class="am-badge am-badge-danger" id="login-error-messaage"></span>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-10 am-u-sm-offset-1">
                            <button id="login-btn" type="submit" class="am-btn am-btn-default">登陆</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="am-modal am-modal-no-btn modal-with-captcha" tabindex="-1" id="sig-modal">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">请注册
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <div class="am-modal-bd">
                <form class="am-form am-form-horizontal" action="/register" method="post">
                    <div class="am-form-group">
                        <label for="register-username" class="am-u-sm-2 am-form-label">用户名</label>
                        <div class="am-u-sm-10">
                            <input name="username" type="text" id="register-username"
                                   placeholder="请输入您的用户名">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="register-displayName" class="am-u-sm-2 am-form-label">昵称</label>
                        <div class="am-u-sm-10">
                            <input name="displayName" type="text" id="register-displayName"
                                   placeholder="请输入您的昵称（用于显示）">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="register-password" class="am-u-sm-2 am-form-label">密码</label>
                        <div class="am-u-sm-10">
                            <input name="password" type="password" id="register-password"
                                   placeholder="请输入您的密码">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="register-captcha" class="am-u-sm-2 am-form-label">验证码</label>
                        <div class="am-u-sm-6">
                            <input name="captcha" type="text" id="register-captcha" placeholder="请输入验证码">
                        </div>
                        <div class="am-u-sm-4">
                            <img src="#/captcha" data-src="/captcha" class="captcha-img">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-10 am-u-sm-offset-1">
                            <span class="am-badge am-badge-danger" id="register-error-messaage"></span>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-10 am-u-sm-offset-1">
                            <button type="submit" id="register-btn" class="am-btn am-btn-default">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>