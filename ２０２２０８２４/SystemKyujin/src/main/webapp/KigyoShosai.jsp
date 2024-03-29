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
        let rtype = '${Rtype}';
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
            a1.style.display = "inline"
            a2.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
            a5.style.display = "inline"
        }
    }
</script>
<style>
    .td_left {
        width: 150px;
        text-align: center;
        height: 45px;
    }

    .td_right {
        padding-left: 1px;
        width: 400PX;
    }

    .str {
        margin: 1PX 10PX 200PX 30PX;
        font-size: 13PX;
        color: red;
    }
    #btn_sub1,#btn_sub2 {
        width: 100px;
        height: 40px;
        background-color: #1da1f2;
        border: 1px solid;
        padding-left: 10px;
        border-radius: 10%;
    }
    #a1,#a2,#a3,#a4,#a5{
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
        <br />
        <br />
        <br />
        <div class="rg_layout">
            <div class="rg_left">
                <h2>個人詳細情報</h2>
            </div>
            <div class="rg_center">
                <div class="rg_form">
                    <form action="#" method="post">
                        <table>
                            <tr>
                                <td class="td_left">会社名 </td>
                                <td class="td_right"><b>${kyujin.kaishaName}</b></td>
                            </tr>
                            <tr>
                                <td class="td_left"> 職種 </td>
                                <td class="td_right"><b>${kyujin.yakuShokuName}</b></td>
                            </tr>
                            <tr>
                                <td class="td_left"> 給与 </td>
                                <td class="td_right"><b>${kyujin.kyoyu}</b></td>
                            </tr>
                            <tr>
                                <td class="td_left">勤務地 </td>
                                <td class="td_right"><b>${kyujin.jusho1}</b> </td>

                            <tr>
                                <td class="td_left">電話番号</td>
                                <td class="td_right"><b>${kyujin.tele}</b> </td>
                            </tr>

                            <tr>
                                <td class="td_left">メール </td>
                                <td class="td_right"><b>${kyujin.mail}</b> </td>
                            </tr>
                            <tr>
                                <td class="td_left">その他 </td>
                                <td class="td_right">
                                    <b>${kyujin.biko}</b>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div style="float: left; padding-left: 500PX; padding-top: 10PX;">
                                        <input type="submit" value="企業情報送付" id="btn_sub1">
                                    </div>
                                    <div style="float: left; padding-left: 30PX; padding-top: 10PX;">
                                        <input type="submit" id="btn_sub2" formaction="${pageContext.request.contextPath}/kyujinList/close/${rtype}?startpage=1&pagesize=10" value="閉める" >

                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>
</body>

</html>
