/**
 * Created by SRoe on 11/6/16.
 */

$("#subscribeToNewsletter").submit(function(e) {

    var emailAddr = document.getElementById('emailAddress').value;

    $.ajax({
        method:'POST',
        cache:false,
        url: '/CommunityTables/rest/emails.json',
        data: emailAddr,
        contentType: 'multipart/form-data',
        success:function(result)//we got the response
        {
            $('#successfulSubscription').fadeIn(300).delay(10000).fadeOut(300);
            document.getElementById('emailSubmit').style.visibility = "collapse";
            document.getElementById('subscribe').style.visibility = "visible";
        },
        error:function(exception){
            $('#failSubscription').fadeIn(300).delay(10000).fadeOut(300);
        }

    });
    return false;
});

