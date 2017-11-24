<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<script>
    window.onload = function(){ //设置当页面加载时执行
        var result = confirm("上传成功");
        if(result) //判断是否点击确定
            window.location.href ="/blog/bloglist" //确定的话游览器自身跳转
    }
</script>
</body>

</html>