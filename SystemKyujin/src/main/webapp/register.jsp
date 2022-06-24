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
    <link href="css/new_file.css" rel="stylesheet" type="text/css" />
</head>

<body>
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<meta charset="utf-8">

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/grid.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/s.css" />
<link rel="stylesheet" href="css/common.css" />
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
        <div>
            <div class="top_header">
                <div class="welcome">
                    <b href="" style="font-size: 24px;text-decoration:none;">求職　求人システム</b>.
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

        <div class="rg_layout">

            <div class="sectionInner">
                <div>
                    <h2><b>新規登録</b></h2>
                    <!-- /.sectionHeader -->
                </div>
                <div>
                    <form action="${pageContext.request.contextPath}/user/register" method="post">
                        <table>
                            <tbody>
                            <tr>
                                <th>類別</th>
                                <td>
                                    <div>
                                        <label>
                                            <input type="radio" name="Rtype" value="1" />
                                        </label>&nbsp;個人&nbsp;
                                        <label>
                                            <input type="radio" name="Rtype" value="2" />
                                        </label>&nbsp;企業&nbsp;
                                    </div>

                                </td>
                            </tr>

                            <tr>
                                <th>メールアドレス<br><span class="str">必須</span></th>

                                <td>
                                    <div>
                                        <label>
                                            <input type="text"  name="Mail" placeholder="例 : 12345566@123.jp">
                                        </label>
                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <th>ユーザー名<br><span class="str">必須</span></th>

                                <td>
                                    <div>
                                        <label>
                                            <input type="text" name="UName">
                                            <b>${param.msg}</b>
                                        </label>
                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <th>パスワード<span class="str">必須</span></th>
                                <td>
                                    <div>
                                        <label>
                                            <input type="password" name="UPassword">
                                        </label>
                                    </div>
                                    <ul>
                                        <li>
                                            8～12文字
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <th>確認パスワード<span class="str">必須</span></th>
                                <td name="Password">
                                    <div>
                                        <label>
                                            <input type="password" name="UPassword">
                                        </label>
                                    </div>
                                    <ul>
                                        <li>
                                            8～12文字
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                            <p class="btn"><input type="submit" value="登録する"></p>

                    </form>
                    <!--/.contBody -->

                </div>
                <!-- /.sectionInner -->

            </div>

        </div>
    </div>

</header>
</body>

</html>
