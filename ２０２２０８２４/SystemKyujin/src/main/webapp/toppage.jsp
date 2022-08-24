<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta charset="utf-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/normalize.css" type="text/css" rel="stylesheet">
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

<script src="${pageContext.request.contextPath}/js/manage.js"></script>

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
            s2.style.color = "red"
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
        let success_flag = '${success_flag}';
        if (success_flag){
            b1.style.display = "inline"
        }
    }
</script>
<style>
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
    #a1,#a2,#a3,#a4,#a5,#b1{
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
    <input type="hidden" th:value="${rtype}" id="manage"/>
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
                        <a id="a1" class="curent" href="javascript:location.reload();">トップページ</a>
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

        <div class="jobsearch-Content">
            <h1 align="center">
                ようこそ!!!
            </h1>
            <h3 align="center">
                <span align="center" style="color: red" id="b1">ログインに成功しました。</span>
            </h3>
            <br />
            <div class="icl-TextInput">
                <div class="icl-TextInput-labelWrapper">
                    <label id="label-text-input-what" class="icl-TextInput-label"  tabindex="-1">キーワード&nbsp;&nbsp;</label>
                </div>
                <div class="icl-TextInput-wrapper1">
                    <label>
                        <input type="text" placeholder="職種、キーワード、会社名など" value="" style="width: 800PX ;">
                    </label>
                </div>
            </div>
            <br />
            <br />
            <div class="icl-TextInput">
                <div class="icl-TextInput-labelWrapper">
                    <label id="label-text-input-where" class="icl-TextInput-label" tabindex="-1"> &nbsp;勤 務 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                </div>
                <div class="icl-TextInput-wrapper">
                    <label>
                        <input type="text" placeholder="都道府県、市区町村、駅名" value="" style="width: 800PX ;">
                    </label>
                </div>
            </div>
            <br />
            <button class="yosegi-InlineWhatWhere-primaryButton" type="submit">検索</button>
        </div>
    </div>
</header>
</body>

</html>