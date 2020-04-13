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

                        <form id="newsForm" action="${pageContext.request.contextPath}/manage/addDeploy"
                              class="templatemo-login-form" method="post" enctype="multipart/form-data">
                            <div class="card-body">
                                <label>标题</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                                    </div>
                                    <input type="text" name="title" class="form-control" placeholder="Name">
                                </div>

                                <label>轮播图</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                    </div>
                                    <input type="file" name="imgFile" class="form-control">
                                    <input type="file" name="imgFile" class="form-control">
                                    <input type="file" name="imgFile" class="form-control">
                                </div>

                                <label>薪资下限</label>
                                <div class="input-group mb-3">
                                    <input type="text" name="downSalary" id="downSalary" class="form-control"
                                           oninput="value=value.replace(/[^\d]/g,'')">
                                </div>

                                <label>薪资上限</label>
                                <div class="input-group mb-3">
                                    <input type="text" name="upSalary" id="upSalary" class="form-control"
                                           oninput="value=value.replace(/[^\d]/g,'')">
                                </div>

                                <label>内容</label>
                                <div class="input-group mb-3">
                                <textarea id="content" name="content" class="form-control" rows="6"
                                          placeholder="Detailed address"></textarea>
                                </div>

                                <button type="button" class="btn btn-block btn-info" onclick="insertCustomer()">新增信息
                                </button>
                            </div>
                        </form>
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
        var forData = new FormData($("#newsForm")[0]);
        // forData.append("file", $("#imgFile")[0]);
        // formData.append("name",name);
        var title = $("input[name='title']").val();
        var downSalary = $("input[name='downSalary']").val();
        var upSalary = $("input[name='upSalary']").val();
        var imgFile = $("input[name='imgFile']").val();
        var content = $("#content").val();

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
        if (parseInt(downSalary) > parseInt(upSalary)) {
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
            cache: false, //上传文件不需要缓存
            processData: false, // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            data: forData,
            dataType: "json",
            'Content-Type': "multipart/form-data",
            success: function (result) {
                console.log(result);
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
