<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
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
    #a1,#a2,#a3,#a4,#a5{
        display: none;
    }
</style>
<div id="top">
    <div class="container_12">
        <div class="grid_9">
            <nav>
                <ul>
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
                        <a id="a1" href="${pageContext.request.contextPath}/list/toppage/${rtype}">トップページ</a>
                    </li>
                    <li>
                        <a id="a2" class="curent" href="javascript:location.reload();">求職情報</a>
                    </li>
                    <li>
                        <a id="a3" href="${pageContext.request.contextPath}/kyujinList/kyujin/${rtype}?startpage=1&pagesize=10" >求人情報</a>
                    </li>
                    <li>
                        <a id="a4" href="${pageContext.request.contextPath}/kyujinList/KigyoJohoToroku/${rtype}">求人広告掲載</a>
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
        <form id="form1">
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
                <c:forEach items="${kyushokulist.list}" var="list">
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox" name="KSId" value="${list.KSId}" >
                            </label>
                        </td>
                        <td name="kojinId">
                            <a href="${pageContext.request.contextPath}/list/detail/${rtype}?id=${list.KSId}">${list.kojinId}</a>
                        </td>
                        <td name="kojinName">${list.kojinName}</td>
                        <td name="yakuShokuName">${list.yakuShokuName}</td>
                        <td name="kyoyu">${list.kyoyu}</td>
                        <td name="jusho1">${list.jusho1}</td>
                        <td name="tele">${list.tele}</td>
                        <td name="mail">${list.mail}</td>
                        <td name="biko">${list.biko}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <br />
            <br />
            <span style="margin-left: 800PX; ">
                   <input  id="button1" type="submit" value="変更" formaction="${pageContext.request.contextPath}/list/updateKakunin/${rtype}" onclick="isChecked()" style="width: 80PX; height: 20PX; background-color: lightskyblue;"/>
		     	</span>
            <span>
                   <input id="button2" type="submit" value="削除" formaction="${pageContext.request.contextPath}/list/deleteKakunin/${rtype}" onclick="isChecked()" style="width: 80PX; height: 20PX; background-color: lightskyblue;" />
			    </span>
        </form>
        <section id="main">
            <div class="container_12" align="center">
                <div class="pagination">
                    <ul>
                        <li class="prev">総数：${kyushokulist.total} &nbsp;&nbsp;&nbsp;&nbsp;第${kyushokulist.pageNum}/${kyushokulist.pages}頁&nbsp;&nbsp;&nbsp;&nbsp;
                        </li>

                        <li class="" style="border-right: 1px solid #E0E0E0">
                            <a href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=1&pagesize=10" style="font-family: 楷体,serif;">
                                << </a>&nbsp;&nbsp;
                        </li>

                        <li style="border-right: 1px solid #E0E0E0">
                            <a href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=${kyushokulist.prePage}&pagesize=10" style="font-family: 楷体,serif;">
                                < </a>&nbsp;&nbsp;&nbsp;
                        </li>

                        <li style="border-right: 1px solid #E0E0E0">
                            <a href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=${kyushokulist.nextPage}&pagesize=10" style="font-family: 楷体,serif;"> > </a>&nbsp;&nbsp;&nbsp;
                        </li>

                        <li class="" style="border-right: 1px solid #E0E0E0">
                            <a href="${pageContext.request.contextPath}/list/kyushoku/${rtype}?startpage=${kyushokulist.pages}&pagesize=10" style="font-family: 楷体,serif;"> >> </a>&nbsp;&nbsp;
                        </li>

                    </ul>
                </div>
            </div>
        </section>
    </div>

</header>
</body>
<script>
    function isChecked(){
        let a = true;
        let count = 0;
        let checkArray = document.getElementsByName("KSId");
        for(i=0;i<checkArray.length;i++){
            if(checkArray[i].checked){
                count++;
            }else {
                if (i === 10 && count === 0){
                    a = false
                    alert("変更するデーターを選択してください");
                    return a;
                }
            }
        }
        if (count !== 1){
            a = false
            alert("選択できるのは一つのデーター変更のみです。");
            return a
        }
    }

</script>
</html>