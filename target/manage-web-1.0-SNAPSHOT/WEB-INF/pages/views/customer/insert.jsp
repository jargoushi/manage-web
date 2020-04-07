<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../common/head.jsp" %>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">

    <%@include file="../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../common/sidebar.jsp" %>

        <div class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            新增客户
                        </div>

<%--                        <form action="${pageContext.request.contextPath}/manage/addDeploy" class="templatemo-login-form" method="post" enctype="multipart/form-data">--%>
                            <div class="card-body">
                                <label>标题</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                                    </div>
                                    <input type="text" name="title" class="form-control" placeholder="Name">
                                </div>

                                <label>首图</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                    </div>
                                    <input type="file" name="imgFile" id="imgFile" class="form-control">
                                </div>

                                <label>薪资下限</label>
                                <div class="input-group mb-3">
                                    <input type="text" name="downSalary" id="downSalary" class="form-control" oninput="value=value.replace(/[^\d]/g,'')">
                                </div>

                                <label>薪资上限</label>
                                <div class="input-group mb-3">
                                    <input type="text" name="upSalary" id="upSalary" class="form-control" oninput="value=value.replace(/[^\d]/g,'')">
                                </div>

                                <label>内容</label>
                                <div class="input-group mb-3">
                                    <textarea id="content" name="content" class="form-control" rows="6" placeholder="Detailed address"></textarea>
                                </div>

                                <button type="submit" class="btn btn-block btn-info" onclick="insertCustomer()">新增信息</button>
                            </div>
<%--                        </form>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../../common/message.jsp" %>
<%@include file="../../common/js.jsp" %>
<script>
    function insertCustomer() {
        var title = $("input[name='title']").val();
        var downSalary = $("input[name='downSalary']").val();
        var upSalary = $("input[name='upSalary']").val();
        var imgFile = $("input[name='imgFile']").val();
        var content = $("#textarea").val();

        if (title == null || title.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('标题不能为空');
            return;
        }
        if (downSalary == null || downSalary.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('薪资下限不能为空');
            return;
        }
        if (upSalary == null || upSalary.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('薪资上限不能为空');
            return;
        }
        if (downSalary > upSalary) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('薪资下限不能大于薪资上限');
            return;
        }

        if (imgFile == null || imgFile.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('首图不能为空');
            return;
        }
        if (content == null || content.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('内容不能为空');
            return;
        }

        $.ajax({
            type: 'POST',
            url: "/manage/addDeploy",
            data: {
                title: title,
                salary: salary,
                content: content,
                imgFile: imgFile
            },
            dataType: "json",
            success: function(result) {
                if (result.code == 200) {
                    $('#modal-success').modal('show');
                    $('#modal-success .modal-body').html(result.msg);
                    $("#successBtn").on("click", function () {
                        window.location.reload();
                    });
                } else {
                    $('#modal-danger').modal('show');
                    $('#modal-danger .modal-body').html("失败：状态码：" + result.code + "，" + result.msg);
                }
            },
            error: function () {
                $('#modal-danger').modal('show');
                $('#modal-danger .modal-body').html('请求失败，请检查请求数据或网络哟');
            }
        });
    }
</script>
</body>
</html>
