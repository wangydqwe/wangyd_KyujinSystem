<%--
  Created by IntelliJ IDEA.
  User: pana
  Date: 2022/06/16
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta charset="utf-8">
    <title></title>
    <link href="../jsp/static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="../jsp/static/css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
    <link href="../jsp/static/css/css.css" type="text/css" rel="stylesheet">
    <link href="../jsp/static/css/normalize.css" type="text/css" rel="stylesheet">
    <link href="../jsp/static/css/new_file.css" rel="stylesheet" type="text/css" />
</head>

<body style="">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<meta charset="utf-8">

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="../jsp/static/css/grid.css">
<link rel="stylesheet" href="../jsp/static/css/style.css">
<link rel="stylesheet" href="../jsp/static/css/normalize.css">
<style>
    .right_fbox {
        width: 50px;
        height: 50px;
        position: fixed;
        float: right;
        left: 92%;
        top: 30%;
        z-index: 999;
        background-color: rgb(200, 100, 100);
    }

    .icl-TextInput {
        border: 1px solid #949494;
        border-radius: .5rem;
        display: -ms-flexbox;
        display: flex;
        align-items: center;
        padding: .75rem 1rem;
    }

    .yosegi-InlineWhatWhere-primaryButton {
        float: right;
        font-size: .875rem;
        width: 100PX;
    }

    .jobsearch-Content {
        margin-top: 100PX;
    }

    .icl-TextInput-wrapper {
        width: 100PX;
        box-sizing: border-box;
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
        <div class="grid_9" style="border:0px solid red;width: 98%">
            <div class="top_header">
                <div class="welcome">
                    <a href="" style="font-size: 24px;text-decoration:none;">求職　求人システム</a>.
                </div>
            </div>
            <nav class="primary">
                <ul>
                    <li class="curent">
                        <a href="">トップページ</a>
                    </li>
                    <li>
                        <a href="">求職情報</a>
                    </li>
                    <!--
                        作者：offline
                        时间：2022-05-26
                        描述： style="color: gray;pointer;pointer-events: none;background-color: gray;"
                    -->
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

        <div class="jobsearch-Content">
            <h1 align="center">ようこそ!!!</h1>
            <br />
            <div class="icl-TextInput">
                <div class="icl-TextInput-labelWrapper">
                    <label id="label-text-input-what" class="icl-TextInput-label" for="text-input-what" tabindex="-1">キーワード&nbsp;&nbsp;</label>
                </div>
                <div class="icl-TextInput-wrapper1">
                    <input type="text" placeholder="職種、キーワード、会社名など" value="" style="width: 800PX ;">
                </div>
            </div>
            <br />
            <br />
            <div class="icl-TextInput">
                <div class="icl-TextInput-labelWrapper">
                    <label id="label-text-input-where" class="icl-TextInput-label" for="text-input-where" tabindex="-1"> &nbsp;勤 務 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                </div>
                <div class="icl-TextInput-wrapper">
                    <input type="text" placeholder="都道府県、市区町村、駅名" value="" style="width: 800PX ;">
                </div>
            </div>
            <br />
            <button class="yosegi-InlineWhatWhere-primaryButton" type="submit">検索</button>
        </div>
    </div>
</header>
</body>

</html>