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

<body>
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<meta charset="utf-8">

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/grid.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/s.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>

    .btn {
        float: right;
        width: 400px;
        padding: 1px;
    }

    .rg_layout {
        width: 900px;
        height: 400px;
        border: none;
        /*solid 定义实线*/
        background-color: white;
        margin: 20px 1px 2px 3px;
        padding: 30px 10px 20px 200px;
    }

    .rg_left>p:first-child {
        color: #FFD026;
        font-size: 20px;
    }

    .rg_left>p:last-child {
        color: #A6A6A6;
        font-size: 20px;
    }

    .rg_right p {
        font-size: 15px;
    }

    .rg_right p a {
        color: coral;
    }

    .sectionInner {
        background: #f0f0f0;
        padding: 36px 48px 40px 48px;
        border: 1px solid #dcdcdc;
        border-radius: 4px;
    }

    #username-error,#mail-error,#password-error,#kakunin-error{
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
        <div>
            <div class="top_header">
                <div class="welcome">
                    <b style="font-size: 24px;text-decoration:none;">求職　求人システム</b>.
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

        <div class="rg_layout">

            <div class="sectionInner">
                <div>
                    <h2><b>新規登録</b></h2>
                    <!-- /.sectionHeader -->
                </div>
                <div>
                    <form action="${pageContext.request.contextPath}/register" method="post" id="register-form">
                        <table>
                            <tbody>
                            <tr>
                                <th>類別</th>
                                <td>
                                    <div>
                                        <label>
                                            <input type="radio" name="Rtype" id="type1" value="1" />
                                        </label>&nbsp;個人&nbsp;
                                        <label>
                                            <input type="radio" name="Rtype" id="type2" value="2" />
                                        </label>&nbsp;企業&nbsp;
                                        <span style="color: red" id="type-error"></span>
                                    </div>

                                </td>
                            </tr>

                            <tr>
                                <th>メールアドレス<br><span class="str">必須</span></th>

                                <td>
                                    <div>
                                        <label>
                                            <input type="text"  name="Mail" placeholder="例 : 12345566@123.jp" id="usermail">
                                            <span style="color: red" id="mail-error"></span>
                                            <span>${errorInfo.Mail}</span>
                                        </label>
                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <th>ユーザー名<br><span class="str">必須</span></th>

                                <td>
                                    <div>
                                        <label>
                                            <input type="text" name="UName" id="username">
                                            <span style="color: red" id="username-error"></span>
                                            <span>${errorInfo.UName}</span>
                                        </label>
                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <th>パスワード<span class="str">必須</span></th>
                                <td>
                                    <div>
                                        <label>
                                            <input type="password" name="UPassword" id="userpassword">
                                            <span style="color: red" id="password-error"></span>
                                            <span>${errorInfo.UPassword}</span>
                                        </label>
                                    </div>
                                    <ul>
                                        <li>
                                            8～20文字
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <th>確認パスワード<span class="str">必須</span></th>
                                <td>
                                    <div>
                                        <label>
                                            <input type="password" name="kakunin" id="kakunin">
                                            <span style="color: red" id="kakunin-error"></span>
                                        </label>
                                    </div>
                                    <ul>
                                        <li>
                                            8～20文字
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                            <p class="btn"><input id="btn" type="button" value="登録する"></p>
                    </form>
                </div>
            </div>

        </div>
    </div>

</header>
<script src="${pageContext.request.contextPath}/js/register.js"></script>
</body>

</html>
