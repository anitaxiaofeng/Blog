<html>
<head>
    <meta charset="utf-8">
    <title>AdminBlog</title>
    <link href="/css/index.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script src="https://cdn.bootcss.com/showdown/1.3.0/showdown.min.js"></script>
</head>
<body>
<header>
    <div id="logo"><a href="/"></a></div>
    <nav class="topnav" id="topnav">
        <a href="/blog/bloglist"><span>Home</span><span class="en">主页</span></a>
        <a href="/blog/writeb"><span>Write Blog</span><span class="en">写博客</span></a>
        <a href="/blog/writed"><span>Write Diary</span><span class="en">写日记</span></a>
    </nav>
</header>

<article>
    <h2 class="title">文章列表</h2>
    <br>
    <br><br>
            <div class="box">
                <div class="banner"></div><br>
                <h2 class="title">${(blog.blogtitle)!''}</h2>
                <input type="hidden"  id="blogarticle"  value="${blog.article}">
                <div class="bloglist">
                    <div class="wz">
                        <script type="text/javascript">
                            $(function() {
                                var converter = new showdown.Converter();
                                var x=document.getElementById('blogarticle').value;
                                var html      = converter.makeHtml(x);
                                document.getElementById('text').innerHTML=html;
                            });
                        </script>
                        <div id="text"></div>
                        <ul>
                            <a title="Delete"  href="/blog/deleteBlogById?blogid=${(blog.blogid)!''}" class="readmore">Delete</a>
                        </ul>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
</article>
</body>
<script type="text/javascript" src="/js/alert.js" ></script>
</html>