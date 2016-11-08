/**
 * Created by SRoeAir on 11/6/16.
 */

function enterEmail() {
    document.getElementById('emailSubmit').style.visibility = "visible";
    document.getElementById('subscribe').style.visibility = "collapse";
}

$("#subscribeToNewsletter").submit(function(e) {

    var emailAddr = document.getElementById('emailAddress').value;

    $.ajax({
        method:'POST',
        cache:false,
        url: '/CommunityTables/rest/emails.json',//$(this).attr('action'),
        data: emailAddr,//{"emailAddress":"test.nyabando@gmail.com"},
        contentType: 'multipart/form-data',
        success:function(result)//we got the response
        {
            document.getElementById('emailSubmit').style.visibility = "collapse";
            document.getElementById('subscribe').style.visibility = "visible";
            document.getElementById('successfulSubscription').style.visibility = "visible";
        },
        error:function(exception){
            document.getElementById('emailSubmit').style.visibility = "collapse";
            document.getElementById('subscribe').style.visibility = "visible";
            document.getElementById('failSubscription').style.visibility = "visible";
        }

    });
    return false;
});

