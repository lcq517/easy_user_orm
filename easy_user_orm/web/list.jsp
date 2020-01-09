<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function delUserFun(id) {
            if(confirm("你确认要删除吗？")){
                location.href = "${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        window.onload=function (ev) {
            document.getElementById("delSelect").onclick=function (ev1) {
                if(confirm("你确认要删除吗？")){
                    var flag = false;
                    var selectId = document.getElementsByName("selectId");
                    for (var i = 0; i < selectId.length; i++) {
                        if (selectId[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }

            document.getElementById("fristCb").onclick=function (ev1) {
                var selectId = document.getElementsByName("selectId");
                for (var i = 0; i < selectId.length; i++) {
                    selectId[i].checked = this.checked;
                }
            }

            var page = document.getElementsByClassName("page");

        }

    </script>
</head>
<body>
<div class="container">
    <div>${user.name},欢迎您&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logoutServlet">退出登录</a></div>
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;margin: 5px">
        <form action="${pageContext.request.contextPath}/findUserByPageServlet" method="post" class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}"  class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin:5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delSelect">删除选中</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectUserServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="fristCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

                <c:forEach items="${PageBean.list}" var="user" varStatus="s">
                    <tr>
                        <td><input type="checkbox" name="selectId" value="${user.id}"></td>
                        <td>${s.count}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                            &nbsp;<a class="btn btn-default btn-sm" href="javascript:delUserFun(${user.id})">删除</a></td>
                    </tr>

                </c:forEach>
        </table>
    </form>
    <div>
        <nav>
            <ul class="pagination">
                <c:if test="${(PageBean.currentPage-1)<=0}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${(PageBean.currentPage-1)>0}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${PageBean.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="1" end="${PageBean.totalPage}" step="1">
                    <c:if test="${PageBean.currentPage== i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${PageBean.currentPage!= i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${PageBean.totalPage>PageBean.currentPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${PageBean.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${PageBean.totalPage<=PageBean.currentPage}">
                    <li class="disabled">
                        <a href="" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 25px;margin-left: 5px">
                    共${PageBean.totalCount}条记录，共${PageBean.totalPage}页

                </span>
            </ul>
        </nav>
    </div>


</div>
</body>
</html>
