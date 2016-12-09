<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="admin-blog-create" >
    <section class="row">

        <div align="center">
            <h2>Add New Blog Entry</h2>
            <form:form id="blog-entry-form" action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">

                <div class="form-group">
                    <form:input name="title" path="subject" type="text" class="form-control input-lg" placeholder="Add blog title here"/>
                </div>

                <div class="form-group">
                    <div class="form-control input-lg" id="summernote"></div>
                    <form:input name="body" path="body" id="hiddenblog" type="hidden" />
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
    });
</script>
