/**
 * Created by SRoe on 11/6/16.
 */

$("#subscribeToNewsletter").submit(function(e) {

    /* Use a ping jquery addon ( from https://gist.github.com/jerone/3487795 ) to verify server is available.
       Without this test, the ajax call fails in a way that is not detected. There may be a better way but this
       works for now.
    */
    $.Ping("/CommunityTables/rest/emails.json" /*, optional timeout */).done(function (success, url, time, on) {
        // console.log("ping done", arguments);
        var emailAddr = document.getElementById('emailAddress').value;

        $.ajax({
            method:'POST',
            cache:false,
            url: '/CommunityTables/rest/emails.json',
            data: emailAddr,
            contentType: 'multipart/form-data',
            success:function(result)//we got the response
            {
                document.getElementById('emailSubmit').style.visibility = "collapse";
                $('#successfulSubscription').fadeIn(300).delay(10000).fadeOut(300);
                // document.getElementById('subscribe').style.visibility = "visible";//what is this?
            },
            error:function(exception){
                //push the exception response text into the fail block on index
                jsonValue = jQuery.parseJSON( exception.responseText );
                document.getElementById('failSubscription').getElementsByTagName("P").item(0).innerHTML = jsonValue.message;

                $('#failSubscription').fadeIn(300).delay(10000).fadeOut(300);
            }
        });

    }).fail(function (failure, url, time, on) {
        console.log("ping fail", arguments);
        //Had to hard-code this exception
        document.getElementById('failSubscription').getElementsByTagName("P").item(0).innerHTML = "So sorry, we are experiencing issues connecting to data store to save your email. Please try again later!";

        $('#failSubscription').fadeIn(300).delay(10000).fadeOut(300);
    });

    return false;
});

