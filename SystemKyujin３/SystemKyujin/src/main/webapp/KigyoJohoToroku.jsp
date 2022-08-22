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
        let rtype = '${Rid}';
        let a1 = document.getElementById("a1")
        let a2 = document.getElementById("a2")
        let a3 = document.getElementById("a3")
        let a4 = document.getElementById("a4")
        let a5 = document.getElementById("a5")

        if (rtype === '1'){
            a1.style.display = "inline"
            a2.style.display = "inline"
            a5.style.display = "inline"
        }else if (rtype === '2'){
            a1.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
        }else if (rtype === '3' || rtype === '4'){
            a1.style.display = "inline"
            a2.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
            a5.style.display = "inline"
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
    #kaishaName,
    #yakuShoku,
    #kyuYu,
    #kinMuChi,
    #email,
    #tele,
    #biKo{
        width: 400px;
        height: 32px;
        border: 2px solid #A6A6A6;
        /*设置边框圆角*/
        border-radius: 5px;
        padding-left: 10px;
    }

    .str {
        margin: 1PX 10PX 200PX 30PX;
        font-size: 13PX;
        color: red;
    }

    #btn_sub1,#btn_sub2 {
        width: 100px;
        height: 40px;
        background-color: #357EBD;
        border: 1px solid;
        padding-left: 10px;
    }
    #a1,#a2,#a3,#a4,#a5{
        display: none;
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
                        <a href="${pageContext.request.contextPath}/toppage.jsp">ログアウト</a>
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
                        <a id="a1" href="${pageContext.request.contextPath}/kyujinList/toppage/${rtype}">トップページ</a>
                    </li>
                    <li>
                        <a id="a2" href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=1&pagesize=10" >求職情報</a>
                    </li>
                    <li>
                        <a id="a3" href="${pageContext.request.contextPath}/kyujinList/kyujin/${rtype}?startpage=1&pagesize=10" >求人情報</a>
                    </li>
                    <li>
                        <a id="a4" class="curent" href="javascript:location.reload();">求人広告掲載</a>
                    </li>
                    <li>
                        <a id="a5" href="${pageContext.request.contextPath}/list/KojinJohoTouRoku/${rtype}">履歴書を作成</a>
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
                <h2>企業情報登録</h2>
                <span style="color: red;display: block">${errorInfo.KaishaName} </span>
                <span style="color: red;display: block">${errorInfo.YakuShokuName} </span>
                <span style="color: red;display: block">${errorInfo.Kyoyu}</span>
                <span style="color: red;display: block">${errorInfo.Jusho1} </span>
                <span style="color: red;display: block">${errorInfo.Tele}</span>
                <span style="color: red;display: block">${errorInfo.Mail}</span>
            </div>
            <div class="rg_center">
                <div class="rg_form">
                    <form method="post">
                        <table>
                            <tr>
                                <td class="td_left"><label for="kaishaName">会社名　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="KaishaName" id="kaishaName" value="${kyujin.kaishaName}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="yakuShoku">　職種　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="YakuShokuName" id="yakuShoku" value="${kyujin.yakuShokuName}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kyuYu">　給与　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="Kyoyu" id="kyuYu" value="${kyujin.kyoyu}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kinMuChi">勤務地　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="Jusho1" id="kinMuChi" value="${kyujin.jusho1}"> </td>

                            <tr>
                                <td class="td_left"><label for="tele">電話番号</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="Tele" id="tele" value="${kyujin.tele}"> </td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="email">メール　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="email" name="Mail" id="email" value="${kyujin.mail}" style="border: none;display:none">${kyujin.mail}</td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="biKo">その他　</label><span class="str">　　</span> </td>
                                <td class="td_right">
                                    <textarea id="biKo" name="Biko" style="width: 400PX; border:  2px solid #A6A6A6; border-radius: 5px; padding-left: 10px;">${kyujin.biko}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div style="float: left; padding-left: 600PX; padding-top: 10PX;">
                                        <input type="submit" value="戻る" id="btn_sub1" formaction="${pageContext.request.contextPath}/list/addModoru/${rtype}">
                                    </div>
                                    <div style="float: left; padding-left: 30PX; padding-top: 10PX;">
                                        <input type="submit" value="提出" id="btn_sub2" formaction="${pageContext.request.contextPath}/kyujinList/add/${rtype}" >
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
