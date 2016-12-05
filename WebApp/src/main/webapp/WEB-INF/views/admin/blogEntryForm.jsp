
<div id="admin-blog-create" >
    <section class="row">

        <div align="center">
            <h2>Add New Blog Entry</h2>
            <form:form id="blog-entry-form" action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">

                <div class="form-group">
                    <form:input name="title" path="subject" class="form-control input-lg"
                                placeholder="Add blog title here"/>
                </div>
                <div class="form-group">
                    <textarea class="form-control input-lg" id="summernote"></textarea>
                    <form:input name="body" path="body" id="hiddenblog" type="hidden" />
                </div>
                <button id="form-submit" type="submit" class="btn btn-lg btn-success">Save Blog Entry</button>
            </form:form>
        </div>

    </section>
</div>

<script>
    $('#summernote').summernote({
        placeholder: 'Add blog content here.',
        minHeight: 200,
        maxHeight: null,
        callbacks: {
            onChange: function(contents, $editable) {
                //console.log('onChange:', contents, $editable);
                $('#hiddenblog').val(contents);
            }
        }
    });

    $('#summernote').summernote('justifyLeft');
</script>