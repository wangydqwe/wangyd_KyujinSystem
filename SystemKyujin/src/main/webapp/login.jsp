<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<html>


<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">

    <meta charset="utf-8">
    <title></title>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/css.css" type="text/css" rel="stylesheet">
    <link href="css/new_file.css" rel="stylesheet" type="text/css" />
</head>

<body style="">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<meta charset="utf-8">

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/grid.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/normalize.css">
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
</style>
<div id="top">
    <div class="container_12">
        <div class="grid_9">
            <nav>
                <ul>
                    <li>
                        <a href=" ">登録</a>
                    </li>
                    <li>
                        <a href=" ">ログイン</a>
                    </li>
                    <li>
                        <a href=" ">ログアウト</a>
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
                    <b  style="font-size: 24px;text-decoration:none;">求職　求人システム</b>.
                </div>
            </div>
            <nav class="primary">
                <ul>
                    <li>
                        <a href="">トップページ</a>
                    </li>
                    <li>
                        <a href="">求職情報</a>
                    </li>
                    <li>
                        <a href="">求人情報</a>
                    </li>
                    <li>
                        <a href="">求人広告掲載</a>
                    </li>
                    <li>
                        <a href="">履歴書を作成</a>
                    </li>
                </ul>
            </nav>
        </div>
        <br />

        <div id="login-box" style="float: left;">
            <form action="${pageContext.request.contextPath}/user/login" method="post" id="login-form">
            <div style="font-size: 20PX; color: blue;">
                <h3>ログインしてください</h3>
                <br />
            </div>
            <div class="form" >
                <div class="item">

                    <b style="font-size: 20px;">　メール　:</b>
                    <label>
                        <input type="email" name="email" placeholder="メール">
                    </label>
                </div>
                <br />
                <div class="item">

                    <b style="font-size: 20px;">パスワード:</b>
                    <label>
                        <input type="password" name="password" placeholder="パスワード">
                    </label>
                </div>
                <br />
            </div>

            <div class="btn">
                <button style="width: 100px; float: left;">Login</button>
                <div style="width: 10px; float: left; padding: 10px;"></div>
                <button style="width: 100px; ">新規登録</button>
            </div>
            </form>
        </div>
    </div>
</header>
</body>

</html>