<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Blog Entry</title>
</head>
<body>

<!-- include bootstrap and jquery (until refactored out) -->
<link rel="stylesheet" type="text/css" href="/CommunityTables/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/CommunityTables/resources/css/community.css">
<script type="text/javascript" src="/CommunityTables/webjars/jquery/3.1.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="/CommunityTables/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>

<div align="center">
    <form:form action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">
        <h2>Blog Entry</h2>

        <div>
            Subject: <form:input path="subject" />
        </div>

        <p></p>

        <div id="summernote"></div>
        <form:input path="body" id="hiddenblog" type="hidden" />

        <div>
            <input type="submit" value="Save Blog Entry"/>
        </div>
    </form:form>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        $('#summernote').summernote({
            placeholder: 'blog entry...',
            height: 500,                 // set editor height
            minHeight: 200,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: true,                  // set focus to editable area after initializing summernote
            callbacks: {
                onChange: function(contents, $editable) {
                    console.log('onChange:', contents, $editable);

                    $('#hiddenblog').val(contents);
                }
            }
        });

        $('#summernote').summernote('justifyLeft');
    });
</script>

</body>
</html>