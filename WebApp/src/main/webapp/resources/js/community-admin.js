/**
 * Created by SRoe on 11/6/16.
 */

$(function(){  // Wait til all resources loaded...

    $("#js-get-emails").click(function(e) {

        // These values are used to bypass anti-CSRF.
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        /* Use a ping jquery addon ( from https://gist.github.com/jerone/3487795 ) to verify server is available.
           Without this test, the ajax call fails in a way that is not detected. There may be a better way but this
           works for now.
        */
        $.Ping("/CommunityTables/rest/ping.json" , 10000 /* Extended timeout for step-through debugging */)
            .done(function (success, url, time, on) {

            $.ajax({
                method:'GET',
                cache:false,
                dataType: 'json',
                url: '/CommunityTables/rest/emailsAsString.json'
                , beforeSend: function( xhr ) {
                    if (header != '' && token != '') {
                        xhr.setRequestHeader(header, token);
                    }
                }
                ,success:function(result)//we got the response
                {
                    $('#admin_middle').text(result.result);
                }
                ,error:function(exception){
                    //push the exception response text into the fail block on index
                    var msg = exception.responseText;
                    try {
                        msg = jQuery.parseJSON(exception.responseText).message;//try to get json message
                    } catch(e){
                        console.log("...issue parsing json from:");
                        console.log(exception.responseText);
                        console.log(e);
                    }
                    $('#admin-main-content').text(msg);
                }
            });

        }).fail(function (failure, url, time, on) {
            var msg = "Unable to access API.";
            $('#admin-main-content').text(msg);
        });

        return false;
    });

    $("#new-blog").click(function(e){

        $.get( "blog.html", function( data ) {
            $( "#admin_middle" ).html( data );
        });
    });

});

