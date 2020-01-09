<%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2019/12/26
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <%--<base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

        <script>
            $(function () {
                $("#submitbtn").click(function () {
                    var name = $("#name").val();
                    var age = $("#age").val();
                    if (name==""){
                        alert("姓名不能为空！");
                        return false;
                    }
                    if (age==""){
                        alert("年龄不能为空！");
                        return false;
                    }
                    var qq = $("#qq").val();
                    var reg =/^\d{5,11}$/;
                    //alert(reg.test(qq))
                    if (!reg.test(qq)){
                        alert("输入的QQ号有误");
                        $("#qq").focus();
                        return false;
                    }
                    var email = $("#email").val();
                    var reg_email = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                    if (!reg_email.test(email)){
                        alert("输入的邮箱有误");
                        $("#email").focus();
                        return false;
                    }
                    $("#form").submit();
                });
            })
        </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <div></div>
    <h3 style="text-align: center;">修改联系人</h3>
    <form id="form" action="${pageContext.request.contextPath}/updateUserServlet?id=${user.id}" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${user.name}" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄"  value="${user.age}"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" >
                <c:if test="${user.address == '北京'}">
                    <option value="北京" selected>北京</option>
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="陕西">陕西</option>
                </c:if>
                <c:if test="${user.address == '广东'}">
                    <option value="北京">北京</option>
                    <option value="广东" selected>广东</option>
                    <option value="广西">广西</option>
                    <option value="陕西">陕西</option>
                </c:if>
                <c:if test="${user.address == '广西'}">
                    <option value="北京">北京</option>
                    <option value="广东">广东</option>
                    <option value="广西" selected>广西</option>
                    <option value="陕西">陕西</option>
                </c:if>
                <c:if test="${user.address == '陕西'}">
                    <option value="北京">北京</option>
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="陕西" selected>陕西</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"  value="${user.qq}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"  value="${user.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" id="submitbtn" type="button" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="javascript:history.go(-1);"><input class="btn btn-default" type="button" value="返回"/></a>
        </div>
    </form>
</div>
</body>
</html>