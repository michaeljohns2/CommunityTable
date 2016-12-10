<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="admin-blog-create" >
    <section class="row">

        <div class="col-sm-12 center">
            <h2>Add New Blog Entry</h2>
            <form:form id="blog-entry-form" action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">

                <div class="form-group">
                    <form:input id="blogTitle" name="title" path="subject" type="text" class="form-control input-lg"
                                placeholder="Add blog title here"/>
                    <span id="helpTitle" class="help-block">Your blog must have a title.</span>
                </div>

                <div class="form-group">
                    <label class="custom-file">
                        Set Featured Image: <input type="file" id="featured-img"
                                           class="custom-file-input form-control input-lg">
                        <span class="custom-file-control"></span>
                    </label>
                    <form:hidden path="featuredImg" id="hiddenfeaturedimg" />
                </div>

                <div class="form-group">
                     <span id="helpBody" class="help-block">Your blog must have <em>some</em> content. Please add
                        content and try again.</span>
                    <div id="summernote"><p></p></div>
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

        $('.help-block').hide();

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
