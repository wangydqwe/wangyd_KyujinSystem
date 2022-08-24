<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<html>


<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">

    <meta charset="utf-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/new_file.css" rel="stylesheet" type="text/css" />
</head>

<body style="">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<meta charset="utf-8">

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/grid.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
<script type = "text/javascript">
    window.onload = function() {
        let rtype = '${rtype}';
        let a1 = document.getElementById("a1")
        let a2 = document.getElementById("a2")
        let a3 = document.getElementById("a3")
        let a4 = document.getElementById("a4")
        let a5 = document.getElementById("a5")

        let s1 = document.getElementById("s1")
        let s2 = document.getElementById("s2")
        let s3 = document.getElementById("s3")
        if (rtype === '1'){
            a1.style.display = "inline"
            a2.style.display = "inline"
            a5.style.display = "inline"
            s1.style.color = "red"
        }else if (rtype === '2'){
            a1.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
            s1.style.color = "red"
        }else if (rtype === '3' || rtype === '4'){
            a1.style.display = "inline"
            a2.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
            a5.style.display = "inline"
            s1.style.color = "red"
            s2.style.color = "red"

        }else {
            a1.style.display = "none"
            a2.style.display = "none"
            a3.style.display = "none"
            a4.style.display = "none"
            a5.style.display = "none"
        }

        let b1 = document.getElementById("b1")
        let b2 = document.getElementById("b2")
        let success_flag = '${success_flag}';

        if (success_flag){
            b2.style.display = "inline"
        }

    }
</script>
<style>

    .btn {
        float: right;
        width: 400px;
        padding: 1px;
    }

    #login-box {
        width: 100%;
        height: auto;
        margin: 5% auto 0;
        text-align: center;
        border: 2px solid #EEF0F5;
        padding: 28px 40px;
    }
    #mail-error,#password-error{
        display: none;
    }
    #a1,#a2,#a3,#a4,#a5,#b2{
        display: none;
    }
    #s1,#s2,#s3{
        font-size: 24px;
        text-decoration:none;
    }
</style>
<div id="top">
    <div class="container_12">
        <div class="grid_9">
            <nav>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/register.jsp">登録</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/login.jsp">ログイン</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/loginOut">ログアウト</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<header>
    <div class="container_12">
        <div class="grid_9" style="border:0 solid red;width: 98%">
            <div class="top_header">
                <div class="welcome">
                    <b  id="s1">求職 </b>
                    <b  id="s2">求人</b>
                    <b  id="s3">システム</b>.
                </div>
            </div>
            <nav class="primary">
                <ul>
                    <li>
                        <a id="a1" href="${pageContext.request.contextPath}/list/toppage/${rtype}">トップページ</a>
                    </li>
                    <li>
                        <a id="a2" href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=1&pagesize=10" >個人情報</a>
                    </li>
                    <li>
                        <a id="a3" href="${pageContext.request.contextPath}/kyujinList/kyujin/${rtype}?startpage=1&pagesize=10" >企業情報</a>
                    </li>
                    <li>
                        <a id="a4" href="${pageContext.request.contextPath}/kyujinList/KigyoJohoToroku/${rtype}">企業情報登録</a>
                    </li>
                    <li>
                        <a id="a5" href="${pageContext.request.contextPath}/list/KojinJohoTouRoku/${rtype}">個人履歴書</a>
                    </li>
                </ul>
            </nav>
        </div>
        <br />

        <div id="login-box" style="float: left;">
            <form action="${pageContext.request.contextPath}/manage?${rtype}" method="post" id="login-form">
            <div style="font-size: 20PX; color: blue;">
                <h3>ログインしてください</h3>
                <span align="center" style="color: red" id="b2">メールまたはパスワード情報入力エラーのログインに失敗しました</span>
                <span id="error" style="color: red;display: block">${error}</span>
                <br />
            </div>

            <div class="form" >
                <div class="item">

                    <b style="font-size: 20px;">　メール　:</b>
                    <label>
                        <input type="email" name="email" placeholder="メール" id="usermail">
                        <span style="color: red" id="mail-error"></span>
                    </label>
                </div>
                <br />
                <div class="item">

                    <b style="font-size: 20px;">パスワード:</b>
                    <label>
                        <input type="password" name="password" placeholder="パスワード" id="userpassword">
                        <span style="color: red" id="password-error"></span>
                    </label>
                </div>
                <br />
            </div>

            <div class="btn">
                <button style="width: 100px; float: left;" id="btn" type="button">Login</button>
                <div style="width: 10px; float: left; padding: 10px;" ></div>
                <button style="width: 100px; " onclick="changeActionToRegister()" value="新規登録">新規登録</button>
            </div>
            </form>
        </div>
    </div>
</header>
<script src="${pageContext.request.contextPath}/js/login.js"></script>

</body>

</html>