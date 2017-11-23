<html>
<head>
    <meta charset="utf-8">
    <title>AdminBlog</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<header>
    <div id="logo"><a href="/"></a></div>
    <nav class="topnav" id="topnav">
        <a href="/blog/bloglist"><span>Home</span><span class="en">主页</span></a>
        <a href="writeblog.ftl"><span>Write Blog</span><span class="en">写博客</span></a>
        <a href="writediary.ftl"><span>Write Diary</span><span class="en">写日记</span></a>
    </nav>
</header>

<article>
    <h2 class="title">文章列表</h2>
    <br>
    <br><br>
    <div class="bloglist">
        <div class="wz">
                <h3>${blog.blogtitle}</h3>
            <div>
                ${blog.article}
            </div>
                <ul>
                    <a title="Delete"  href="/blog/deleteBlogById?blogid=${blogs.blogid}" class="readmore">Delete</a>
                </ul>
            <div class="clear"></div>
        </div>
    </div>
    </div>
</article>
</body>
<script type="text/javascript" src="js/alert.js" ></script>
</html>