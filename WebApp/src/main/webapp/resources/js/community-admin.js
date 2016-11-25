/**
 * Created by SRoe on 11/6/16.
 */

$(function(){

    $("#js-get-emails").click(function(e) {

        /* Use a ping jquery addon ( from https://gist.github.com/jerone/3487795 ) to verify server is available.
           Without this test, the ajax call fails in a way that is not detected. There may be a better way but this
           works for now.
        */
        $.Ping("/CommunityTables/rest/emailsAsString.json" , 10000 /* Extended timeout for step-through debugging */)
            .done(function (success, url, time, on) {

            $.ajax({
                method:'GET',
                cache:false,
                url: '/CommunityTables/rest/emailsAsString.json',
                success:function(result)//we got the response
                {
                    $( '#admin-main-content' ).text(result);
                },
                error:function(exception){
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
            //console.log("ping fail", arguments);
            //Had to hard-code this exception
            var msg = "REST connectivity failure.";
            $('#admin-main-content').text(msg);
        });

        return false;
    });

});

