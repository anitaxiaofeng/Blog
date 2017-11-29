<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<header>
    <div id="logo"><a href="/"></a></div>
    <nav class="topnav" id="topnav">
        <a href="/blog/bloglist?username=${username}"><span>Home</span><span class="en">主页</span></a>
        <a href="/blog/writeb"><span>Write Blog</span><span class="en">写博客</span></a>
        <a href="/blog/about"><span>About</span><span class="en">关于我</span></a>
        <a href="/blog/diarylist"><span>Diary</span><span class="en">日记心得</span></a>
        <a href="/blog/gustbook"><span>Gustbook</span><span class="en">留言板</span></a>
        <a href="#" onclick="fun1()"><span>Admin</span><span class="en">管理</span></a>
    </nav>
</header>
<div class="box">
    <div class="banner"></div><br>
    <h2 class="title">文章列表</h2>
    <h3 >你好:${username}</h3>
    <div class="bloglist">
        <div class="wz">
        <#list blogs as blog>
           <h3>${(blog.blogtitle)!''}</h3>
        <ul>
            <#if (blog.blogid) != 0>
            <a title="阅读全文"  href="/blog/selectBlogById?blogid=${(blog.blogid)!''}" class="readmore">阅读全文</a>
            </#if>
        </ul>
        </#list>
            <div class="clear"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/alert.js" ></script>
</html>
