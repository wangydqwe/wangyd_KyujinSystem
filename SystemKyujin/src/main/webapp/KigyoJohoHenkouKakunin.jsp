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
            a1.style.display = "inline"
            a2.style.display = "inline"
            a3.style.display = "inline"
            a4.style.display = "inline"
            a5.style.display = "inline"
        }

        let t1 = document.getElementById("t1")
        let t2 = document.getElementById("t2")
        let t3 = document.getElementById("t3")
        let t4 = document.getElementById("t4")
        let t5 = document.getElementById("t5")
        let t6 = document.getElementById("t6")
        let t7 = document.getElementById("t7")

        let kaishaName = '${kyujin.kaishaName}';
        let yakuShoku = '${kyujin.yakuShokuName}';
        let kyuyo = '${kyujin.kyoyu}';
        let kinmuchi = '${kyujin.jusho1}';
        let tele = '${kyujin.tele}';
        let mail = '${kyujin.mail}';
        let biko = '${kyujin.biko}';
        //old
        let oldkaishaName = '${oldkyujin.kaishaName}';
        let oldyakuShoku = '${oldkyujin.yakuShokuName}';
        let oldkyuyo = '${oldkyujin.kyoyu}';
        let oldkinmuchi = '${oldkyujin.jusho1}';
        let oldtele = '${oldkyujin.tele}';
        let oldmail = '${oldkyujin.mail}';
        let oldoldbiko = '${oldkyujin.biko}';
        if (kaishaName !== oldkaishaName){
            t1.style.backgroundColor = "red";
        }
        if (yakuShoku !== oldyakuShoku){
            t2.style.backgroundColor = "red";
        }
        if (kyuyo !== oldkyuyo){
            t3.style.backgroundColor = "red";
        }
        if (kinmuchi !== oldkinmuchi){
            t4.style.backgroundColor = "red";
        }
        if (tele !== oldtele){
            t5.style.backgroundColor = "red";
        }
        if (mail !== oldmail){
            t6.style.backgroundColor = "red";
        }
        if (biko !== oldbiko){
            t7.style.backgroundColor = "red";
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
    #KaishaName,
    #yakuShoku,
    #kyuYu,
    #kinMuChi,
    #email,
    #tele,
    #biKo{
        width: 400px;
        height: 32px;
        border: none;
        /*设置边框圆角*/
        border-radius: 5px;
        padding-left: 10px;
        display:none
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
                <h2>企業情報変更確認画面</h2>
            </div>
            <div class="rg_center">
                <div class="rg_form">
                    <form method="post">
                        <input type="hidden" name="KJId" value="${kyujin.KJId}">
                        <table>
                            <tr>
                                <td class="td_left"><label for="KaishaName">会社名　</label></td>
                                <td class="td_right" id="t1"><input type="text" name="KaishaName" id="KaishaName" value="${kyujin.kaishaName}" readonly>${kyujin.kaishaName}</td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="yakuShoku">　職種　</label></td>
                                <td class="td_right" id="t2"><input type="text" name="YakuShokuName" id="yakuShoku" value="${kyujin.yakuShokuName}"readonly>${kyujin.yakuShokuName}</td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kyuYu">　給与　</label></td>
                                <td class="td_right" id="t3"><input type="text" name="Kyoyu" id="kyuYu" value="${kyujin.kyoyu}" readonly>${kyujin.kyoyu}</td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="kinMuChi">勤務地　</label></td>
                                <td class="td_right" id="t4"><input type="text" name="Jusho1" id="kinMuChi" value="${kyujin.jusho1}" readonly>${kyujin.jusho1}</td>
                            <tr>
                                <td class="td_left"><label for="tele">電話番号</label></td>
                                <td class="td_right" id="t5"><input type="text" name="Tele" id="tele" value="${kyujin.tele}" readonly>${kyujin.tele}</td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="email"> メール　</label></td>
                                <td class="td_right" id="t6"><input type="email" name="Mail" id="email" value="${kyujin.mail}" readonly>${kyujin.mail}</td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="biKo">その他　</label></td>

                                <td class="td_right" id="t7">
                                    <textarea id="biKo" name="Biko" style="width: 400PX;"  readonly>${kyujin.biko}</textarea>
                                    ${kyujin.biko}
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div style="float: left; padding-left: 500PX; padding-top: 10PX;">
                                        <input type="submit" value="戻る" id="btn_sub1" formaction="${pageContext.request.contextPath}/kyujinList/updKauninModoru/${rtype}">
                                    </div>
                                    <div style="float: left; padding-left: 30PX; padding-top: 10PX;">
                                        <input type="submit" value="変更" id="btn_sub2" formaction="${pageContext.request.contextPath}/kyujinList/update/${rtype}">
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
