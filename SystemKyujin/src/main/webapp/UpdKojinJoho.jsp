<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta charset="utf-8">
    <title></title>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
    <link href="css/css.css" type="text/css" rel="stylesheet">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
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
    .td_left {
        width: 150px;
        text-align: center;
        height: 45px;
    }

    .td_right {
        padding-left: 1px;
        width: 400PX;
    }
    #shimeiKanji,
    #kihonShokushu,
    #kyuyo,
    #kimuchi,
    #tele,
    #email,
    #biko{
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
                    <a href="" style="font-size: 24px;text-decoration:none;">求職　求人システム</a>.
                </div>
            </div>
            <nav class="primary">
                <ul>
                    <li>
                        <a id="a1" href="javascript:location.reload();">トップページ</a>
                    </li>
                    <li>
                        <a id="a2" href="${pageContext.request.contextPath}/list/kyushoku/${rtype}">求職情報</a>
                    </li>
                    <li>
                        <a id="a3" href="${pageContext.request.contextPath}/kyushokujoho.jsp">求人情報</a>
                    </li>
                    <li>
                        <a id="a4" href="${pageContext.request.contextPath}/KigyoJohoToroku.jsp">求人広告掲載</a>
                    </li>
                    <li>
                        <a id="a5" href="${pageContext.request.contextPath}/KojinJohoTouRoku.jsp">履歴書を作成</a>
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
                <h2>個人情報変更</h2>
            </div>
            <div class="rg_center">
                <div class="rg_form">
                    <form action="#" method="post">
                        <table>
                            <tr>
                                <td class="td_left"><label for="shimeiKanji">　氏名漢字　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="shimeiKanji" id="shimeiKanji" value="${kyushoku.kojinName}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kihonShokushu">　希望職種　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="name" id="kihonShokushu" onfocus="" value="${kyushoku.yakuShokuName}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kyuyo">　希望給与　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="kyuyo" id="kyuyo" onfocus="" value="${kyushoku.kyoyu}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kimuchi">希望勤務地　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="kimuchi" id="kimuchi" onfocus="" value="${kyushoku.jusho1}"> </td>

                            <tr>
                                <td class="td_left"><label for="tele">　電話番号　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="tele" id="tele" onfocus="" value="${kyushoku.tele}"> </td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="email"> イー メ ール　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="email" name="email" id="email" value="${kyushoku.mail}"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="biko">その他　</label><span class="str">　　</span> </td>
                                <td class="td_right">
												<textarea id="biko" style="width: 400PX; border:  2px solid #A6A6A6; border-radius: 5px;padding-left: 10px;">${kyushoku.biko}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div style="float: left; padding-left: 600PX; padding-top: 10PX;">
                                        <input type="submit" value="戻る" id="btn_sub1">
                                    </div>
                                    <div style="float: left; padding-left: 30PX; padding-top: 10PX;">
                                        <input type="submit" value="変更" id="btn_sub2">
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
