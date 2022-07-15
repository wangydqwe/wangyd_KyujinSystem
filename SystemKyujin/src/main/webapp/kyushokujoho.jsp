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
<style>
    table,
    tbody {
        display: block;
        height: 305px;
        border: 0;
    }

    tbody {
        overflow-y: scroll;
    }

    table thead,
    tbody tr {
        display: table;
        width: 100%;
        table-layout: fixed;
    }

    table thead {
        width: calc(100% - 1em)
    }

    table thead th {
        background: #84acde;
        width: 20%;
        text-align: center;
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
    <form>
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
                            <a href="">トップページ</a>
                        </li>
                        <li class="curent">
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
            <br />
            <br />
            <br />
            <table class="jobCard_mainContent"  role="presentation">
                <thead>
                <tr style="background-color: #ADADAD;">
                    <th>　</th>
                    <th>　番号</th>
                    <th>　氏名　</th>
                    <th>　希望職種　　</th>
                    <th>　希望月給</th>
                    <th>　希望勤務地　　</th>
                    <th>　電話番号　　</th>
                    <th>　メールアドレス</th>
                    <th>　その他</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.kojinList}" var="joho">
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox" name="" value="">
                            </label>
                        </td>
                        <td>
                            <a href="">${kojinList.KSId}</a>
                        </td>
                        <td>${kojinList.KojinId}</td>
                        <td>${kojinList.ShimeKanji}</td>
                        <td>${kojinList.RirekiSu}</td>
                        <td>${kojinList.RirekiSu}</td>
                        <td>${kojinList.RirekiSu}</td>
                        <td>${kojinList.RirekiSu}</td>
                        <td>${kojinList.RirekiSu}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <br />
            <br />
            <span style="margin-left: 800PX; ">
                <input id="button1" type="button" value="変更" style="width: 80PX; height: 20PX; background-color: lightskyblue;"/>
			</span>
            <span>
                <input type="button" value="削除"  style="width: 80PX; height: 20PX; background-color: lightskyblue;" />
			</span>
        </div>
	</form>
    <section id="main">
        <div class="container_12" align="center">
            <div class="pagination">
                <ul>
                    <li class="prev">総数：6 &nbsp;&nbsp;&nbsp;&nbsp;第1/1頁&nbsp;&nbsp;&nbsp;&nbsp;
                    </li>

                    <li class="" style="border-right: 1px solid #E0E0E0">
                        <a href="" style="font-family: 楷体,serif;">
                            << </a>&nbsp;&nbsp;
                    </li>

                    <li style="border-right: 1px solid #E0E0E0">
                        <a href="" style="font-family: 楷体,serif;">
                            < </a>&nbsp;&nbsp;&nbsp;
                    </li>

                    <li style="border-right: 1px solid #E0E0E0">
                        <a href="" style="font-family: 楷体,serif;"> > </a>&nbsp;&nbsp;&nbsp;
                    </li>

                    <li class="" style="border-right: 1px solid #E0E0E0">
                        <a href="" style="font-family: 楷体,serif;"> >> </a>&nbsp;&nbsp;
                    </li>

                </ul>
            </div>
        </div>
    </section>
</header>
</body>

</html>