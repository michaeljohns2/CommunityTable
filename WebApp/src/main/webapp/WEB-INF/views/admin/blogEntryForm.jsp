<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Blog Entry</title>

    <!-- include libraries(jQuery, bootstrap) -->
    <link rel="stylesheet" type="text/css" href="/CommunityTables/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/CommunityTables/resources/css/community.css">
    <link rel="stylesheet" type="text/css" href="/CommunityTables/webjars/summernote/0.8.2/dist/summernote.css">

    <script type="text/javascript" src="/CommunityTables/webjars/jquery/3.1.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="/CommunityTables/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/CommunityTables/webjars/summernote/0.8.2/dist/summernote.js"></script>

</head>
<body>

<div id="admin-blog-create" >
    <section class="row">

        <div align="center">
            <h2>Blog Entry</h2>
            <form:form id="blog-entry-form" action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">

                <div class="form-group">
                    <form:input name="title" path="subject" type="text" class="form-control input-lg" placeholder="Blog Title" />
                </div>

                <div class="form-group">
                    <div id="summernote"></div>
                    <form:input name="body" path="body" id="hiddenblog" type="hidden" />
                </div>
                <button id="form-submit" type="submit" class="btn btn-lg btn-success">Save Blog Entry</button>
            </form:form>
        </div>

    </section>

</div>

<script>
    //on document load
    $(function () {

        $('#summernote').summernote({
            placeholder: 'blog entry...',
            height: 500,
            minHeight: 200,
            maxHeight: null,
            focus: true,
            callbacks: {
                onChange: function(contents, $editable) {
                    $('#hiddenblog').val(contents);
                },
                onInit: function(){
                    console.log('...summernote is launched...');
                    //summernote defaults to justifycenter
                    $('#summernote').summernote('justifyLeft');
                },
                onFocus: function() {
//                    console.log('...editable area is focused');
                }
            }
        });
    });
</script>

</body>
</html>