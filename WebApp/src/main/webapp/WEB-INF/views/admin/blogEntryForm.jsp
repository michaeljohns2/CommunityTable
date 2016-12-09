<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

    <style type = "text/css">
        .summernote h1, .summernote h2, .summernote h3, .summernote h4, .summernote h5, .summernote h6,
        .note-style h1, .note-style h2, .note-style h3, .note-style h4, .note-style h5, .note-style h6,
        .note-editable h1, .note-editable h2, .note-editable h3, .note-editable h4, .note-editable h5, .note-editable h6,
        .note-editor.note-frame .note-editing-area .note-editable {
            color: white;
            background-color: #2B2C2A;
        }

    </style>

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
                    <label class="custom-file">
                        <input type="file" id="featured-img" class="custom-file-input form-control input-lg">
                        <span class="custom-file-control"></span>
                    </label>
                    <form:hidden path="featuredImg" id="hiddenfeaturedimg" />
                </div>

                <div class="form-group">
                    <div id="summernote"><p><br></p></div>
                    <form:hidden path="body" id="hiddenblog" />
                </div>
                <button id="form-submit" type="submit" class="btn btn-lg btn-success">Save Blog Entry</button>
            </form:form>
        </div>

    </section>

</div>

<script type="text/javascript">
    //on document load
    $(function () {

        /**
         Having issues with dropdowns in summernote (within CT not when used outside).
        */
        function registerDropdownHandler(btnGroupName){
            $('.btn-group.'+btnGroupName+' .dropdown-toggle').click(function(ev){

                var title = $(this).attr("data-original-title");
//                console.log("... '.dropdown-togge clicked' for ",title);

                var ddm = $('.btn-group.'+btnGroupName+' .dropdown-menu');

                //if not currently visible, hide everything prior to toggle()
                if (!ddm.is(":visible"))
                    $('#admin-blog-create .dropdown-menu').hide();

                //toggle this drop-down
                ddm.toggle();
                return false;
            });
        }

        $('#summernote').summernote({
            placeholder: 'Write your blog entry here...',
            height: 500,
            minHeight: 200,
            callbacks: {
                onChange: function(contents, $editable) {
                    $('#hiddenblog').val(contents);
                },
                onInit: function(){
//                    console.log('...summernote is launched...');

                    //use default format
                    $('#summernote').summernote('justifyLeft');

                    /*fix an issue with dropdown-menu (due to something in our setup) */

                    //(1) register handlers
                    ["note-style","note-fontname","note-color","note-para","note-table"].forEach(function (item, index, array) {
                        registerDropdownHandler(item);
                    });

                    //(2) close drop-down if an item within is clicked
                    $("#admin-blog-create .dropdown-menu").click(function(ev) {
//                        console.log("... '.dropdown-menu clicked' ");
                        $(this).hide();
                        return false;
                    });
                },
                onFocus: function() {
//                    console.log('...editable area is focused');
                },
                onBlur: function() {
//                    console.log('...editable area is now blurred');
                }
            }
        });

        /*
         * Handle file selection.
         * https://www.abeautifulsite.net/whipping-file-inputs-into-shape-with-bootstrap-3
         */
        $(document).on('change', ':file', function() {
            var input = $(this),
                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');

            input.trigger('fileselect', [numFiles, label]);
        });

        $(':file').on('fileselect', function(event, numFiles, label) {
            console.log("number of files selected? ",numFiles);
            console.log("what is the label? ", label);

            var $i = $( '#featured-img' ), // Put file input ID here
                input = $i[0]; // Getting the element from jQuery
            if ( input.files && input.files[0] ) {
                var file = input.files[0];
                var fr = new FileReader();
                fr.onload = function () {
                    $( '#hiddenfeaturedimg' ).val(fr.result);
                };
                //fr.readAsText( file );
                fr.readAsDataURL(file);
            } else {
                $( '#hiddenfeaturedimg' ).val("");
            }
        });
    });


</script>

</body>
</html>