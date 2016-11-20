/**
 * Created by SRoe on 11/6/16.
 */

$("#subscribeToNewsletter").submit(function(e) {

    /* Use a ping jquery addon ( from https://gist.github.com/jerone/3487795 ) to verify server is available.
       Without this test, the ajax call fails in a way that is not detected. There may be a better way but this
       works for now.
    */
    $.Ping("/CommunityTables/rest/emails.json" , 10000 /* Extended timeout for step-through debugging */)
        .done(function (success, url, time, on) {
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
                var msg = exception.responseText;
                try {
                    msg = jQuery.parseJSON(exception.responseText).message;//try to get json message
                } catch(e){
                    console.log("...issue parsing json from:");
                    console.log(exception.responseText);
                    console.log(e);
                }
                document.getElementById('failSubscription').getElementsByTagName("P").item(0).innerHTML = msg;

                $('#failSubscription').fadeIn(300).delay(10000).fadeOut(300);
            }
        });

    }).fail(function (failure, url, time, on) {
        //console.log("ping fail", arguments);
        //Had to hard-code this exception
        var msg = "Whoops! We messed that up. Our bad. Would you mind trying that again? We'd really love to keep you informed about our upcoming services. You can press the 'back' button and enter your email address again. If that doesn't work, please come back later to try again a little later. Thanks. Sorry about that!";
        document.getElementById('failSubscription').getElementsByTagName("P").item(0).innerHTML = msg;

        $('#failSubscription').fadeIn(300).delay(10000).fadeOut(300);
    });

    return false;
});

