<html>
<head>
    <meta charset="utf-8">
    <title>Write Blog</title>
    <link rel="stylesheet" href="/EditorMd/examples/css/style.css" />
    <link rel="stylesheet" href="/EditorMd/css/editormd.css" />
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />

    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/about.css" rel="stylesheet"/>
</head>
<body>
<header>
    <div id="logo"><a href="/"></a></div>
    <nav class="topnav" id="topnav">
        <a href="/blog/bloglist?username=${Session.username}"><span>Home</span><span class="en">主页</span></a>
        <a href="/blog/about"><span>About</span><span class="en">关于我</span></a>
        <a href="/blog/diarylist"><span>Diary</span><span class="en">日记心得</span></a>
        <a href="/blog/gustbook"><span>Gustbook</span><span class="en">留言板</span></a>
        <a href="#" onclick="fun1()"><span>Admin</span><span class="en">管理</span></a>
    </nav>
</header>
<div class="box">
    <form action="/blog/writeBlog" method="post">
        <div class="admin">
            <h1 class="t_nav"><span>分享使人感到愉悦。</span></h1><br />
            <div id="layout">
                <header>

                    <h1>写博客</h1>
                </header>
                <div class="blogtitle">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    标题 ：<input type="text" name="blogtitle" style="width: 400px;height:25px;"/><br>
                    姓名：<input type="text" name="username" readonly="readonly" value=${Session.username}>
                </div>
                <br />
                <br />
                <br />
                <input type="submit" value="uplode"  style="background-color:#0055AA;color: white;font-size: 15px;
            	height:30px;width:80px;display:inline-block;float: left;margin-left: 55px;" />
                <br />
                <br />
                <br />
                <div id="test-editormd">
                <textarea style="display:none;" name="article">


</textarea>
                </div>
            </div>
            <script src="/EditorMd/examples/js/jquery.min.js"></script>
            <script src="/EditorMd/editormd.min.js"></script>
            <script type="text/javascript">
                var testEditor;

                $(function() {
                    testEditor = editormd("test-editormd", {
                        width   : "90%",
                        height  : 800,
                        syncScrolling : "single",
                        path    : "/EditorMd/lib/"
                    });

                    /*
                    // or
                    testEditor = editormd({
                        id      : "test-editormd",
                        width   : "90%",
                        height  : 640,
                        path    : "../lib/"
                    });
                    */
                });
            </script>
        </div>
    </form>
</div>
</body>
</html>

</html>