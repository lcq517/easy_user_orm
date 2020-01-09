<%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2019/12/27
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
           $("#inputAge").blur(function () {
                var number = /^\d{1,3}$/;
                if ($(this).val()==""){
                    $(this).after("<span class='msg'>不能为空！</span>");
                    $(".msg").css("color","red");
                    return;
                }else if (!number.test($(this).val())){
                   $(this).after("<span class='msg'>只能输入数字</span>");
                   $(".msg").css("color","red");
                    $("#inputAge").focus;
               }
           });
           $("#inputAge").focus(function () {
                $(".msg").remove();
           })


        });

    </script>


</head>
<body>
<div class="container" style="width: 600px;">
    <div><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></div>
    <h1 style="text-align: center">注册新用户</h1>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/registUserServlet" method="post">
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="inputName" placeholder="姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="radio" name="gender" value="男" checked="checked">男
                <input type="radio" name="gender" value="女">女
            </div>
        </div>
        <div class="form-group">
            <label for="inputAge" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" name="age" class="form-control" id="inputAge" placeholder="年龄">

            </div>
        </div>
        <div class="form-group">
            <label for="jiguan" class="col-sm-2 control-label">籍贯</label>
            <div class="col-sm-10">
                <select name="address" class="form-control" id="jiguan">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="inputQq" class="col-sm-2 control-label">QQ</label>
            <div class="col-sm-10">
                <input type="text" name="qq" class="form-control" id="inputQq" placeholder="QQ">
                <span></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="email" name="email" class="form-control" id="inputEmail" placeholder="邮箱">
                <span></span>
            </div>
        </div>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" name="username" class="form-control" id="username" placeholder="用户名">
                <span></span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="password" placeholder="密码">
                <span></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 同意本协议
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">注册</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
