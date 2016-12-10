/**
 * Created by Dairai on 2016-12-09.
 */
$(function(){
    $("#form-submit").click(function(e) {
        e.preventDefault();

        $("#helpTitle").hide();
        $("#helpBody").hide();
        // validation
        var title = $("input[name=subject]", "#blog-entry-form").val();
        var body = $($("#summernote").summernote('code'))[0].innerText;

        if (!title || !body) {
            // show error message
            if(!title){
                $("#helpTitle").show().closest('.form-group').addClass(' has-error');
            }else{
                $("#helpBody").show();
            }
            return;
        } else {
            //$("#form-warning").hide();
            $("#helpTitle").hide();
            $("#helpBody").hide();
        }

        $("#blog-entry-form").submit();
    });
});