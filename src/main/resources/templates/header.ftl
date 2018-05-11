<div class="super-navigation">
    <!--自定义导航-->
    <div class="super-navigation-main">
        <div class="super-setting-left">
            <div class="super-navigation-title">
            	<img src="assets/images/logo.png" width="40" height="40" align="absmiddle">  吉林智明社内管理システム</div>
        </div>
        <div class="super-setting-right">
            <ul>
                <li class="user">
                    <div class="super-setting-icon">
                        <span class="user-icon">
                            <@shiro.hasRole name="lv5" ><img src="assets/images/lv5.png"/></@shiro.hasRole>
                            <@shiro.hasRole name="lv4" ><img src="assets/images/lv4.png"/></@shiro.hasRole>
                            <@shiro.hasRole name="lv3" ><img src="assets/images/lv3.png"/></@shiro.hasRole>
                            <@shiro.hasRole name="lv2" ><img src="assets/images/lv2.png"/></@shiro.hasRole>
                            <@shiro.hasRole name="lv1" ><img src="assets/images/lv1.png"/></@shiro.hasRole>
                        </span><@shiro.user>当前用户：<@shiro.principal/>
                     </div>
                     <div id="mm" class="easyui-menu">
                        <div id="change-pass">更改密码</div>
                        <div class="menu-sep"></div>
                        <div id="logout">退出</div>
                    </div>
                    </@shiro.user>
                </li>
            </ul>
        </div>
    </div>
</div>