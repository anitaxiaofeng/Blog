<html>
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<form action="/checklogin" name="loginfrom" accept-charset="utf-8" method="post">
    <label class="label-tips" for="u">账号:</label>
    <input type="text" id="u" name="username" class="inputstyle"/>
    <div>
        <label class="lable-tips" for="password">密码:</label>
        <input type="password" id="password" name="password" class="inputstyle" />
    </div>
    <input type="submit" name="登录"/>
    <a href="/register" class="zcxy" target="_blank">注册</a>
</form>

</body>
</html>