<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Basket</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100);

        body {
            font-family: "Roboto", helvetica, arial, sans-serif;
            font-size: 16px;
            font-weight: 400;
            text-rendering: optimizeLegibility;
        }

        .table-title h3 {
            color: #fafafa;
            font-size: 30px;
            font-weight: 400;
            font-style: normal;
            font-family: "Roboto", helvetica, arial, sans-serif;
            text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
            text-transform: uppercase;
        }

        /*** Table Styles **/

        .table-fill {
            background: white;
            /*border-radius: 3px;*/
            border-collapse: collapse;
            height: 320px;
            margin: auto;
            /*max-width: 600px;*/
            padding: 5px;
            width: 100%;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
            animation: float 5s infinite;
        }

        th {
            color: #d5dde5;
            background: #1b1e24;
            border-bottom: 4px solid #9ea7af;
            border-right: 1px solid #343a45;
            font-size: 23px;
            font-weight: 100;
            padding: 24px;
            text-align: left;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
            vertical-align: middle;
        }

        th:first-child {
            border-top-left-radius: 3px;
        }

        th:last-child {
            border-top-right-radius: 3px;
            border-right: none;
        }

        tr {
            border-top: 1px solid #c1c3d1;
            border-bottom-: 1px solid #c1c3d1;
            color: #666b85;
            font-size: 16px;
            font-weight: normal;
            text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
        }

        tr:hover td {
            background: #4e5066;
            color: #ffffff;
            border-top: 1px solid #22262e;
        }

        tr:first-child {
            border-top: none;
        }

        tr:last-child {
            border-bottom: none;
        }

        tr:nth-child(odd) td {
            background: #ebebeb;
        }

        tr:nth-child(odd):hover td {
            background: #4e5066;
        }

        tr:last-child td:first-child {
            border-bottom-left-radius: 3px;
        }

        tr:last-child td:last-child {
            border-bottom-right-radius: 3px;
        }

        td {
            background: #ffffff;
            padding: 20px;
            text-align: left;
            vertical-align: middle;
            font-weight: 300;
            font-size: 18px;
            text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
            border-right: 1px solid #c1c3d1;
        }

        td:last-child {
            border-right: 0;
        }

        th.text-left {
            text-align: left;
        }

        th.text-center {
            text-align: center;
        }

        td.text-left {
            text-align: left;
        }

        td.text-center {
            text-align: center;
        }

        div.table {
            margin: 100px auto;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }

        .btn {
            background-color: #22262e;
            border: none;
            color: white;
            padding: 12px 30px;
            cursor: pointer;
            font-size: 20px;
        }

        .btn:hover {
            background-color: #ffffff;
            color: #22262e;
        }

        .center {
            /*position: absolute;*/
            bottom: 10%;
            margin: auto;
            /*right: 50%;*/
        }

        ::selection {
            color: #4e5066;
            background: #ffffff;
        }

        .container p {
            font-size: 19px;
        }

        .pagination {
            margin: 25px 0 15px 0;
        }

        .pagination,
        .pagination li a {
            display: flex;
            align-items: center;
            justify-content: center;
            flex-wrap: wrap;
        }

        .pagination li {
            background: #ffffff;
            list-style: none;
        }

        .pagination li a {
            text-decoration: none;
            color: #4e5066;
            height: 50px;
            width: 50px;
            font-size: 18px;
            padding-top: 1px;
            border: 1px solid rgba(0, 0, 0, 0.25);
            border-right-width: 0;
            box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, 0.35);
        }

        .pagination li:last-child a {
            border-right-width: 1px;
        }

        .pagination li a:hover {
            background: rgba(255, 255, 255, 0.2);
            border-top-color: rgba(0, 0, 0, 0.35);
            border-bottom-color: rgba(0, 0, 0, 0.5);
        }

        .pagination li a:focus,
        .pagination li a:active {
            padding-top: 4px;
            border-left-width: 1px;
            background: rgba(255, 255, 255, 0.15);
            box-shadow: inset 0 2px 1px 0 rgba(0, 0, 0, 0.25);
        }

        .pagination li.icon a {
            min-width: 120px;
        }

        .pagination li:first-child span {
            padding-right: 8px;
        }

        .pagination li:last-child span {
            padding-left: 8px;
        }

        header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100px;
            background-color: #4e5066;
        }

        .top-menu {
            position: fixed;
            right: -100px;
            width: 685px;
            height: 80px;
            float: left;
        }

        .top-menu ul li {
            list-style: none;
            float: left;
            text-align: center;
        }

        .top-menu ul li a {
            color: #fafafa;
            font-weight: 400;
            font-style: normal;
            font-family: "Roboto", helvetica, arial, sans-serif;
            display: block;
            width: 171px;
            text-decoration: none;
            font-size: 17px;
            height: 40px;
            padding-top: 25px;
            cursor: pointer;
        }

        .top-menu ul li a:hover {
            transition: all 0.5s ease;
            -webkit-transition: all 0.5s ease;
            -o-transition: all 0.5s ease;
            -ms-transition: all 0.5s ease;
            -moz-transition: all 0.5s ease;
            background: #1b1e24;
        }
    </style>
</head>
<body>
<header>
    <div class="top-menu">
        <%--        <ul>--%>
        <%--            <li><a href="/user">USERS</a></li>--%>
        <%--            <li><a href="/phone">PHONES</a></li>--%>
        <%--            <li><a href="/basket">BASKETS</a></li>--%>
        <%--        </ul>--%>
    </div>
</header>
<div class="table">
    <table class="table-fill">
        <thead>
        <tr>
            <th class="text-center">№ лота</th>
            <th class="text-center">auto_number</th>
            <th class="text-center">Категория</th>
            <th class="text-center">Старт.цена</th>
            <th class="text-center">Текущая цена</th>
            <th class="text-center">Дата окончания</th>
            <th class="text-center">Регион</th>
            <th class="text-center">SUBMIT</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${auctionList}" var="auction" varStatus="theCount">
            <tr>
                <td class="text-left">${auction.id}</td>
                <td class="text-left">${auction.number}</td>
                <td class="text-left">${auction.role}</td>
                <td class="text-left">${auction.startPrice}</td>
                <td class="text-left">${auction.currentPrice}</td>
                <td class="text-left">
                    <fmt:formatDate value='${auction.finishDate}' type="both" pattern='dd/MMMM/yyyy  HH:mm'/>
                        <%--                        ${basket.data}--%>
                </td>
                <td class="text-left">${auction.region}</td>
                <td class="text-left">
                    <a href="/home?pages=${pages}&confirm=${auction.id}">
                                        <span class="span">
                                        <button type="button" class="btn btn-danger ml-2">CONFIRM</button>
                                                </span>
                    </a>
                        <%--                    <c:choose>--%>
                        <%--                        <c:when test="${auction.isConfirmed == null}">--%>
                        <%--                            <a href="/basket?page=${page}&confirm=${basket.id}">--%>
                        <%--                                        <span class="span">--%>
                        <%--                                        <button type="button" class="btn btn-danger ml-2">CONFIRM</button>--%>
                        <%--                                                </span>--%>
                        <%--                            </a>--%>
                        <%--                            <a href="/basket?page=${page}&cancel=${basket.id}">--%>
                        <%--                                        <span class="span">--%>
                        <%--                                        <button type="button" class="btn btn-danger ml-2">CANCEL</button>--%>
                        <%--                                                </span>--%>
                        <%--                            </a>--%>
                        <%--                        </c:when>--%>
                        <%--                    </c:choose>--%>

                        <%--                    <c:choose>--%>
                        <%--                        <c:when test="${basket.isConfirmed == true}">--%>
                        <%--                            CONFIRMED--%>
                        <%--                        </c:when>--%>
                        <%--                    </c:choose>--%>

                        <%--                    <c:choose>--%>
                        <%--                        <c:when test="${basket.isConfirmed == false}">--%>
                        <%--                            NOT CONFIRMED--%>
                        <%--                        </c:when>--%>
                        <%--                    </c:choose>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="center">
        <ul class="pagination">
            <c:choose>
                <c:when test="${pages-1 > 0}">
                    <li>
                        <a href="/basket?page=${pages-1}">&laquo;</a>
                    </li>
                </c:when>
            </c:choose>
            <li>
                <a href="/basket?page=${pages}"><c:out value="${pages}"/></a>
            </li>
            <c:choose>
                <c:when test="${isEmpty == false}">
                    <li>
                        <a href="/basket?page=${pages+1}">&raquo;</a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
    </div>
</div>


</body>
</html>
