<%--
  Created by IntelliJ IDEA.
  User: pana
  Date: 2022/06/18
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    #username,
    #password,
    #email,
    #name,
    #tel,
    #birthday,
    #checkcode {
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

    #btn_sub {
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
        <div class="grid_9" style="border:0px solid red;width: 98%">
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
                        <a id="a2" href="${pageContext.request.contextPath}/list/kyushoku" >求職情報</a>
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
                <h2>企業情報変更</h2>
            </div>
            <div class="rg_center">
                <div class="rg_form">
                    <form action="#" method="post">
                        <table>
                            <tr>
                                <!--label 标签的作用是当点击文字也会跳到文本输出框-->
                                <!--for属性与ID属性对应规定 label 绑定到哪个表单元素。-->
                                <td class="td_left"><label for="username">会社名　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="username" id="username" value="XXX株式会社"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="password">&nbsp &nbsp 職種　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="username" id="username"　onfocus="" value="JAVA開発"> </td>
                                <text>
                            <tr>
                                <td class="td_left"><label for="email">　給与　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="username" id="username"　onfocus="" value="17K"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="name">勤務地　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="text" name="name" id="name"　onfocus="" value="東京"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="tel">電話番号</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="tel" name="tel" id="tel"　 value="12456777"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="tel">メール　</label><span class="str">必須</span> </td>
                                <td class="td_right"><input type="email" name="email" id="email" 　 value="12456@777.jp"> </td>
                            </tr>
                            <tr>
                                <td class="td_left"><label for="tel">その他　</label><span class="str">　　</span> </td>
                                <td class="td_right">
											<textarea  style="width: 400PX; border:  2px solid #A6A6A6; border-radius: 5px; padding-left: 10px;" >
												SEFWDSFVSDVGFSDFSD
											</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div style="float: left; padding-left: 600PX; padding-top: 10PX;">
                                        <input type="submit" value="戻る" id="btn_sub">
                                    </div>
                                    <div style="float: left; padding-left: 30PX; padding-top: 10PX;">
                                        <input type="submit" value="変更" id="btn_sub">
                                    </div>


                                </td>
                            </tr>

                        </table>
                    </form>
                </div>
            </div>
        </div>

    </div>

    </section>
</header>
</body>

</html>
